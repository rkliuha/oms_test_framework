package academy.softserve.edu.tests;


import  org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class GridTestParallel {

    private WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (browser){

            case "firefox":
                capabilities.setPlatform(Platform.MAC);
                capabilities.setBrowserName("firefox");
                capabilities.setVersion("46");
                break;

            case "chrome":
                capabilities.setPlatform(Platform.MAC);
                capabilities.setBrowserName("chrome");
                capabilities.setVersion("43");
                break;
        }

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {

        driver.get("https://www.google.com/");
        driver.findElement(By.id("lst-ib")).sendKeys("selenium");
        driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);

        Assert.assertTrue(driver.findElement(By.xpath("(.//*[@class='srg']//a)[1]"))
                .getText()
                .toLowerCase()
                .contains("selenium"));

        Thread.sleep(10000);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
