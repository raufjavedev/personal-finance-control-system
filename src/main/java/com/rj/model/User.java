package com.rj.model;

import java.time.LocalDateTime;

/**
 * Representa un usuario dentro del sistema.
 */
public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private double balance;
    private String username;
    private String password;
    private String keyword;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;

    /**
     * Constructor por defecto.
     */
    public User() {
    }

    /**
     * Constructor que inicializa un usuario con todos sus atributos.
     *
     * @param userId       Identificador único del usuario.
     * @param firstName    Nombre del usuario.
     * @param lastName     Apellido del usuario.
     * @param balance      Saldo disponible del usuario.
     * @param username     Nombre de usuario para inicio de sesión.
     * @param password     Contraseña del usuario.
     * @param keyword      Palabra clave para recuperación de cuenta.
     * @param creationDate Fecha de creación de la cuenta.
     * @param lastUpdate   Última fecha de actualización de los datos.
     */
    public User(int userId, String firstName, String lastName, double balance, String username, String password,
            String keyword, LocalDateTime creationDate, LocalDateTime lastUpdate) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.username = username;
        this.password = password;
        this.keyword = keyword;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
