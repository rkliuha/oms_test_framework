package academy.softserve.edu.tests;

import academy.softserve.edu.elements.wrappers.TextLabel;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static academy.softserve.edu.elements.locators.userinfo.UserInfoPageLocators.*;

public class UserInfoDisplayedTest extends TestRunner {

    //Do log in for every role
    @Test(dataProvider = "testDataForAllUsersRole", dataProviderClass = DataProviders.class)
    public void testAdminInfoDisplayed(final Roles role) {
        logInPage.logInAs(role);
        final TextLabel firstNameValue = new TextLabel(driver, FIRST_NAME_VALUE);
        final TextLabel lastNameValue = new TextLabel(driver, LAST_NAME_VALUE);
        final TextLabel customerTypeValue = new TextLabel(driver, CUSTOMER_TYPE_VALUE);
        final TextLabel roleValue = new TextLabel(driver, ROLE_VALUE);

        //Assert that values are not empty
        Assert.assertTrue(!firstNameValue.getText().isEmpty() &&
                        !lastNameValue.getText().isEmpty() &&
                        !customerTypeValue.getText().isEmpty() &&
                        !roleValue.getText().isEmpty(),
                "\nFirst Name = " + firstNameValue.getText() +
                        "\nLast Name = " + lastNameValue.getText() +
                        "\nCustomer Type = " + customerTypeValue.getText() +
                        "\nRole = " + roleValue.getText() + "\n");
    }
}
