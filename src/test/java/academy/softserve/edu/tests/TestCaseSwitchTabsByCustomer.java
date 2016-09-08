package academy.softserve.edu.tests;

import academy.softserve.edu.pageobjects.CustomerOrderingPage;
import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static academy.softserve.edu.enums.Drivers.FIREFOX;
import static academy.softserve.edu.pageobjects.CustomerOrderingPage.CUSTOMER_ORDERING_PAGE_URL;
import static academy.softserve.edu.pageobjects.LogInPage.OMS_HOME_PAGE;
import static academy.softserve.edu.pageobjects.UserInfoPage.*;

public class TestCaseSwitchTabsByCustomer {

    public static final int TIME_OUT = 30;
    public static final String USER_LOGIN = "vpopkin";
    public static final String USER_PASSWORD = "qwerty";

    private WebDriver driver;
    private final WebDriverFactory webDriverFactory = new WebDriverFactory();
    private LogInPage logInPage;
    private UserInfoPage userInfoPage;

    @BeforeMethod
    public void setUp() {

        driver = webDriverFactory.getDriver(FIREFOX);

        driver
                .manage()
                .timeouts()
                .implicitlyWait(TIME_OUT, TimeUnit.SECONDS);

        driver
                .get(OMS_HOME_PAGE);

        logInPage = new LogInPage(driver);
    }

    @AfterMethod
    public void ternDown() {

        driver
                .quit();
    }

    @Test
    public void defaultUserInfoPageTest() {

        logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        Assert.assertEquals(driver.getCurrentUrl(), USER_INFO_PAGE_URL);

    }

    @Test
    public void userInfoButtonCheck() {

        userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_LINK)
                .isDisplayed());
    }

    @Test
    public void orderingBattonCheck() {

        userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        Assert.assertTrue(userInfoPage
                .getElement(CUSTOMER_ORDERING_LINK)
                .isDisplayed());
    }

    @Test
    public void activeOrderingPageTest() {

        userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        userInfoPage
                .clickCustomerOrderingTab();

        Assert.assertEquals(driver.getCurrentUrl(), CUSTOMER_ORDERING_PAGE_URL);
    }

    @Test
    public void switchTabsUserOrdering() {

        userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        final CustomerOrderingPage customerOrderingPage = userInfoPage
                .clickCustomerOrderingTab();

        Assert.assertEquals(driver.getCurrentUrl(), CUSTOMER_ORDERING_PAGE_URL);

        customerOrderingPage
                .clickUserInfoTab();

        Assert.assertEquals(driver.getCurrentUrl(), USER_INFO_PAGE_URL);

    }
}
