package com.rj.util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;

import java.awt.*;

public class StackedBarChart {
    /**
     * Crear un gráfico de barras apiladas.
     * @param dataset El conjunto de datos para el gráfico.
     * @param categoryLabel Etiqueta para el eje X.
     * @param valueLabel Etiqueta para el eje Y.
     * @param chartTitle Título del gráfico.
     * @return Un ChartPanel listo para ser añadido a la interfaz.
     */
    public static ChartPanel createStackedBarChart(DefaultCategoryDataset dataset, String categoryLabel, String valueLabel, String chartTitle) {
        JFreeChart chart = ChartFactory.createStackedBarChart(
                chartTitle,
                categoryLabel,
                valueLabel,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // Configuración del diseño visual
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

        // Personalizar etiquetas de los ejes
        plot.getDomainAxis().setLabelPaint(Color.WHITE);   // Color de la etiqueta del eje X
        plot.getDomainAxis().setTickLabelPaint(Color.WHITE); // Color de las marcas del eje X
        plot.getRangeAxis().setLabelPaint(Color.WHITE);    // Color de la etiqueta del eje Y
        plot.getRangeAxis().setTickLabelPaint(Color.WHITE); // Color de las marcas del eje Y

        return new ChartPanel(chart);
    }
}
