package academy.softserve.edu.tests.customer;

import academy.softserve.edu.pageobjects.CustomerOrderingPage;
import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static academy.softserve.edu.pageobjects.CustomerOrderingPage.CUSTOMER_ORDERING_PAGE_URL;
import static academy.softserve.edu.pageobjects.UserInfoPage.*;

public class SwitchTabsByCustomerTest extends TestRunner {

    public static final String USER_LOGIN = "vpopkin";
    public static final String USER_PASSWORD = "qwerty";
    public static final String USER_PAGE_IDENTIFICATION_TEXT = "User Info";
    public static final String ORDERING_PAGE_IDENTIFICATION_TEXT = "Search for orders by";

    private LogInPage logInPage;
    private UserInfoPage userInfoPage;

    @Test
    public void testDefaultUserInfoPage() {

        logInPage = new LogInPage(driver);

        logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        Assert.assertEquals(driver
                .getCurrentUrl(), USER_INFO_PAGE_URL);

        Assert.assertTrue(driver
                .getPageSource()
                .contains(USER_PAGE_IDENTIFICATION_TEXT));

    }

    @Test(dependsOnMethods = "testDefaultUserInfoPage")
    public void testUserInfoButtonCheck() {

        logInPage = new LogInPage(driver);

        userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_LINK)
                .isDisplayed());
    }

    @Test(dependsOnMethods = "testUserInfoButtonCheck")
    public void testOrderingButtonCheck() {

        logInPage = new LogInPage(driver);

        userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        Assert.assertTrue(userInfoPage
                .getElement(CUSTOMER_ORDERING_LINK)
                .isDisplayed());
    }

    @Test(dependsOnMethods = "testOrderingButtonCheck")
    public void testActiveOrderingPage() {

        logInPage = new LogInPage(driver);

        userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        userInfoPage
                .clickCustomerOrderingTab();

        Assert.assertEquals(driver
                .getCurrentUrl(), CUSTOMER_ORDERING_PAGE_URL);

        Assert.assertTrue(driver
                .getPageSource()
                .contains(ORDERING_PAGE_IDENTIFICATION_TEXT));
    }

    @Test(dependsOnMethods = "testActiveOrderingPage")
    public void testSwitchTabsUserOrdering() {

        logInPage = new LogInPage(driver);

        userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        final CustomerOrderingPage customerOrderingPage = userInfoPage
                .clickCustomerOrderingTab();

        Assert.assertEquals(driver
                .getCurrentUrl(), CUSTOMER_ORDERING_PAGE_URL);

        Assert.assertTrue(driver
                .getPageSource()
                .contains(ORDERING_PAGE_IDENTIFICATION_TEXT));

        customerOrderingPage
                .clickUserInfoTab();

        Assert.assertEquals(driver
                .getCurrentUrl(), USER_INFO_PAGE_URL);

        Assert.assertTrue(driver
                .getPageSource()
                .contains(USER_PAGE_IDENTIFICATION_TEXT));

    }
}
