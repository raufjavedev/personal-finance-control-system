package com.rj.view;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.rj.model.Transaction;
import com.rj.util.Currency;
import com.rj.util.RoundedPanelSwing;
import org.jfree.chart.ChartPanel;

import java.awt.*;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class DashboardView extends javax.swing.JPanel {

    public DashboardView() {
        initComponents();
        initStyles();
    }

    private void initStyles() {
        DefaultTableModel model = new DefaultTableModel();
        String[] columnNames = { "Operación", "Concepto", "Fecha", "Monto" };
        for (String columnName : columnNames) {
            model.addColumn(columnName);
            transactionHistoryTable.setModel(model);
        }

        // Icono de saldo
        FlatSVGIcon balance = new FlatSVGIcon(getClass().getResource("/icons/money_bag.svg"));
        lblBalanceIcon.setIcon(balance);
        lblBalanceIcon.setText("");

        // Icono de ingreso
        FlatSVGIcon income = new FlatSVGIcon(getClass().getResource("/icons/account_balance_wallet.svg"));
        lblIncomeIcon.setIcon(income);
        lblIncomeIcon.setText("");

        // Icono de gasto
        FlatSVGIcon expense = new FlatSVGIcon(getClass().getResource("/icons/wallet.svg"));
        lblExpenseIcon.setIcon(expense);
        lblExpenseIcon.setText("");

        // Icono de perfil
        FlatSVGIcon profile = new FlatSVGIcon(getClass().getResource("/icons/account_circle.svg"));
        lblImage.setIcon(profile);
        lblImage.setText("");

        // calendario
        jCalendar.setDecorationBackgroundColor(new Color(31, 97, 141));
        jCalendar.setWeekdayForeground(Color.WHITE);
        jCalendar.setDecorationBackgroundColor(new Color(52, 152, 219));

        // DashboardView
        // RoundedPanel.applyRoundedBorder(jpBalance, 20, new Color(18,25,41),
        // Color.CYAN); //210,228,238
        RoundedPanelSwing.applyBorderWithColor(jpBalance, 20, new Color(18, 25, 41), Color.CYAN);
        RoundedPanelSwing.applyBorderWithColor(jpIncome, 20, new Color(18, 25, 41), Color.GREEN);
        RoundedPanelSwing.applyBorderWithColor(jpExpense, 20, new Color(18, 25, 41), Color.RED);

        // Calendario
        RoundedPanelSwing.applyBorderNoColor(jpCalendar, 20, new Color(18, 25, 41));

        // Cuenta
        RoundedPanelSwing.applyBorderNoColor(jpAccount, 20, new Color(18, 25, 41));
        // Ingreso reciente
        RoundedPanelSwing.applyBorderNoColor(jpRecentIncome, 20, new Color(18, 25, 41));
        // Egreso reciente
        RoundedPanelSwing.applyBorderNoColor(jpRecentExpenses, 20, new Color(18, 25, 41));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactionHistoryTable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jpGraphic = new javax.swing.JPanel();
        jpInfo = new javax.swing.JPanel();
        jpCalendar = new javax.swing.JPanel();
        jCalendar = new com.toedter.calendar.JCalendar();
        jpRecentExpenses = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        lblExpensesAmount = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblExpensesCategory = new javax.swing.JLabel();
        lblDateExpenses = new javax.swing.JLabel();
        jpRecentIncome = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblLastIncomeAmount = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblIncomeCategory = new javax.swing.JLabel();
        lblDateIncome = new javax.swing.JLabel();
        jpAccount = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        jpIncome = new javax.swing.JPanel();
        lblIncomeIcon = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTotalIncome = new javax.swing.JLabel();
        jpExpense = new javax.swing.JPanel();
        lblExpenseIcon = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTotalExpenses = new javax.swing.JLabel();
        jpBalance = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        lblBalanceIcon = new javax.swing.JLabel();

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Últimos cinco transacciones");

        transactionHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(transactionHistoryTable);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Ingresos y Egresos de los Últimos 12 Meses");

        jpGraphic.setLayout(new java.awt.BorderLayout());

        jCalendar.setBackground(new java.awt.Color(18, 25, 41));

        javax.swing.GroupLayout jpCalendarLayout = new javax.swing.GroupLayout(jpCalendar);
        jpCalendar.setLayout(jpCalendarLayout);
        jpCalendarLayout.setHorizontalGroup(
            jpCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCalendarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpCalendarLayout.setVerticalGroup(
            jpCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCalendarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Último Egreso");

        lblExpensesAmount.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblExpensesAmount.setForeground(new java.awt.Color(169, 50, 38));
        lblExpensesAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExpensesAmount.setText("Monto");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Detalle:");

        jLabel19.setText("Categoría:");

        jLabel20.setText("Fecha y Hora:");

        lblExpensesCategory.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblExpensesCategory.setText("Categoría");

        lblDateExpenses.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDateExpenses.setText("Fecha y Hora");

        javax.swing.GroupLayout jpRecentExpensesLayout = new javax.swing.GroupLayout(jpRecentExpenses);
        jpRecentExpenses.setLayout(jpRecentExpensesLayout);
        jpRecentExpensesLayout.setHorizontalGroup(
            jpRecentExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRecentExpensesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpRecentExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblExpensesAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpRecentExpensesLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpRecentExpensesLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jpRecentExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpRecentExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDateExpenses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblExpensesCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jpRecentExpensesLayout.setVerticalGroup(
            jpRecentExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRecentExpensesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblExpensesAmount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpRecentExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(lblExpensesCategory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpRecentExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(lblDateExpenses))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Último Ingreso");

        lblLastIncomeAmount.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblLastIncomeAmount.setForeground(new java.awt.Color(23, 165, 137));
        lblLastIncomeAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLastIncomeAmount.setText("Monto");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Detalle:");

        jLabel7.setText("Categoría:");

        jLabel9.setText("Fecha y Hora:");

        lblIncomeCategory.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIncomeCategory.setText("Categoría");

        lblDateIncome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDateIncome.setText("Fecha y Hora");

        javax.swing.GroupLayout jpRecentIncomeLayout = new javax.swing.GroupLayout(jpRecentIncome);
        jpRecentIncome.setLayout(jpRecentIncomeLayout);
        jpRecentIncomeLayout.setHorizontalGroup(
            jpRecentIncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRecentIncomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpRecentIncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLastIncomeAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpRecentIncomeLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpRecentIncomeLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jpRecentIncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpRecentIncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDateIncome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIncomeCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jpRecentIncomeLayout.setVerticalGroup(
            jpRecentIncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRecentIncomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLastIncomeAmount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpRecentIncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblIncomeCategory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpRecentIncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblDateIncome))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setText("Icono");

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setText("Nombre");

        javax.swing.GroupLayout jpAccountLayout = new javax.swing.GroupLayout(jpAccount);
        jpAccount.setLayout(jpAccountLayout);
        jpAccountLayout.setHorizontalGroup(
            jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpAccountLayout.setVerticalGroup(
            jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblName)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpInfoLayout = new javax.swing.GroupLayout(jpInfo);
        jpInfo.setLayout(jpInfoLayout);
        jpInfoLayout.setHorizontalGroup(
            jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpRecentExpenses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpRecentIncome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpInfoLayout.setVerticalGroup(
            jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpRecentIncome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpRecentExpenses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpIncome.setBackground(new java.awt.Color(153, 153, 153));

        lblIncomeIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIncomeIcon.setText("Icono");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel6.setText("Ingreso Total");

        lblTotalIncome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTotalIncome.setText("jLabel2");
        lblTotalIncome.setToolTipText("");

        javax.swing.GroupLayout jpIncomeLayout = new javax.swing.GroupLayout(jpIncome);
        jpIncome.setLayout(jpIncomeLayout);
        jpIncomeLayout.setHorizontalGroup(
            jpIncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpIncomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpIncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalIncome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lblIncomeIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpIncomeLayout.setVerticalGroup(
            jpIncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpIncomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpIncomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIncomeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpIncomeLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotalIncome, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jpExpense.setBackground(new java.awt.Color(153, 153, 153));

        lblExpenseIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExpenseIcon.setText("Icono");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel10.setText("Egreso Total");

        lblTotalExpenses.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTotalExpenses.setText("jLabel2");
        lblTotalExpenses.setToolTipText("");

        javax.swing.GroupLayout jpExpenseLayout = new javax.swing.GroupLayout(jpExpense);
        jpExpense.setLayout(jpExpenseLayout);
        jpExpenseLayout.setHorizontalGroup(
            jpExpenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpExpenseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpExpenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalExpenses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lblExpenseIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpExpenseLayout.setVerticalGroup(
            jpExpenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpExpenseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpExpenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblExpenseIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpExpenseLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotalExpenses, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jpBalance.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setText("Saldo Actual");

        lblBalance.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblBalance.setText("jLabel2");
        lblBalance.setToolTipText("");

        lblBalanceIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBalanceIcon.setText("Icono");
        lblBalanceIcon.setToolTipText("");

        javax.swing.GroupLayout jpBalanceLayout = new javax.swing.GroupLayout(jpBalance);
        jpBalance.setLayout(jpBalanceLayout);
        jpBalanceLayout.setHorizontalGroup(
            jpBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBalanceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lblBalanceIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpBalanceLayout.setVerticalGroup(
            jpBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBalanceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBalanceIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpBalanceLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblBalance, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jpGraphic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jpBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpIncome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpExpense, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jpIncome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpBalance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpExpense, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpGraphic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jpInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar jCalendar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpAccount;
    private javax.swing.JPanel jpBalance;
    private javax.swing.JPanel jpCalendar;
    private javax.swing.JPanel jpExpense;
    public javax.swing.JPanel jpGraphic;
    private javax.swing.JPanel jpIncome;
    private javax.swing.JPanel jpInfo;
    private javax.swing.JPanel jpRecentExpenses;
    private javax.swing.JPanel jpRecentIncome;
    public javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblBalanceIcon;
    public javax.swing.JLabel lblDateExpenses;
    public javax.swing.JLabel lblDateIncome;
    private javax.swing.JLabel lblExpenseIcon;
    public javax.swing.JLabel lblExpensesAmount;
    public javax.swing.JLabel lblExpensesCategory;
    private javax.swing.JLabel lblImage;
    public javax.swing.JLabel lblIncomeCategory;
    private javax.swing.JLabel lblIncomeIcon;
    public javax.swing.JLabel lblLastIncomeAmount;
    public javax.swing.JLabel lblName;
    public javax.swing.JLabel lblTotalExpenses;
    public javax.swing.JLabel lblTotalIncome;
    public javax.swing.JTable transactionHistoryTable;
    // End of variables declaration//GEN-END:variables

    /**
     * Actualiza el nombre del usuario en la vista.
     *
     * @param firstName El nuevo nombre del usuario que se mostrará en la etiqueta.
     */
    public void setUserName(String firstName) {
        lblName.setText(firstName);
    }

    /**
     * Actualiza el saldo total mostrado en la vista.
     *
     * @param balance El nuevo saldo total del usuario que se mostrará en la interfaz.
     */
    public void setBalance(double balance) {
        // lblTotalIncome.setText(String.format("S/ %.2f", balance));
        lblBalance.setText(Currency.currencySymbol() +" "+ Currency.formatCurrency(balance));
    }

    /**
     * Muestra el total de ingresos en la interfaz de usuario.
     *
     * @param totalIncome El monto total de ingresos que se actualizará en la vista.
     */
    public void setTotalIncome(double totalIncome) {
        lblTotalIncome.setText(Currency.currencySymbol() +" "+ Currency.formatCurrency(totalIncome));
    }

    /**
     * Muestra el total de egresos en la interfaz de usuario.
     *
     * @param totalExpenses El monto total de egresos que se actualizará en la vista.
     */
    public void setTotalExpenses(double totalExpenses) {
        lblTotalExpenses.setText(Currency.currencySymbol() +" "+ Currency.formatCurrency(totalExpenses));
    }

    /**
     * Establece el último ingreso en la interfaz de usuario, mostrando detalles adicionales.
     *
     * @param amount   El monto del último ingreso.
     * @param category La categoría del ingreso (por ejemplo, salario, ventas, etc.).
     * @param date     La fecha en que se registró el ingreso.
     * @param time     La hora en que se registró el ingreso.
     */
    public void setLastIncome(double amount, String category, Date date, String time) {
        lblLastIncomeAmount.setText(Currency.currencySymbol() +" "+Currency.formatCurrency(amount));
        lblIncomeCategory.setText(category);
        lblDateIncome.setText(
                (date != null && time != null)
                        ? String.format("%s %s", date, time)
                        : "Sin fecha");
    }

    /**
     * Establece el último egreso en la interfaz de usuario, mostrando detalles adicionales.
     *
     * @param amount   El monto del último egreso.
     * @param category La categoría del egreso (por ejemplo, comida, transporte, etc.).
     * @param date     La fecha en que se registró el egreso.
     * @param time     La hora en que se registró el egreso.
     */
    public void setLastExpense(double amount, String category, Date date, String time) {
        lblExpensesAmount.setText("- " + Currency.currencySymbol() +" "+ Currency.formatCurrency(amount));
        lblExpensesCategory.setText(category);
        lblDateExpenses.setText(
                (date != null && time != null)
                        ? String.format("%s %s", date, time)
                        : "Sin fecha");
    }

    /**
     * Actualiza el historial de transacciones recientes en la interfaz de usuario.
     *
     * @param recentTransactions Una lista de transacciones recientes que se mostrarán en la vista.
     */
    public void updateTransactionHistory(List<Transaction> recentTransactions) {
        DefaultTableModel model = (DefaultTableModel) transactionHistoryTable.getModel();
        model.setRowCount(0); // Limpiar la tabla

        for (Transaction transaction : recentTransactions) {
            model.addRow(new Object[] {
                    transaction.getTransactionType(),
                    transaction.getCategory(),
                    transaction.getRegistrationDate(),
                    Currency.currencySymbol()+" "+Currency.formatCurrency(transaction.getAmount())
            });
        }
    }

    /**
     * Limpia el historial de transacciones recientes en la interfaz de usuario.
     * Elimina todas las transacciones mostradas previamente.
     */
    public void clearTransactionHistory() {
        DefaultTableModel model = (DefaultTableModel) transactionHistoryTable.getModel();
        model.setRowCount(0); // Limpia todas las filas de la tabla
    }

    /**
     * Actualiza el panel gráfico en la interfaz de usuario con un nuevo gráfico.
     *
     * @param chartPanel El nuevo panel de gráfico que se mostrará en la vista.
     */
    public void updateGraphicPanel(ChartPanel chartPanel) {
        jpGraphic.removeAll();
        jpGraphic.setLayout(new BorderLayout());
        jpGraphic.add(chartPanel, BorderLayout.CENTER);
        jpGraphic.revalidate();
        jpGraphic.repaint();
    }

    /**
     * Limpia el panel gráfico en la interfaz de usuario si no hay datos disponibles.
     * Elimina cualquier gráfico existente para mostrar un estado vacío.
     */
    public void clearGraphicPanel() {
        jpGraphic.removeAll();
        jpGraphic.revalidate();
        jpGraphic.repaint();
    }
}
