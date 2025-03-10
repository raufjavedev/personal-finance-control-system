package com.rj.util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.util.Map;

public class LineChart {
    /**
     * Genera un gráfico de líneas con el estilo personalizado.
     *
     * @param dataset   Los datos que se usarán en el gráfico.
     * @param xAxisLabel Etiqueta del eje X.
     * @param yAxisLabel Etiqueta del eje Y.
     * @param title      Título del gráfico.
     * @return Un objeto ChartPanel listo para ser utilizado en la interfaz.
     */
    public static ChartPanel createLineChart(CategoryDataset dataset, String xAxisLabel, String yAxisLabel, String title) {
        // Crear gráfico
        JFreeChart chart = ChartFactory.createLineChart(
                title,
                xAxisLabel,
                yAxisLabel,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // Configurar el renderizador
        LineAndShapeRenderer renderer = new LineAndShapeRenderer(true, true);
        chart.getCategoryPlot().setRenderer(renderer);

        // Cambiar el color de fondo del gráfico
        chart.setBackgroundPaint(new Color(56, 60, 74)); // Fondo general del gráfico

        // Obtener el área de trazado y cambiar solo el fondo
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(18,25,41)); // Fondo del área de trazado

        // Configurar las líneas de la cuadrícula
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY); // Cuadrícula de las categorías (eje X)
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);  // Cuadrícula de los valores (eje Y)

        // Personalizar la leyenda
        LegendTitle legend = chart.getLegend();
        legend.setBackgroundPaint(Color.DARK_GRAY); // Fondo de la leyenda
        legend.setItemPaint(Color.WHITE);           // Color de las fuentes de la leyenda
        legend.setItemFont(new Font("Arial", Font.BOLD, 12)); // Fuente personalizada

        // Personalizar el título del gráfico
        chart.getTitle().setPaint(Color.BLUE);         // Color del título
        chart.getTitle().setFont(new Font("Arial", Font.BOLD, 16)); // Fuente del título

        // Personalizar etiquetas de los ejes
        plot.getDomainAxis().setLabelPaint(Color.WHITE);   // Color de la etiqueta del eje X
        plot.getDomainAxis().setTickLabelPaint(Color.WHITE); // Color de las marcas del eje X
        plot.getRangeAxis().setLabelPaint(Color.WHITE);    // Color de la etiqueta del eje Y
        plot.getRangeAxis().setTickLabelPaint(Color.WHITE); // Color de las marcas del eje Y

        // Crear y devolver el panel del gráfico
        return new ChartPanel(chart);
    }

    /**
     * Crea un dataset para gráficos de líneas basado en datos jerárquicos.
     *
     * @param data Los datos jerárquicos en formato Map.
     * @param seriesLabels Etiquetas para las series (por ejemplo, "Ingreso", "Egreso").
     * @return Un DefaultCategoryDataset con los datos procesados.
     */
    public static DefaultCategoryDataset createDataset(Map<String, Map<String, Double>> data, String... seriesLabels) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (String category : data.keySet()) {
            Map<String, Double> values = data.get(category);
            for (String series : seriesLabels) {
                dataset.addValue(values.getOrDefault(series, 0.0), series, category);
            }
        }

        return dataset;
    }
}
