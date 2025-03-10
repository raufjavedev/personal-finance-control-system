package com.rj.view;

import com.rj.model.Transaction;
import com.rj.util.Message;
import com.rj.util.RoundedPanelSwing;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransactionFormView extends JDialog {

    /**
     * Creates new form ViewTransactionForm
     * @param parent
     * @param modal
     */
    public TransactionFormView(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initStyles();
        initListeners();
        
    }

    private void initStyles(){
        this.setLocationRelativeTo(null);
        RoundedPanelSwing.applyBorderNoColor(jpContainer, 20, new Color(18,25,41));
         
        lblTitle.setText("Nueva Transacción");
        lblId.setVisible(false);
        lblOperationNumber.setVisible(false);
        String[] cashFlows = {"Seleccionar tipo...","Ingreso","Egreso"};
        for (String cashFlow : cashFlows) {
            cbCashFlow.addItem(cashFlow);
        }
        
        btnUpdate.setVisible(false);
        cbCategory.setEditable(true);
        
        txtAmount.setText("0");

        btnSave.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnUpdate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpContainer = new JPanel();
        lblTitle = new JLabel();
        lblId = new JLabel();
        jSeparator1 = new JSeparator();
        lblOperationNumber = new JLabel();
        jLabel4 = new JLabel();
        cbCategory = new JComboBox<>();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        txtAmount = new JTextField();
        txtDescription = new JTextField();
        jLabel7 = new JLabel();
        jSeparator2 = new JSeparator();
        btnSave = new JButton();
        btnUpdate = new JButton();
        btnCancel = new JButton();
        cbCashFlow = new JComboBox<>();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        lblTitle.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setText("Título");

        lblId.setFont(new Font("Segoe UI", 0, 10)); // NOI18N
        lblId.setText("Id:");

        lblOperationNumber.setFont(new Font("Segoe UI", 0, 10)); // NOI18N
        lblOperationNumber.setText("1");

        jLabel4.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Tipo");

        cbCategory.setFont(new Font("Segoe UI", 0, 13)); // NOI18N

        jLabel5.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setText("Monto");

        jLabel6.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Categoría");

        txtAmount.setFont(new Font("Segoe UI", 0, 13)); // NOI18N

        txtDescription.setFont(new Font("Segoe UI", 0, 13)); // NOI18N

        jLabel7.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setText("Descripción");

        btnSave.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        btnSave.setText("Guardar");

        btnUpdate.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        btnUpdate.setText("Editar");

        btnCancel.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        btnCancel.setText("Cancelar");

        cbCashFlow.setFont(new Font("Segoe UI", 0, 13)); // NOI18N

        GroupLayout jpContainerLayout = new GroupLayout(jpContainer);
        jpContainer.setLayout(jpContainerLayout);
        jpContainerLayout.setHorizontalGroup(
            jpContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jpContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbCategory, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAmount)
                    .addComponent(txtDescription)
                    .addGroup(jpContainerLayout.createSequentialGroup()
                        .addGroup(jpContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jpContainerLayout.createSequentialGroup()
                                .addComponent(lblId)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblOperationNumber))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpContainerLayout.createSequentialGroup()
                        .addComponent(btnSave, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                    .addComponent(cbCashFlow, GroupLayout.Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpContainerLayout.setVerticalGroup(
            jpContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpContainerLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitle)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpContainerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(lblOperationNumber))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCashFlow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jpContainerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUpdate)
                        .addComponent(btnCancel))
                    .addComponent(btnSave))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpContainer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpContainer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TransactionFormView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TransactionFormView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TransactionFormView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TransactionFormView.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                TransactionFormView dialog = new TransactionFormView(new JFrame(), true);
                dialog.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public JButton btnCancel;
    public JButton btnSave;
    public JButton btnUpdate;
    public JComboBox<String> cbCashFlow;
    public JComboBox<String> cbCategory;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JPanel jpContainer;
    private JLabel lblId;
    private JLabel lblOperationNumber;
    public JLabel lblTitle;
    public JTextField txtAmount;
    public JTextField txtDescription;
    // End of variables declaration//GEN-END:variables

    /**
     * Obtiene el flujo de efectivo validado del usuario.
     *
     * @return El flujo de efectivo asociado al usuario actual, como una cadena de texto.
     */
    public String getCashFlow() {
        String cashFlow = (String) cbCashFlow.getSelectedItem();
        if (cashFlow == null || cashFlow.isEmpty()) {
            Message.showWarning("Debe seleccionar un tipo de flujo de efectivo.");
        }
        return cashFlow;
    }

    /**
     * Obtiene la categoría asociada a la transacción.
     *
     * @return La categoría de transacción.
     */
    public String getCategory() {
        String category = (String) cbCategory.getSelectedItem();
        if (category == null || category.isEmpty()) {
            Message.showWarning("Debe seleccionar una categoría.");
        }
        return category;
    }

    /**
     * Obtiene la descripción asociada a la transacción.
     *
     * @return La descripción.
     */
    public String getDescription() {
        String description = txtDescription.getText().trim();
        if (description.isEmpty()) {
            Message.showWarning("La descripción no puede estar vacía.");
        }
        return description;
    }

    /**
     * Obtiene el monto asociado a la transacción.
     *
     * @return El monto de la transacción como un valor de tipo {@code double}.
     */
    public double getAmount() {
        String amountText = txtAmount.getText().trim();
        if (amountText.isEmpty()) {
            Message.showWarning("El monto no puede estar vacío.");
            return 0.0;
        }
        try {
            return Double.parseDouble(amountText);
        } catch (NumberFormatException e) {
            Message.showWarning("El monto debe ser un número válido.");
            return 0.0;
        }
    }

    /**
     * Verifica si alguno de los campos requeridos está vacío.
     *
     * @return {@code true} si alguno de los campos relevantes está vacío, de lo contrario {@code false}.
     */
    public boolean isFieldsEmpty() {
        return getCashFlow().isEmpty() || getCategory().isEmpty() || getDescription().isEmpty();
    }

    /**
     * Muestra los datos de la transacción en el formulario.
     * Este método establece los valores correspondientes de la transacción en los campos del formulario para la edición.
     *
     * @param transaction La transacción cuyos datos se mostrarán en el formulario.
     */
    public void setTransactionData(Transaction transaction) {
        lblOperationNumber.setText(transaction.getTransactionNumber());
        cbCashFlow.setSelectedItem(transaction.getTransactionType());
        cbCategory.setSelectedItem(transaction.getCategory());
        txtAmount.setText(String.valueOf(transaction.getAmount()));
        txtDescription.setText(transaction.getTransactionDescription());
        btnSave.setVisible(false);
        btnUpdate.setVisible(true);
        lblTitle.setText("Actualizar Transacción");
        setVisible(true);
    }

    /**
     * Verifica si la transacción es un ingreso o un egreso.
     * Según la opción seleccionada, carga la categoría correspondiente en el campo de categoría.
     */
    private void cashFlow() {
        String selectedItem = (String) cbCashFlow.getSelectedItem();
        switch (selectedItem) {
            case "Ingreso" -> {
                cbCategory.removeAllItems();
                String[] cashInflows = {"Salario", "Venta", "Intereses ganados", "Rendimientos por alquiler", "Dividendos", "Otros"};
                for (String cashInflow : cashInflows) {
                    cbCategory.addItem(cashInflow);
                }
            }
            case "Egreso" -> {
                cbCategory.removeAllItems();
                String[] cashInflows = {"Pago de servicios", "Renta", "Impuestos", "Mantenimiento", "Transporte", "Otros"};
                for (String cashInflow : cashInflows) {
                    cbCategory.addItem(cashInflow);
                }
            }
            case "Seleccionar tipo..." -> {
                cbCategory.removeAllItems();
                cbCategory.addItem("");
            }
            case null -> {}
            default -> {
            }
        }
    }

    /**
     * Limpia todos los campos del formulario, restableciéndolos a su estado vacío.
     */
    public void clearFields(){
        lblOperationNumber.setText("");
        cbCashFlow.setSelectedIndex(0);
        txtAmount.setText("");
        txtDescription.setText("");
    }
    
    private void initListeners(){
        cbCashFlow.addActionListener((ActionEvent e) -> {
            cashFlow();
        });
    }
}
