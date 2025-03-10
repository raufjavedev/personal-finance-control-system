package com.rj.controller;

import com.rj.model.User;
import com.rj.service.TransactionService;
import com.rj.service.UserService;
import com.rj.util.UserSession;
import com.rj.view.MainApp;
import com.rj.view.ProfileView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileController implements ActionListener {
    private final UserService userService;
    private final TransactionService transactionService;
    private final MainApp mainApp;
    private final ProfileView profileView;

    public ProfileController(UserService userService, TransactionService transactionService, MainApp mainApp, ProfileView profileView) {
        this.userService = userService;
        this.transactionService = transactionService;
        this.mainApp = mainApp;
        this.profileView = profileView;

        this.mainApp.btnProfile.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainApp.btnProfile) {
            showProfile();
        }
    }

    /**
     * Mostrar datos del usuario en perfil
     */
    private void showProfile() {
        int userId = UserSession.getInstance().getUserId();

        User user = userService.getUserData(userId);

        double totalIncome = transactionService.getTotalIncome(userId); // Obtiene el total de ingresos.
        double totalExpense = transactionService.getTotalExpenses(userId); // Obtiene el total de egresos.

        // Mostrar datos del usuario
        profileView.profileDetails(user);
        profileView.displayTotalIncome(totalIncome);
        profileView.displayTotalExpense(totalExpense);
        
        // Abrir la vista
        mainApp.JPanel(profileView);
    }

}
