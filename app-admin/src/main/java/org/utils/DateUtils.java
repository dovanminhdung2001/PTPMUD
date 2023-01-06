package org.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateUtils {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
    public static SimpleDateFormat sdtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat dateUpFile = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

    public static Date now() {
        return new Date();
    }

    public static Date today() throws ParseException {
        return  sdf.parse(sdf.format(new Date()));
    }

    public static Date tomorrow() throws ParseException {
        return sdf.parse(sdf.format(Date.from(new Date().toInstant().minus(-1, ChronoUnit.DAYS))));
    }

    public static String nowStr() {
        return sdtf.format(new Date());
    }

    public static String todayStr() {
        return sdf.format(new Date());
    }

    public static String tomorrowStr () throws ParseException {
        return sdf.format(Date.from(new Date().toInstant().minus(-1, ChronoUnit.DAYS)));
    }

    public static String dateUpFile() {
        return dateUpFile.format(new Date());
    }

    public static String secondToHms (Long total) {
        long  second = total % 60;
        long  minute = (total / 60) % 60;
        long  hour = total / 3600;
        return hour > 0
                ? String.format("%02d:%02d:%02d", hour, minute, second)
                : String.format("     " + "%02d:%02d",  minute, second);
    }
}
