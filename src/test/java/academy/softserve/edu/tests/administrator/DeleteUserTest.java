package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.domains.User;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import academy.softserve.edu.utils.TestUtil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteUserTest extends TestRunner {

    private final static String FILTER_DROPDOWN = "Login";
    private final static String CONDITION_DROPDOWN = "equals";
    private final static String CREATED_USER_LOGIN = "justlogin";
    private final static byte USER_STATUS = 1;
    private final static int TIMEOUT = 10;

    private User lastAddedUserForDelete;

    @BeforeTest
    public final void createTestUser() {

        TestUtil.createValidUserInDB();
        lastAddedUserForDelete = DBHandler.getUserByLogin(CREATED_USER_LOGIN);
    }

    @BeforeMethod
    public final void setUpTests() {

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);

        administrationPage = userInfoPage.clickAdministrationTab();

        administrationPage.getSearchFieldFilterDropdown()
                .sendKeys(FILTER_DROPDOWN);
        administrationPage.getSearchFieldFilterDropdown()
                .sendKeys(CONDITION_DROPDOWN);
        administrationPage.getSearchInput()
                .sendKeys(lastAddedUserForDelete.getLogin());
        administrationPage.getSearchButton().click();
    }

    @Test
    public final void testDeleteUserAndClickCancel() {

        administrationPage.clickDeleteFirstUserLink();

        Assert.assertNotNull(new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.alertIsPresent()), "Alert is not present");

        administrationPage.dismissAlert();

        Assert.assertEquals(lastAddedUserForDelete
                .getUserActive(), USER_STATUS, "User status changed into 'inactive'");
    }

    @Test
    public final void testDeleteUserAndClickConfirm() {

        administrationPage.clickDeleteFirstUserLink();

        Assert.assertNotNull(new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.alertIsPresent()), "Alert is not present");

        administrationPage.acceptAlert();

        Assert.assertNotEquals(lastAddedUserForDelete
                .getUserActive(), USER_STATUS, "User status stays 'active'");
    }

    @AfterTest
    public final void deleteTestUser() {
        DBHandler.deleteUser(DBHandler
                .getUserByLogin(CREATED_USER_LOGIN)
                .getId());
    }
}
