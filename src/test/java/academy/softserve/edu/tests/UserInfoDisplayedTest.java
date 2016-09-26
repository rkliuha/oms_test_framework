package academy.softserve.edu.tests;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class UserInfoDisplayedTest extends TestRunner {

    @Test(dataProvider = "testDataForAllUsersRole", dataProviderClass = DataProviders.class)
    public void testAdminInfoDisplayed(final Roles role) {
        logInPage.loginAs(role);
        Assert.assertTrue(!driver.findElement(UserInfoPage.FIRST_NAME_VALUE).getText().isEmpty() &&
                        !driver.findElement(UserInfoPage.LAST_NAME_VALUE).getText().isEmpty() &&
                        !driver.findElement(UserInfoPage.CUSTOMER_TYPE_VALUE).getText().isEmpty() &&
                        !driver.findElement(UserInfoPage.ROLE_VALUE).getText().isEmpty(),
                "\nFirst Name = " + driver.findElement(UserInfoPage.FIRST_NAME_VALUE).getText() +
                        "\nLast Name = " + driver.findElement(UserInfoPage.LAST_NAME_VALUE).getText() +
                        "\nCustomer Type = " + driver.findElement(UserInfoPage.CUSTOMER_TYPE_VALUE).getText() +
                        "\nRole = " + driver.findElement(UserInfoPage.ROLE_VALUE).getText() + "\n");
    }
}
