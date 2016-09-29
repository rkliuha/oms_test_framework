package academy.softserve.edu.tests;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserInfoDisplayedTest extends TestRunner {

    @Test(dataProvider = "testDataForAllUsersRole", dataProviderClass = DataProviders.class)
    public void testAdminInfoDisplayed(final Roles role) {
        logInPage.logInAs(role);
        userInfoPage = new UserInfoPage(driver);
        Assert.assertTrue(!userInfoPage.getFirstNameValue().getText().isEmpty() &&
                        !userInfoPage.getLastNameValue().getText().isEmpty() &&
                        !userInfoPage.getCustomerTypeValue().getText().isEmpty() &&
                        !userInfoPage.getRoleValue().getText().isEmpty(),
                "\nFirst Name = " + userInfoPage.getFirstNameValue().getText() +
                        "\nLast Name = " + userInfoPage.getLastNameValue().getText() +
                        "\nCustomer Type = " + userInfoPage.getCustomerTypeValue().getText() +
                        "\nRole = " + userInfoPage.getRoleValue().getText() + "\n");
    }
}
