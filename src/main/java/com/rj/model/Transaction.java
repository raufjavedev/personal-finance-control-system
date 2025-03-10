package com.rj.model;

import java.util.Date;

/**
 * Representa una transacción financiera realizada por un usuario.
 */
public class Transaction {
    private int transactionId;
    private String transactionNumber;
    private String transactionType;
    private String category;
    private Double amount;
    private String transactionDescription;
    private Date registrationDate;
    private String registrationTime;
    private User user;

    /**
     * Constructor por defecto.
     */
    public Transaction() {
    }

    /**
     * Constructor que inicializa una transacción con todos sus atributos.
     *
     * @param transactionId          Identificador único de la transacción.
     * @param transactionNumber      Número único asignado a la transacción.
     * @param transactionType        Tipo de transacción (Ej: Ingreso, Egreso).
     * @param category               Categoría de la transacción.
     * @param amount                 Monto de la transacción.
     * @param transactionDescription Descripción o detalle de la transacción.
     * @param registrationDate       Fecha en que se registró la transacción.
     * @param registrationTime       Hora en que se registró la transacción.
     * @param user                   Usuario asociado a la transacción.
     */
    public Transaction(int transactionId, String transactionNumber, String transactionType,
                       String category, Double amount, String transactionDescription,
                       Date registrationDate, String registrationTime, User user) {
        this.transactionId = transactionId;
        this.transactionNumber = transactionNumber;
        this.transactionType = transactionType;
        this.category = category;
        this.amount = amount;
        this.transactionDescription = transactionDescription;
        this.registrationDate = registrationDate;
        this.registrationTime = registrationTime;
        this.user = user;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}