package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.CustomerOrderingPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoNotRevertDefaultStateTest extends TestRunner {

    public static final String SEARCH_ORDERS = "Status";
    public static final String SEARCH_ORDERS_VALUE = "Ordered";
    public static final String TAG_ATRIBUT = "value";

    @Test
    public void testUserInfoButtonsDisplayed() {

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        Assert.assertTrue(userInfoPage
                .getUserInfoLink()
                .isDisplayed(), "Element " + userInfoPage.getUserInfoLink().getLocatorValue() + " isn't displayed");

        Assert.assertTrue(userInfoPage
                .getCustomerOrderingLink()
                .isDisplayed(), "Element " + userInfoPage.getCustomerOrderingLink().getLocatorValue() + " isn't displayed");
    }

    @Test
    public void testDoNotRevertDefaultState() {

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        userInfoPage.getCustomerOrderingLink()
                .click();

        customerOrderingPage = new CustomerOrderingPage(driver);

        customerOrderingPage
                .getSearchDropdown()
                .sendKeys(SEARCH_ORDERS);

        customerOrderingPage
                .getSearchInput()
                .sendKeys(SEARCH_ORDERS_VALUE);

        customerOrderingPage
                .getApplyButton().click();

        customerOrderingPage
                .getUserInfoLink()
                .click();

        userInfoPage
                .getCustomerOrderingLink()
                .click();

        Assert.assertTrue(customerOrderingPage
                .getSearchDropdown()
                .getText()
                .contains(SEARCH_ORDERS), "Search order in the search order drop down is different of " + SEARCH_ORDERS);

        Assert.assertTrue(customerOrderingPage
                .getSearchInput()
                .getValue()
                .contains(SEARCH_ORDERS_VALUE), "Search order value in the search order text box is different of " + SEARCH_ORDERS_VALUE);
    }
}
