package academy.softserve.edu.tests.supervisor;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class DoNotRevertDefaultStateTest extends TestRunner {

    //TODO move inline
    public static final String FIELD_FILTER = "Description";
    public static final String FIELD_FILTER_VALUE = "Fruits";

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

        userInfoPage = logInPage
                .logInAs(Roles.SUPERVISOR);

        itemManagementPage = userInfoPage.clickItemManagementTab();

        itemManagementPage.selectSearchFieldFilterDropdown(FIELD_FILTER)
                .fillSearchInput(FIELD_FILTER_VALUE)
                .clickSearchButton()
                .clickUserInfoTab();

        userInfoPage.clickItemManagementTab();

        assertThat(itemManagementPage.getSearchFieldFilterDropdown())
                .selectedDropdownEquals(FIELD_FILTER);

        assertThat(itemManagementPage.getSearchInput())
                .valueEquals(FIELD_FILTER_VALUE);
    }
}
