package com.rj.view;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.rj.util.Currency;
import com.rj.model.Transaction;

import java.awt.Cursor;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TransactionView extends javax.swing.JPanel {

    public TransactionView() {
        initComponents();
        initStyles();
    }

    private void initStyles() {
        DefaultTableModel model = new DefaultTableModel();
        String[] columnNames = { "#", "Num. Operación", "Tipo de Transacción", "Categoría", "Monto", "Descripción",
                "Fecha", "Hora" };
        for (String columnName : columnNames) {
            model.addColumn(columnName);
            transactionsTable.setModel(model);
        }

        FlatSVGIcon iconAdd = new FlatSVGIcon(getClass().getResource("/icons/add_circle.svg"));
        btnNew.setIcon(iconAdd);
        btnNew.setCursor(new Cursor(Cursor.HAND_CURSOR));

        FlatSVGIcon iconDelete = new FlatSVGIcon(getClass().getResource("/icons/delete_forever.svg"));
        btnDelete.setIcon(iconDelete);
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));

        FlatSVGIcon iconUpdate = new FlatSVGIcon(getClass().getResource("/icons/bxs-edit.svg"));
        btnUpdate.setIcon(iconUpdate);
        btnUpdate.setCursor(new Cursor(Cursor.HAND_CURSOR));

        FlatSVGIcon iconDetail = new FlatSVGIcon(getClass().getResource("/icons/bx-detail.svg"));
        btnDetail.setIcon(iconDetail);
        btnDetail.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Icono de los botones
        FlatSVGIcon filter = new FlatSVGIcon(getClass().getResource("/icons/filter_alt.svg"));
        FlatSVGIcon reset = new FlatSVGIcon(getClass().getResource("/icons/restart_alt.svg"));

        // Gráfico 1
        btnFilter.setIcon(filter);
        btnFilter.setText("");
        btnFilter.setToolTipText("Filtrar");
        btnFilter.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnReset.setIcon(reset);
        btnReset.setText("");
        btnReset.setToolTipText("Resetear");
        btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));

        String[] transactionType = { "Todos", "Ingreso", "Egreso" };
        cbbTransactions.removeAllItems();
        for (String transactions : transactionType) {
            cbbTransactions.addItem(transactions);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactionsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnDetail = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnNew = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbbTransactions = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcStartDate = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jcEndDate = new com.toedter.calendar.JDateChooser();
        btnFilter = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        transactionsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        jScrollPane1.setViewportView(transactionsTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Histrorial de transacciones");

        btnUpdate.setText("Editar");

        btnDelete.setText("Eliminar");

        btnDetail.setText("Detalle");

        btnNew.setText("Nuevo");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel8.setText("|");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel9.setText("Filtar por");

        cbbTransactions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de transación" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel7.setText("Fecha:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Inicio");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel10.setText("Fin");

        btnFilter.setText("Aplicar");

        btnReset.setText("Reset");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setText("|");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 989,
                                                Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnNew)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnUpdate)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnDelete)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnDetail)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbbTransactions, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jcStartDate, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jcEndDate, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel2)))
                                .addContainerGap())
                        .addComponent(jSeparator1));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(btnNew))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                        jPanel1Layout.createSequentialGroup()
                                                                .addComponent(btnDetail)
                                                                .addGap(1, 1, 1))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnUpdate)
                                                        .addComponent(btnDelete)))
                                        .addGroup(jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(jLabel10,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jcStartDate,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel1Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel6)
                                                                .addComponent(jLabel7)
                                                                .addComponent(jLabel8)
                                                                .addComponent(jLabel9)
                                                                .addComponent(cbbTransactions,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jcEndDate, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnDetail;
    public javax.swing.JButton btnFilter;
    public javax.swing.JButton btnNew;
    public javax.swing.JButton btnReset;
    public javax.swing.JButton btnUpdate;
    public javax.swing.JComboBox<String> cbbTransactions;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser jcEndDate;
    private com.toedter.calendar.JDateChooser jcStartDate;
    public javax.swing.JTable transactionsTable;
    // End of variables declaration//GEN-END:variables

    /**
     * Obtiene el Número de operación de la transacción seleccionada en la tabla de
     * transacciones.
     * 
     * @return el Número operación de la transacción seleccionada como String, o
     *         null si no se seleccionó ninguna fila.
     */
    public String getTransactionNumber() {
        int selectedRow = transactionsTable.getSelectedRow();
        if (selectedRow != -1) {
            return transactionsTable.getValueAt(selectedRow, 1).toString(); // Retorna el valor de la primera columna
                                                                            // (ID)
        }
        return null;
    }

    /**
     * Muestra un cuadro de diálogo de confirmación para eliminar una transacción.
     * 
     * @return true si el usuario selecciona "Sí" en el cuadro de diálogo,
     *         indicando que desea proceder con la eliminación;
     *         false si selecciona "No", cancelando la eliminación.
     */
    public boolean confirmDeletion() {
        int option = JOptionPane.showConfirmDialog(
                this,
                "¿Desea eliminar esta transacción?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);
        return option == JOptionPane.YES_OPTION;
    }

    /**
     * Muestra todas las transacciones correspondientes al usuario logueado.
     * 
     * @param transactions Lista de transacciones
     */
    public void setTransactionsList(List<Transaction> transactions) {
        DefaultTableModel model = (DefaultTableModel) transactionsTable.getModel();
        model.setRowCount(0); // Limpiar la tabla
        int rowIndex = 1; // Inicia el índice en 1

        for (Transaction transaction : transactions) {
            model.addRow(new Object[] {
                    rowIndex++,
                    transaction.getTransactionNumber(),
                    transaction.getTransactionType(),
                    transaction.getCategory(),
                    Currency.formatCurrency(transaction.getAmount()),
                    transaction.getTransactionDescription(),
                    transaction.getRegistrationDate(),
                    transaction.getRegistrationTime()
            });
        }
    }

    /**
     * Obtiene el tipo de transacción (ingreso o egreso).
     *
     * @return El tipo de transacción como una cadena de texto, que puede ser "Ingreso", "Egreso" o "Todos".
     */
    public String getTransactionType() {
        String transactionType = (String) cbbTransactions.getSelectedItem();

        // Lista de valores permitidos
        Set<String> validTypes = new HashSet<>(Arrays.asList("Todos", "Ingreso", "Egreso"));

        // Retorna el tipo de transacción si es válido, de lo contrario, devuelve
        // "Todos"
        return validTypes.contains(transactionType) ? transactionType : "Todos";
    }

    /**
     * Obtiene el rango de fechas seleccionado por el usuario.
     *
     * @return Un arreglo de tipo {@code LocalDate} que contiene la fecha de inicio y la fecha de fin del rango seleccionado.
     */
    public LocalDate[] getSelectedDateRange() {
        Date startDateRaw = jcStartDate.getDate();
        Date endDateRaw = jcEndDate.getDate();

        // Convertir a LocalDate o dejar como null si no hay selección
        LocalDate startDate = (startDateRaw != null)
                ? startDateRaw.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
                : null;

        LocalDate endDate = (endDateRaw != null) ? endDateRaw.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
                : null;

        return new LocalDate[] { startDate, endDate };
    }

    /**
     * Limpia todos los campos del formulario, restaurándolos a su estado inicial vacío.
     */
    public void clearFields() {
        jcEndDate.setDate(null);
        jcStartDate.setDate(null);
    }

}
