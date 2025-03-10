package com.rj.dao;

import java.time.LocalDate;
import java.util.Map;

public interface ReportDAO {
    /**
     * Obtiene y procesa los datos de transacciones mensuales de un usuario específico
     * desde la base de datos, organizados para su visualización en un gráfico de líneas.
     *
     * @param userId El ID del usuario cuyas transacciones se desean recuperar.
     * @return Un mapa anidado donde las claves principales representan los meses
     *         y los valores contienen mapas con detalles como tipo de transacción y montos.
     */
    Map<String, Map<String, Double>> getMonthlyTransactionData(int userId);

    /**
     * Obtiene los datos de transacciones dentro de un rango de fechas para un usuario específico.
     * Los datos se estructuran para representar tendencias en un gráfico de líneas.
     *
     * @param userId     El ID del usuario cuyos datos se desean recuperar.
     * @param startDate  La fecha de inicio del rango.
     * @param endDate    La fecha de fin del rango.
     * @return Un mapa anidado donde las claves principales representan meses,
     *          y los valores contienen mapas con detalles como tipo de transacción y montos.
     */
    Map<String, Map<String, Double>> getTransactionDataByDateRange(int userId, LocalDate startDate, LocalDate endDate);

    /**
     * Obtiene los datos de ingresos y egresos mensuales categorizados dentro de un rango de fechas para un usuario específico,
     * estructurados para su visualización en un gráfico de barras apiladas.
     *
     * @param userId     El ID del usuario cuyos datos de ingresos se desean recuperar.
     * @param startDate  La fecha de inicio del rango.
     * @param endDate    La fecha de fin del rango.
     * @return Un mapa anidado donde las claves principales representan los meses,
     *         y los valores contienen mapas que categorizan los ingresos y egresos con sus respectivos montos.
     */
    Map<String, Map<String, Double>> getIncomeDataByMonthAndCategory(int userId, LocalDate startDate, LocalDate endDate); // Ingreso
    Map<String, Map<String, Double>> getExpensesDataByMonthAndCategory(int userId, LocalDate startDate, LocalDate endDate); // Egreso
}
