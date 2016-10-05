package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;


//TODO get rid of collection of WebElements, refactor for use wrappers and custom assertions;
public class SearchTest extends TestRunner {

    @Test
    public void testStatusSearch() {

        final String dropdownStatus = "Status";
        final String textFieldValueByStatus = "ordered";

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        userInfoPage
                .getCustomerOrderingLink()
                .click();

        customerOrderingPage = userInfoPage.clickCustomerOrderingTab();

        customerOrderingPage
                .getSearchDropdown()
                .sendKeys(dropdownStatus);

        customerOrderingPage
                .getSearchInput()
                .sendKeys(textFieldValueByStatus);

        assertThat(customerOrderingPage.getSearchStatusResult())
                .isDisplayed();
    }

    @Test
    public void testNameSearch() {

        final String dropdownName = "Order Name";
        final String textFieldValueByName = "orderName1";

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        userInfoPage
                .getCustomerOrderingLink()
                .click();

        customerOrderingPage = userInfoPage.clickCustomerOrderingTab();

        customerOrderingPage
                .getSearchDropdown()
                .sendKeys(dropdownName);

        customerOrderingPage
                .getSearchInput()
                .sendKeys(textFieldValueByName);

        assertThat(customerOrderingPage.getSearchNameResult())
                .isDisplayed();
    }

    @Test
    public void test5ElementsSearch() {

        final int show5Item = 5;

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        userInfoPage
                .getCustomerOrderingLink()
                .click();

        customerOrderingPage = userInfoPage.clickCustomerOrderingTab();

        customerOrderingPage.getResizeShowItemsLink()
                .click();

        final boolean elementsAmount = customerOrderingPage
                .checkElementsAmount(customerOrderingPage.getSearchResultElements(), show5Item);

        assertThat(customerOrderingPage.getSearchResultElements())
                .isTrue(elementsAmount);
    }

    @Test
    public void test10ElementsSearch() {

        final int show10Item = 10;

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        userInfoPage
                .getCustomerOrderingLink()
                .click();

        customerOrderingPage = userInfoPage.clickCustomerOrderingTab();

        customerOrderingPage.getResizeShowItemsLink()
                .click();

        final boolean elementsAmount = customerOrderingPage
                .checkElementsAmount(customerOrderingPage.getSearchResultElements(), show10Item);

        assertThat(customerOrderingPage.getSearchResultElements())
                .isTrue(elementsAmount);
    }
}
