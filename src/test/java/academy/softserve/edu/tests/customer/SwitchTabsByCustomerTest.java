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

    @Test
    public void testDefaultUserInfoPage() {

        userInfoPage = logInPage
                .loginAs(Roles.CUSTOMER);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_PAGE_EXISTS)
                .isDisplayed(), "Element " + USER_INFO_PAGE_EXISTS + " isn't displayed");
    }

    @Test
    public void testUserInfoButtonCheck() {

        userInfoPage = logInPage
                .loginAs(Roles.CUSTOMER);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_LINK)
                .isDisplayed(), "Element " + USER_INFO_LINK + " isn't displayed");
    }

    @Test
    public void testOrderingButtonCheck() {

        userInfoPage = logInPage
                .loginAs(Roles.CUSTOMER);

        Assert.assertTrue(userInfoPage
                .getElement(CUSTOMER_ORDERING_LINK)
                .isDisplayed(), "Element " + CUSTOMER_ORDERING_LINK + " isn't displayed");
    }

    @Test
    public void testActiveOrderingPage() {

        userInfoPage = logInPage
                .loginAs(Roles.CUSTOMER);

        userInfoPage
                .click(CUSTOMER_ORDERING_LINK);

        Assert.assertTrue(userInfoPage
                .getElement(CUSTOMER_PAGE_EXISTS)
                .isDisplayed(), "Element " + CUSTOMER_PAGE_EXISTS + " isn't displayed");
    }

    @Test
    public void testSwitchTabsUserOrdering() {

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
