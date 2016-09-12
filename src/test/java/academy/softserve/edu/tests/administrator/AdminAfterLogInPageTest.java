package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.pageobjects.AdministrationPage;
import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.TestListener;
import academy.softserve.edu.utils.TestRunner;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class AdminAfterLogInPageTest extends TestRunner {

    private static final String ADMIN_USERNAME = "iva";
    private static final String ADMIN_PASSWORD = "qwerty";

    public final WebDriver getDriver() {
        return driver;
    }

    //  This test checks if Administrator user can see the following tabs: ‘Administration’ and ‘User Info’(default),
    //  test checks if Administrator user can switch between tabs.
    @Test
    final public void testSwitchingBetweenTabs() {

        LogInPage logInPage = new LogInPage(driver);
        logInPage.doLogIn(ADMIN_USERNAME, ADMIN_PASSWORD);
        Assert.assertEquals(driver.getCurrentUrl(), UserInfoPage.USER_INFO_PAGE_URL);

        UserInfoPage userInfoPage = new UserInfoPage(driver);
        Assert.assertTrue(userInfoPage.getElement(UserInfoPage.USER_INFO_LINK).isDisplayed() &&
                userInfoPage.getElement(UserInfoPage.ADMINISTRATION_LINK).isDisplayed());
        userInfoPage.clickAdministrationTab();

        AdministrationPage administrationPage = new AdministrationPage(driver);
        Assert.assertTrue(administrationPage.getElement(UserInfoPage.USER_INFO_LINK).isDisplayed() &&
                administrationPage.getElement(UserInfoPage.ADMINISTRATION_LINK).isDisplayed());
        administrationPage.clickUserInfoTab();

        Assert.assertTrue(userInfoPage.getElement(UserInfoPage.USER_INFO_LINK).isDisplayed() &&
                userInfoPage.getElement(UserInfoPage.ADMINISTRATION_LINK).isDisplayed());
        administrationPage.doLogOut();
    }
}
