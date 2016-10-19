package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class DoNotRevertDefaultStateTest extends TestRunner {

    @Test
    public void testUserInfoButtonsDisplayed() {

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        assertThat(userInfoPage.getUserInfoLink())
                .isDisplayed();

        assertThat(userInfoPage.getCustomerOrderingLink())
                .isDisplayed();
    }

    @Test
    public void testDoNotRevertDefaultState() {

        final String searchOrders = "Status";
        final String searchOrdersValue = "Ordered";

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        customerOrderingPage = userInfoPage.clickCustomerOrderingTab();

        customerOrderingPage.selectSearchDropdown(searchOrders)
                .fillSearchInput(searchOrdersValue)
                .clickApplyButton();

        customerOrderingPage.clickUserInfoTab();

        userInfoPage.clickCustomerOrderingTab();

        assertThat(customerOrderingPage.getSearchDropdown())
                .selectedDropdownEquals(searchOrders);

        assertThat(customerOrderingPage.getSearchInput())
                .valueEquals(searchOrdersValue);
    }
}
