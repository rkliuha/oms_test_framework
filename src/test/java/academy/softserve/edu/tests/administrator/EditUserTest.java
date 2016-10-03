package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.domains.User;
import academy.softserve.edu.enums.Regions;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import academy.softserve.edu.utils.TestUtil;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;

public class EditUserTest extends TestRunner {

    //TODO move these inline
    private static final String NEW_USER_LAST_NAME = "Tsoni";
    private static final String NEW_USER_PASSWORD = "1qaz2wsx";
    private static final String NEW_USER_EMAIL = "google@gmail.com";
    private static final Regions NEW_REGION = Regions.WEST;

    private User testUser;
    private int testUserId;

    @BeforeTest
    public final void createTestUser() {

        testUserId = TestUtil.createValidUserInDB();
        testUser = DBHandler.getUserById(testUserId);
    }

    @BeforeMethod
    public final void setUpTests() {

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);

        administrationPage = userInfoPage
                .clickAdministrationTab()
                .clickLastUserPaginationButton();

        editUserPage = administrationPage.clickEditUserById(testUserId);
    }

    @Test
    public final void testAreEditFieldsFilledCorrectly() {

        assertThat(editUserPage.getNewPasswordText())
                .isDisplayed();

        assertThat(editUserPage.getFirstNameInput())
                .valueEquals(testUser.getFirstName());

        assertThat(editUserPage.getLastNameInput())
                .valueEquals(testUser.getLastName());

        assertThat(editUserPage.getNewPasswordInput())
                .isValueEmpty();

        assertThat(editUserPage.getConfirmPasswordInput())
                .isValueEmpty();

        assertThat(editUserPage.getEmailAddressInput())
                .valueEquals(testUser.getEmail());

        assertThat(editUserPage.getRoleDropdown())
                .selectedDropdownEqualsIgnoreCase(testUser.getRoleName());

        assertThat(editUserPage.getRegionDropdown())
                .selectedDropdownEqualsIgnoreCase(testUser.getRegionName());
    }

    @Test
    public final void testEditUserAndClickSave() {

        assertThat(editUserPage.getNewPasswordText())
                .isDisplayed();

        editUserPage
                .getLastNameInput()
                .clear();
        editUserPage
                .getLastNameInput()
                .sendKeys(NEW_USER_LAST_NAME);
        editUserPage
                .getNewPasswordInput()
                .sendKeys(NEW_USER_PASSWORD);
        editUserPage
                .getConfirmPasswordInput()
                .sendKeys(NEW_USER_PASSWORD);
        editUserPage
                .getRegionDropdown()
                .sendKeys(NEW_REGION.toString());
        editUserPage
                .clickSaveChangesButton();

        testUser = DBHandler.getUserById(testUserId);

        assertThat(testUser)
                .lastNameEquals(NEW_USER_LAST_NAME);

        assertThat(testUser)
                .passwordEquals(NEW_USER_PASSWORD);

        assertThat(testUser)
                .regionNameEquals(NEW_REGION.toString());

        assertThat(administrationPage.getFoundUsersTextLabel())
                .isDisplayed();
    }

    @Test
    public final void testEditUserAndClickCancel() {

        assertThat(editUserPage.getNewPasswordText())
                .isDisplayed();

        editUserPage.getEmailAddressInput().clear();
        editUserPage.getEmailAddressInput().sendKeys(NEW_USER_EMAIL);
        editUserPage.clickCancelButton();

        assertThat(DBHandler.getUserById(testUserId))
                .userEquals(testUser);

        assertThat(administrationPage.getFoundUsersTextLabel())
                .isDisplayed();
    }

    @AfterTest
    public final void deleteTestUser() {
        DBHandler.deleteUser(testUserId);
    }

}
