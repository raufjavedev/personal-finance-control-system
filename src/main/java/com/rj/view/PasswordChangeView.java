package com.rj.view;

import com.rj.util.Message;
import com.rj.util.RoundedPanelSwing;

import java.awt.*;
import java.util.Arrays;

public class PasswordChangeView extends javax.swing.JDialog {

    /**
     * Creates new form PasswordChangeView
     * @param parent
     * @param modal
     */
    public PasswordChangeView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initStyles();
    }

    private void initStyles(){
        this.setLocationRelativeTo(null);
        RoundedPanelSwing.applyBorderNoColor(jpPasswordChange, 20, new Color(18,25,41));

        btnChangePassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPasswordChange = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnChangePassword = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtCurrentPassword = new javax.swing.JPasswordField();
        txtNewPassword = new javax.swing.JPasswordField();
        txtRepeatPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jpPasswordChange.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cambiar la contraseña");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Contraseña actual");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Nueva contraseña");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Repita la contraseña");

        btnChangePassword.setText("Cambiar");

        btnCancel.setText("Cancelar");

        javax.swing.GroupLayout jpPasswordChangeLayout = new javax.swing.GroupLayout(jpPasswordChange);
        jpPasswordChange.setLayout(jpPasswordChangeLayout);
        jpPasswordChangeLayout.setHorizontalGroup(
            jpPasswordChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPasswordChangeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPasswordChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addGroup(jpPasswordChangeLayout.createSequentialGroup()
                        .addComponent(btnChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPasswordChangeLayout.createSequentialGroup()
                        .addGroup(jpPasswordChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtCurrentPassword)
                    .addComponent(txtNewPassword)
                    .addComponent(txtRepeatPassword, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jpPasswordChangeLayout.setVerticalGroup(
            jpPasswordChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPasswordChangeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCurrentPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRepeatPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPasswordChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChangePassword)
                    .addComponent(btnCancel))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpPasswordChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpPasswordChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PasswordChangeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasswordChangeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasswordChangeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasswordChangeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PasswordChangeView dialog = new PasswordChangeView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancel;
    public javax.swing.JButton btnChangePassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel jpPasswordChange;
    private javax.swing.JPasswordField txtCurrentPassword;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtRepeatPassword;
    // End of variables declaration//GEN-END:variables

    /**
     * Obtiene la contraseña actual del usuario.
     *
     * @return La contraseña actual del usuario.
     */
    public String getCurrentPassword(){
        char[] passwordChars = txtCurrentPassword.getPassword();

        if (passwordChars.length == 0) {
            Message.showWarning("La contraseña no puede estar vacía.");
        }

        String currentPassword = new String(passwordChars);
        Arrays.fill(passwordChars, '\0');
        return currentPassword;
    }

    /**
     * Obtiene la nueva contraseña del usuario.
     *
     * @return La nueva contraseña que el usuario ha ingresado.
     */
    public String getNewPassword(){
        char[] passwordChars = txtNewPassword.getPassword();

        if (passwordChars.length == 0) {
            Message.showWarning("La contraseña no puede estar vacía.");
        }

        String newPassword = new String(passwordChars);
        Arrays.fill(passwordChars, '\0');
        return newPassword;
    }

    /**
     * Obtiene la contraseña repetida ingresada por el usuario para confirmación.
     *
     * @return La contraseña repetida ingresada por el usuario.
     */
    public String getRepeatPassword(){
        char[] passwordChars = txtRepeatPassword.getPassword();

        if (passwordChars.length == 0) {
            Message.showWarning("Repita la contraseña.");
        }

        String repeatPassword = new String(passwordChars);
        Arrays.fill(passwordChars, '\0');
        return repeatPassword;
    }

    /**
     * Verifica si la contraseña cumple con los requisitos de longitud.
     *
     * @param password La contraseña que se va a validar.
     * @return {@code true} si la contraseña cumple con la longitud requerida, de lo contrario {@code false}.
     */
    public boolean isValidPassword(String password) {
        int minLength = 4;
        int maxLength = 8;

        if (password == null) {
            return true;
        }

        int length = password.length();
        return length < minLength || length > maxLength;
    }

    /**
     * Valida si algún campo (como nombre de usuario o contraseña) está vacío.
     *
     * @return {@code true} si algún campo está vacío, de lo contrario {@code false}.
     */
    public boolean isFieldsEmpty() {
        return getCurrentPassword().isEmpty() || getNewPassword().isEmpty() || getRepeatPassword().isEmpty();
    }

    /**
     * Limpia todos los campos, restableciéndolos a un estado vacío.
     */
    public void clearFields(){
        txtCurrentPassword.setText("");
        txtNewPassword.setText("");
        txtRepeatPassword.setText("");
    }
}
