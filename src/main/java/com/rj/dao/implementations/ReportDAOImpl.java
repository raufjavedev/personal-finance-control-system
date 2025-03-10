package com.rj.dao.implementations;

import com.rj.model.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import com.rj.dao.ReportDAO;

/**
 * Implementación de la interfaz {@code ReportDAO} que gestiona el acceso a la base de datos
 * para la generación de reportes financieros.
 * Extiende {@code DatabaseConnection} para manejar la conexión con la base de datos.
 */
public class ReportDAOImpl extends DatabaseConnection implements ReportDAO {
    private PreparedStatement ps;
    private ResultSet rs;
    private final Connection conn = getConnection();

    @Override
    public Map<String, Map<String, Double>> getMonthlyTransactionData(int userId) {
        String sql = """
                    SELECT 
                        DATE_FORMAT(registration_date, '%Y-%m') AS month,
                        transaction_type,
                        SUM(amount) AS total
                    FROM transactions
                    WHERE user_id = ? AND registration_date >= DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 12 MONTH), '%Y-%m-01')
                    GROUP BY month, transaction_type
                    ORDER BY month ASC;
                """;

        Map<String, Map<String, Double>> data = new LinkedHashMap<>();

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            // Crear un mapa base con los últimos 12 meses inicializados a 0
            LocalDate currentDate = LocalDate.now();
            for (int i = 0; i < 12; i++) {
                LocalDate monthDate = currentDate.minusMonths(11 - i);
                String monthKey = monthDate.format(DateTimeFormatter.ofPattern("yyyy-MM"));
                data.putIfAbsent(monthKey, new HashMap<>());
                data.get(monthKey).put("Ingreso", 0.0);
                data.get(monthKey).put("Egreso", 0.0);
            }

            // Procesar los resultados de la consulta y actualizar los valores en el mapa
            while (rs.next()) {
                String month = rs.getString("month");
                String type = rs.getString("transaction_type");
                double total = rs.getDouble("total");

                data.getOrDefault(month, new HashMap<>()).put(type, total);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores, puedes usar un logger en lugar de imprimir
        }

        return data;
    }

    @Override
    public Map<String, Map<String, Double>> getTransactionDataByDateRange(int userId, LocalDate startDate, LocalDate endDate) {
        // Validar fechas, usar últimos 12 meses si no se proporcionan
        if (startDate == null || endDate == null) {
            endDate = LocalDate.now();
            startDate = endDate.minusMonths(12).withDayOfMonth(1); // Primer día del mes
        }

        String sql = """
                    SELECT 
                        DATE_FORMAT(registration_date, '%Y-%m') AS month,
                        transaction_type,
                        SUM(amount) AS total
                    FROM transactions
                    WHERE user_id = ? AND registration_date BETWEEN ? AND ?
                    GROUP BY month, transaction_type
                    ORDER BY month ASC;
                """;

        Map<String, Map<String, Double>> data = new LinkedHashMap<>();

        try {
            ps = conn.prepareStatement(sql);
            // Establecer parámetros de la consulta
            ps.setInt(1, userId);
            ps.setDate(2, java.sql.Date.valueOf(startDate));
            ps.setDate(3, java.sql.Date.valueOf(endDate));
            ResultSet rs = ps.executeQuery();
            // Inicializar mapa base para todos los meses en el rango
            LocalDate currentDate = startDate;
            while (!currentDate.isAfter(endDate)) {
                String monthKey = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM"));
                data.putIfAbsent(monthKey, new HashMap<>());
                data.get(monthKey).put("Ingreso", 0.0);
                data.get(monthKey).put("Egreso", 0.0);
                currentDate = currentDate.plusMonths(1);
            }

            // Poblar resultados de la consulta
            while (rs.next()) {
                String month = rs.getString("month");
                String type = rs.getString("transaction_type");
                double total = rs.getDouble("total");

                data.getOrDefault(month, new HashMap<>()).put(type, total);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores, usar logger en producción
        }

        return data;
    }

    @Override
    public Map<String, Map<String, Double>> getIncomeDataByMonthAndCategory(int userId, LocalDate startDate, LocalDate endDate) {
        // Validar fechas, usar últimos 12 meses si no se proporcionan
        if (startDate == null || endDate == null) {
            endDate = LocalDate.now();
            startDate = endDate.minusMonths(12).withDayOfMonth(1); // Primer día del mes
        }

        String sql = """
                    SELECT 
                        DATE_FORMAT(registration_date, '%Y-%m') AS month,
                        category,
                        SUM(amount) AS total
                    FROM transactions
                    WHERE user_id = ? AND transaction_type = 'Ingreso' 
                      AND registration_date BETWEEN ? AND ?
                    GROUP BY month, category
                    ORDER BY month ASC;
                """;

        Map<String, Map<String, Double>> data = new LinkedHashMap<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setDate(2, java.sql.Date.valueOf(startDate));
            ps.setDate(3, java.sql.Date.valueOf(endDate));
            rs = ps.executeQuery();

            while (rs.next()) {
                String month = rs.getString("month");
                String category = rs.getString("category");
                double total = rs.getDouble("total");

                data.putIfAbsent(month, new HashMap<>());
                data.get(month).put(category, total);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Mejor usar logging en producción
        }
        return data;
    }

    @Override
    public Map<String, Map<String, Double>> getExpensesDataByMonthAndCategory(int userId, LocalDate startDate, LocalDate endDate) {
        // Validar fechas, usar últimos 12 meses si no se proporcionan
        if (startDate == null || endDate == null) {
            endDate = LocalDate.now();
            startDate = endDate.minusMonths(12).withDayOfMonth(1); // Primer día del mes
        }

        String sql = """
                    SELECT 
                        DATE_FORMAT(registration_date, '%Y-%m') AS month,
                        category,
                        SUM(amount) AS total
                    FROM transactions
                    WHERE user_id = ? AND transaction_type = 'Egreso' 
                      AND registration_date BETWEEN ? AND ?
                    GROUP BY month, category
                    ORDER BY month ASC;
                """;

        Map<String, Map<String, Double>> data = new LinkedHashMap<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setDate(2, java.sql.Date.valueOf(startDate));
            ps.setDate(3, java.sql.Date.valueOf(endDate));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String month = rs.getString("month");
                String category = rs.getString("category");
                double total = rs.getDouble("total");

                data.putIfAbsent(month, new HashMap<>());
                data.get(month).put(category, total);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Mejor usar logging en producción
        }
        return data;
    }
}
