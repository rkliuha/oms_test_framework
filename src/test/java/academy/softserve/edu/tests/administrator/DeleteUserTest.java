package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.domains.User;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import academy.softserve.edu.utils.DBHelper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;

public class DeleteUserTest extends TestRunner {

    private User testUser;

    @BeforeTest
    public final void createTestUser() {

        final int testUserId = DBHelper.createValidUserInDB();
        testUser = DBHandler.getUserById(testUserId);
    }

    @BeforeMethod
    public final void setUpTests() {

        final String FILTER_DROPDOWN = "Login";
        final String CONDITION_DROPDOWN = "equals";

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);

        administrationPage = userInfoPage.clickAdministrationTab();

        administrationPage.getSearchFieldFilterDropdown()
                .sendKeys(FILTER_DROPDOWN);
        administrationPage.getSearchFieldFilterDropdown()
                .sendKeys(CONDITION_DROPDOWN);
        administrationPage.getSearchInput()
                .sendKeys(testUser.getLogin());
        administrationPage.getSearchButton().click();
    }

    @Test
    public final void testDeleteUserAndClickCancel() {

        administrationPage.clickDeleteFirstUserLink();

        administrationPage.dismissAlert();

        assertThat(DBHandler.getUserByLogin(testUser.getLogin()))
                .isUserActive();
    }

    @Test
    public final void testDeleteUserAndClickConfirm() {

        administrationPage.clickDeleteFirstUserLink();

        administrationPage.acceptAlert();

        assertThat(DBHandler.getUserByLogin(testUser.getLogin()))
                .isUserInactive();
    }

    @AfterTest
    public final void deleteTestUser() {
        DBHandler.deleteUser(DBHandler
                .getUserByLogin(testUser.getLogin())
                .getId());
    }
}
