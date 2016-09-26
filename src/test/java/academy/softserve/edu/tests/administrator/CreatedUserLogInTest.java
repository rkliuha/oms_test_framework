package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.AdministrationPage;
import academy.softserve.edu.pageobjects.EditUserPage;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static academy.softserve.edu.pageobjects.AdministrationPage.CREATE_NEW_USER_LINK;
import static academy.softserve.edu.pageobjects.CreateNewUserPage.*;
import static academy.softserve.edu.pageobjects.UserInfoPage.ADMINISTRATION_LINK;
import static academy.softserve.edu.pageobjects.UserInfoPage.USER_INFO_PAGE_EXISTS;

public class CreatedUserLogInTest extends TestRunner {

    private static final String LOGIN = "vgopkin";

    @Test(priority = 1)
    public void testTabsExist() {

        userInfoPage = logInPage
                .loginAs(Roles.ADMINISTRATOR);

        userInfoPage
                .getElement(ADMINISTRATION_LINK)
                .click();

       administrationPage = new AdministrationPage(driver);

        Assert.assertTrue(administrationPage
                .getElement(CREATE_NEW_USER_LINK)
                .isDisplayed(), "Create new user link " + CREATE_NEW_USER_LINK + " isn't present");
    }

    @Test(priority = 2)
    public void testCreateUserPageExist() {

        userInfoPage = logInPage
                .loginAs(Roles.ADMINISTRATOR);

        userInfoPage
                .getElement(ADMINISTRATION_LINK)
                .click();

        administrationPage = new AdministrationPage(driver);

        administrationPage
                .getElement(CREATE_NEW_USER_LINK)
                .click();

        Assert.assertTrue(administrationPage
                .getElement(CREATE_USER_PAGE_EXISTS)
                .isDisplayed(), "Element " + CREATE_USER_PAGE_EXISTS + " isn't present");
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
                .loginAs(Roles.ADMINISTRATOR);

        userInfoPage
                .getElement(ADMINISTRATION_LINK)
                .click();

       administrationPage = new AdministrationPage(driver);

        administrationPage
                .getElement(CREATE_NEW_USER_LINK)
                .click();

        editUserPage = new EditUserPage(driver);

        editUserPage
                .getElement(LOGIN_NAME_TEXT_FIELD)
                .sendKeys(LOGIN);

        editUserPage
                .getElement(FIRST_NAME_TEXT_FIELD)
                .sendKeys(FIRST_NAME);

        editUserPage
                .getElement(LAST_NAME_TEXT_FIELD)
                .sendKeys(LAST_NAME);

        editUserPage
                .getElement(PASSWORD_TEXT_FIELD)
                .sendKeys(PASSWORD);

        editUserPage
                .getElement(CONFIRM_PASSWORD_TEXT_FIELD)
                .sendKeys(PASSWORD);

        editUserPage
                .getElement(EMAIL_ADDRESS_TEXT_FIELD)
                .sendKeys(EMAIL);

        editUserPage
                .getElement(REGION_DROPDOWN)
                .sendKeys(REGION);

        editUserPage
                .getElement(ROLE_DROPDOWN)
                .sendKeys(ROLE);

        editUserPage
                .getElement(CREATE_BUTTON)
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
                .getElement(USER_INFO_PAGE_EXISTS)
                .isDisplayed(), "Element " + USER_INFO_PAGE_EXISTS + " isn't displayed");
    }

    @AfterClass
    public final void deleteTestUser() {

        DBHandler.deleteUser(DBHandler
                .getUserByLogin(LOGIN)
                .getId());
    }
}
