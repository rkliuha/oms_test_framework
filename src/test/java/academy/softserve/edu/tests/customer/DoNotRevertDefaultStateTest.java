package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.CustomerOrderingPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static academy.softserve.edu.pageobjects.CustomerOrderingPage.*;
import static academy.softserve.edu.pageobjects.UserInfoPage.CUSTOMER_ORDERING_LINK;
import static academy.softserve.edu.pageobjects.UserInfoPage.USER_INFO_LINK;

public class DoNotRevertDefaultStateTest extends TestRunner {

    public static final String SEARCH_ORDERS = "Status";
    public static final String SEARCH_ORDERS_VALUE = "Ordered";
    public static final String TAG_ATRIBUT = "value";

    @Test
    public void testUserInfoButtonsDisplayed() {

        userInfoPage = logInPage
                .loginAs(Roles.CUSTOMER);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_LINK)
                .isDisplayed(), "Element " + USER_INFO_LINK + " isn't displayed");

        Assert.assertTrue(userInfoPage
                .getElement(CUSTOMER_ORDERING_LINK)
                .isDisplayed(), "Element " + CUSTOMER_ORDERING_LINK + " isn't displayed");
    }

    @Test
    public void testDoNotRevertDefaultState() {

        userInfoPage = logInPage
                .loginAs(Roles.CUSTOMER);

        userInfoPage
                .click(CUSTOMER_ORDERING_LINK);

        customerOrderingPage = new CustomerOrderingPage(driver);

        customerOrderingPage
                .getElement(SEARCH_ORDERS_DROPDOWN)
                .sendKeys(SEARCH_ORDERS);

        customerOrderingPage
                .getElement(SEARCH_ORDERS_TEXT_BOX)
                .sendKeys(SEARCH_ORDERS_VALUE);

        customerOrderingPage
                .click(SEARCH_ORDERS_BUTTON);

        customerOrderingPage
                .click(USER_INFO_LINK);

        userInfoPage
                .click(CUSTOMER_ORDERING_LINK);

        Assert.assertTrue(customerOrderingPage
                .getElement(SEARCH_ORDERS_DROPDOWN)
                .getText()
                .contains(SEARCH_ORDERS), "Search order in the search order drop down is different of " + SEARCH_ORDERS);

        Assert.assertTrue(customerOrderingPage
                .getElement(SEARCH_ORDERS_TEXT_BOX)
                .getAttribute(TAG_ATRIBUT)
                .contains(SEARCH_ORDERS_VALUE), "Search order value in the search order text box is different of " + SEARCH_ORDERS_VALUE);
    }
}
