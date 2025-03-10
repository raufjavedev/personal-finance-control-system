package com.rj.dao.implementations;

import com.rj.dao.TransactionDAO;
import com.rj.model.DatabaseConnection;
import com.rj.model.Transaction;
import com.rj.model.User;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz {@code TransactionDAO} que gestiona el acceso a la base de datos
 * para realizar operaciones CRUD sobre transacciones.
 * Extiende {@code DatabaseConnection} para establecer la conexión con la base de datos.
 */
public class TransactionDAOImpl extends DatabaseConnection implements TransactionDAO {
    private PreparedStatement ps;
    private ResultSet rs;
    private final Connection conn = getConnection();

    @Override
    public boolean addTransaction(Transaction transaction) {
        String query = """
                INSERT INTO transactions (
                    transaction_number,
                    user_id,
                    transaction_type,
                    category,
                    amount,
                    transaction_description)
                    VALUES (?,?,?,?,?,?)
                """;
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, transaction.getTransactionNumber());
            ps.setInt(2, transaction.getUser().getUserId());
            ps.setString(3, transaction.getTransactionType());
            ps.setString(4, transaction.getCategory());
            ps.setDouble(5, transaction.getAmount());
            ps.setString(6, transaction.getTransactionDescription());

            int execute = ps.executeUpdate();
            return execute != 0;
        } catch (SQLException e) {
            System.err.println("Erro en: " + e);
            return false;
        }
    }

    @Override
    public List<Transaction> getAllTransactions(int userId, LocalDate startDate, LocalDate endDate) {
        List<Transaction> list = new ArrayList<>();
        String query = "SELECT * FROM transactions WHERE user_id = ?";

        // Si se proporcionan fechas, agregamos la condición de filtro por rango de
        // fechas
        if (startDate != null && endDate != null) {
            query += " AND registration_date BETWEEN ? AND ?";
        }

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);

            // Si las fechas no son nulas, se asignan a la consulta
            if (startDate != null && endDate != null) {
                ps.setDate(2, java.sql.Date.valueOf(startDate));
                ps.setDate(3, java.sql.Date.valueOf(endDate));
            }

            rs = ps.executeQuery();
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionId(rs.getInt(1));
                transaction.setTransactionNumber(rs.getString(2));
                User user = new User();
                user.setUserId(rs.getInt(3));
                transaction.setUser(user);
                transaction.setTransactionType(rs.getString(4));
                transaction.setCategory(rs.getString(5));
                transaction.setAmount(rs.getDouble(6));
                transaction.setTransactionDescription(rs.getString(7));
                transaction.setRegistrationDate(rs.getDate(8));
                transaction.setRegistrationTime(rs.getString(9));
                list.add(transaction);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error SQL Listar Transacciones", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    @Override
    public boolean updateTransaction(Transaction transaction) {
        String query = """
                UPDATE transactions SET
                    user_id = ?,
                    transaction_type = ?,
                    category = ?,
                    amount = ?,
                    transaction_description = ?
                    WHERE transaction_number = ?
                """;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, transaction.getUser().getUserId());
            ps.setString(2, transaction.getTransactionType());
            ps.setString(3, transaction.getCategory());
            ps.setDouble(4, transaction.getAmount());
            ps.setString(5, transaction.getTransactionDescription());
            ps.setString(6, transaction.getTransactionNumber());

            int execute = ps.executeUpdate();
            return execute != 0;
        } catch (SQLException e) {
            System.err.println("Erro en: " + e);
            return false;
        }
    }

    @Override
    public boolean deleteTransaction(String operationNumber) {
        String query = "DELETE FROM transactions WHERE transaction_number = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, operationNumber);
            int execute = ps.executeUpdate();
            return execute != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public List<Transaction> getLastFiveRecords(int userId) {
        List<Transaction> list = new ArrayList<>();
        String query = """
                SELECT
                    transaction_type,
                    category,
                    registration_date,
                    amount
                FROM transactions
                WHERE user_id = ?
                ORDER BY transaction_id DESC LIMIT 5
                """;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionType(rs.getString(1));
                transaction.setCategory(rs.getString(2));
                transaction.setRegistrationDate(rs.getDate(3));
                transaction.setAmount(rs.getDouble(4));
                list.add(transaction);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error SQL Listar Transacciones", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    @Override
    public Transaction getTransactionByOperationNumber(String operationNumber) {
        String query = """
                SELECT
                    transaction_number,
                    transaction_type,
                    category,
                    amount,
                    transaction_description,
                    registration_date,
                    registration_time
                FROM transactions
                WHERE transaction_number = ?
                """;
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, operationNumber);
            rs = ps.executeQuery();
            if (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionNumber(rs.getString(1));
                transaction.setTransactionType(rs.getString(2));
                transaction.setCategory(rs.getString(3));
                transaction.setAmount(rs.getDouble(4));
                transaction.setTransactionDescription(rs.getString(5));
                transaction.setRegistrationDate(rs.getDate(6));
                transaction.setRegistrationTime(rs.getString(7));
                return transaction;
            }
        } catch (SQLException e) {
            // throw new RuntimeException(e);
            System.err.println("Error en: " + e.getMessage());
        }
        return null;
    }

    @Override
    public double getTotalIncome(int userId) {
        double totalIncome = 0.0;
        String query = "SELECT SUM(amount) FROM transactions WHERE transaction_type = 'ingreso' AND user_id=?";
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                totalIncome = rs.getInt(1);
            }
        } catch (Exception e) {
            // throw new RuntimeException(e);
            System.err.println("Error: " + e.getMessage());
        }
        return totalIncome;
    }

    @Override
    public double getTotalExpenses(int userId) {
        double totalExpenses = 0.0;
        String query = "SELECT SUM(amount) FROM transactions WHERE transaction_type = 'Egreso' AND user_id = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                totalExpenses = rs.getInt(1);
            }
        } catch (Exception e) {
            // throw new RuntimeException(e);
            System.err.println("Error: " + e.getMessage());
        }
        return totalExpenses;
    }

    @Override
    public Transaction getLastIncome(int userId) {
        String query = """
                SELECT
                    transaction_type,
                    category,
                    amount,
                    registration_date,
                    registration_time
                FROM transactions
                WHERE user_id = ? AND transaction_type = 'Ingreso'
                ORDER BY registration_date  DESC, registration_time DESC;
                """;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionType(rs.getString(1));
                transaction.setCategory(rs.getString(2));
                transaction.setAmount(rs.getDouble(3));
                transaction.setRegistrationDate(rs.getDate(4));
                transaction.setRegistrationTime(rs.getString(5));
                return transaction;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Transaction getLastExpenses(int userId) {
        String query = """
                SELECT
                    transaction_type,
                    category,
                    amount,
                    registration_date,
                    registration_time
                FROM transactions
                WHERE user_id = ? AND transaction_type = 'Egreso'
                ORDER BY registration_date DESC, registration_time DESC;
                """;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionType(rs.getString(1));
                transaction.setCategory(rs.getString(2));
                transaction.setAmount(rs.getDouble(3));
                transaction.setRegistrationDate(rs.getDate(4));
                transaction.setRegistrationTime(rs.getString(5));
                return transaction;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void deleteTransactionByUserId(int userId) {
        String query = "DELETE FROM transactions WHERE user_id = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
