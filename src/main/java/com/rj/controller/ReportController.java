package com.rj.controller;

import com.rj.service.ReportService;
import com.rj.util.LineChart;
import com.rj.util.Message;
import com.rj.util.StackedBarChart;
import com.rj.util.UserSession;
import com.rj.view.MainApp;
import com.rj.view.ReportView;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Map;

/**
 * Controlador de reportes, encargado de manejar las interacciones con la vista de reportes.
 */
public class ReportController implements ActionListener {
    private final ReportService reportService;
    private final MainApp mainApp;
    private final ReportView reportView;

    public ReportController(ReportService reportService, MainApp mainApp, ReportView reportView) {
        this.reportService = reportService;
        this.mainApp = mainApp;
        this.reportView = reportView;

        mainApp.btnReport.addActionListener(this);

        reportView.btnFilter.addActionListener(this);
        reportView.btnReset.addActionListener(this);
        reportView.btnFilter1.addActionListener(this);
        reportView.btnReset1.addActionListener(this);
        reportView.btnFilter2.addActionListener(this);
        reportView.btnReset2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainApp.btnReport) {
            updateLineChartByDateRange();
            updateStackedBarChartIncome();
            updateStackedBarChartExpenses();
            mainApp.JPanel(reportView);
        }
        if (e.getSource() == reportView.btnFilter) {
            updateLineChartByDateRange();
        }
        if (e.getSource() == reportView.btnReset) {
            reportView.clearFields1();
            updateLineChartByDateRange();
        }
        if (e.getSource() == reportView.btnFilter1) {
            updateStackedBarChartIncome();
        }
        if (e.getSource() == reportView.btnReset1) {
            reportView.clearFields2();
            updateStackedBarChartIncome();
        }
        if (e.getSource() == reportView.btnFilter2) {
            updateStackedBarChartExpenses();
        }
        if (e.getSource() == reportView.btnReset2) {
            reportView.clearFields3();
            updateStackedBarChartExpenses();
        }
    }

    /**
     * Muestra el gráfico de línea de ingreso y egreso con un rango de fechas al usuario correspondiente.
     * <p>
     * Actualiza la vista del gráfico según las fechas seleccionadas.
     */
    private void updateLineChartByDateRange() {
        int userId = UserSession.getInstance().getUserId();

        if (userId > 0) {
            // Obtener las fechas desde los selectores de fecha
            LocalDate[] dateRange = reportView.getSelectedDateRange();
            LocalDate startDate = dateRange[0];
            LocalDate endDate = dateRange[1];

            if (startDate != null && endDate != null) {
                // Obtener los datos procesados desde el servicio
                Map<String, Map<String, Double>> data = reportService.getTransactionDataByDateRange(userId, startDate, endDate);

                // Validar que los datos no estén vacíos
                if (data != null && !data.isEmpty()) {
                    // Crear el dataset y el gráfico
                    DefaultCategoryDataset dataset = LineChart.createDataset(data, "Ingreso", "Egreso");
                    ChartPanel chartPanel = LineChart.createLineChart(
                            dataset,
                            "Mes",
                            "Monto (S/)",
                            "");

                    // Actualizar el panel gráfico en el reporte general
                    reportView.updateGraphicPanel(chartPanel);
                } else {
                    Message.showWarning("No hay datos disponibles para el rango de fechas seleccionado.");
                    reportView.clearGraphicPanel();
                }
            } else {
                Message.showError("Las fechas seleccionadas son inválidas.");
                reportView.clearGraphicPanel();
            }
        } else {
            Message.showError("El ID del usuario no está disponible.");
            reportView.clearGraphicPanel();
        }
    }

    /**
     * Muestra el gráfico de barras apiladas de ingresos al usuario correspondiente.
     * <p>
     * Actualiza la vista del gráfico de ingresos.
     */
    private void updateStackedBarChartIncome() {
        int userId = UserSession.getInstance().getUserId();

        if (userId > 0) {
            // Obtener las fechas desde la vista
            LocalDate[] dateRange = reportView.getSelectedDateRange2();
            LocalDate startDate = dateRange[0];
            LocalDate endDate = dateRange[1];

            if (startDate != null && endDate != null) {
                // Obtener los datos del servicio
                Map<String, Map<String, Double>> data = reportService.getIncomeDataByMonthAndCategory(userId, startDate, endDate);

                // Validar que los datos no estén vacíos
                if (data != null && !data.isEmpty()) {
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                    for (String month : data.keySet()) {
                        data.get(month).forEach((category, total) -> dataset.addValue(total, category, month));
                    }

                    // Crear el gráfico utilizando el generador
                    ChartPanel chartPanel = StackedBarChart.createStackedBarChart(
                            dataset,
                            "Mes",
                            "Monto (S/)", "");

                    // Actualizar el panel gráfico en la vista
                    reportView.updateIncomeChart(chartPanel);
                } else {
                    System.out.println("No hay datos disponibles para los ingresos en el rango de fechas seleccionado.");
                    reportView.clearIncomeChart();
                }
            } else {
                System.out.println("Las fechas seleccionadas son inválidas.");
                reportView.clearIncomeChart();
            }
        } else {
            System.out.println("El ID del usuario no está disponible.");
            reportView.clearIncomeChart();
        }
    }

    /**
     * Muestra el gráfico de barras apiladas de egresos al usuario correspondiente.
     * <p>
     * Actualiza la vista del gráfico de egresos.
     */
    private void updateStackedBarChartExpenses() {
        int userId = UserSession.getInstance().getUserId();

        if (userId > 0) {
            // Obtener las fechas desde la vista
            LocalDate[] dateRange = reportView.getSelectedDateRange3();
            LocalDate startDate = dateRange[0];
            LocalDate endDate = dateRange[1];

            if (startDate != null && endDate != null) {
                // Obtener los datos del servicio
                Map<String, Map<String, Double>> data = reportService.getExpensesDataByMonthAndCategory(userId, startDate, endDate);

                // Validar que los datos no estén vacíos
                if (data != null && !data.isEmpty()) {
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                    for (String month : data.keySet()) {
                        data.get(month).forEach((category, total) -> dataset.addValue(total, category, month));
                    }

                    // Crear el gráfico utilizando el generador
                    ChartPanel chartPanel = StackedBarChart.createStackedBarChart(
                            dataset,
                            "Mes",
                            "Monto (S/)",
                            "");

                    // Actualizar el panel gráfico en la vista
                    reportView.updateExpensesChart(chartPanel);
                } else {
                    Message.showWarning("No hay datos disponibles para los egresos en el rango de fechas seleccionado.");
                    reportView.clearExpensesChart();
                }
            } else {
                Message.showError("Las fechas seleccionadas son inválidas.");
                reportView.clearExpensesChart();
            }
        } else {
            Message.showError("El ID del usuario no está disponible.");
            reportView.clearExpensesChart();
        }
    }
}
