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

    private static final String TAG_ATRIBUT = "value";
    private static final By ORDERED_RESULT = By.xpath(".//div[@id='list']/table//tr");

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForCustomer")
    public void testStatusSearch(final String name, final String password) {

        final String SEARCH_ORDERS_VALUE = "ordered";
        final String SEARCH_ORDERS = "Status";

        userInfoPage = logInPage
                .doLogIn(name, password);

        userInfoPage
                .click(CUSTOMER_ORDERING_LINK);

        final CustomerOrderingPage customerOrderingPage = new CustomerOrderingPage(driver);

        customerOrderingPage
                .getElement(SEARCH_ORDERS_DROPDOWN)
                .sendKeys(SEARCH_ORDERS);

        customerOrderingPage
                .getElement(SEARCH_ORDERS_TEXT_BOX)
                .sendKeys(SEARCH_ORDERS_VALUE);


        final List<WebElement> elementsList = customerOrderingPage
                .getElements(ORDERED_RESULT);

        elementsList
                .forEach(element -> Assert.assertTrue(element
                        .getAttribute(TAG_ATRIBUT)
                        .equals(SEARCH_ORDERS_VALUE), "Status search result isn't contains " + SEARCH_ORDERS_VALUE));
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForCustomer")
    public void testOrderNameSearch(final String name, final String password) {

        final String SEARCH_ORDERS = "Order Name";
        final String SEARCH_ORDERS_VALUE = "orderName1";

        userInfoPage = logInPage
                .doLogIn(name, password);

        userInfoPage
                .click(CUSTOMER_ORDERING_LINK);

        final CustomerOrderingPage customerOrderingPage = new CustomerOrderingPage(driver);

        customerOrderingPage
                .getElement(SEARCH_ORDERS_DROPDOWN)
                .sendKeys(SEARCH_ORDERS);

        customerOrderingPage
                .getElement(SEARCH_ORDERS_TEXT_BOX)
                .sendKeys(SEARCH_ORDERS_VALUE);

        final List<WebElement> elementsList = customerOrderingPage
                .getElements(ORDERED_RESULT);

        elementsList
                .forEach(element -> Assert.assertTrue(element
                        .getAttribute(TAG_ATRIBUT)
                        .equals(SEARCH_ORDERS_VALUE), "Order name search result isn't contains " + SEARCH_ORDERS_VALUE));
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

        final List<WebElement> elementsList = customerOrderingPage
                .getElements(ORDERED_RESULT);

        elementsList
                .stream()
                .filter(element -> elementsList.size() >= 10)
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

        final List<WebElement> elementsList = customerOrderingPage
                .getElements(ORDERED_RESULT);

        elementsList
                .stream()
                .filter(element -> elementsList.size() >= 5)
                .forEach(element -> Assert.assertTrue(element.isDisplayed(), "Aren't 5 elements on page"));
    }

}
