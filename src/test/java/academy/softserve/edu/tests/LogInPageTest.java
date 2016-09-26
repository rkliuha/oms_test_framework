package academy.softserve.edu.tests;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.PropertiesReader;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInPageTest extends TestRunner {

    @Test
    public final void testLoginInputsAreEmpty() {

        Assert.assertFalse(logInPage.getInputNameField().getText() == null &&
                        logInPage.getInputPasswordField().getText() == null,
                "Input fields should be empty!");

    }

    // To check is it possible to input different symbols in to the inputName field.
    @Test
    public final void testInputText() {

        logInPage
                .getInputNameField()
                .sendKeys("Asa23@(?|};6756%");

        Assert.assertTrue(logInPage.getInputNameField().getText() != null,
                "Input name field should not be empty!");

    }

    // To check is it possible to input password data, and characters must be converted in to the asterisk
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public final void testInputsCanTakeSymbols(final String name, final String password) {

        logInPage
                .getInputPasswordField()
                .sendKeys(password);

        Assert.assertFalse(password.equals(logInPage.getInputPasswordField().getText()),
                "You should not see the password!");
    }

    //Try to put in the both fields unregistered data
    @Test
    public final void testUnregisteredUser() {

        logInPage
                .logInAs(Roles.INVALID_USER);

        Assert.assertTrue(logInPage.getLogInButton().isDisplayed(),
                "You should not Logged In with unregistered data!");
    }

    //Try to Log In with only users field filled
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public final void testInputOnlyName(final String name, final String password) {

        logInPage
                .inputName(name)
                .clickLogInButton();

        Assert.assertTrue(logInPage.getLogInButton().isDisplayed(),
                "You should not Logged In without password!");

    }

    //Input data at the password field only
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public final void testInputOnlyPassword(final String name, final String password) {

        logInPage
                .inputPassword(password)
                .clickLogInButton();

        Assert.assertTrue(logInPage.getLogInButton().isDisplayed(),
                "You should not Logged In with empty name field!");
    }

    //Try to Log In with empty input fields
    @Test
    public final void testInputNothing() {

        logInPage
                .clickLogInButton();

        Assert.assertTrue(logInPage.getLogInButton().isDisplayed(),
                "You are David Copperfield!");
    }

    //Check Reset Button
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public final void testClearFields(final String name, final String password) {

        logInPage
                .inputName(name)
                .inputPassword(password)
                .clickResetButton();

        Assert.assertTrue(logInPage.getNameField().getText().isEmpty() &&
                        logInPage.getPasswordField().getText().isEmpty(),
                "Input fields should be empty!");
    }

    //Try to Log In and Log Out with valid data and turn on Remember me check box. Data should remain in the input fields
    //!!input fields on LogInPage remain clean after click on remember me check box. Log in and Log out!!!
    @Test
    public final void testRememberUserData() {

        logInPage
                .clickRememberMeButton()
                .logInAs(Roles.CUSTOMER);
        logInPage
                .doLogOut();
        Assert.assertFalse(logInPage
                        .getInputNameField()
                        .getText() != PropertiesReader
                        .getDefaultProperty("customer.login") &&
                        logInPage
                                .getInputPasswordField()
                                .getText()
                                .isEmpty(),
                "The data should be saved!");
    }

    @Test
    public final void testLoginWithNonExistingData() {

        logInPage
                .inputName("Sarumjan")      // Input Incorrect name and empty password field and click
                .clickLogInButton();
        logInPage
                .inputPassword("Mordor")
                .clickLogInButton();                // Input Incorrect password and empty name field and click

        Assert.assertTrue(logInPage.getLogInButton().isDisplayed(),
                "You should not Logged In with invalid data!");
    }

    //Input data in to the Password field, Try to Log In
    //En expected message: «Such user does not exist in the system – please try again.»
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public final void testErrorMessageOnEmptyUsername(final String name, final String password) {

        logInPage
                .inputPassword(password)
                .clickLogInButton();
        Assert.assertEquals(logInPage.getElement(LogInPage.ERROR_MESSAGE).getText(),
                "Such user does not exist in the system � please try again.",
                "Unexpected message!");
    }

    //Input not registered data in to the Name field, Try to Log In
    //En expected message: «Such user does not exist in the system – please try again.»
    @Test
    public final void testErrorMessageOnUnregisteredName() {

        logInPage.inputName("unregistered data")
                .clickLogInButton();
        Assert.assertEquals(logInPage.getElement(LogInPage.ERROR_MESSAGE).getText(),
                "Such user does not exist in the system � please try again.",
                "Unexpected message!");
    }

    //Input data in to the User Field, Try to Log In
    //En expected message: «Password is incorrect – please try again»
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public final void testErrorMessageOnEmptyPasswordField(final String name, final String password) {

        logInPage
                .inputName(name)
                .clickLogInButton();
        Assert.assertEquals(logInPage.getElement(LogInPage.ERROR_MESSAGE).getText(),
                "Password is incorrect � please try again",
                "Unexpected message!");
    }

    //Input right data in to the User field, input wrong data in to the Password field. Try to log in.
    //En expected message: «Password is incorrect – please try again»
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public final void testErrorMessageOnWrongPassword(String name, String password) {

        logInPage
                .inputName(name)
                .inputPassword("Mordor")
                .clickLogInButton();
        Assert.assertEquals(logInPage.getElement(LogInPage.ERROR_MESSAGE).getText(),
                "Password is incorrect � please try again",
                "Unexpected message!");
    }
}

