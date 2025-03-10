package com.rj.util;

import java.text.NumberFormat;
import java.util.Locale;

public class Currency {
    // Método estático para formatear montos en soles peruanos
    public static String formatCurrency(double amount) {
        // NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
        Locale peruLocale = Locale.of("es", "PE");
        NumberFormat format = NumberFormat.getNumberInstance(peruLocale);
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);
        return format.format(amount);
    }

    public static String currencySymbol() {
        return "S/";
    }
}
