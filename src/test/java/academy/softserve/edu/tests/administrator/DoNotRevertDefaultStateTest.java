package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.AdministrationPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class DoNotRevertDefaultStateTest extends TestRunner {

    //TODO move inline
    private static final String ROLE = "Role";
    private static final String ROLE_FILTER = "contains";
    private static final String TEXT = "A";

    @Test
    public void testUserInfoAdministrationButtonCheck() {

        userInfoPage = logInPage
                .logInAs(Roles.ADMINISTRATOR);

        assertThat(userInfoPage.getUserInfoLink())
                .isDisplayed();

        assertThat(userInfoPage.getAdministrationLink())
                .isDisplayed();
    }

    @Test
    public void testDoNotRevertDefaultState() {

        userInfoPage = logInPage
                .logInAs(Roles.ADMINISTRATOR);

        userInfoPage
                .getAdministrationLink()
                .click();

        administrationPage = new AdministrationPage(driver);

        administrationPage
                .getSearchFieldFilterDropdown()
                .sendKeys(ROLE);

        administrationPage
                .getSearchConditionDropdown()
                .sendKeys(ROLE_FILTER);

        administrationPage
                .getSearchInput()
                .sendKeys(TEXT);

        administrationPage
                .getSearchButton()
                .click();

        administrationPage
                .getUserInfoLink()
                .click();

        userInfoPage
                .getAdministrationLink()
                .click();

        assertThat(administrationPage.getSearchFieldFilterDropdown())
                .selectedDropdownEquals(ROLE);

        assertThat(administrationPage.getSearchConditionDropdown())
                .selectedDropdownEquals(ROLE_FILTER);

        assertThat(administrationPage.getSearchInput())
                .valueEquals(TEXT);
    }
}
