package com.rj.util;

public class UserSession {
    private static UserSession instance; // Instancia única
    private Integer userId; // Id del usuario en sesión, puede ser nulo si no hay sesión activa
    private boolean isAuthenticated; // Estado de autenticación

    // Constructor privado para prevenir instanciación
    private UserSession() {
        this.userId = null;
        this.isAuthenticated = false;
    }

    // Método para obtener la instancia única
    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    // Método para iniciar sesión
    public void login(int userId) {
        if (userId <= 0) {
            throw new IllegalArgumentException("ID de usuario no válido.");
        }
        this.userId = userId;
        this.isAuthenticated = true;
    }

    // Método para cerrar sesión
    public void logout() {
        this.userId = null;
        this.isAuthenticated = false;
    }

    // Método para verificar si el usuario está autenticado
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    // Método para obtener el ID del usuario
    public int getUserId() {
        if (!isAuthenticated) {
            throw new IllegalStateException("El usuario no está autenticado.");
        }
        return userId;
    }
}

