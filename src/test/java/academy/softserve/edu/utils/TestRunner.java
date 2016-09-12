package academy.softserve.edu.utils;

import academy.softserve.edu.enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestRunner {

    public static final String LOG_IN_PAGE =
            "http://192.168.56.101:8080/oms5/login.htm";
    public static final int TIMEOUT = 10;

    protected WebDriver driver;

    @BeforeMethod
    public final void setUp() {
        driver = new WebDriverFactory().getDriver(Browsers.CHROME);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.get(LOG_IN_PAGE);
    }

    @AfterMethod
    public final void tearDown() {
        driver.close();
    }

}
