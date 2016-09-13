package academy.softserve.edu.tests.customer;

import academy.softserve.edu.pageobjects.CustomerOrderingPage;
import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static academy.softserve.edu.pageobjects.CustomerOrderingPage.CUSTOMER_ORDERING_PAGE_URL;
import static academy.softserve.edu.pageobjects.CustomerOrderingPage.CUSTOMER_PAGE_EXISTS;
import static academy.softserve.edu.pageobjects.UserInfoPage.*;

public class SwitchTabsByCustomerTest extends TestRunner {

    public static final String USER_LOGIN = "vpopkin";
    public static final String USER_PASSWORD = "qwerty";

    private LogInPage logInPage;
    private UserInfoPage userInfoPage;

    @Test
    public void testDefaultUserInfoPage() {

        logInPage = new LogInPage(driver);

        userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        Assert.assertEquals(driver
                .getCurrentUrl(), USER_INFO_PAGE_URL, "URL is different from " + USER_INFO_PAGE_URL);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_PAGE_EXISTS)
                .isDisplayed(), "Element " + USER_INFO_PAGE_EXISTS + " isn't displayed");

    }

    @Test
    public void testUserInfoButtonCheck() {

        logInPage = new LogInPage(driver);

        userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_LINK)
                .isDisplayed(), "Element " + USER_INFO_LINK + " isn't displayed");
    }

    @Test
    public void testOrderingButtonCheck() {

        logInPage = new LogInPage(driver);

        userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        Assert.assertTrue(userInfoPage
                .getElement(CUSTOMER_ORDERING_LINK)
                .isDisplayed(), "Element " + CUSTOMER_ORDERING_LINK + " isn't displayed");
    }

    @Test
    public void testActiveOrderingPage() {

        logInPage = new LogInPage(driver);

        userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        userInfoPage
                .click(CUSTOMER_ORDERING_LINK);

        Assert.assertEquals(driver
                .getCurrentUrl(), CUSTOMER_ORDERING_PAGE_URL, "URL is different from " + CUSTOMER_ORDERING_PAGE_URL);

        Assert.assertTrue(userInfoPage
                .getElement(CUSTOMER_PAGE_EXISTS)
                .isDisplayed(), "Element " + CUSTOMER_PAGE_EXISTS + " isn't displayed");
    }

    @Test
    public void testSwitchTabsUserOrdering() {

        logInPage = new LogInPage(driver);

        userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        userInfoPage
                .click(CUSTOMER_ORDERING_LINK);

        Assert.assertEquals(driver
                .getCurrentUrl(), CUSTOMER_ORDERING_PAGE_URL, "URL is different from " + CUSTOMER_ORDERING_PAGE_URL);

        Assert.assertTrue(userInfoPage
                .getElement(CUSTOMER_PAGE_EXISTS)
                .isDisplayed(), "Element " + CUSTOMER_PAGE_EXISTS + " isn't displayed");

        CustomerOrderingPage customerOrderingPage = new CustomerOrderingPage(driver);

        customerOrderingPage
                .click(USER_INFO_LINK);

        Assert.assertEquals(driver
                .getCurrentUrl(), USER_INFO_PAGE_URL, "URL is different from " + USER_INFO_PAGE_URL);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_PAGE_EXISTS)
                .isDisplayed(), "Element " + CUSTOMER_PAGE_EXISTS + " isn't displayed");

    }
}
