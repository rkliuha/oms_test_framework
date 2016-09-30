package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.CustomerOrderingPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwitchTabsByCustomerTest extends TestRunner {

    @Test
    public void testDefaultUserInfoPage() {

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        Assert.assertTrue(userInfoPage
                .getUserInfoFieldSet()
                .isDisplayed(), "Element " + userInfoPage.getUserInfoFieldSet().getLocatorValue() + " isn't displayed");
    }

    @Test
    public void testUserInfoButtonCheck() {

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        Assert.assertTrue(userInfoPage
                .getUserInfoLink()
                .isDisplayed(), "Element " + userInfoPage.getUserInfoLink().getLocatorValue() + " isn't displayed");
    }

    @Test
    public void testOrderingButtonCheck() {

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        Assert.assertTrue(userInfoPage
                .getCustomerOrderingLink()
                .isDisplayed(), "Element " + userInfoPage.getCustomerOrderingLink().getLocatorValue() + " isn't displayed");
    }

    @Test
    public void testActiveOrderingPage() {

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        userInfoPage
                .getCustomerOrderingLink()
                .click();

        customerOrderingPage = new CustomerOrderingPage(driver);

        Assert.assertTrue(customerOrderingPage
                .getCreateNewOrderLink()
                .isDisplayed(), "Element " + customerOrderingPage.getCreateNewOrderLink().getLocatorValue() + " isn't displayed");
    }

    @Test
    public void testSwitchTabsUserOrdering() {

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        userInfoPage
                .getCustomerOrderingLink()
                .click();

        customerOrderingPage = new CustomerOrderingPage(driver);

        Assert.assertTrue(customerOrderingPage
                .getCreateNewOrderLink()
                .isDisplayed(), "Element " + customerOrderingPage.getCreateNewOrderLink().getLocatorValue() + " isn't displayed");

        customerOrderingPage = new CustomerOrderingPage(driver);

        customerOrderingPage
                .getUserInfoLink()
                .click();

        Assert.assertTrue(userInfoPage
                .getUserInfoFieldSet()
                .isDisplayed(), "Element " + userInfoPage.getUserInfoFieldSet().getLocatorValue() + " isn't displayed");
    }
}
