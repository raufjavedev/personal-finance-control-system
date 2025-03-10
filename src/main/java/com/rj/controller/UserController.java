package com.rj.controller;

import com.rj.listeners.LoginSuccessListener;
import com.rj.model.User;
import com.rj.service.UserService;
import com.rj.util.Message;
import com.rj.util.UserSession;
import com.rj.view.LoginView;
import com.rj.view.MainApp;
import com.rj.view.PasswordChangeView;
import com.rj.view.PasswordRecoveryView;
import com.rj.view.ProfileView;
import com.rj.view.SignupView;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Controlador para gestionar las acciones del usuario en la interfaz.
 * Implementa la interfaz {@code ActionListener} para manejar los eventos de acción del usuario, como clics en botones o selecciones.
 * Este controlador se encarga de recibir las acciones del usuario y actualizar la vista o el modelo según sea necesario.
 */
public class UserController implements ActionListener{
    private final UserService userService;
    private final LoginView loginView;
    private final SignupView signupView;
    private final MainApp mainApp;
    private final ProfileView profileView;
    private final PasswordRecoveryView passwordRecoveryView;
    private final PasswordChangeView passwordChangeView;
    private LoginSuccessListener loginSuccessListener; // Listener para notificar el éxito del login

    public UserController(UserService userService, LoginView loginView, SignupView signupView, MainApp mainApp, ProfileView profileView, PasswordRecoveryView passwordRecoveryView, PasswordChangeView passwordChangeView) {
        this.userService = userService;
        this.loginView = loginView;
        this.signupView = signupView;
        this.mainApp = mainApp;
        this.profileView = profileView;
        this.passwordRecoveryView = passwordRecoveryView;
        this.passwordChangeView = passwordChangeView;

        loginView.btnLogin.addActionListener(this);
        loginView.btnSignUp.addActionListener(this);
        signupView.btnCreateAccount.addActionListener(this);
        signupView.btnLogin.addActionListener(this);
        mainApp.btnExit.addActionListener(this);
        profileView.btnSaveChanges.addActionListener(this);
        profileView.btnDeleteAccount.addActionListener(this);
        profileView.btnChangePassword.addActionListener(this);
        passwordRecoveryView.btnRecoverAccount.addActionListener(this);
        passwordRecoveryView.btnCancel.addActionListener(this);
        passwordChangeView.btnChangePassword.addActionListener(this);
        passwordChangeView.btnCancel.addActionListener(this);
        
        initMouseListeners();

    }

