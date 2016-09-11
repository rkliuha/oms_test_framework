package academy.softserve.edu.utils;

import academy.softserve.edu.tests.TestAdminAfterLogIn;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(final ITestResult iTestResult) {
        takeScreenShotOnFailure(iTestResult);
    }

    private void takeScreenShotOnFailure(final ITestResult iTestResult) {
        final Object object = iTestResult.getInstance();
        final WebDriver driver = ((TestAdminAfterLogIn) object).getDriver();
        final Date currentDate = new Date();
        final Format formatter = new SimpleDateFormat("dd.MM.yyyy_HH-mm - ");
        final File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File("test-output//html//screenshots//" +
                    formatter.format(currentDate) + iTestResult.getName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
