package academy.softserve.edu.utils;

import academy.softserve.edu.domains.User;
import academy.softserve.edu.enums.Browsers;
import academy.softserve.edu.pageobjects.*;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static academy.softserve.edu.enums.Browsers.FIREFOX;

@Listeners({TestListener.class})
public class TestRunner {

    public static final String CONFIG_PROPERTIES = "src/resources/config.properties";
    public static final String LOG_IN_PAGE = PropertiesReader.getDefaultProperty("login.url");
    protected static final int TIMEOUT = 10;

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


    @Parameters({"browser", "version"})
    @BeforeMethod
    public final void setUp(@Optional("default") final String browser, @Optional(" ") final String version) throws MalformedURLException {

        final WebDriverFactory webDriverFactory = new WebDriverFactory();

        webDriverFactory
                .setDriver(browser, version);

        driver = webDriverFactory.getDriver();

        driver
                .manage()
                .window()
                .maximize();

        driver
                .manage()
                .timeouts()
                .implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

        driver
                .get(LOG_IN_PAGE);

        logInPage = new LogInPage(driver);
    }

    @AfterMethod
    public final void tearDown() {

        driver
                .quit();
    }

}