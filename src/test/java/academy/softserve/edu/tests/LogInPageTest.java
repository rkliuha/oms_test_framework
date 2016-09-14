package academy.softserve.edu.tests;

import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class LogInPageTest extends TestRunner {

    // To check input fields empty or not.
    @Test
    public void testLoginInputsAreEmpty() {
        final LogInPage logInPage = new LogInPage(driver);
        Assert.assertFalse(logInPage.getInputNameField().getText() == null &
                        logInPage.getInputPasswordField().getText() == null,
                "Input fields is not empty!");
    }

    // To check is it possible to input different symbols in to the inputName field.
    @Test
    public void testInputText() {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .getInputNameField()
                .sendKeys("Asa23@(?|};6756%");
        Assert.assertTrue(logInPage.getInputNameField().getText() != null,
                "Input name field is empty!");
    }

    // To check is it possible to input password data, and characters must be converted in to the asterisk
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public void testInputsCanTakeSymbols(final String name, final String password) {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .getInputPasswordField()
                .sendKeys(password);
        Assert.assertFalse(Objects.equals(logInPage.getInputPasswordField().getText(), password),
                "You can see the password!");
    }

    //Try to put in the both fields unregistered data
    @Test
    public void testUnregisteredUser() {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage.doLogIn("Sarumjan", "Mordor");
        Assert.assertFalse(Objects.equals(driver.getCurrentUrl(), UserInfoPage.USER_INFO_PAGE_URL),
                "You Logged In with unregistered data!");
    }

    //Try to Log In with only users field filled
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public void testInputOnlyName(final String name, final String password) {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .inputName(name)
                .clickLogInButton();
        Assert.assertFalse(Objects.equals(driver.getCurrentUrl(), UserInfoPage.USER_INFO_PAGE_URL),
                "You Logged In without password!");
    }

    //Input data at the password field only
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public void testInputOnlyPassword(final String name, final String password) {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .inputPassword(password)
                .clickLogInButton();
        Assert.assertFalse(Objects.equals(driver.getCurrentUrl(), UserInfoPage.USER_INFO_PAGE_URL),
                "You Logged In with empty name field!");
    }

    //Try to Log In with empty input fields
    @Test
    public void testInputNothing() {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .clickLogInButton();
        Assert.assertFalse(Objects.equals(driver.getCurrentUrl(), UserInfoPage.USER_INFO_PAGE_URL),
                "You are David Copperfield!");
    }

    //Check Reset Button
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public void testClearFields(final String name, final String password) {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .inputName(name)
                .inputPassword(password)
                .clickResetButton();
        Assert.assertTrue(logInPage.getNameField().getText().isEmpty() &
                        logInPage.getPasswordField().getText().isEmpty(),
                "Input fields is not empty!");
    }

    //Try to Log In and Log Out with valid data and turn on Remember me check box. Data should remain in the input fields
    //!!input fields on LogInPage remain clean after click on remember me check box. Log in and Log out!!!
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public void testRememberUserData(final String name, final String password) {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .clickRememberMeButton()
                .doLogIn(name, password);
        logInPage.doLogOut();
        Assert.assertFalse(logInPage.getInputNameField().getText() != name &
                logInPage.getInputPasswordField().getText().isEmpty(), "The data is not saved!");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public void testLoginWithNonExistingData(final String name, final String password) {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage.doLogIn("Sarumjan", password);      // Input Incorrect name and empty password field and click
        logInPage.doLogIn(name, "mordor");            // Input Incorrect password and empty name field and click
        Assert.assertFalse(Objects.equals(driver.getCurrentUrl(), UserInfoPage.USER_INFO_PAGE_URL),
                "You are Logged In with invalid data!");
    }

    //Input data in to the Password field, Try to Log In
    //En expected message: «Such user does not exist in the system – please try again.»
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public void testErrorMessageOnEmptyUsername(final String name, final String password) {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .inputPassword(password)
                .clickLogInButton();
        Assert.assertEquals(logInPage.getElement(LogInPage.ERROR_MESSAGE).getText(),
                logInPage.EXPECTED_INVALID_NAME_MESSAGE, "Unexpected message!");
    }

    //Input not registered data in to the Name field, Try to Log In
    //En expected message: «Such user does not exist in the system – please try again.»
    @Test
    public void testErrorMessageOnUnregisteredName() {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage.inputName("unregistered data")
                .clickLogInButton();
        Assert.assertEquals(logInPage.getElement(LogInPage.ERROR_MESSAGE).getText(),
                logInPage.EXPECTED_INVALID_NAME_MESSAGE, "Unexpected message!");
    }

    //Input data in to the User Field, Try to Log In
    //En expected message: «Password is incorrect – please try again»
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public void testErrorMessageOnEmptyPasswordField(final String name, final String password) {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .inputName(name)
                .clickLogInButton();
        Assert.assertEquals(logInPage.getElement(LogInPage.ERROR_MESSAGE).getText(),
                logInPage.EXPECTED_INVALID_PASSWORD_MESSAGE, "Unexpected message!");
    }

    //Input right data in to the User field, input wrong data in to the Password field. Try to log in.
    //En expected message: «Password is incorrect – please try again»
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public void testErrorMessageOnWrongPassword(String name, String password) {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage.doLogIn(name, "mordor");// Input Incorrect password and empty name field and click
        Assert.assertEquals(logInPage.getElement(LogInPage.ERROR_MESSAGE).getText(),
                logInPage.EXPECTED_INVALID_PASSWORD_MESSAGE, "Unexpected message!");
    }
}

