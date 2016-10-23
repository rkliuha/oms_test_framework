package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;

public class CreatedUserLogInTest extends TestRunner {

    private static final String LOGIN = "vgopkin";

    @Test(priority = 1)
    public void testTabsExist() {

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);

        administrationPage = userInfoPage.clickAdministrationTab();

        assertThat(administrationPage.getCreateUserLink())
                .isDisplayed();
    }


    @Test(priority = 2)
    public void testCreateUserPageExist() {

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);

        administrationPage = userInfoPage.clickAdministrationTab();

        createNewUserPage = administrationPage.clickCreateUserLink();

        assertThat(createNewUserPage.getPageInfoText())
                .isDisplayed();
    }

    @Test(priority = 3)
    public void testCreatedUserExist() {

        final String FIRST_NAME = "valodja";
        final String LAST_NAME = "gopkin";
        final String PASSWORD = "qwerty";
        final String EMAIL = "vgopkin@mail.ru";
        final String REGION = "north";
        final String ROLE = "customer";

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);

        administrationPage = userInfoPage.clickAdministrationTab();

        createNewUserPage = administrationPage.clickCreateUserLink();

        createNewUserPage.fillLogInNameInput(LOGIN)
                .fillFirstNameInput(FIRST_NAME)
                .fillLastNameInput(LAST_NAME)
                .fillPasswordInput(PASSWORD)
                .fillConfirmPasswordInput(PASSWORD)
                .fillEmailInput(EMAIL)
                .selectRegionDropdown(REGION)
                .selectRoleDropdown(ROLE)
                .clickCreateButton();

        assertThat(DBHandler.getUserByLogin(LOGIN))
                .isNotNull();
    }

    @Test(priority = 4)
    public void testCreatedUserLogIn() {

        final String login = DBHandler.getUserByLogin(LOGIN)
                .getLogin();

        final String password = DBHandler.getUserByLogin(LOGIN)
                .getPassword();

        userInfoPage = logInPage.logInAs(login, password);

        assertThat(userInfoPage.getUserInfoFieldSet())
                .isDisplayed();
    }

    @AfterClass
    public final void deleteTestUser() {

        DBHandler.deleteUser(DBHandler.getUserByLogin(LOGIN)
                .getId());
    }
}
