package academy.softserve.edu.utils;

import academy.softserve.edu.domains.User;
import academy.softserve.edu.enums.Browsers;
import academy.softserve.edu.pageobjects.*;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static academy.softserve.edu.enums.Browsers.*;

public class TestRunner {
    public static final String CONFIG_PROPERTIES = "src/resources/config.properties";
    public static final String LOG_IN_PAGE = PropertiesReader.getProperty("login.url", CONFIG_PROPERTIES);
    protected static final int TIMEOUT = 30;
    protected LogInPage loginPage;

    @Getter
    protected WebDriver driver;

    protected AdministrationPage administrationPage;
    protected CustomerOrderingPage customerOrderingPage;
    protected ItemManagementPage itemManagementPage;
    protected LogInPage logInPage;
    protected MerchandiserOrderingPage merchandiserOrderingPage;
    protected UserInfoPage userInfoPage;
    protected EditUserPage editUserPage;
    protected CreateReportPage createReportPage;
    protected ReportPage reportPage;

    protected User userForLogin;

    @Parameters("browser")
    @BeforeMethod
    public final void setUp(@Optional("firefox") final String browserParam) {

        Browsers browser = null;

        switch (browserParam) {
            case ("firefox"):
                browser = FIREFOX;
                break;
            case ("chrome"):
                browser = CHROME;
                break;
            case ("chrome_mac") :
                browser = CHROME_MAC;
                break;
            case ("ie"):
                browser = EXPLORER;
                break;
        }

        driver = new WebDriverFactory().getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.get(LOG_IN_PAGE);

        logInPage = new LogInPage(driver);
    }

    @AfterMethod
    public final void tearDown() {
        driver.quit();
    }

}
