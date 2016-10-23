package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class DoNotRevertDefaultStateTest extends TestRunner {

    @Test
    public void testUserInfoAdministrationButtonCheck() {

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);

        assertThat(userInfoPage.getUserInfoLink())
                .isDisplayed();

        assertThat(userInfoPage.getAdministrationLink())
                .isDisplayed();
    }

    @Test
    public void testDoNotRevertDefaultState() {

        final String ROLE = "Role";
        final String ROLE_FILTER = "contains";
        final String TEXT = "A";

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);

        administrationPage = userInfoPage.clickAdministrationTab();

        administrationPage.selectSearchFieldFilterDropdown(ROLE)
                .selectSearchConditionDropdown(ROLE_FILTER)
                .fillSearchInput(TEXT)
                .clickSearchButton();

        administrationPage.clickUserInfoTab();

        userInfoPage.clickAdministrationTab();

        assertThat(administrationPage.getSearchFieldFilterDropdown())
                .selectedDropdownEquals(ROLE);

        assertThat(administrationPage.getSearchConditionDropdown())
                .selectedDropdownEquals(ROLE_FILTER);

        assertThat(administrationPage.getSearchInput())
                .valueEquals(TEXT);
    }
}
