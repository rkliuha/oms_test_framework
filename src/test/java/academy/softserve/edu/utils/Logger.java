package academy.softserve.edu.utils;

import org.testng.Reporter;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private final static Date currentLogDate = new Date();
    private final static Format logFormatter = new SimpleDateFormat("HH:mm:ss - ");

    public static void logInfo(final String value) {
        Reporter.log(logFormatter.format(currentLogDate)
                + "<b> <font size='1' color='blue'>" + "INFO" + "</font></b>" + " - " + value);
    }

    public static void logPass(final String value) {
        Reporter.log("<b> <font size='1' color='green'>" + "PASS" + "</font></b>" + " - Test Name: " + value);
    }

    public static void logFail(final String value) {
        Reporter.log("<b> <font size='1' color='red'>" + "FAIL" + "</font></b>" + " - Here: " + value);
    }
}
