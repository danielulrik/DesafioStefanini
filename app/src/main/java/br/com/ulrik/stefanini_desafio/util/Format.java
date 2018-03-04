package br.com.ulrik.stefanini_desafio.util;

import java.util.Locale;

/**
 * Created by Daniel Ulrik on 04/03/2018.
 */

public final class Format {
    public static String formatTempCelsius(double x) {
        return String.format(Locale.getDefault(), "%.0f", x) + "c";
    }
}
