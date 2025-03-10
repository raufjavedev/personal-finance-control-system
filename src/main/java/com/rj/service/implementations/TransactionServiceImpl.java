package com.rj.service.implementations;

import com.rj.dao.UserDAO;
import com.rj.dao.implementations.TransactionDAOImpl;
import com.rj.dao.TransactionDAO;
import com.rj.dao.implementations.UserDAOImpl;
import com.rj.model.Transaction;
import com.rj.service.TransactionService;

import java.time.LocalDate;
import java.util.List;

/**
 * Implementación de la interfaz {@code TransactionService} que gestiona la lógica de negocio
 * para las transacciones antes de interactuar con la capa de acceso a datos.
 * Utiliza una instancia de {@code TransactionDAO} para realizar operaciones en la base de datos.
 */
public class TransactionServiceImpl implements TransactionService {
    private final TransactionDAO transactionDAO;
    private final UserDAO userDAO;

    /**
     * Constructor que inicializa la implementación de {@code TransactionDAO}.
     */
    public TransactionServiceImpl() {
        this.transactionDAO = new TransactionDAOImpl();
        this.userDAO = new UserDAOImpl();
    }

    @Override
    public boolean addTransaction(Transaction transaction) {
        return transactionDAO.addTransaction(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions(int userId, LocalDate startDate, LocalDate endDate) {
        return transactionDAO.getAllTransactions(userId, startDate, endDate);
    }

    @Override
    public boolean updateTransaction(Transaction transaction) {
        return transactionDAO.updateTransaction(transaction);
    }

    @Override
    public boolean deleteTransaction(String operationNumber) {
        return transactionDAO.deleteTransaction(operationNumber);
    }

    @Override
    public List<Transaction> getLastFiveRecords(int userId) {
        return transactionDAO.getLastFiveRecords(userId);
    }

    @Override
    public Transaction getTransactionByOperationNumber(String operationNumber) {
        return transactionDAO.getTransactionByOperationNumber(operationNumber);
    }

    @Override
    public double getTotalIncome(int userId) {
        return transactionDAO.getTotalIncome(userId);
    }

    @Override
    public double getTotalExpenses(int userId) {
        return transactionDAO.getTotalExpenses(userId);
    }

    @Override
    public Transaction getLastIncome(int userId) {
        return transactionDAO.getLastIncome(userId);
    }

    @Override
    public Transaction getLastExpenses(int userId) {
        return transactionDAO.getLastExpenses(userId);
    }

    @Override
    public Double getBalance(int userId) {
        return userDAO.getBalance(userId);
    }
}
