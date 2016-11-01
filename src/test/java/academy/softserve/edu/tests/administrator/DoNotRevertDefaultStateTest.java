package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.enums.administration_page.ColumnFilters;
import academy.softserve.edu.enums.administration_page.SearchConditions;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class DoNotRevertDefaultStateTest extends TestRunner {

    @Test
    public final void testUserInfoAdministrationButtonCheck() {

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);

        assertThat(userInfoPage.getUserInfoLink())
                .isDisplayed();

        assertThat(userInfoPage.getAdministrationLink())
                .isDisplayed();
    }

    @Test
    public final void testDoNotRevertDefaultState() {

        final ColumnFilters columnFilter = ColumnFilters.ROLE;
        final SearchConditions roleFilter = SearchConditions.CONTAINS;
        final String text = "A";

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);

        administrationPage = userInfoPage.goToAdministrationPage();

        administrationPage.searchForUser(columnFilter, SearchConditions.CONTAINS, text);

        administrationPage.goToUserInfoPage();

        userInfoPage.goToAdministrationPage();

        assertThat(administrationPage.getSearchFieldFilterDropdown())
                .selectedDropdownEqualsIgnoreCase(columnFilter.toString());

        assertThat(administrationPage.getSearchConditionDropdown())
                .selectedDropdownEqualsIgnoreCase(roleFilter.toString());

        assertThat(administrationPage.getSearchInput())
                .valueEquals(text);
    }
}
