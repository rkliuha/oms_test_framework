package academy.softserve.edu.tests.customer;

import academy.softserve.edu.pageobjects.CustomerOrderingPage;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.TestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static academy.softserve.edu.pageobjects.CustomerOrderingPage.*;
import static academy.softserve.edu.pageobjects.UserInfoPage.CUSTOMER_ORDERING_LINK;

public class SearchResultTest extends TestRunner {

    private static final String STATUS_SEARCH_ORDERS_VALUE = "ordered";
    private static final String TAG_ATRIBUT = "value";
    private static final By ORDERED_RESULT_ATTRIBUTES = By.xpath(".//div[@id='list']/table//@*");
    private static final By ORDERED_RESULT_STRINGS = By.xpath(".//div[@id='list']/table//tr");

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForCustomer")
    public void testStatusSearch(final String name, final String password) {

        final String STATUS_SEARCH_ORDERS = "Status";

        userInfoPage = logInPage
                .doLogIn(name, password);

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
                .getElement(ORDERED_RESULT_ATTRIBUTES)
                .getAttribute(TAG_ATRIBUT)
                .contains(STATUS_SEARCH_ORDERS_VALUE), "Status search result isn't contains " + STATUS_SEARCH_ORDERS_VALUE);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForCustomer")
    public void testOrderNameSearch(final String name, final String password) {

        final String ORDER_NAME_SEARCH_ORDERS = "Order Name";
        final String ORDER_NAME_SEARCH_ORDERS_VALUE = "orderName1";

        userInfoPage = logInPage
                .doLogIn(name, password);

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
                .getElement(ORDERED_RESULT_ATTRIBUTES)
                .getAttribute(TAG_ATRIBUT)
                .contains(ORDER_NAME_SEARCH_ORDERS_VALUE), "Order name search result isn't contains " + ORDER_NAME_SEARCH_ORDERS_VALUE);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForCustomer")
    public void testFirst10Search(final String name, final String password) {

        userInfoPage = logInPage
                .doLogIn(name, password);

        userInfoPage
                .click(CUSTOMER_ORDERING_LINK);

        final CustomerOrderingPage customerOrderingPage = new CustomerOrderingPage(driver);

        customerOrderingPage
                .click(SHOW_10_ITEMS_LINK);

        final List<WebElement> elementsList = customerOrderingPage.getElements(ORDERED_RESULT_STRINGS);

        elementsList
                .stream()
                .limit(10)
                .forEach(element -> Assert.assertTrue(element.isDisplayed(), "Aren't 10 elements on page"));
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForCustomer")
    public void testFirst5Search(final String name, final String password) {

        userInfoPage = logInPage
                .doLogIn(name, password);

        userInfoPage
                .click(CUSTOMER_ORDERING_LINK);

        final CustomerOrderingPage customerOrderingPage = new CustomerOrderingPage(driver);

        customerOrderingPage
                .click(SHOW_5_ITEMS_LINK);

        final List<WebElement> elementsList = customerOrderingPage.getElements(ORDERED_RESULT_STRINGS);

        elementsList
                .stream()
                .limit(10)
                .forEach(element -> Assert.assertTrue(element.isDisplayed(), "Aren't 10 elements on page"));
    }

}
