package com.rj.main;

import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import com.rj.controller.*;
import com.rj.service.implementations.ReportServiceImpl;
import com.rj.service.implementations.TransactionServiceImpl;
import com.rj.service.implementations.UserServiceImpl;
import com.rj.service.ReportService;
import com.rj.service.TransactionService;
import com.rj.service.UserService;
import com.rj.view.*;

import javax.swing.*;

/**
 * Clase principal de la aplicación.
 * <p>
 * Inicializa la aplicación y configura los componentes necesarios.
 */
public class Main {

    public static void main(String[] args) {
        // Configura el tema visual de la aplicación con FlatLaf.
       try {
            UIManager.setLookAndFeel( new FlatArcDarkIJTheme() );
            UIManager.put( "TabbedPane.showTabSeparators", true );
        } catch( UnsupportedLookAndFeelException e ) {
            System.err.println( "Failed to initialize LaF" +e );
        }

        // Crear las vistas
        MainApp mainApp = new MainApp();
        LoginView loginView = new LoginView();
        SignupView signupView = new SignupView();
        ProfileView profileView = new ProfileView();
        TransactionView transactionView = new TransactionView();
        TransactionFormView transactionFormView = new TransactionFormView(mainApp, true);
        DashboardView dashboardView = new DashboardView();
        ReportView reportView = new ReportView();
        PasswordChangeView passwordChangeView = new PasswordChangeView(mainApp, true);
        PasswordRecoveryView passwordRecoveryView = new PasswordRecoveryView(mainApp, true);

        // Crear los servicios
        UserService userService = new UserServiceImpl();
        TransactionService transactionService = new TransactionServiceImpl();
        ReportService reportService = new ReportServiceImpl();

        // Crear el controlador del login
        UserController userController = new UserController(userService, loginView, signupView, mainApp, profileView, passwordRecoveryView, passwordChangeView);

        // Establecer el listener para el éxito del login
        userController.setLoginSuccessListener(() -> {
            // Después del login exitoso, crear otros controladores
            new TransactionController(transactionService, mainApp, transactionView, transactionFormView);
            new ReportController(reportService, mainApp, reportView);
            new ProfileController(userService, transactionService, mainApp, profileView);
            new DashboardController(transactionService, userService, reportService, mainApp, dashboardView);

            // Mostrar la vista principal
            mainApp.setVisible(true);
        });

        // Mostrar la vista de login
        loginView.setVisible(true);
    }
}
