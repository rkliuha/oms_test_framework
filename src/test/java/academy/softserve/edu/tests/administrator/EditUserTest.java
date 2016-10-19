package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.domains.User;
import academy.softserve.edu.enums.Regions;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.EditUserPage;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import academy.softserve.edu.utils.DBHelper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;

public class EditUserTest extends TestRunner {

    private User testUser;
    private int testUserId;

    @BeforeTest
    public final void createTestUser() {

        testUserId = DBHelper.createValidUserInDB();
        testUser = DBHandler.getUserById(testUserId);
    }

    @BeforeMethod
    public final void setUpTests() {

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);

        administrationPage = userInfoPage.clickAdministrationTab()
                .clickLastUserPaginationButton();

        administrationPage.clickEditUserById(testUserId);

        editUserPage = new EditUserPage(driver);
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

        final String NEW_USER_LAST_NAME = "Tsoni";
        final String NEW_USER_PASSWORD = "1qaz2wsx";
        final Regions NEW_REGION = Regions.WEST;

        assertThat(editUserPage.getNewPasswordText())
                .isDisplayed();

        editUserPage.fillLastNameInput(NEW_USER_LAST_NAME)
                .fillNewPasswordInput(NEW_USER_PASSWORD)
                .fillConfirmPasswordInput(NEW_USER_PASSWORD)
                .selectRegionDropdown(NEW_REGION.toString())
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

        final String NEW_USER_EMAIL = "google@gmail.com";

        assertThat(editUserPage.getNewPasswordText())
                .isDisplayed();

        editUserPage.fillEmailAddressInput(NEW_USER_EMAIL)
                .clickCancelButton();

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
