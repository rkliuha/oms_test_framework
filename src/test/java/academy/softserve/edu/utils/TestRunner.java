package academy.softserve.edu.utils;

import academy.softserve.edu.enums.Browsers;
import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestRunner {
    protected static final String LOG_IN_PAGE = PropertiesFile.getProperty("LOG_IN_PAGE");
    //protected static final String LOG_IN_PAGE = "http://192.168.56.101:8080/oms5/login.htm";
    protected static final int TIMEOUT = 30;
    protected UserInfoPage infoPage;
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
