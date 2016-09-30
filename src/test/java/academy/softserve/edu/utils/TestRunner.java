package academy.softserve.edu.utils;

import academy.softserve.edu.enums.Browsers;
import academy.softserve.edu.pageobjects.*;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class TestRunner {

    public static final String CONFIG_PROPERTIES = "src/resources/config.properties";
    public static final String LOG_IN_PAGE = PropertiesReader.getProperty("login.url", CONFIG_PROPERTIES);
    protected static final int TIMEOUT = 10;

    @Getter
    protected WebDriver driver;

    protected AdministrationPage administrationPage;
    protected CreateNewUserPage createNewUserPage;
    protected CustomerOrderingPage customerOrderingPage;
    protected ItemManagementPage itemManagementPage;
    protected LogInPage logInPage;
    protected MerchandiserOrderingPage merchandiserOrderingPage;
    protected UserInfoPage userInfoPage;
    protected EditUserPage editUserPage;
    protected CreateReportPage createReportPage;
    protected ReportPage reportPage;
    protected CreateNewOrderPage createNewOrderPage;
    protected AddItemPage addItemPage;


    @Parameters("browser")
    @BeforeMethod
    public final void setUp(@Optional("firefox") final String browserParameter) {

        Browsers browser = Browsers.valueOf(browserParameter.toUpperCase());

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
