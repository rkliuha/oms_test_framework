package academy.softserve.edu;

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
        System.out.println("TestClass has failed: " + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(final ITestResult iTestResult) {
        System.out.println("Test Passed: " + iTestResult.getName());
    }

    @Override
    public void onTestSkipped(final ITestResult iTestResult) {
        System.out.println("Test Skipped: " + iTestResult.getName());
    }

    public void takeScreenShotOnFailure(final ITestResult iTestResult) {
        final Object object = iTestResult.getInstance();
        final WebDriver driver = ((TestClass) object).getDriver();

        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File("screenshot/" + iTestResult.getName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
