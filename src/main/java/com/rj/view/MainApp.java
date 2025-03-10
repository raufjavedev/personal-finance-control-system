package com.rj.view;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.rj.util.Sidebar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

public final class MainApp extends javax.swing.JFrame {

    public MainApp() {
        initComponents();
        initStyles();
    }

    private void initStyles() {
        this.setLocationRelativeTo(null);
        
        FlatSVGIcon logo = new FlatSVGIcon(getClass().getResource("/icons/bxs-bank.svg"));
        lblLogo.setIcon(logo);
        lblLogo.setText("");

        // btn Home
        FlatSVGIcon home = new FlatSVGIcon(getClass().getResource("/icons/bxs-home.svg"));
        btnHome.setIcon(home);
        btnHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnHome.setToolTipText("Inicio");

        // btn Estadistica
        FlatSVGIcon statistics = new FlatSVGIcon(getClass().getResource("/icons/bx-chart.svg"));
        btnReport.setIcon(statistics);
        btnReport.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnReport.setToolTipText("Estadistica");

        // btn Estadistica
        FlatSVGIcon iconRecord = new FlatSVGIcon(getClass().getResource("/icons/bx-list.svg"));
        btnRecord.setIcon(iconRecord);
        btnRecord.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRecord.setToolTipText("Historial");

        // btn Egreso
        FlatSVGIcon expense = new FlatSVGIcon(getClass().getResource("/icons/bxs-wallet.svg"));
        btnTransactions.setIcon(expense);
        btnTransactions.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnTransactions.setToolTipText("Nueva Transacción");

        // btn Ajustes
        FlatSVGIcon setting = new FlatSVGIcon(getClass().getResource("/icons/manage_accounts.svg"));
        btnProfile.setIcon(setting);
        btnProfile.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnProfile.setToolTipText("Ajustes");

        // btn Salir
        FlatSVGIcon logout = new FlatSVGIcon(getClass().getResource("/icons/bx-power-off.svg"));
        btnExit.setIcon(logout);
        btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnExit.setToolTipText("Cerrar Sesión");

        // Menu
        List<JButton> buttons = Arrays.asList(btnHome, btnReport, btnRecord, btnTransactions, btnProfile, btnExit);
        // Crear el administrador de colores
        Sidebar colorManager = new Sidebar(new Color(31, 97, 141), new Color(18, 25, 41));
        colorManager.setActiveButton(btnHome, buttons); // Activo por defecto

        btnHome.addActionListener(e -> {
            colorManager.setActiveButton(btnHome, buttons);
        });
        btnReport.addActionListener(e -> {
            colorManager.setActiveButton(btnReport, buttons);
        });
        btnRecord.addActionListener(e -> {
            colorManager.setActiveButton(btnRecord, buttons);
        });
        btnProfile.addActionListener(e -> {
            colorManager.setActiveButton(btnProfile, buttons);
        });
    }

    public void JPanel(JPanel panel) {
        jpContainer.removeAll();
        jpContainer.add(panel, BorderLayout.CENTER);
        jpContainer.revalidate();
        jpContainer.repaint();
    }

    // Mensaje de confirmación para cerrar sesión
    public int showLogoutConfirmationDialog() {
        return JOptionPane.showConfirmDialog(
                this,
                "¿Cerrar sesión?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        btnTransactions = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();
        btnRecord = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jpContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(18, 25, 41));

        lblLogo.setText("Lo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 9, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jpContainer.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 1069, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnExit;
    public javax.swing.JButton btnHome;
    public javax.swing.JButton btnProfile;
    public javax.swing.JButton btnRecord;
    public javax.swing.JButton btnReport;
    public javax.swing.JButton btnTransactions;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jpContainer;
    private javax.swing.JLabel lblLogo;
    // End of variables declaration//GEN-END:variables
}
