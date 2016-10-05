package academy.softserve.edu.tests.customer;

import academy.softserve.edu.elements.wrappers.Element;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.CustomerOrderingPage;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.TestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static academy.softserve.edu.asserts.FluentAssertions.*;


//TODO get rid of collection of WebElements, refactor for use wrappers and custom assertions;
public class SearchTest extends TestRunner {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataSearchStatusCustomer")
    public void testStatusSearch(final String searchOrder, final String searchOrderValue, final Element element) {

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

        assertThat(element)
                .isDisplayed();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testData5SearchElementsCustomer")
    public void test5ElementsSearch(final String elements) {

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        userInfoPage
                .getCustomerOrderingLink()
                .click();

        customerOrderingPage = new CustomerOrderingPage(driver);

        customerOrderingPage.getResizeShowItemsLink()
                .click();

        assertThat(customerOrderingPage.getSearchResult(elements))
                .isDisplayed();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testData10SearchElementsCustomer")
    public void test10ElementsSearch(final String elements) {

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        userInfoPage
                .getCustomerOrderingLink()
                .click();

        customerOrderingPage = new CustomerOrderingPage(driver);

        customerOrderingPage.getResizeShowItemsLink()
                .click();

        assertThat(customerOrderingPage.getSearchResult(elements))
                .isDisplayed();
    }
}
