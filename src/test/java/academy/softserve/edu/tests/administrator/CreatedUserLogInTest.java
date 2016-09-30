package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.AdministrationPage;
import academy.softserve.edu.pageobjects.CreateNewUserPage;
import academy.softserve.edu.pageobjects.EditUserPage;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class CreatedUserLogInTest extends TestRunner {

    private static final String LOGIN = "vgopkin";

    @Test(priority = 1)
    public void testTabsExist() {

        userInfoPage = logInPage
                .logInAs(Roles.ADMINISTRATOR);

        userInfoPage
                .getAdministrationLink()
                .click();

        administrationPage = new AdministrationPage(driver);

        Assert.assertTrue(administrationPage
                .getCreateUserLink()
                .isDisplayed(), "Create new user link " + administrationPage.getCreateUserLink().getLocatorValue() + " isn't present");
    }


    @Test(priority = 2)
    public void testCreateUserPageExist() {

        userInfoPage = logInPage
                .logInAs(Roles.ADMINISTRATOR);

        userInfoPage
                .getAdministrationLink()
                .click();

        administrationPage = new AdministrationPage(driver);

        administrationPage
                .getCreateUserLink()
                .click();

        createNewUserPage = new CreateNewUserPage(driver);

        Assert.assertTrue(createNewUserPage
                .getPageInfoText()
                .isDisplayed(), "Element " + createNewUserPage.getPageInfoText().getValue() + " isn't present");
    }

    @Test(priority = 3)
    public void testCreatedUserExist() {

        //Login value should take from current class constants
        final String FIRST_NAME = "valodja";
        final String LAST_NAME = "gopkin";
        final String PASSWORD = "qwerty";
        final String EMAIL = "vgopkin@mail.ru";
        final String REGION = "north";
        final String ROLE = "customer";

        userInfoPage = logInPage
                .logInAs(Roles.ADMINISTRATOR);

        userInfoPage
                .getAdministrationLink()
                .click();

        administrationPage = new AdministrationPage(driver);

        administrationPage
                .getCreateUserLink()
                .click();

        editUserPage = new EditUserPage(driver);
        createNewUserPage = new CreateNewUserPage(driver);

        createNewUserPage
                .getLogInNameInput()
                .sendKeys(LOGIN);

        createNewUserPage
                .getFirstNameInput()
                .sendKeys(FIRST_NAME);

        createNewUserPage
                .getLastNameInput()
                .sendKeys(LAST_NAME);

        createNewUserPage
                .getPasswordInput()
                .sendKeys(PASSWORD);

        createNewUserPage
                .getConfirmPasswordInput()
                .sendKeys(PASSWORD);

        createNewUserPage
                .getEmailInput()
                .sendKeys(EMAIL);

        createNewUserPage
                .getRegionDropdown()
                .sendKeys(REGION);

        createNewUserPage
                .getRoleDropdown()
                .sendKeys(ROLE);

        createNewUserPage
                .getCreateButton()
                .click();

        Assert.assertNotNull(DBHandler
                .getUserByLogin(LOGIN), "User doesn't exist");
    }

    @Test(priority = 4)
    public void testCreatedUserLogIn() {

        final String login = DBHandler
                .getUserByLogin(LOGIN)
                .getLogin();

        final String password = DBHandler
                .getUserByLogin(LOGIN)
                .getPassword();

        userInfoPage = logInPage
                .logInAs(login, password);

        Assert.assertTrue(userInfoPage
                .getUserInfoFieldSet()
                .isDisplayed(), "Element " + userInfoPage.getUserInfoFieldSet().getLocatorValue() + " isn't displayed");
    }

    @AfterClass
    public final void deleteTestUser() {

        DBHandler.deleteUser(DBHandler
                .getUserByLogin(LOGIN)
                .getId());
    }
}
