package academy.softserve.edu.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(final ITestResult result) {

        final Object currentClass = result
                .getInstance();

        final WebDriver driver = ((TestRunner) currentClass)
                .getDriver();

        final Date currentDate = new Date();
        final Format formatter = new SimpleDateFormat("dd.MM.yyyy_HH-mm - ");

        final File screenShotFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File("test-output//html//screenshots//" +
                    formatter.format(currentDate) + result.getName() + ".png"));
            Reporter.log("<a href='" + "screenshots/" +
                    formatter.format(currentDate) + result.getName() + ".png'> <img src='" +
                    "screenshots/" + formatter.format(currentDate) + result.getName() + ".png' height='388' width='760'/> <a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
