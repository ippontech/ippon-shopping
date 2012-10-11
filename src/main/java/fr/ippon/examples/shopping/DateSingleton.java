package fr.ippon.examples.shopping;

import java.util.Calendar;

/**
 * This class manages the current system date. It is used for special offers, like the Christmas offer.
 */
public class DateSingleton {

    private static DateSingleton dateSingleton = new DateSingleton();

    private Calendar currentCalendar;

    public static DateSingleton getInstance() {
        return dateSingleton;
    }

    public void setCurrentDate(Calendar calendar) {
        this.currentCalendar = calendar;
    }

    public boolean isDecember() {
        return false;
    }
}
