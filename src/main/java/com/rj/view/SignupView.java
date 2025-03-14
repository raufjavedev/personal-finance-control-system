package com.rj.view;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.rj.util.Message;
import com.rj.util.RoundedPanelSwing;
import java.awt.Color;
import java.awt.Cursor;
import java.util.Arrays;

public class SignupView extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public SignupView() {
        initComponents();
        initStyle();
    }

    private void initStyle() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        RoundedPanelSwing.applyBorderNoColor(jpCreateAccount, 20, new Color(18, 25, 41));
        btnCreateAccount.setBackground(new Color(31, 97, 141));

        txtUsername.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON,
                new FlatSVGIcon(getClass().getResource("/icons/person.svg")));
        txtPassword.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON,
                new FlatSVGIcon(getClass().getResource("/icons/lock.svg")));
        txtKeyword.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON,
                new FlatSVGIcon(getClass().getResource("/icons/key.svg")));
        txtPassword.putClientProperty(FlatClientProperties.STYLE, "showRevealButton:true");

        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCreateAccount.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpCreateAccount = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        btnCreateAccount = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtKeyword = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpCreateAccount.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Crear nueva cuenta");

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Nombre de usuario");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Contraseña");

        btnCreateAccount.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnCreateAccount.setText("Crear Cuenta");

        btnLogin.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnLogin.setText("Iniciar Sesión");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Palabra clave para recuperar la cuenta");

        txtKeyword.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel5.setText("(De 4 a 8 caracteres)");

        javax.swing.GroupLayout jpCreateAccountLayout = new javax.swing.GroupLayout(jpCreateAccount);
        jpCreateAccount.setLayout(jpCreateAccountLayout);
        jpCreateAccountLayout.setHorizontalGroup(
                jpCreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpCreateAccountLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(jpCreateAccountLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jpCreateAccountLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jpCreateAccountLayout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel5))
                                        .addComponent(jLabel2)
                                        .addComponent(txtUsername)
                                        .addComponent(txtPassword)
                                        .addComponent(btnCreateAccount, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 261,
                                                Short.MAX_VALUE)
                                        .addComponent(jSeparator1)
                                        .addComponent(jLabel4)
                                        .addComponent(txtKeyword))
                                .addContainerGap(58, Short.MAX_VALUE)));
        jpCreateAccountLayout.setVerticalGroup(
                jpCreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpCreateAccountLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jpCreateAccountLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btnCreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22,
                                        Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jpCreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(64, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jpCreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(49, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignupView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCreateAccount;
    public javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpCreateAccount;
    public javax.swing.JTextField txtKeyword;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    /**
     * Obtiene el nombre de usuario del usuario.
     *
     * @return El nombre de usuario asociado al usuario actual.
     */
    public String getUsername() {
        String username = txtUsername.getText().trim();
        if (username.isEmpty()) {
            Message.showWarning("El nombre de usuario no puede estar vacío.");
        }
        return username;
    }

    /**
     * Obtiene la palabra clave de recuperación de cuenta del usuario.
     *
     * @return La palabra clave de recuperación de cuenta ingresada por el usuario.
     */
    public String getKeyword() {
        String keyword = txtKeyword.getText().trim();
        if (keyword.isEmpty()) {
            Message.showWarning("La palabra clave no puede estar vacía.");
        }
        return keyword;
    }

    /**
     * Obtiene la contraseña ingresada por el usuario.
     *
     * @return La contraseña que el usuario ha proporcionado.
     */
    public String getPassword() {
        char[] passwordChars = txtPassword.getPassword();
        if (passwordChars.length == 0) {
            Message.showWarning("La contraseña no puede estar vacía.");
        }
        String password = new String(passwordChars);
        Arrays.fill(passwordChars, '\0'); // Destruir la contraseña
        return password;
    }

    /**
     * Verifica si la longitud de la contraseña proporcionada es válida.
     *
     * @param password La contraseña que se va a verificar.
     * @return {@code true} si la longitud de la contraseña es válida, de lo contrario {@code false}.
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
     * Limpia todos los campos de la vista, restableciéndolos a su estado vacío.
     */
    public void clearFields() {
        txtUsername.setText("");
        txtKeyword.setText("");
        txtPassword.setText("");
    }

    /**
     * Valida si algún campo requerido está vacío.
     *
     * @return {@code true} si alguno de los campos relevantes está vacío, de lo contrario {@code false}.
     */
    public boolean isFieldsEmpty() {
        return getUsername().isEmpty() || getKeyword().isEmpty() || getPassword().isEmpty();
    }
}
