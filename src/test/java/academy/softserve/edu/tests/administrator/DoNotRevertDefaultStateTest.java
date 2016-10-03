package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.AdministrationPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoNotRevertDefaultStateTest extends TestRunner {

    private static final String ROLE = "Role";
    private static final String ROLE_FILTER = "contains";
    private static final String TEXT = "A";
    private static final String TAG_ATRIBUT = "value";

    @Test
    public void testUserInfoAdministrationButtonCheck() {

        userInfoPage = logInPage
                .logInAs(Roles.ADMINISTRATOR);

        Assert.assertTrue(userInfoPage
                .getUserInfoLink()
                .isDisplayed(), "Element " + userInfoPage.getUserInfoLink().getLocatorValue() + " isn't displayed");

        Assert.assertTrue(userInfoPage
                .getAdministrationLink()
                .isDisplayed(), "Element " + userInfoPage.getAdministrationLink().getLocatorValue() + " isn't displayed");
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

        Assert.assertTrue(administrationPage
                .getSearchFieldFilterDropdown()
                .getText()
                .contains(ROLE), "Role in the first drop down is different of " + ROLE);

        Assert.assertTrue(administrationPage
                .getSearchConditionDropdown()
                .getText()
                .contains(ROLE_FILTER), "Role filter in the second drop box is different of " + ROLE_FILTER);

        Assert.assertTrue(administrationPage
                .getSearchInput()
                .getValue()
                .contains(TEXT), "Text in the text box is different of " + TEXT);
    }
}
