package academy.softserve.edu.tests.supervisor;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.ItemManagementPage;
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

        final String FIELD_FILTER = "Description";
        final String FIELD_FILTER_VALUE = "Fruits";

        userInfoPage = logInPage
                .logInAs(Roles.SUPERVISOR);

        userInfoPage
                .getItemManagementLink()
                .click();

        itemManagementPage = new ItemManagementPage(driver);

        itemManagementPage
                .getSearchFieldFilterDropdown()
                .sendKeys(FIELD_FILTER);

        itemManagementPage
                .getSearchInput()
                .sendKeys(FIELD_FILTER_VALUE);

        itemManagementPage
                .getSearchButton()
                .click();

        itemManagementPage
                .getUserInfoLink()
                .click();

        userInfoPage
                .getItemManagementLink()
                .click();

        assertThat(itemManagementPage.getSearchFieldFilterDropdown())
                .selectedDropdownEquals(FIELD_FILTER);

        assertThat(itemManagementPage.getSearchInput())
                .valueEquals(FIELD_FILTER_VALUE);
    }
}
