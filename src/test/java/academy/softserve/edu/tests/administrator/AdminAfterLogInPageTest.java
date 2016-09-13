package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.pageobjects.AdministrationPage;
import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.TestListener;
import academy.softserve.edu.utils.TestRunner;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static academy.softserve.edu.pageobjects.UserInfoPage.ADMINISTRATION_LINK;
import static academy.softserve.edu.pageobjects.UserInfoPage.USER_INFO_LINK;
import static academy.softserve.edu.pageobjects.UserInfoPage.USER_INFO_PAGE_URL;

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

        final LogInPage logInPage = new LogInPage(driver);
        logInPage.doLogIn(ADMIN_USERNAME, ADMIN_PASSWORD);
        Assert.assertEquals(driver
                .getCurrentUrl(), USER_INFO_PAGE_URL, "URL is different from " + USER_INFO_PAGE_URL);

        UserInfoPage userInfoPage = new UserInfoPage(driver);
        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_LINK)
                .isDisplayed() && userInfoPage
                .getElement(ADMINISTRATION_LINK)
                .isDisplayed(), "\nVerification Failed: Either\n" + USER_INFO_LINK
                + " or\n" + ADMINISTRATION_LINK + "is not being displayed");
        userInfoPage.clickAdministrationTab();

        AdministrationPage administrationPage = new AdministrationPage(driver);
        Assert.assertTrue(administrationPage
                .getElement(USER_INFO_LINK)
                .isDisplayed() && administrationPage
                .getElement(ADMINISTRATION_LINK)
                .isDisplayed(), "\nVerification Failed: Either\n" + USER_INFO_LINK
                + " or\n" + ADMINISTRATION_LINK + "is not being displayed");
        administrationPage.clickUserInfoTab();

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_LINK)
                .isDisplayed() && userInfoPage
                .getElement(ADMINISTRATION_LINK)
                .isDisplayed(), "\nVerification Failed: Either\n" + USER_INFO_LINK
                + " or\n" + ADMINISTRATION_LINK + "is not being displayed");
        administrationPage.doLogOut();
    }
}
