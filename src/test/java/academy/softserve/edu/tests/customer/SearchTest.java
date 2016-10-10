package academy.softserve.edu.tests.customer;

import academy.softserve.edu.elements.wrappers.Element;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;


//TODO get rid of collection of WebElements, refactor for use wrappers and custom assertions;
public class SearchTest extends TestRunner {

    final public boolean checkElementsAmount(final Element elements, final int elementsAmount) {

        if (elements.getElements().size() == elementsAmount) {

            return true;

        } else return false;
    }

    @Test
    public void testStatusSearch() {

        final String dropdownStatus = "Status";
        final String textFieldValueByStatus = "ordered";

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        customerOrderingPage = userInfoPage.clickCustomerOrderingTab();

        customerOrderingPage.selectSearchDropdown(dropdownStatus)
                .fillSearchInput(textFieldValueByStatus)
                .clickApplyButton();

        assertThat(customerOrderingPage.getSearchStatusResult())
                .isDisplayed();
    }

    @Test
    public void testNameSearch() {

        final String dropdownName = "Order Name";
        final String textFieldValueByName = "orderName1";

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        customerOrderingPage = userInfoPage.clickCustomerOrderingTab();

        customerOrderingPage.selectSearchDropdown(dropdownName)
                .fillSearchInput(textFieldValueByName)
                .clickApplyButton();

        assertThat(customerOrderingPage.getSearchNameResult())
                .isDisplayed();
    }

    @Test
    public void test5ElementsSearch() {

        final int show5Item = 5;

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        customerOrderingPage = userInfoPage.clickCustomerOrderingTab();

        customerOrderingPage.clickResizeShowItemsLink();

        final boolean searchOrderResult = checkElementsAmount(customerOrderingPage.getSearchResultElements(), show5Item);

        assertThat(searchOrderResult)
                .isTrue();
    }

    @Test
    public void test10ElementsSearch() {

        final int show10Item = 10;

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        customerOrderingPage = userInfoPage.clickCustomerOrderingTab();

        customerOrderingPage.clickResizeShowItemsLink();

        final boolean searchOrderResult = checkElementsAmount(customerOrderingPage.getSearchResultElements(), show10Item);

        assertThat(searchOrderResult)
                .isTrue();
    }
}
