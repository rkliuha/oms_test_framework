package academy.softserve.edu.tests.customer;

import academy.softserve.edu.pageobjects.CustomerOrderingPage;
import academy.softserve.edu.utils.TestRunner;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static academy.softserve.edu.pageobjects.CustomerOrderingPage.*;
import static academy.softserve.edu.pageobjects.UserInfoPage.CUSTOMER_ORDERING_LINK;

public class SearchResultTest extends TestRunner {

    public static final String USER_LOGIN = "vpopkin";
    public static final String USER_PASSWORD = "qwerty";
    public static final String STATUS_SEARCH_ORDERS = "Status";
    public static final String STATUS_SEARCH_ORDERS_VALUE = "ordered";
    public static final String STATUS_SEARCH_ORDERS_VALUE_1 = "created";
    public static final String STATUS_SEARCH_ORDERS_VALUE_2 = "pending";
    public static final String STATUS_SEARCH_ORDERS_VALUE_3 = "delivered";
    public static final String ORDER_NAME_SEARCH_ORDERS = "Order Name";
    public static final String ORDER_NAME_SEARCH_ORDERS_VALUE = "orderName1";
    public static final String TAG_ATRIBUT = "value";
    public static final By ORDERED_RESULT = By.xpath(".//div[@id='list']/table//@*");

    @Test
    public void testStatusSearchResult() {

        userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        userInfoPage
                .click(CUSTOMER_ORDERING_LINK);

        final CustomerOrderingPage customerOrderingPage = new CustomerOrderingPage(driver);

        customerOrderingPage
                .getElement(SEARCH_ORDERS_DROPDOWN)
                .sendKeys(STATUS_SEARCH_ORDERS);

        customerOrderingPage
                .getElement(SEARCH_ORDERS_TEXT_BOX)
                .sendKeys(STATUS_SEARCH_ORDERS_VALUE);

        Assert.assertTrue(customerOrderingPage
                .getElement(ORDERED_RESULT)
                .getAttribute(TAG_ATRIBUT)
                .contains(STATUS_SEARCH_ORDERS_VALUE), "Status search result isn't contains " + STATUS_SEARCH_ORDERS_VALUE);
    }

    @Test
    public void testOrderNameSearchResult() {

        userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        userInfoPage
                .click(CUSTOMER_ORDERING_LINK);

        final CustomerOrderingPage customerOrderingPage = new CustomerOrderingPage(driver);

        customerOrderingPage
                .getElement(SEARCH_ORDERS_DROPDOWN)
                .sendKeys(ORDER_NAME_SEARCH_ORDERS);

        customerOrderingPage
                .getElement(SEARCH_ORDERS_TEXT_BOX)
                .sendKeys(ORDER_NAME_SEARCH_ORDERS_VALUE);

        Assert.assertTrue(customerOrderingPage
                .getElement(ORDERED_RESULT)
                .getAttribute(TAG_ATRIBUT)
                .contains(ORDER_NAME_SEARCH_ORDERS_VALUE), "Order name search result isn't contains " + ORDER_NAME_SEARCH_ORDERS_VALUE);
    }

    @Test
    public void testFirst10ElementsSearchResult() {

        userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        userInfoPage
                .click(CUSTOMER_ORDERING_LINK);

        final CustomerOrderingPage customerOrderingPage = new CustomerOrderingPage(driver);

        customerOrderingPage
                .click(SHOW_10_ITEMS);

        Assert.assertTrue(customerOrderingPage
                .getElement(ORDERED_RESULT)
                .getAttribute(TAG_ATRIBUT)
                .contains(STATUS_SEARCH_ORDERS_VALUE), "Search result isn't contains " + STATUS_SEARCH_ORDERS_VALUE);

        Assert.assertTrue(customerOrderingPage
                .getElement(ORDERED_RESULT)
                .getAttribute(TAG_ATRIBUT)
                .contains(STATUS_SEARCH_ORDERS_VALUE_1), "Search result isn't contains " + STATUS_SEARCH_ORDERS_VALUE_1);

        Assert.assertTrue(customerOrderingPage
                .getElement(ORDERED_RESULT)
                .getAttribute(TAG_ATRIBUT)
                .contains(STATUS_SEARCH_ORDERS_VALUE_2), "Search result isn't contains " + STATUS_SEARCH_ORDERS_VALUE_2);

        Assert.assertTrue(customerOrderingPage
                .getElement(ORDERED_RESULT)
                .getAttribute(TAG_ATRIBUT)
                .contains(STATUS_SEARCH_ORDERS_VALUE_3), "Search result isn't contains " + STATUS_SEARCH_ORDERS_VALUE_3);

    }

    @Test
    public void testFirst5ElementsSearchResult() {

        userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        userInfoPage
                .click(CUSTOMER_ORDERING_LINK);

        final CustomerOrderingPage customerOrderingPage = new CustomerOrderingPage(driver);

        customerOrderingPage
                .click(SHOW_5_ITEMS);

        Assert.assertTrue(customerOrderingPage
                .getElement(ORDERED_RESULT)
                .getAttribute(TAG_ATRIBUT)
                .contains(STATUS_SEARCH_ORDERS_VALUE), "Search result isn't contains " + STATUS_SEARCH_ORDERS_VALUE);

        Assert.assertTrue(customerOrderingPage
                .getElement(ORDERED_RESULT)
                .getAttribute(TAG_ATRIBUT)
                .contains(STATUS_SEARCH_ORDERS_VALUE_1), "Search result isn't contains " + STATUS_SEARCH_ORDERS_VALUE_1);

        Assert.assertTrue(customerOrderingPage
                .getElement(ORDERED_RESULT)
                .getAttribute(TAG_ATRIBUT)
                .contains(STATUS_SEARCH_ORDERS_VALUE_2), "Search result isn't contains " + STATUS_SEARCH_ORDERS_VALUE_2);

        Assert.assertTrue(customerOrderingPage
                .getElement(ORDERED_RESULT)
                .getAttribute(TAG_ATRIBUT)
                .contains(STATUS_SEARCH_ORDERS_VALUE_3), "Search result isn't contains " + STATUS_SEARCH_ORDERS_VALUE_3);
    }

}
