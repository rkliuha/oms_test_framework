package academy.softserve.edu.tests;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.PropertiesReader;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class LogInPageTest extends TestRunner {

    @Test
    public final void testLoginInputsAreEmpty() {

        assertThat(logInPage.getUserNameInput())
                .isValueEmpty();

        assertThat(logInPage.getPasswordInput())
                .isValueEmpty();
    }

    // To check is it possible to input different symbols in to the inputName field.
    @Test
    public final void testInputText() {

        logInPage
                .getUserNameInput()
                .sendKeys("Asa23@(?|};6756%");

        assertThat(logInPage.getUserNameInput())
                .isValueNotEmpty();
    }

    // To check is it possible to input password data, and characters must be converted in to the asterisk
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public final void testInputsCanTakeSymbols(final String name, final String password) {

        logInPage
                .getPasswordInput()
                .sendKeys(password);

        assertThat(logInPage.getPasswordInput())
                .textNotEqual(password);
    }

    //Try to put in the both fields unregistered data
    @Test
    public final void testUnregisteredUser() {

        logInPage
                .logInAs(Roles.INVALID_USER);

        assertThat(logInPage.getLogInButton())
                .isDisplayed();
    }

    //Try to Log In with only users field filled
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public final void testInputOnlyName(final String name, final String password) {

        logInPage
                .inputName(name)
                .clickLogInButton();

        assertThat(logInPage.getLogInButton())
                .isDisplayed();
    }

    //Input data at the password field only
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public final void testInputOnlyPassword(final String name, final String password) {

        logInPage
                .inputPassword(password)
                .clickLogInButton();

        assertThat(logInPage.getLogInButton())
                .isDisplayed();
    }

    //Try to Log In with empty input fields
    @Test
    public final void testInputNothing() {

        logInPage
                .clickLogInButton();

        assertThat(logInPage.getLogInButton())
                .isDisplayed();
    }

    //Check Reset Button
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public final void testClearFields(final String name, final String password) {

        logInPage
                .inputName(name)
                .inputPassword(password)
                .getCancelButton()
                .click();

        assertThat(logInPage.getUserNameInput())
                .isValueEmpty();

        assertThat(logInPage.getPasswordInput())
                .isValueEmpty();
    }

    //Try to Log In and Log Out with valid data and turn on Remember me check box. Data should remain in the input fields
    //!!input fields on LogInPage remain clean after click on remember me check box. Log in and Log out!!!
    @Test
    public final void testRememberUserData() {

        logInPage
                .clickRememberMeCheckbox()
                .logInAs(Roles.CUSTOMER);
        logInPage
                .doLogOut();

        assertThat(logInPage.getUserNameInput())
                .valueEquals(PropertiesReader.getDefaultProperty("customer.login"));

        assertThat(logInPage.getPasswordInput())
                .isValueEmpty();
    }

    @Test
    public final void testLoginWithNonExistingData() {

        logInPage
                .inputName("Sarumjan")      // Input Incorrect name and empty password field and click
                .clickLogInButton();
        logInPage
                .inputPassword("Mordor")
                .clickLogInButton();                // Input Incorrect password and empty name field and click

        assertThat(logInPage.getLogInButton())
                .isDisplayed();
    }

    //Input data in to the Password field, Try to Log In
    //En expected message: «Such user does not exist in the system – please try again.»
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public final void testErrorMessageOnEmptyUsername(final String name, final String password) {

        logInPage
                .inputPassword(password)
                .clickLogInButton();

        assertThat(logInPage.getLogInErrorMessage())
                .textEquals("Such user does not exist in the system � please try again.");
    }

    //Input not registered data in to the Name field, Try to Log In
    //En expected message: «Such user does not exist in the system – please try again.»
    @Test
    public final void testErrorMessageOnUnregisteredName() {

        logInPage.inputName("unregistered data")
                .clickLogInButton();

        assertThat(logInPage.getLogInErrorMessage())
                .textEquals("Such user does not exist in the system � please try again.");
    }

    //Input data in to the User Field, Try to Log In
    //En expected message: «Password is incorrect – please try again»
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public final void testErrorMessageOnEmptyPasswordField(final String name, final String password) {

        logInPage
                .inputName(name)
                .clickLogInButton();

        assertThat(logInPage.getLogInErrorMessage())
                .textEquals("Password is incorrect � please try again");
    }

    //Input right data in to the User field, input wrong data in to the Password field. Try to log in.
    //En expected message: «Password is incorrect – please try again»
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public final void testErrorMessageOnWrongPassword(String name, String password) {

        logInPage
                .inputName(name)
                .inputPassword("Mordor")
                .clickLogInButton();

        assertThat(logInPage.getLogInErrorMessage())
                .textEquals("Password is incorrect � please try again");
    }

}

