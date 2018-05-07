package com.terralogic.mywallet.model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class Utils {
    public static String seperate(String s) {

        StringBuilder builder = new StringBuilder(s);

        s = builder.toString();
        return s;
    }

    public static String parseToCash(long value) {
        String pattern = "###,###";
        DecimalFormatSymbols ds = new DecimalFormatSymbols();
//		ds.setDecimalSeparator(',');
        ds.setGroupingSeparator(',');
        DecimalFormat df = new DecimalFormat(pattern, ds);
        df.setGroupingUsed(true);
        return df.format(value);
    }
}
