package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class SwitchTabsTest extends TestRunner {

    @Test
    public final void testDefaultUserInfoPage() {

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        assertThat(userInfoPage.getUserInfoFieldSet())
                .isDisplayed();
    }

    @Test
    public final void testUserInfoButtonCheck() {

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        assertThat(userInfoPage.getUserInfoLink())
                .isDisplayed();
    }

    @Test
    public final void testOrderingButtonCheck() {

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        assertThat(userInfoPage.getCustomerOrderingLink())
                .isDisplayed();
    }

    @Test
    public final void testActiveOrderingPage() {

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        customerOrderingPage = userInfoPage.goToCustomerOrderingPage();

        assertThat(customerOrderingPage.getCreateNewOrderLink())
                .isDisplayed();
    }

    @Test
    public final void testSwitchTabsUserOrdering() {

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        customerOrderingPage = userInfoPage.goToCustomerOrderingPage();

        assertThat(customerOrderingPage.getCreateNewOrderLink())
                .isDisplayed();

        customerOrderingPage.goToUserInfoPage();

        assertThat(userInfoPage.getUserInfoFieldSet())
                .isDisplayed();
    }
}
