package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.AdministrationPage;
import academy.softserve.edu.utils.TestRunner;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static academy.softserve.edu.pageobjects.AdministrationPage.*;
import static academy.softserve.edu.pageobjects.UserInfoPage.ADMINISTRATION_LINK;
import static academy.softserve.edu.pageobjects.UserInfoPage.USER_INFO_LINK;

public class DoNotRevertDefaultStateTest extends TestRunner {

    private static final String ROLE = "Role";
    private static final String ROLE_FILTER = "contains";
    private static final String TEXT = "A";

    @Test
    public void testUserInfoAdministrationButtonCheck() {

        userInfoPage = logInPage
                .logInAs(Roles.ADMINISTRATOR);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_LINK)
                .isDisplayed(), "Element " + USER_INFO_LINK + " isn't displayed");

        Assert.assertTrue(userInfoPage
                .getElement(ADMINISTRATION_LINK)
                .isDisplayed(), "Element " + ADMINISTRATION_LINK + " isn't displayed");
    }

    @Test
    public void testDoNotRevertDefaultState() {

        final String TAG_ATRIBUTE = "value";

        userInfoPage = logInPage
                .logInAs(Roles.ADMINISTRATOR);

        userInfoPage
                .click(ADMINISTRATION_LINK);

        administrationPage = new AdministrationPage(driver);

        administrationPage
                .getElement(FIRST_FILED_FILTER_DROPDOWN)
                .sendKeys(ROLE);

        administrationPage
                .getElement(SECOND_FILED_FILTER_DROPDOWN)
                .sendKeys(ROLE_FILTER);

        administrationPage
                .getElement(FILED_FILTER_TEXT_BOX)
                .sendKeys(TEXT);

        administrationPage
                .click(FILED_FILTER_SEARCH_BUTTON);

        administrationPage
                .click(USER_INFO_LINK);

        userInfoPage
                .click(ADMINISTRATION_LINK);

        Assert.assertTrue(new Select(administrationPage
                .getElement(FIRST_FILED_FILTER_DROPDOWN))
                .getFirstSelectedOption()
                .getText()
                .equalsIgnoreCase(ROLE), "Role in the first drop down is different of " + ROLE);

        Assert.assertTrue(new Select(administrationPage
                .getElement(SECOND_FILED_FILTER_DROPDOWN))
                .getFirstSelectedOption()
                .getText()
                .equalsIgnoreCase(ROLE_FILTER), "Role filter in the second drop box is different of " + ROLE_FILTER);

        Assert.assertTrue(administrationPage
                .getElement(FILED_FILTER_TEXT_BOX)
                .getAttribute(TAG_ATRIBUTE)
                .contains(TEXT), "Text in the text box is different of " + TEXT);
    }
}
