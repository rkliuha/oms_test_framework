package academy.softserve.edu.tests;

import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

public class LogInPageTest extends TestRunner {

    @DataProvider
    final public Object[][] testData() {
        return new Object[][]{
                {"login1", "qwerty"}
        };
    }

    // To check input fields empty or not.
    @Test
    public void testOpenLogInPage() {
        final LogInPage logInPage = new LogInPage(driver);
        System.out.println(logInPage.getInputNameField().getText());
        Assert.assertFalse(logInPage.getInputNameField().getText() == null &
                logInPage.getInputPasswordField().getText() == null);
    }

    // To check is it possible to input different symbols in to the inputName field.
    @Test
    public void testInputText() {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .getInputNameField()
                .sendKeys("Asa23@(?|};6756%");
        Assert.assertTrue(logInPage.getInputNameField().getText() != null);
    }

    // To check is it possible to input password data, and characters must be converted in to the asterisk
    @Test(dataProvider = "testData")
    public void testInputPassword(final String name, final String password) {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .getInputPasswordField()
                .sendKeys(password);
        Assert.assertFalse(logInPage
                .getInputPasswordField().getText() == null &
                !Objects.equals(logInPage.getInputPasswordField().getText(), password));
    }

    //Try to put in the both fields unregistered data
    @Test
    public void testUnregisteredUser() {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage.doLogIn("Sarumjan", "Mordor");
        Assert.assertFalse(Objects.equals(driver.getCurrentUrl(), UserInfoPage.USER_INFO_PAGE_URL));
    }

    //Try to Log In with only users field filled
    @Test(dataProvider = "testData")
    public void testInputOnlyName(final String name, final String password) {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .inputName(name)
                .clickLogInButton();
        Assert.assertFalse(Objects.equals(driver.getCurrentUrl(), UserInfoPage.USER_INFO_PAGE_URL));
    }

    //Input data at the password field only
    @Test(dataProvider = "testData")
    public void testInputOnlyPassword(final String name, final String password) {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .inputPassword(password)
                .clickLogInButton();
        Assert.assertFalse(Objects.equals(driver.getCurrentUrl(), UserInfoPage.USER_INFO_PAGE_URL));
    }

    //Try to Log In with empty input fields
    @Test
    public void testInputNothing() {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .clickLogInButton();
        Assert.assertFalse(Objects.equals(driver.getCurrentUrl(), UserInfoPage.USER_INFO_PAGE_URL));
    }

    //Check Reset Button
    @Test(dataProvider = "testData")
    public void testClearFields(final String name, final String password) {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .inputName(name)
                .inputPassword(password)
                .clickResetButton();
        Assert.assertTrue(logInPage.getNameField().getText().isEmpty() &
                logInPage.getPasswordField().getText().isEmpty());
    }

    //Try to Log In and Log Out with valid data and turn on Remember me check box. Data should remain in the input fields
    //!!input fields on LogInPage remain clean after click on remember me check box. Log in and Log out!!!
    @Test(dataProvider = "testData")
    public void testRememberUserData(final String name, final String password) {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .clickRememberMeButton()
                .doLogIn(name, password);
        logInPage.doLogOut();
        Assert.assertFalse(logInPage.getInputNameField().getText() != name &
                logInPage.getInputPasswordField().getText().isEmpty());
    }

    @Test(dataProvider = "testData")
    public void testUnregisteredUser(final String name, final String password) {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage.doLogIn("Sarumjan", password);      // Input Incorrect name and empty password field and click
        logInPage.doLogIn(name, "mordor");            // Input Incorrect password and empty name field and click
        Assert.assertFalse(Objects.equals(driver.getCurrentUrl(), UserInfoPage.USER_INFO_PAGE_URL));
    }

    //Input data in to the Password field, Try to Log In
    //En expected message: «Such user does not exist in the system – please try again.»
    @Test(dataProvider = "testData")
    public void testErrorMessage1(final String name, final String password) {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .inputPassword(password)
                .clickLogInButton();
        Assert.assertEquals(logInPage.getElement(LogInPage.ERROR_MESSAGE).getText(), logInPage.EXPECTED_INVALID_NAME_MESSAGE);
    }

    //Input not registered data in to the Name field, Try to Log In
    //En expected message: «Such user does not exist in the system – please try again.»
    @Test
    public void testErrorMessage2() {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage.inputName("unregistered data")
                .clickLogInButton();
        Assert.assertEquals(logInPage.getElement(LogInPage.ERROR_MESSAGE).getText(), logInPage.EXPECTED_INVALID_NAME_MESSAGE);
    }

    //Input data in to the User Field, Try to Log In
    //En expected message: «Password is incorrect – please try again»
    @Test(dataProvider = "testData")
    public void testErrorMessage3(final String name, final String password) {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .inputName(name)
                .clickLogInButton();
        Assert.assertEquals(logInPage.getElement(LogInPage.ERROR_MESSAGE).getText(), logInPage.EXPECTED_INVALID_PASSWORD_MESSAGE);
    }

    //Input right data in to the User field, input wrong data in to the Password field. Try to log in.
    //En expected message: «Password is incorrect – please try again»
    @Test(dataProvider = "testData")
    public void testErrorMessage4(String name, String password) {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage.doLogIn(name, "mordor");// Input Incorrect password and empty name field and click
        Assert.assertEquals(logInPage.getElement(LogInPage.ERROR_MESSAGE).getText(), logInPage.EXPECTED_INVALID_PASSWORD_MESSAGE);
    }
}

