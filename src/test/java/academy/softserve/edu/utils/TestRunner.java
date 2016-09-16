package academy.softserve.edu.utils;

import academy.softserve.edu.enums.Browsers;
import academy.softserve.edu.pageobjects.LogInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestRunner {
    protected static final String CONFIG_PROPERTIES = "src/resources/config.properties";
    protected static final String LOG_IN_PAGE = PropertiesReader.getProperty("LOG_IN_PAGE", CONFIG_PROPERTIES);
    protected static final int TIMEOUT = 30;
    protected LogInPage loginPage;

    protected WebDriver driver;

    @BeforeMethod
    public final void setUp() {
        driver = new WebDriverFactory().getDriver(Browsers.FIREFOX);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.get(LOG_IN_PAGE);
    }

    @AfterMethod
    public final void tearDown() {
        driver.close();
    }
}
