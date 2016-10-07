package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.CustomerOrderingPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class SwitchTabsByCustomerTest extends TestRunner {

    @Test
    public void testDefaultUserInfoPage() {

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        assertThat(userInfoPage.getUserInfoFieldSet())
                .isDisplayed();
    }

    @Test
    public void testUserInfoButtonCheck() {

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        assertThat(userInfoPage.getUserInfoLink())
                .isDisplayed();
    }

    @Test
    public void testOrderingButtonCheck() {

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        assertThat(userInfoPage.getCustomerOrderingLink())
                .isDisplayed();
    }

    @Test
    public void testActiveOrderingPage() {

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        userInfoPage
                .getCustomerOrderingLink()
                .click();

        customerOrderingPage = new CustomerOrderingPage(driver);

        assertThat(customerOrderingPage.getCreateNewOrderLink())
                .isDisplayed();
    }

    @Test
    public void testSwitchTabsUserOrdering() {

        userInfoPage = logInPage
                .logInAs(Roles.CUSTOMER);

        userInfoPage
                .getCustomerOrderingLink()
                .click();

        customerOrderingPage = new CustomerOrderingPage(driver);

        assertThat(customerOrderingPage.getCreateNewOrderLink())
                .isDisplayed();

        customerOrderingPage
                .getUserInfoLink()
                .click();

        assertThat(userInfoPage.getUserInfoFieldSet())
                .isDisplayed();
    }
}
