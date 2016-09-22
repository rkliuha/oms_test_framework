package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.domains.User;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import academy.softserve.edu.utils.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteUserTest extends TestRunner {

    private final static String FILTER_DROPDOWN = "Login";
    private final static String CONDITION_DROPDOWN = "equals";
    private final static byte USER_STATUS = 1;

    private User lastAddedUserForDelete;

    @BeforeTest
    public final void createTestUser() {

        TestUtil.createValidUserInDB();
        lastAddedUserForDelete = DBHandler.getLastUser();
    }

    @BeforeMethod
    public final void setUpTests() {

        final User userForLogin = DBHandler.getUserByRole(Roles.ADMINISTRATOR);

        userInfoPage = logInPage
                .doLogIn(userForLogin.getLogin(), userForLogin.getPassword());

        administrationPage = userInfoPage
                .clickAdministrationTab();

        administrationPage.getFirstFilterDropDown()
                .sendKeys(FILTER_DROPDOWN);
        administrationPage.getSecondFilterDropdown()
                .sendKeys(CONDITION_DROPDOWN);
        administrationPage.filterTextBox()
                .sendKeys(lastAddedUserForDelete.getLogin());
        administrationPage.clickFilterSearchButton();
    }

    @Test
    public final void testDeleteUserAndClickCancel() {

        administrationPage.clickDeleteFirstUserLink().dismissAlert();

        Assert.assertEquals(lastAddedUserForDelete
                .getUserActive(), USER_STATUS, "User status changed into 'inactive'");
    }

    @Test
    public final void testDeleteUserAndClickConfirm() {

        administrationPage.clickDeleteFirstUserLink().acceptAlert();

        Assert.assertNotEquals(lastAddedUserForDelete
                .getUserActive(), USER_STATUS, "User status stays 'active'");
    }

    @AfterTest
    public final void deleteTestUser() {
        DBHandler.deleteUser(DBHandler.getLastUser().getId());
    }
}
