package academy.softserve.edu.tests;

import academy.softserve.edu.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

@Listeners({TestListener.class})
public class TestClassForListener {
    public WebDriver driver;

    public final WebDriver getDriver() {
        return driver;
    }

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.google.com.ua");
    }

    @Test
    public void testScreenShotOnFailure() {
        final String title = driver.getTitle();
        System.out.println(driver.getTitle());
        Assert.assertTrue(title.equals("Google (:"));
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
