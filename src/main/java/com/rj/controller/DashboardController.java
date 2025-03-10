package com.rj.controller;

import com.rj.listeners.TransactionListener;
import com.rj.model.Transaction;
import com.rj.model.User;
import com.rj.service.ReportService;
import com.rj.service.TransactionService;
import com.rj.service.UserService;
import com.rj.util.*;
import com.rj.view.DashboardView;
import com.rj.view.MainApp;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

/**
 * Controlador del Dashboard que gestiona las acciones del usuario y actualiza
 * gráficos, saldo e información de transacciones. Implementa {@code ActionListener}
 * y {@code TransactionListener}  para manejar interacciones y eventos de transacciones.
 */
public class DashboardController implements ActionListener, TransactionListener {
    private final TransactionService transactionService;
    private final UserService userService;
    private final ReportService reportService;
    private final MainApp mainApp;
    private final DashboardView dashboardView;

    // Mensaje de error cuando el ID del usuario no está disponible
    private static final String USER_ID_NOT_AVAILABLE = "El ID del usuario no está disponible.";

    public DashboardController(TransactionService transactionService, UserService userService,
            ReportService reportService, MainApp mainApp, DashboardView dashboardView) {
        this.transactionService = transactionService;
        this.userService = userService;
        this.reportService = reportService;
        this.mainApp = mainApp;
        this.dashboardView = dashboardView;

        mainApp.btnHome.addActionListener(this);

        // Suscribirse al EventBus para escuchar eventos de transacciones
        EventBus.getInstance().subscribe(this);

        if (UserSession.getInstance().isAuthenticated()) {
            initializeDashboard();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainApp.btnHome) {
            initializeDashboard();
        }
    }

    private void initializeDashboard() {
        updateFirstName();
        updateTotalBalance();
        updateTotalIncome();
        updateTotalExpenses();
        updateRecentTransactions();
        updateLineChart();
        updateLastIncome();
        updateLastExpenses();

        mainApp.JPanel(dashboardView);
    }

    /**
     * Actualiza el dashboard
     */
    private void updateDashboard() {
        updateFirstName();
        updateTotalBalance();
        updateTotalIncome();
        updateTotalExpenses();
        updateRecentTransactions();
        updateLineChart();
        updateLastIncome();
        updateLastExpenses();
    }

    /**
     * Actualiza la visualización del nombre del usuario logueado en el dashboard.
     * <p>
     * Este método se encarga de mostrar el nombre del usuario actualmente logueado
     * en el dashboard, asegurando que la interfaz de usuario esté actualizada con
     * la información más reciente del perfil del usuario.
     */
    private void updateFirstName() {
        int userId = UserSession.getInstance().getUserId();

        if (userId > 0) {
            User user = userService.getUserData(userId);

            if (user != null && user.getFirstName() != null) {
                dashboardView.setUserName(user.getFirstName());
            } else {
                dashboardView.setUserName("Usuario desconocido");
            }
        } else {
            Message.showError(USER_ID_NOT_AVAILABLE);
        }
    }

    /**
     * Actualiza la visualización del saldo total del usuario en la interfaz.
     * <p>
     * Este método se encarga de mostrar el saldo total actual, recuperado de los datos del usuario,
     * en el panel correspondiente, asegurando que el saldo mostrado esté siempre actualizado
     * en la vista.
     */
    private void updateTotalBalance() {
        int userId = UserSession.getInstance().getUserId();
        double totalBalance = userService.getTotalBalance(userId);
        dashboardView.setBalance(totalBalance);
    }

    /**
     * Actualiza la visualización del total de ingresos del usuario.
     * <p>
     * Este método se encarga de mostrar el total acumulado de ingresos en la interfaz de usuario,
     * asegurando que la información mostrada esté actualizada con los datos más recientes
     * sobre los ingresos del usuario.
     */
    private void updateTotalIncome() {
        int userId = UserSession.getInstance().getUserId();
        double totalIncome = transactionService.getTotalIncome(userId);
        dashboardView.setTotalIncome(totalIncome);
    }

    /**
     * Actualiza la visualización del total de egresos del usuario.
     * <p>
     * Este método se encarga de mostrar el total acumulado de egresos en la interfaz de usuario,
     * asegurando que la información mostrada esté actualizada con los datos más recientes
     * sobre los egresos del usuario.
     */
    private void updateTotalExpenses() {
        int userId = UserSession.getInstance().getUserId();
        double totalExpenses = transactionService.getTotalExpenses(userId);
        dashboardView.setTotalExpenses(totalExpenses);
    }

