package academy.softserve.edu.utils;


import academy.softserve.edu.pageobjects.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;
import static academy.softserve.edu.enums.Browsers.FIREFOX;

@Listeners({TestListener.class})
public class TestRunner {
    public static final String CONFIG_PROPERTIES = "src/resources/config.properties";
    public static final String LOG_IN_PAGE = PropertiesReader.getProperty("login.url", CONFIG_PROPERTIES);
    protected static final int TIMEOUT = 30;
    protected LogInPage loginPage;

    protected WebDriver driver;

    public final WebDriver getDriver() {
        return driver;
    }

    protected AdministrationPage administrationPage;
    protected CustomerOrderingPage customerOrderingPage;
    protected ItemManagementPage itemManagementPage;
    protected LogInPage logInPage;
    protected MerchandiserOrderingPage merchandiserOrderingPage;
    protected UserInfoPage userInfoPage;

    @BeforeMethod
    public final void setUp() {
        driver = new WebDriverFactory().getDriver(FIREFOX);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.get(LOG_IN_PAGE);

        logInPage = new LogInPage(driver);
    }

    @AfterMethod
    public final void tearDown() {
        driver.close();
    }

}
