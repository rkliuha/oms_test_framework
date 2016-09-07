package academy.softserve.edu.utils;

import academy.softserve.edu.tests.TestClassForListener;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(final ITestResult iTestResult) {
        takeScreenShotOnFailure(iTestResult);
    }

    public void takeScreenShotOnFailure(final ITestResult iTestResult) {
        final Object object = iTestResult.getInstance();
        final WebDriver driver = ((TestClassForListener) object).getDriver();
        final File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File("screenshot/" + iTestResult.getName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
