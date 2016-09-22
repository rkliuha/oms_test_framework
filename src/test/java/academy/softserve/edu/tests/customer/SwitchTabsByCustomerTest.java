package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.CustomerOrderingPage;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static academy.softserve.edu.pageobjects.CustomerOrderingPage.CUSTOMER_PAGE_EXISTS;
import static academy.softserve.edu.pageobjects.UserInfoPage.*;

public class SwitchTabsByCustomerTest extends TestRunner {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForCustomer")
    public void testDefaultUserInfoPage(final String name, final String password) {

        userInfoPage = logInPage
                .loginAs(Roles.CUSTOMER);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_PAGE_EXISTS)
                .isDisplayed(), "Element " + USER_INFO_PAGE_EXISTS + " isn't displayed");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForCustomer")
    public void testUserInfoButtonCheck(final String name, final String password) {

        userInfoPage = logInPage
                .loginAs(Roles.CUSTOMER);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_LINK)
                .isDisplayed(), "Element " + USER_INFO_LINK + " isn't displayed");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForCustomer")
    public void testOrderingButtonCheck(final String name, final String password) {

        userInfoPage = logInPage
                .loginAs(Roles.CUSTOMER);

        Assert.assertTrue(userInfoPage
                .getElement(CUSTOMER_ORDERING_LINK)
                .isDisplayed(), "Element " + CUSTOMER_ORDERING_LINK + " isn't displayed");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForCustomer")
    public void testActiveOrderingPage(final String name, final String password) {

        userInfoPage = logInPage
                .loginAs(Roles.CUSTOMER);

        userInfoPage
                .click(CUSTOMER_ORDERING_LINK);

        Assert.assertTrue(userInfoPage
                .getElement(CUSTOMER_PAGE_EXISTS)
                .isDisplayed(), "Element " + CUSTOMER_PAGE_EXISTS + " isn't displayed");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForCustomer")
    public void testSwitchTabsUserOrdering(final String name, final String password) {

        userInfoPage = logInPage
                .loginAs(Roles.CUSTOMER);

        userInfoPage
                .click(CUSTOMER_ORDERING_LINK);

        Assert.assertTrue(userInfoPage
                .getElement(CUSTOMER_PAGE_EXISTS)
                .isDisplayed(), "Element " + CUSTOMER_PAGE_EXISTS + " isn't displayed");

        customerOrderingPage = new CustomerOrderingPage(driver);

        customerOrderingPage
                .click(USER_INFO_LINK);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_PAGE_EXISTS)
                .isDisplayed(), "Element " + CUSTOMER_PAGE_EXISTS + " isn't displayed");
    }
}
