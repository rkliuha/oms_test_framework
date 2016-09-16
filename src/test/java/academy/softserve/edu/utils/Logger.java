package academy.softserve.edu.utils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private final static Date currentLogDate = new Date();
    private final static Format logFormatter = new SimpleDateFormat("HH:mm:ss - ");

    public static String logInfo(final String value) {
        return logFormatter.format(currentLogDate)
                + "<b> <font size='1' color='blue'>" + "INFO" + "</font></b>" + " - " + value;
    }

    public static String logPass(final String value) {
        return "<b> <font size='1' color='green'>" + "PASS" + "</font></b>" + " - Test Name: " + value;
    }

    public static String logFail(final String value) {
        return "<b> <font size='1' color='red'>" + "FAIL" + "</font></b>" + " - Test Name: " + value;
    }
}
