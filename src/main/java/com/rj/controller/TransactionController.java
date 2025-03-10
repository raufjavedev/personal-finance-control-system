package com.rj.controller;

import com.rj.model.Transaction;
import com.rj.model.User;
import com.rj.service.TransactionService;
import com.rj.util.EventBus;
import com.rj.util.Message;
import com.rj.util.UserSession;
import com.rj.view.DetailView;
import com.rj.view.MainApp;
import com.rj.view.TransactionFormView;
import com.rj.view.TransactionView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Controlador de las transacciones que gestiona las acciones relacionadas con
 * la creación, actualización y eliminación de transacciones. Implementa {@code ActionListener}
 * para manejar eventos de acción del usuario.
 */

public class TransactionController implements ActionListener {

    private final TransactionService transactionService;
    private final MainApp mainApp;
    private final TransactionView transactionView;
    private final TransactionFormView transactionFormView;

    public TransactionController(TransactionService transactionService, MainApp mainApp, TransactionView transactionView, TransactionFormView transactionFormView) {
        this.transactionService = transactionService;
        this.mainApp = mainApp;
        this.transactionView = transactionView;
        this.transactionFormView = transactionFormView;

        mainApp.btnRecord.addActionListener(this);
        mainApp.btnTransactions.addActionListener(this);

        transactionView.btnNew.addActionListener(this);
        transactionView.btnUpdate.addActionListener(this);
        transactionView.btnDelete.addActionListener(this);
        transactionView.btnDetail.addActionListener(this);

        transactionFormView.btnSave.addActionListener(this);
        transactionFormView.btnUpdate.addActionListener(this);
        transactionFormView.btnCancel.addActionListener(this);

        transactionView.cbbTransactions.addActionListener(this);
        transactionView.btnFilter.addActionListener(this);
        transactionView.btnReset.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainApp.btnRecord) {
            listTransactions();
            mainApp.JPanel(transactionView);
        }
        if (e.getSource() == mainApp.btnTransactions) {
            transactionFormView.btnSave.setVisible(true);
            transactionFormView.btnUpdate.setVisible(false);
            transactionFormView.clearFields();
            transactionFormView.setVisible(true);
        }
        if (e.getSource() == transactionView.btnNew) {
            transactionFormView.btnSave.setVisible(false);
            transactionFormView.btnUpdate.setVisible(true);
            transactionFormView.clearFields();
            transactionFormView.setVisible(true);
        }
        if (e.getSource() == transactionView.btnUpdate) {
            loadTransactionData();
        }
        if (e.getSource() == transactionView.btnDelete) {
            deleteTransaction();
        }
        if (e.getSource() == transactionView.btnDetail) {
            showTransactionDetail();
        }
        if (e.getSource() == transactionFormView.btnSave) {
            registerTransaction();
        }
        if (e.getSource() == transactionFormView.btnUpdate) {
            updateTransaction();
        }
        if (e.getSource() == transactionFormView.btnCancel) {
            transactionFormView.dispose();
        }
        if (e.getSource() == transactionView.cbbTransactions) {
            listTransactions();
        }
        if (e.getSource() == transactionView.btnFilter) {
            listTransactions();
        }
        if (e.getSource() == transactionView.btnReset) {
            transactionView.clearFields();
            listTransactions();
        }

    }

    /**
     * Registrar nueva transacción.
     * <p>
     * Verifica que los campos no estén vacíos antes de continuar,
     * si el monto es mayor a cero
     * y si hay saldo disponible {@code transactionService.getBalance()}.
     * Si todas las condiciones son satisfactorias, crea un objeto {@code Transaction}
     * y lo envía a {@code transactionService.addTransaction()} pra su registro. Muestra un mensaje de éxito o error
     * según el resultado.
     */
    public void registerTransaction() {
        // Verificar si existe campos vacíos
        transactionFormView.isFieldsEmpty();
        // Obtener los datos validados desde la vista
        String cashFlow = transactionFormView.getCashFlow();
        String category = transactionFormView.getCategory();
        String description = transactionFormView.getDescription();
        double amount = transactionFormView.getAmount();



        // Generar los datos de la transacción
        int userId = UserSession.getInstance().getUserId();
        String operationNumber = generateOperationNumber();

        // Obtener el saldo actual
        double balance = transactionService.getBalance(userId);

        // Validar que el monto sea mayor que 0 y no supere el saldo disponible, solo si la categoría es "Egreso"
        if ("Egreso".equals(cashFlow)) {
            if (amount <= 0) {
                Message.showWarning("El monto debe ser mayor a cero (0)");
                return;
            }
            if (amount > balance) {
                Message.showWarning("Saldo insuficiente");
                return;
            }
        }

        // Crear la entidad de transacción
        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(operationNumber);
        User user = new User();
        user.setUserId(userId); // Crear usuario con el ID obtenido de la sesión
        transaction.setUser(user);
        transaction.setTransactionType(cashFlow);
        transaction.setCategory(category);
        transaction.setAmount(amount);
        transaction.setTransactionDescription(description);

        // Intentar registrar la transacción
        if (transactionService.addTransaction(transaction)) {
            // Publicar el evento de transacción registrada
            EventBus.getInstance().publishTransactionRegistered(transaction);
            Message.showSuccess("Transacción registrada con éxito");
            transactionFormView.clearFields(); // Limpiar campos
            listTransactions();
        } else {
            Message.showError("Error al registrar la transacción");
        }
    }

    /**
     * Actualizar la transacción por número de operación.
     * <p>
     * Verifica que los campos no estén vacíos antes de continuar,
     * el monto es mayor a cero
     * y si hay saldo disponible {@code transactionService.getBalance()}.
     * Si todas las condiciones son satisfactorias, crea un objeto {@code Transaction}
     * y lo envía a {@code transactionService.updateTransaction} pra su actualización. Muestra un mensaje de éxito o error
     * según el resultado.
     */
    private void updateTransaction() {
        if (transactionFormView.isFieldsEmpty()) {
            Message.showSuccess("Todos los campos son obligatorios.");
            return;
        }

        String operationNumber = transactionView.getTransactionNumber();
        String cashFlow = transactionFormView.getCashFlow();
        String category = transactionFormView.getCategory();
        String description = transactionFormView.getDescription();
        double amount = transactionFormView.getAmount();

        // Si algún valor es inválido, se detiene la ejecución.
        if (cashFlow == null || category == null || description == null) {
            return;
        }

        // Obtener el Id del usuario
        int userId = UserSession.getInstance().getUserId();
        // Obtener el saldo actual
        double balance = transactionService.getBalance(userId);

        // Validar que el monto sea mayor que 0 y no supere el saldo disponible, solo si la categoría es "Egreso"
        if ("Egreso".equals(cashFlow)) {
            if (amount <= 0) {
                Message.showWarning("El monto debe ser mayor a cero (0)");
                return;
            }
            if (amount > balance) {
                Message.showWarning("Saldo insuficiente");
                return;
            }
        }

        // Crear y llenar el objeto de transacción
        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(operationNumber);
        User user = new User();
        user.setUserId(UserSession.getInstance().getUserId()); // Id del usuario desde la sesión
        transaction.setUser(user);
        transaction.setTransactionType(cashFlow);
        transaction.setCategory(category);
        transaction.setAmount(amount);
        transaction.setTransactionDescription(description);

        // Actualizar la transacción
        if (transactionService.updateTransaction(transaction)) {
            // Publicar el evento de transacción actualizada
            EventBus.getInstance().publishTransactionUpdated(transaction);
            Message.showSuccess("Transacción actualizada con éxito.");
            transactionFormView.clearFields(); // Limpiar campos
            listTransactions(); // Refrescar la lista de transacciones
            transactionFormView.dispose(); // Cerrar el formulario
        } else {
            Message.showError("Error al actualizar la transacción.");
        }
    }

    /**
     * Eliminar una transacción utilizando el número de operación.
     * <p>
     * Primero, verifica que la transacción esté presente en el sistema
     * y luego solicita confirmación del usuario antes de realizar la eliminación.
     */
    private void deleteTransaction() {
        try {
            // Obtener el número de operación de la transacción seleccionada desde la vista
            String operatioNumber = transactionView.getTransactionNumber();
            if (operatioNumber == null) {
                Message.showWarning("Seleccione una transacción para eliminar.");
                return; // Salir si no hay transacción seleccionada
            }

            // Confirmar eliminación
            if (!transactionView.confirmDeletion()) {
                return; // Salir si el usuario cancela la operación
            }

            // Llamar al servicio para eliminar la transacción
            if (transactionService.deleteTransaction(operatioNumber)) {
                // Publicar el evento de transacción eliminada
                EventBus.getInstance().publishTransactionDeleted(operatioNumber);
                Message.showSuccess("Transacción eliminada con éxito.");
                listTransactions(); // Refrescar la lista de transacciones
            } else {
                Message.showError("No se encontró la transacción con el ID proporcionado.");
            }
        } catch (Exception e) {
            Message.showError("Ocurrió un error inesperado: " + e.getMessage());
        }
    }

    /**
     * Listar las transacciones correspondientes al usuario logueado.
     * <p>
     * Recupera todas las transacciones del usuario actual y las muestra en la interfaz.
     */
    private void listTransactions() {
        try {
            int userId = UserSession.getInstance().getUserId();
            // Obtener las fechas desde los selectores de fecha
            LocalDate[] dateRange = transactionView.getSelectedDateRange();
            LocalDate startDate = dateRange[0];
            LocalDate endDate = dateRange[1];

            String transactionType = transactionView.getTransactionType().toLowerCase();

            List<Transaction> filteredTransaction = transactionService.getAllTransactions(userId, startDate, endDate).stream()
                    .filter(transaction -> transactionType.equals("todos") ||
                            transaction.getTransactionType().toLowerCase().contains(transactionType))
                    .toList();

            // Actualizar la vista con los datos obtenidos
            transactionView.setTransactionsList(filteredTransaction);
        } catch (Exception e) {
            Message.showError("Ocurrió un error al cargar las transacciones: " + e.getMessage());
        }
    }

    /**
     * Muestra los datos de la transacción en el formulario de edición.
     */
    private void loadTransactionData() {
        String operationNumber = transactionView.getTransactionNumber();

        // Validar transactionId
        if (operationNumber == null) {
            Message.showWarning("Seleccione una transacción para editar.");
            return;
        }

        try {
            // Buscar la transacción en la base de datos
            Transaction transaction = transactionService.getTransactionByOperationNumber(operationNumber);

            // Si la transacción es encontrada, actualizar los campos de la vista
            if (transaction != null) {
                transactionFormView.setTransactionData(transaction);
            } else {
                Message.showError("No se encontró la transacción con el ID proporcionado.");
            }
        } catch (NumberFormatException e) {
            Message.showWarning("El ID de la transacción debe ser un número válido.");
        }
    }

    /**
     * Muestra los detalles de la transacción seleccionada.
     * <p>
     * Obtiene los detalles completos de una transacción específica y los muestra en la interfaz de usuario.
     */
    private void showTransactionDetail() {
        String operationNumber = transactionView.getTransactionNumber();

        // Validar si se ha seleccionado una transacción
        if (operationNumber == null) {
            Message.showWarning("Seleccione una transacción para ver el detalle.");
            return;
        }

        try {
            // Buscar la transacción en la base de datos
            Transaction transaction = transactionService.getTransactionByOperationNumber(operationNumber);

            // Si se encuentra la transacción, mostrar los detalles
            if (transaction != null) {
                DetailView detailView = new DetailView(mainApp, true);
                detailView.setTransactionDetail(transaction);
            } else {
                Message.showError("No se encontró la transacción con el ID proporcionado.");
            }
        } catch (Exception e) {
            Message.showWarning("");
        }
    }

    /**
     * Genera número un serie de números a partir de la fecha y hora
     *
     * @return Número de operación concatenada con TXN en formato String
     */
    private String generateOperationNumber() {
        final SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return "TXN" + format.format(new Date());
    }

}
