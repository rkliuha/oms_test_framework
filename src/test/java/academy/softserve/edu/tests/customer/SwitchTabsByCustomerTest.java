package academy.softserve.edu.tests.customer;

import academy.softserve.edu.pageobjects.CustomerOrderingPage;
import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static academy.softserve.edu.pageobjects.CustomerOrderingPage.CUSTOMER_ORDERING_PAGE_URL;
import static academy.softserve.edu.pageobjects.CustomerOrderingPage.CUSTOMER_PAGE_EXISTS;
import static academy.softserve.edu.pageobjects.UserInfoPage.*;

public class SwitchTabsByCustomerTest extends TestRunner {

    private LogInPage logInPage;
    private UserInfoPage userInfoPage;

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForCustomer")
    public void testDefaultUserInfoPage(String name, String password) {

        logInPage = new LogInPage(driver);

        userInfoPage = logInPage
                .doLogIn(name, password);

        Assert.assertEquals(driver
                .getCurrentUrl(), USER_INFO_PAGE_URL, "URL is different from " + USER_INFO_PAGE_URL);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_PAGE_EXISTS)
                .isDisplayed(), "Element " + USER_INFO_PAGE_EXISTS + " isn't displayed");

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForCustomer")
    public void testUserInfoButtonCheck(String name, String password) {

        logInPage = new LogInPage(driver);

        userInfoPage = logInPage
                .doLogIn(name, password);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_LINK)
                .isDisplayed(), "Element " + USER_INFO_LINK + " isn't displayed");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForCustomer")
    public void testOrderingButtonCheck(String name, String password) {

        logInPage = new LogInPage(driver);

        userInfoPage = logInPage
                .doLogIn(name, password);

        Assert.assertTrue(userInfoPage
                .getElement(CUSTOMER_ORDERING_LINK)
                .isDisplayed(), "Element " + CUSTOMER_ORDERING_LINK + " isn't displayed");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForCustomer")
    public void testActiveOrderingPage(String name, String password) {

        logInPage = new LogInPage(driver);

        userInfoPage = logInPage
                .doLogIn(name, password);

        userInfoPage
                .clickCustomerOrderingTab();

        Assert.assertEquals(driver
                .getCurrentUrl(), CUSTOMER_ORDERING_PAGE_URL, "URL is different from " + CUSTOMER_ORDERING_PAGE_URL);

        Assert.assertTrue(userInfoPage
                .getElement(CUSTOMER_PAGE_EXISTS)
                .isDisplayed(), "Element " + CUSTOMER_PAGE_EXISTS + " isn't displayed");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForUser")
    public void testSwitchTabsUserOrdering(String name, String password) {

        logInPage = new LogInPage(driver);

        userInfoPage = logInPage
                .doLogIn(name, password);

        final CustomerOrderingPage customerOrderingPage = userInfoPage
                .clickCustomerOrderingTab();

        Assert.assertEquals(driver
                .getCurrentUrl(), CUSTOMER_ORDERING_PAGE_URL, "URL is different from " + CUSTOMER_ORDERING_PAGE_URL);

        Assert.assertTrue(userInfoPage
                .getElement(CUSTOMER_PAGE_EXISTS)
                .isDisplayed(), "Element " + CUSTOMER_PAGE_EXISTS + " isn't displayed");

        customerOrderingPage
                .clickUserInfoTab();

        Assert.assertEquals(driver
                .getCurrentUrl(), USER_INFO_PAGE_URL, "URL is different from " + USER_INFO_PAGE_URL);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_PAGE_EXISTS)
                .isDisplayed(), "Element " + CUSTOMER_PAGE_EXISTS + " isn't displayed");

    }
}
