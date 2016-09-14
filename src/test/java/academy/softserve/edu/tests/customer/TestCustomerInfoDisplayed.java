package academy.softserve.edu.tests.customer;

import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class TestCustomerInfoDisplayed extends TestRunner {

    @Test(dataProvider = "testDataForCustomer", dataProviderClass = DataProviders.class)
    public void testAdminInfoDisplayed(final String userName, final String userPassword) {
        infoPage = new UserInfoPage(driver);
        loginPage = new LogInPage(driver);
        loginPage.doLogIn(userName, userPassword);
        assertTrue(!infoPage.getFirstNameValue().isEmpty() &&
                !infoPage.getLastNameValue().isEmpty() &&
                !infoPage.getCustomerTypeValue().isEmpty() &&
                !infoPage.getRoleValue().isEmpty());
    }
}
