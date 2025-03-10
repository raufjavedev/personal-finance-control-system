package com.rj.service.implementations;

import com.rj.dao.implementations.ReportDAOImpl;
import com.rj.dao.ReportDAO;
import com.rj.service.ReportService;

import java.time.LocalDate;
import java.util.Map;

/**
 * Implementación de la interfaz {@code ReportService} que maneja la lógica de negocio
 * relacionada con la generación de reportes financieros.
 * Utiliza un objeto {@code ReportDAO} para interactuar con la capa de acceso a datos.
 */
public class ReportServiceImpl implements ReportService {
    private final ReportDAO reportDAO;

    /**
     * Constructor que inicializa la instancia de {@code ReportDAO}
     * utilizando su implementación {@code ReportDAOImpl}.
     */
    public  ReportServiceImpl(){
        this.reportDAO = new ReportDAOImpl();
    }
    @Override
    public Map<String, Map<String, Double>> getMonthlyTransactionData(int userId) {
        return reportDAO.getMonthlyTransactionData(userId);
    }

    @Override
    public Map<String, Map<String, Double>> getTransactionDataByDateRange(int userId, LocalDate startDate, LocalDate endDate) {
        return reportDAO.getTransactionDataByDateRange(userId, startDate, endDate);
    }

    @Override
    public Map<String, Map<String, Double>> getIncomeDataByMonthAndCategory(int userId, LocalDate startDate, LocalDate endDate) {
        return reportDAO.getIncomeDataByMonthAndCategory(userId, startDate, endDate);
    }

    @Override
    public Map<String, Map<String, Double>> getExpensesDataByMonthAndCategory(int userId, LocalDate startDate, LocalDate endDate) {
        return reportDAO.getExpensesDataByMonthAndCategory(userId, startDate, endDate);
    }
}
