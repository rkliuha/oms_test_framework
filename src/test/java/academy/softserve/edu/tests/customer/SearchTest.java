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

        customerOrderingPage = userInfoPage.goToCustomerOrderingPage();

        customerOrderingPage.searchOrder(dropdownStatus, textFieldValueByStatus);

        assertThat(customerOrderingPage.getSearchStatusResult())
                .isDisplayed();
    }

    @Test
    public void testNameSearch() {

        final String dropdownName = "Order Name";
        final String textFieldValueByName = "OrderName3";

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        customerOrderingPage = userInfoPage.goToCustomerOrderingPage();

        customerOrderingPage.searchOrder(dropdownName, textFieldValueByName);

        assertThat(customerOrderingPage.getSearchNameResult())
                .isDisplayed();
    }

    @Test
    public void testElementsSearch() {

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        customerOrderingPage = userInfoPage.goToCustomerOrderingPage();

        assertThat(customerOrderingPage.getOrderNameColumnElements())
                .isQuantityLessOrEqualsThan(5);

        customerOrderingPage.resizeShowOrders();

        assertThat(customerOrderingPage.getOrderNameColumnElements())
                .isQuantityMoreThan(5);

        assertThat(customerOrderingPage.getOrderNameColumnElements())
                .isQuantityLessOrEqualsThan(10);
    }

}
