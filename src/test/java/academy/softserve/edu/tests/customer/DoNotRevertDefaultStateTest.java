package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class DoNotRevertDefaultStateTest extends TestRunner {

    //TODO move inline
    public static final String SEARCH_ORDERS = "Status";
    public static final String SEARCH_ORDERS_VALUE = "Ordered";

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

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        customerOrderingPage = userInfoPage.clickCustomerOrderingTab();

        customerOrderingPage.selectSearchDropdown(SEARCH_ORDERS)
                .fillSearchInput(SEARCH_ORDERS_VALUE)
                .clickApplyButton();

        customerOrderingPage.clickUserInfoTab();

        userInfoPage.clickCustomerOrderingTab();

        assertThat(customerOrderingPage.getSearchDropdown())
                .selectedDropdownEquals(SEARCH_ORDERS);

        assertThat(customerOrderingPage.getSearchInput())
                .valueEquals(SEARCH_ORDERS_VALUE);
    }
}
