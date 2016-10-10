package academy.softserve.edu.tests.supervisor;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class DoNotRevertDefaultStateTest extends TestRunner {

    @Test
    public void testUserInfoItemManagementButtonCheck() {

        userInfoPage = logInPage
                .logInAs(Roles.SUPERVISOR);

        assertThat(userInfoPage.getUserInfoLink())
                .isDisplayed();

        assertThat(userInfoPage.getItemManagementLink())
                .isDisplayed();
    }

    @Test
    public void testDoNotRevertDefaultState() {

        final String fieldFilter = "Description";
        final String fieldFilterValue = "Fruits";

        userInfoPage = logInPage
                .logInAs(Roles.SUPERVISOR);

        itemManagementPage = userInfoPage.clickItemManagementTab();

        itemManagementPage.selectSearchFieldFilterDropdown(fieldFilter)
                .fillSearchInput(fieldFilterValue)
                .clickSearchButton()
                .clickUserInfoTab();

        userInfoPage.clickItemManagementTab();

        assertThat(itemManagementPage.getSearchFieldFilterDropdown())
                .selectedDropdownEquals(fieldFilter);

        assertThat(itemManagementPage.getSearchInput())
                .valueEquals(fieldFilterValue);
    }
}
