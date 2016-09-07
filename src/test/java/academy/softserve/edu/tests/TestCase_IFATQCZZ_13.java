package academy.softserve.edu.tests;

import academy.softserve.edu.pageobjects.CustomerOrderingPage;
import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.pageobjects.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static academy.softserve.edu.enums.Drivers.FIREFOX;
import static academy.softserve.edu.pageobjects.CustomerOrderingPage.CUSTOMER_ORDERING_PAGE_URL;
import static academy.softserve.edu.pageobjects.LogInPage.OMS_HOME_PAGE;
import static academy.softserve.edu.pageobjects.UserInfoPage.ORDERING_BUTTON;
import static academy.softserve.edu.pageobjects.UserInfoPage.USER_INFO_BUTTON;
import static academy.softserve.edu.pageobjects.UserInfoPage.USER_INFO_PAGE_URL;

public class TestCase_IFATQCZZ_13 {

    public static final int TIME_OUT = 30;
    public static final String USER_LOGIN = "vpopkin";
    public static final String USER_PASSWORD = "qwerty";

    private WebDriver driver;
    final WebDriverFactory webDriverFactory = new WebDriverFactory();

    @BeforeTest
    public void setUp() {

        driver = webDriverFactory.getDriver(FIREFOX);

        driver
                .manage()
                .timeouts()
                .implicitlyWait(TIME_OUT, TimeUnit.SECONDS);

        driver
                .get(OMS_HOME_PAGE);
    }

    @AfterTest
    public void ternDown() {

        driver
                .close();
    }

    @Test
    public void test_IFATQCZZ_13_1() {

        final LogInPage logInPage = new LogInPage(driver);

        logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        Assert.assertEquals(driver.getCurrentUrl(), USER_INFO_PAGE_URL);

    }

    @Test
    public void test_IFATQCZZ_13_2() {

        final LogInPage logInPage = new LogInPage(driver);

        final UserInfoPage userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_BUTTON)
                .isDisplayed());
    }

    @Test
    public void test_IFATQCZZ_13_3() {

        final LogInPage logInPage = new LogInPage(driver);

        final UserInfoPage userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        Assert.assertTrue(userInfoPage
                .getElement(ORDERING_BUTTON)
                .isDisplayed());
    }

    @Test
    public void test_IFATQCZZ_13_4() {

        final LogInPage logInPage = new LogInPage(driver);

        final UserInfoPage userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        userInfoPage
                .clickCustomerOrderingTab();

        Assert.assertEquals(driver.getCurrentUrl(), CUSTOMER_ORDERING_PAGE_URL);
    }

    @Test
    public void test_IFATQCZZ_13_5() {

        final LogInPage logInPage = new LogInPage(driver);

        final UserInfoPage userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        final CustomerOrderingPage customerOrderingPage = userInfoPage
                .clickCustomerOrderingTab();

        Assert.assertEquals(driver.getCurrentUrl(), CUSTOMER_ORDERING_PAGE_URL);

        customerOrderingPage
                .clickUserInfoTab();

        Assert.assertEquals(driver.getCurrentUrl(), USER_INFO_PAGE_URL);

    }
}
