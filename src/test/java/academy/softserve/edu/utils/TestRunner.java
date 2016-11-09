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

    @Getter
    protected WebDriver driver;

    protected AdministrationPage administrationPage;
    protected CreateNewUserPage createNewUserPage;
    protected CustomerOrderingPage customerOrderingPage;
    protected ItemManagementPage itemManagementPage;
    protected SupervisorCreateReportPage supervisorCreateReportPage;
    protected SupervisorReportPage supervisorReportPage;
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
    protected AddProductPage addProductPage;

    @Parameters({"browser", "version"})
    @BeforeMethod
    public final void setUp(@Optional("default") final String browser,
                            @Optional("46") final String version) throws MalformedURLException {

        final String logInPageUrl = PropertiesReader.getProperty("login.url");

        final WebDriverFactory webDriverFactory = new WebDriverFactory();

        webDriverFactory.setDriver(browser, version);

        driver = webDriverFactory.getDriver();

        driver.manage()
                .window()
                .maximize();

        driver.get(logInPageUrl);

        logInPage = new LogInPage(driver);
    }

    @AfterMethod
    public final void tearDown() {

        driver.quit();
    }
}


