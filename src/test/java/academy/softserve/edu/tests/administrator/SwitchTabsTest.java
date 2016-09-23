package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.AdministrationPage;
import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static academy.softserve.edu.pageobjects.UserInfoPage.*;

public class SwitchTabsTest extends TestRunner {

    //  This test checks if Administrator user can see the following tabs: ‘Administration’ and ‘User Info’(default),
    //  test checks if Administrator user can switch between tabs.

    @Test
    final public void testSwitchingBetweenTabs() {

        logInPage = new LogInPage(driver);
        logInPage.loginAs(Roles.ADMINISTRATOR);
        Assert.assertTrue(logInPage.getElement(USER_INFO_PAGE_EXISTS).isDisplayed(),
                "After login tab isn't 'User Info'");

        userInfoPage = new UserInfoPage(driver);
        Assert.assertTrue(userInfoPage.getElement(USER_INFO_LINK).isDisplayed(),
                "Element " + USER_INFO_LINK + " is not being displayed");
        Assert.assertTrue(userInfoPage.getElement(ADMINISTRATION_LINK).isDisplayed(),
                "Element " + ADMINISTRATION_LINK + " is not being displayed");

        userInfoPage.clickAdministrationTab();

        administrationPage = new AdministrationPage(driver);

        Assert.assertTrue(administrationPage.getElement(USER_INFO_LINK).isDisplayed(),
                "Element " + USER_INFO_LINK + " is not being displayed");
        Assert.assertTrue(administrationPage.getElement(ADMINISTRATION_LINK).isDisplayed(),
                "Element " + ADMINISTRATION_LINK + " is not being displayed");
        administrationPage.clickUserInfoTab();

        Assert.assertTrue(userInfoPage.getElement(USER_INFO_LINK).isDisplayed(),
                "Element " + USER_INFO_LINK + " is not being displayed");
        Assert.assertTrue(userInfoPage.getElement(ADMINISTRATION_LINK).isDisplayed(),
                "Element " + ADMINISTRATION_LINK + " is not being displayed");
        userInfoPage.doLogOut();
    }
}