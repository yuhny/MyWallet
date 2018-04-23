package com.terralogic.mywallet.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by trile on 4/10/2018.
 */

public class DateUtil {

    public static final Map<String, String> MONTH_OF_YEAR = generateMonth();

    private static Map<String, String> generateMonth() {
        Map<String, String> map = new HashMap<>();
        map.put("01", "January");
        map.put("02", "February");
        map.put("03", "March");
        map.put("04", "April");
        map.put("05", "May");
        map.put("06", "June");
        map.put("07", "July");
        map.put("08", "August");
        map.put("09", "September");
        map.put("10", "October");
        map.put("11", "January");
        map.put("12", "January");

        return map;
    }

    public static String getMonthFromLong(long input) {
        Date d = new Date(input);
        SimpleDateFormat format = new SimpleDateFormat("MM");
        String text = format.format(d);
        return text;
    }

    public static String getDate(long input) {
        Date d = new Date(input);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String text = format.format(d);
        return text;
    }

    public static int getMonth(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = simpleDateFormat.parse(s);
            return date.getMonth() + 1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

//    public static void main(String[] args) {
//        Map<String, String> mappp = DateUtil.MONTH_OF_YEAR;
//        mappp.get();
//    }
}