    /**
     * Establece el listener que se activará cuando el inicio de sesión sea exitoso.
     * Este listener permite que otras partes del sistema reaccionen a un inicio de sesión exitoso,
     * por ejemplo, redirigiendo a la vista principal o mostrando un mensaje de bienvenida.
     *
     * @param listener El listener que manejará los eventos de inicio de sesión exitoso.
     */
    public void setLoginSuccessListener(LoginSuccessListener listener) {
        this.loginSuccessListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginView.btnLogin) {
            login();
        }
        if (e.getSource() == loginView.btnSignUp) {
            loginView.dispose();
            signupView.setVisible(true);
        }
        if (e.getSource() == signupView.btnCreateAccount) {
            createAccount();
        }
        if (e.getSource() == signupView.btnLogin) {
            signupView.dispose();
            loginView.setVisible(true);
        }
        if (e.getSource() == mainApp.btnExit) {
            logout();
        }
        if (e.getSource() == profileView.btnSaveChanges) {
            updateUser();
        }
        if (e.getSource() == profileView.btnDeleteAccount) {
            deleteAccountByUserId();
        }
        if (e.getSource() == profileView.btnChangePassword) {
            passwordChangeView.clearFields();
            passwordChangeView.setVisible(true);
        }
        if (e.getSource() == passwordRecoveryView.btnRecoverAccount){
            recoveryAccount();
        }
        if (e.getSource() == passwordRecoveryView.btnCancel){
            passwordRecoveryView.dispose();
        }
        if (e.getSource() == passwordChangeView.btnChangePassword){
            updatePassword();
        }
        if (e.getSource() == passwordChangeView.btnCancel){
            passwordChangeView.dispose();
        }
    }
    
    private void initMouseListeners() {
        loginView.lblForgotPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                passwordRecoveryView.clearFields();
                passwordRecoveryView.setVisible(true);
            }
        });
    }

    /**
     * Realiza el proceso de inicio de sesión.
     * <p>
     * Válida los campos del formulario y, si están completos, intenta validar las credenciales del usuario a través del servicio {@code userService.getUserIdByCredentialsAndLogin}.
     * Si las credenciales son correctas, se guarda el ID del usuario mediante {@code UserSession.getInstance()} y se notifica mediante {@code LoginSuccessListener} que el inicio de sesión fue exitoso.
     * Si el inicio de sesión es fallido, se muestra un mensaje de error.
     */
    public void login() {
        // Verificar si algún campo está vacío
        if (loginView.isFieldsEmpty()) {
            return;
        }
        try {
            String username = loginView.getUsername();
            String plainPassword = loginView.getPassword();

            int userId = userService.getUserIdByCredentialsAndLogin(username, plainPassword);

            if (userId != -1) {
                loginView.clearFields();
                loginView.dispose();
                // Inicio de sesión exitoso
                UserSession.getInstance().login(userId); // Almacenar el ID del usuario

                // Notificar que el login fue exitoso
                if (loginSuccessListener != null) {
                    loginSuccessListener.onLoginSuccess();
                }
            } else {
                Message.showError("Credenciales inválidas. Inténtalo de nuevo.");
            }
        } catch (Exception e) {
            Message.showError("Ocurrió un error inesperado: " + e.getMessage());
        }
    }

    /**
     * Crea una nueva cuenta de usuario.
     * Primero, verifica si algún campo del formulario está vacío. Si algún campo está vacío, la operación se detiene.
     * Luego, se valida que la longitud de la contraseña cumpla con los requisitos y que el nombre de usuario y la palabra clave no existan ya en el sistema.
     * Si las validaciones son exitosas, se realiza un hash de la contraseña mediante {@code BCrypt.hashpw} y se crea un objeto {@code User} con los datos proporcionados
     * y lo envía a {@code userService.addUser()}. Muestra un mensaje de éxito o error
     * según el resultado.
     */
    private void createAccount() {
        // Verificar si algún campo está vacío
        if (signupView.isFieldsEmpty()) {
            return; // Ya se muestra el mensaje en la vista
        }

        String firstName = signupView.getUsername();
        String username = signupView.getUsername();
        String keyword = signupView.getKeyword();
        String password = signupView.getPassword();


        // Validar longitud de la contraseña
        if (signupView.isValidPassword(password)) {
            Message.showWarning("La contraseña no cumple con los requisitos de longitud.");
            return;
        }

        // Verificar si el nombre de usuario o palabra clave existen
        if (userService.usernameExist(username)) {
            Message.showWarning("El nombre de usuario ya existe.");
            return;
        } else if (userService.keywordExist(keyword)) {
            Message.showWarning("La palabra clave ya existe.");
            return;
        }

        // Realizar hash de la contraseña
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        // Crear el objeto Usuario
        User user = new User();
        user.setFirstName(firstName);
        user.setUsername(username);
        user.setKeyword(keyword);
        user.setPassword(hashedPassword);

        // Agregar el usuario al servicio
        if (userService.addUser(user)) {
            Message.showSuccess("Cuenta creada con éxito");
            signupView.clearFields();
            signupView.dispose();
            // Mostrar la vista de login
            loginView.setVisible(true);
        } else {
            Message.showError("Ocurrió un error al crear la cuenta.");
        }

    }

    /**
     * Actualiza los datos del usuario existente.
     * <p>
     * Primero, verifica si algún campo del formulario está vacío. Si algún campo está vacío, la operación se detiene.
     * Luego, verifica si el nombre de usuario y la palabra clave ya existen en la base de datos para evitar duplicados.
     * Se crea un objeto {@code User} con los datos proporcionados y lo envía a {@code userService.updateUser()}.
     * Si la actualización es exitosa, se muestra un mensaje de éxito. Si ocurre algún error, se muestra un mensaje de error.
     */
    private void updateUser() {
        // Verificar si algún campo está vacío
        if (profileView.isFieldsEmpty()) {
            return; // Ya se muestra el mensaje en la vista
        }

        String firstName = profileView.getFirstName();
        String lastName = profileView.getLastName();
        String username = profileView.getUsername();
        String keyword = profileView.getKeyword();

        int userId = UserSession.getInstance().getUserId();
        User userData = userService.getUserData(userId);

        // Verificar si el nombre de usuario y palabra clave son los mismos
        if (!username.equals(userData.getUsername()) && !keyword.equals(userData.getKeyword())) {
            // Verificar si el nombre de usuario o palabra clave existen
            if (userService.usernameExist(username)) {
                Message.showWarning("El nombre de usuario ya existe.");
                return;
            } else if (userService.keywordExist(keyword)) {
                Message.showWarning("La palabra clave ya existe.");
                return;
            }
        }

        // Crear el objeto Usuario
        User user = new User();
        user.setUserId(userId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setKeyword(keyword);

        // Agregar el usuario al servicio
        if (userService.updateUser(user)) {
            Message.showSuccess("Datos actualizados.");
        } else {
            Message.showError("Ocurrió un error al actualizar.");
        }

    }

    /**
     * Elimina la cuenta del usuario después de una confirmación.
     * <p>
     * Si se confirma, se elimina la cuenta y se redirige al login.
     * En caso de error, muestra un mensaje de error.
     */
    private void deleteAccountByUserId(){
        int userId = UserSession.getInstance().getUserId();

        // Confirmación de eliminación
        int option = Message.showConfirm("¿Está seguro de eliminar la cuenta?\nRecuerde que se eliminarán todas las transacciones.");
        if (option != JOptionPane.NO_OPTION) {
            userService.deleteUserAndTransactions(userId);
            UserSession.getInstance().logout();
            mainApp.dispose();
            loginView.setVisible(true);
        }
    }

    /**
     * Cierra la sesión del usuario actual y redirige a la vista de login.
     */
    public void logout() {
        // Solicitar confirmación a través de la vista
        int option = mainApp.showLogoutConfirmationDialog();
        if (option == JOptionPane.YES_OPTION) {
            // Limpiar la sesión
            UserSession.getInstance().logout();

            // Cerrar la vista principal y mostrar la pantalla de inicio de sesión
            mainApp.dispose();
            loginView.setVisible(true);
        }
    }

    /**
     * Recuperar la cuenta.
     * <p>
     * Verifica si la palabra clave es válida mediante {@code userService.keywordExist()}.
     * Si la palabra clave no es válida, termina la operación.
     * Verifica si la contraseña cumple los requisitos; si cumple, la encripta mediante {@code  BCrypt.hashpw()}
     * y lo envía a {@code userService.updatePasswordByKeyword()} para su recuperación.
     */
    private void recoveryAccount(){
        // Verificar si algún campo está vacío
        if (passwordRecoveryView.isFieldsEmpty()) {
            return;
        }

        String keyword = passwordRecoveryView.getKeyword();
        String newPassword = passwordRecoveryView.getNewPassword();
        String repeatPassword = passwordRecoveryView.getRepeatPassword();

        // Validar longitud de la contraseña
        if (signupView.isValidPassword(newPassword)) {
            Message.showWarning("La contraseña no cumple con los requisitos de longitud.");
            return;
        }

        // Validar que la nueva contraseña coincida
        if (!repeatPassword.equals(newPassword)) {
            Message.showWarning("Las contraseñas no son iguales.");
            return;
        }

        // Verificar si la palabra clave existe en la base de datos
        if (!userService.keywordExist(keyword)) {
            Message.showWarning("La palabra clave no existe en la base de datos.");
            return;
        }

        // Realizar hash de la contraseña
        String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());

        if (userService.updatePasswordByKeyword(keyword, hashedPassword)) {
            Message.showSuccess("Contraseña cambiada con éxito");
            passwordRecoveryView.clearFields();
            passwordRecoveryView.dispose();
            loginView.setVisible(true);
        } else {
            Message.showError("Ocurrió un error al cambiar la contraseña.");
        }
    }

    /**
     * Actualiza la contraseña del usuario.
     * <p>
     * Comprueba si la contraseña actual ingresada coincide con la almacenada
     * mediante {@code BCrypt.checkpw()}. Si es válida, hashea la nueva contraseña con {@code BCrypt.hashpw()},
     * la encripta y la envía a {@code userService.updatePasswordByUserId} para su actualización.
     */
    private void updatePassword(){
        // Verificar si algún campo está vacío
        if (passwordChangeView.isFieldsEmpty()) {
            return;
        }
        String currentPassword = passwordChangeView.getCurrentPassword();
        String newPassword = passwordChangeView.getNewPassword();
        String repeatPassword = passwordChangeView.getRepeatPassword();

        // Validar que la nueva contraseña coincida
        if (!repeatPassword.equals(newPassword)) {
            Message.showWarning("Las contraseñas no son iguales.");
            return;
        }

        int userId = UserSession.getInstance().getUserId();
        // Obtener la contraseña almacenada
        String storedHash = userService.getStoredHash(userId);

        if (BCrypt.checkpw(currentPassword, storedHash)) {
            // Realizar hash de la nueva contraseña
            String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());

            // Actualizar en la base de datos
            if (userService.updatePasswordByUserId(userId, hashedPassword)) {
                Message.showSuccess("Contraseña actualizada con éxito");
                passwordChangeView.clearFields();
                passwordChangeView.dispose();
            } else {
                Message.showError("Ocurrió un error al cambiar la contraseña.");
            }
        } else {
            Message.showError("Contraseña incorrecta.");
        }

    }
}
