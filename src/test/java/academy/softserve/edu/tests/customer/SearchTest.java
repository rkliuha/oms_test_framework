package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;

public class SearchTest extends TestRunner {

    @Test
    public void testStatusSearch() {

        final String dropdownStatus = "Status";
        final String textFieldValueByStatus = "Created";

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

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
        final String textFieldValueByName = "OrderName3";

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        customerOrderingPage = userInfoPage.clickCustomerOrderingTab();

        customerOrderingPage.selectSearchDropdown(dropdownName)
                .fillSearchInput(textFieldValueByName)
                .clickApplyButton();

        assertThat(customerOrderingPage.getSearchNameResult())
                .isDisplayed();
    }

    @Test
    public void testElementsSearch() {

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        customerOrderingPage = userInfoPage.clickCustomerOrderingTab();

        assertThat(customerOrderingPage.getOrderNameColumnElements())
                .isQuantityLessOrEqualsThan(5);

        customerOrderingPage.clickResizeShowItemsLink();

        assertThat(customerOrderingPage.getOrderNameColumnElements())
                .isQuantityMoreThan(5);

        assertThat(customerOrderingPage.getOrderNameColumnElements())
                .isQuantityLessOrEqualsThan(10);
    }

}
