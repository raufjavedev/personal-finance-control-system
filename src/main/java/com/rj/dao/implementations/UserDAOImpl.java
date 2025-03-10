package com.rj.dao.implementations;

import com.rj.dao.TransactionDAO;
import com.rj.dao.UserDAO;
import com.rj.model.DatabaseConnection;
import com.rj.model.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implementación de la interfaz {@code UserDAO} que gestiona el acceso a la base de datos
 * para las operaciones relacionadas con los usuarios.
 * Extiende {@code DatabaseConnection} para manejar la conexión con la base de datos.
 */
public class UserDAOImpl extends DatabaseConnection implements UserDAO {
    private PreparedStatement ps;
    private ResultSet rs;
    private final Connection conn = getConnection();

    private final TransactionDAO transactionDAO;

    public UserDAOImpl() {
        // Inicializa el DAO de transacciones
        this.transactionDAO = new TransactionDAOImpl();
    }

    @Override
    public boolean addUser(User user) {
        String query = """
                INSERT INTO users (
                    first_name,
                    balance,
                    user_name,
                    user_password,
                    keyword
                )
                VALUES (?,?,?,?,?)
                """;
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setDouble(2, user.getBalance());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getKeyword());
            int execute = ps.executeUpdate();
            return execute != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean updateUser(User user) {
        String query = """
                UPDATE users SET
                    first_name = ?,
                    last_name = ?,
                    user_name = ?,
                    keyword = ?
                WHERE user_id = ?
                """;
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getKeyword());
            ps.setInt(5, user.getUserId());
            int execute = ps.executeUpdate();
            return execute != 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar. " + e.getMessage());
            return false;
        }
    }

    @Override
    public void deleteUserAndTransactions(int userId) {
        try {
            // Inicia la transacción para la eliminación
            conn.setAutoCommit(false);

            // Elimina las transacciones relacionadas
            transactionDAO.deleteTransactionByUserId(userId);

            // Elimina al usuario
            String query = "DELETE FROM users WHERE user_id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.executeUpdate();

            // Confirma la transacción
            conn.commit();
        } catch (SQLException e) {
            try {
                // Si hay un error, realiza el rollback
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Error al eliminar usuario y transacciones: " + e.getMessage());
            } catch (SQLException rollbackEx) {
                JOptionPane.showMessageDialog(null, "Error al realizar el rollback: " + rollbackEx.getMessage());
            }
        } finally {
            try {
                // Restablece el auto-commit
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al restablecer auto-commit: " + e.getMessage());
            }
        }
    }

    @Override
    public boolean usernameExist(String username) {
        String query = "SELECT COUNT(*) FROM users WHERE user_name = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Si la cuenta es mayor a 0, significa que ya existe el usuario
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false; // No existe el usuario
    }

    @Override
    public boolean keywordExist(String keyword) {
        String query = "SELECT COUNT(*) FROM users WHERE keyword = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, keyword);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Si la cuenta es mayor a 0, significa que ya existe la palabra clave
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false; // No existe la palabra clave
    }

    @Override
    public int getUserIdByCredentialsAndLogin(String username, String plainPassword) {
        String sql = "SELECT user_id, user_password FROM users WHERE user_name = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                String storedHash = rs.getString(2);
                if (BCrypt.checkpw(plainPassword, storedHash)) {
                    return rs.getInt(1); // Devuelve el ID del usuario si la contraseña es correcta
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1; // Devuelve -1 si las credenciales son incorrectas
    }

    @Override
    public User getUserData(int userId) {
        String sql = """
                SELECT 
                    first_name,
                    last_name,
                    balance,
                    user_name,
                    keyword,
                    creation_date,
                    last_update 
                FROM users 
                WHERE user_id = ?
                """;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setFirstName(rs.getString(1));
                user.setLastName(rs.getString(2));
                user.setBalance(rs.getDouble(3));
                user.setUsername(rs.getString(4));
                user.setKeyword(rs.getString(5));
                user.setCreationDate(rs.getTimestamp(6).toLocalDateTime());
                user.setLastUpdate(rs.getTimestamp(7).toLocalDateTime());
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public double getTotalBalance(int userId) {
        double balance = 0.0;
        String sql = "SELECT SUM(balance) FROM users WHERE user_id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                balance = rs.getDouble(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return balance;
    }

    @Override
    public boolean updatePasswordByKeyword(String keyword, String newPassword) {
        String query = """
                UPDATE users SET
                    user_password = ?
                WHERE keyword = ?
                """;
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, newPassword);
            ps.setString(2, keyword);

            int execute = ps.executeUpdate();
            return execute != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean updatePasswordByUserId(int userId, String newPassword) {
        String query = """
                UPDATE users SET
                    user_password = ?
                WHERE user_id = ?
                """;
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, newPassword);
            ps.setInt(2, userId);

            int execute = ps.executeUpdate();
            return execute != 0;
        } catch (SQLException e) {
            System.err.println("Error en 1: "+e.getMessage());
            return false;
        }
    }

    @Override
    public String getStoredHash(int userId) {
        String query = "SELECT user_password FROM users WHERE user_id = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
           // throw new RuntimeException(e);
            System.err.println("Error en 2: "+e.getMessage());
        }
        return null;
    }

    @Override
    public Double getBalance(int userId) {
        String query = "SELECT balance FROM users WHERE user_id = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
