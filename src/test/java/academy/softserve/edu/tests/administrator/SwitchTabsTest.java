package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.AdministrationPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwitchTabsTest extends TestRunner {

    //  This test checks if Administrator user can see the following tabs: ‘Administration’ and ‘User Info’(default),
    //  test checks if Administrator user can switch between tabs.

    @Test
    final public void testSwitchingBetweenTabs() {

        logInPage.logInAs(Roles.ADMINISTRATOR);
        userInfoPage = new UserInfoPage(driver);

        Assert.assertTrue(userInfoPage.getUserInfoFieldSet().isDisplayed(),
                "After login tab isn't 'User Info'");

        Assert.assertTrue(userInfoPage.getUserInfoLink().isDisplayed(),
                "Element " + userInfoPage.getUserInfoLink().getLocatorValue() + " is not being displayed");
        Assert.assertTrue(userInfoPage.getAdministrationLink().isDisplayed(),
                "Element " + userInfoPage.getAdministrationLink().getLocatorValue() + " is not being displayed");

        userInfoPage
                .getAdministrationLink()
                .click();

        administrationPage = new AdministrationPage(driver);

        Assert.assertTrue(administrationPage.getUserInfoLink().isDisplayed(),
                "Element " + administrationPage.getUserInfoLink().getLocatorValue() + " is not being displayed");
        Assert.assertTrue(administrationPage.getAdministrationLink().isDisplayed(),
                "Element " + administrationPage.getAdministrationLink().getLocatorValue() + " is not being displayed");
        administrationPage.clickUserInfoTab();

        Assert.assertTrue(userInfoPage.getUserInfoLink().isDisplayed(),
                "Element " + userInfoPage.getUserInfoLink().getLocatorValue() + " is not being displayed");
        Assert.assertTrue(userInfoPage.getAdministrationLink().isDisplayed(),
                "Element " + userInfoPage.getAdministrationLink().getLocatorValue() + " is not being displayed");
        userInfoPage.doLogOut();
    }
}
