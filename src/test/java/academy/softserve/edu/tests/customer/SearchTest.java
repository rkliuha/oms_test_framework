package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.CustomerOrderingPage;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.TestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

//TODO get rid of collection of WebElements, refactor for use wrappers and custom assertions;
public class SearchTest extends TestRunner {

    private static final By ORDERED_RESULT = By.xpath(".//div[@id='list']/table/tbody/tr");

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataSearchStatusCustomer")
    public void testStatusSearch(final String searchOrder, final String searchOrderValue) {

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        userInfoPage
                .getCustomerOrderingLink()
                .click();

        customerOrderingPage = new CustomerOrderingPage(driver);

        customerOrderingPage
                .getSearchDropdown()
                .sendKeys(searchOrder);

        customerOrderingPage
                .getSearchInput()
                .sendKeys(searchOrderValue);

        final List<WebElement> elementsList = customerOrderingPage
                .getElements(ORDERED_RESULT);

        elementsList
                .forEach(element -> Assert.assertTrue(element
                        .getText()
                        .equals(searchOrderValue), "Status search result isn't contains " + searchOrderValue));
    }

    // TODO remove data provider
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataSearchElementsCustomer")
    public void testElementsSearch(final By elementPath, final int elementsAmount) {

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        userInfoPage
                .getCustomerOrderingLink()
                .click();

        customerOrderingPage = new CustomerOrderingPage(driver);

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