    /**
     * Actualiza la visualización del último ingreso registrado.
     * <p>
     * Este método se encarga de mostrar los detalles del último ingreso realizado por el usuario
     * en la interfaz de usuario, asegurando que la información esté actualizada y refleje
     * el último movimiento de ingresos registrado en el sistema.
     */
    private void updateLastIncome() {
        int userId = UserSession.getInstance().getUserId();

        if (userId > 0) {
            Transaction lastIncome = transactionService.getLastIncome(userId);

            if (lastIncome != null) {
                dashboardView.setLastIncome(
                        lastIncome.getAmount(),
                        lastIncome.getCategory(),
                        lastIncome.getRegistrationDate(),
                        lastIncome.getRegistrationTime());
            } else {
                dashboardView.setLastIncome(0.0, "Sin registros", null, null);
            }
        } else {
            Message.showError(USER_ID_NOT_AVAILABLE);
        }
    }

    /**
     * Actualiza la visualización del último egreso registrado.
     * <p>
     * Este método se encarga de mostrar los detalles del último egreso realizado por el usuario
     * en la interfaz de usuario, asegurando que la información esté actualizada y refleje
     * el último movimiento de egresos registrado en el sistema.
     */
    private void updateLastExpenses() {
        int userId = UserSession.getInstance().getUserId();

        if (userId > 0) {
            Transaction lastExpense = transactionService.getLastExpenses(userId);

            if (lastExpense != null) {
                dashboardView.setLastExpense(
                        lastExpense.getAmount(),
                        lastExpense.getCategory(),
                        lastExpense.getRegistrationDate(),
                        lastExpense.getRegistrationTime());
            } else {
                dashboardView.setLastExpense(0.0, "Sin registros", null, null);
            }
        } else {
            Message.showError(USER_ID_NOT_AVAILABLE);
        }
    }

    /**
     * Muestra las últimas 5 transacciones recientes realizadas por el usuario.
     * <p>
     * Este método actualiza la interfaz de usuario mostrando las últimas 5 transacciones
     * realizadas, permitiendo que el usuario visualice rápidamente las transacciones más recientes.
     */
    private void updateRecentTransactions() {
        int userId = UserSession.getInstance().getUserId();

        if (userId > 0) {
            List<Transaction> recentTransactions = transactionService.getLastFiveRecords(userId);

            if (recentTransactions != null && !recentTransactions.isEmpty()) {
                dashboardView.updateTransactionHistory(recentTransactions);
            } else {
                dashboardView.clearTransactionHistory();
            }
        } else {
            Message.showError(USER_ID_NOT_AVAILABLE);
        }
    }

    /**
     * Muestra el gráfico de línea en el dashboard.
     * <p>
     * Este método actualiza la interfaz de usuario mostrando un gráfico de línea que visualiza
     * los datos de ingresos y egresos de últimos 12 meses.
     */
    private void updateLineChart() {
        int userId = UserSession.getInstance().getUserId();

        if (userId > 0) {
            // Obtener los datos procesados desde el servicio
            Map<String, Map<String, Double>> monthlyData = reportService.getMonthlyTransactionData(userId);

            // Validar que los datos no estén vacíos
            if (monthlyData != null && !monthlyData.isEmpty()) {
                // Crear el dataset y el gráfico
                DefaultCategoryDataset dataset = LineChart.createDataset(monthlyData, "Ingreso", "Egreso");
                ChartPanel chartPanel = LineChart.createLineChart(
                        dataset,
                        "Mes",
                        "Monto ("+ Currency.currencySymbol()+")",
                        "");

                // Actualizar el panel gráfico en el dashboard
                dashboardView.updateGraphicPanel(chartPanel);
            } else {
                Message.showWarning("No hay datos disponibles para generar el gráfico.");
                dashboardView.clearGraphicPanel();
            }
        } else {
            Message.showError(USER_ID_NOT_AVAILABLE);
            dashboardView.clearGraphicPanel();
        }
    }

    /**
     * Escuchar los eventos
     */
    @Override
    public void onTransactionRegistered(Transaction transaction) {
        updateDashboard();
    }

    @Override
    public void onTransactionUpdated(Transaction transaction) {
        updateDashboard();
    }

    @Override
    public void onTransactionDeleted(String operationNumber) {
        updateDashboard();
    }
}
