package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.CustomerOrderingPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class DoNotRevertDefaultStateTest extends TestRunner {

    @Test
    public void testUserInfoButtonsDisplayed() {

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        assertThat(userInfoPage.getUserInfoLink())
                .isDisplayed();

        assertThat(userInfoPage.getCustomerOrderingLink())
                .isDisplayed();
    }

    @Test
    public void testDoNotRevertDefaultState() {

        final String SEARCH_ORDERS = "Status";
        final String SEARCH_ORDERS_VALUE = "Ordered";

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

        assertThat(customerOrderingPage.getSearchDropdown())
                .selectedDropdownEquals(SEARCH_ORDERS);

        assertThat(customerOrderingPage.getSearchInput())
                .valueEquals(SEARCH_ORDERS_VALUE);
    }
}
