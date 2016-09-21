package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.pageobjects.AdministrationPage;
import academy.softserve.edu.pageobjects.EditUserPage;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static academy.softserve.edu.pageobjects.AdministrationPage.CREATE_NEW_USER_LINK;
import static academy.softserve.edu.pageobjects.EditUserPage.*;
import static academy.softserve.edu.pageobjects.UserInfoPage.ADMINISTRATION_LINK;
import static academy.softserve.edu.pageobjects.UserInfoPage.USER_INFO_PAGE_EXISTS;

public class CreatedUserLogInTest extends TestRunner {

    private static final String USER_LOGIN = "iva";
    private static final String USER_PASSWORD = "qwerty";

    @Test
    public void testTabsExist() {

        userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        userInfoPage
                .getElement(ADMINISTRATION_LINK)
                .click();

        final AdministrationPage administrationPage = new AdministrationPage(driver);

        Assert.assertTrue(administrationPage
                .getElement(CREATE_NEW_USER_LINK)
                .isDisplayed(), "Create new user link " + CREATE_NEW_USER_LINK + " isn't present");
    }

    @Test
    public void testCreateUserPageExist() {

        userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        userInfoPage
                .getElement(ADMINISTRATION_LINK)
                .click();

        final AdministrationPage administrationPage = new AdministrationPage(driver);

        administrationPage
                .getElement(CREATE_NEW_USER_LINK)
                .click();

        Assert.assertTrue(administrationPage
                .getElement(EDIT_USER_PAGE_EXISTS)
                .isDisplayed(), "Element " + EDIT_USER_PAGE_EXISTS + " isn't present");
    }

    @Test
    public void testCreatedUserExist() {

        final int ID = 18;
        final String LOGIN = "vpopkin";
        final String FIRST_NAME = "valodja";
        final String LAST_NAME = "popkin";
        final String PASSWORD = "qwerty";
        final String EMAIL = "sharma@gmail.com";
        final String REGION = "north";
        final String ROLE = "customer";

        userInfoPage = logInPage
                .doLogIn(USER_LOGIN, USER_PASSWORD);

        userInfoPage
                .getElement(ADMINISTRATION_LINK)
                .click();

        final AdministrationPage administrationPage = new AdministrationPage(driver);

        administrationPage
                .getElement(CREATE_NEW_USER_LINK)
                .click();

        EditUserPage editUserPage = new EditUserPage(driver);

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
                .getElement(NEW_PASSWORD_TEXT_FIELD)
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
                .getUserById(ID), "User dosen't exist");
    }

    @Test
    public void testCreatedUserLogIn() {

        final int ID = 18;

        final String login = DBHandler
                .getUserById(ID)
                .getLogin();

        final String password = DBHandler
                .getUserById(ID)
                .getPassword();

        userInfoPage = logInPage
                .doLogIn(login, password);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_PAGE_EXISTS)
                .isDisplayed(), "Element " + USER_INFO_PAGE_EXISTS + " isn't displayed");
    }

    @AfterTest
    public final void deleteTestUser() {

        DBHandler.deleteUser(DBHandler
                .getLastUser()
                .getId());
    }
}
