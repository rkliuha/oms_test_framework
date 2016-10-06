package academy.softserve.edu.utils;

import academy.softserve.edu.pageobjects.*;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class TestRunner {

    public static final String CONFIG_PROPERTIES = "src/resources/config.properties";
    public static final String LOG_IN_PAGE = PropertiesReader.getProperty("login.url", CONFIG_PROPERTIES);

    @Getter
    protected WebDriver driver;

    protected AdministrationPage administrationPage;
    protected CreateNewUserPage createNewUserPage;
    protected CustomerOrderingPage customerOrderingPage;
    protected ItemManagementPage itemManagementPage;
    protected LogInPage logInPage;
    protected MerchandiserOrderingPage merchandiserOrderingPage;
    protected MerchandiserEditOrderPage merchandiserEditOrderPage;
    protected UserInfoPage userInfoPage;
    protected EditUserPage editUserPage;
    protected CreateReportPage createReportPage;
    protected ReportPage reportPage;
    protected CreateNewOrderPage createNewOrderPage;
    protected AddItemPage addItemPage;
    protected EditProductPage editProductPage;

    @Parameters({"browser", "version"})
    @BeforeMethod
    public final void setUp(@Optional("firefox") final String browser, @Optional("46 ") final String version) throws MalformedURLException {

        final WebDriverFactory webDriverFactory = new WebDriverFactory();

        webDriverFactory
                .setDriver(browser, version);

        driver = webDriverFactory.getDriver();

        driver
                .manage()
                .window()
                .maximize();

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


