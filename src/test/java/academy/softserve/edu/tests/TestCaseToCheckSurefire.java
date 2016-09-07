package academy.softserve.edu.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCaseToCheckSurefire {

    final WebDriver driver = new FirefoxDriver();

    @BeforeTest
    final public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterTest
    final public void teatDown() {
        driver.close();
    }

    @Test
    final public void testWebdriverPractice() {

        driver.navigate().to("https://www.google.com");

        driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("funny picture");

        final String foundText = driver.findElement(By.xpath("//a[text()='Crazy Funny Pictures']")).getText();
        Assert.assertTrue(foundText.toLowerCase().contains("funny picture"));
    }
}

