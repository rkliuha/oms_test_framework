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

public class SearchTest extends TestRunner {

    private static final By ORDERED_RESULT = By.xpath(".//div[@id='list']/table/tbody/tr");

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataSearchStatusCustomer")
    public void testStatusSearch(final String name, final String password, final String searchOrder, final String searchOrderValue) {

        userInfoPage = logInPage
                .doLogIn(name, password);

        userInfoPage
                .click(CUSTOMER_ORDERING_LINK);

        final CustomerOrderingPage customerOrderingPage = new CustomerOrderingPage(driver);

        customerOrderingPage
                .getElement(SEARCH_ORDERS_DROPDOWN)
                .sendKeys(searchOrder);

        customerOrderingPage
                .getElement(SEARCH_ORDERS_TEXT_BOX)
                .sendKeys(searchOrderValue);

        final List<WebElement> elementsList = customerOrderingPage
                .getElements(ORDERED_RESULT);

        elementsList
                .forEach(element -> Assert.assertTrue(element
                        .getText()
                        .equals(searchOrderValue), "Status search result isn't contains " + searchOrderValue));
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataSearchElementsCustomer")
    public void testElementsSearch(final String name, final String password, final By elementPath, final int elementsAmount) {

        userInfoPage = logInPage
                .doLogIn(name, password);

        userInfoPage
                .click(CUSTOMER_ORDERING_LINK);

        final CustomerOrderingPage customerOrderingPage = new CustomerOrderingPage(driver);

        customerOrderingPage
                .click(elementPath);

        final List<WebElement> elementsList = customerOrderingPage
                .getElements(ORDERED_RESULT);

        elementsList
                .stream()
                .filter(element -> elementsList.size() >= elementsAmount)
                .forEach(element -> Assert.assertTrue(element.isDisplayed(), "Aren't " + elementsAmount + " elements on page"));
    }
}
