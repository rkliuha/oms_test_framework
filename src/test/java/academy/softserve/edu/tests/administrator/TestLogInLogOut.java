package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.pageobjects.AdministrationPage;
import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogInLogOut extends TestRunner {

    public static final String ADMINISTRATOR_USERNAME = "RomanS";
    public static final String ADMINISTRATOR_PASSWORD = "qwerty";

    @Test
    public final void testLogIn() {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage.doLogIn(ADMINISTRATOR_USERNAME, ADMINISTRATOR_PASSWORD);
        Assert.assertEquals(driver.getCurrentUrl(), UserInfoPage.USER_INFO_PAGE_URL,
                "LogIn failed!");
    }

    @Test
    public final void testLogOutButtonAbilityAndVisibility() {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage.doLogIn(ADMINISTRATOR_USERNAME, ADMINISTRATOR_PASSWORD);

        final UserInfoPage userInfoPage = new UserInfoPage(driver);
        // below we have to check if logIn was successful because every page has
        // logOut button with same locator and we could get false positive result
        // after logIn failure;
        Assert.assertEquals(driver.getCurrentUrl(), UserInfoPage.USER_INFO_PAGE_URL,
                "LogIn failed!");

        Assert.assertTrue(userInfoPage
                .getElement(UserInfoPage.LOG_OUT_BUTTON)
                .isDisplayed(), "LogOut button is not displayed!\nURL: "
                + driver.getCurrentUrl());

        final AdministrationPage administrationPage =
                userInfoPage.clickAdministrationTab();
        // we have to check switching between pages, has the same issue with logIn check;
        Assert.assertEquals(driver.getCurrentUrl(),
                AdministrationPage.ADMINISTRATION_PAGE_URL,
                "Page is not switched to: "
                        + AdministrationPage.ADMINISTRATION_PAGE_URL);

        Assert.assertTrue(administrationPage
                .getElement(AdministrationPage.LOG_OUT_BUTTON)
                .isDisplayed(), "LogOut button is not displayed!\nURL: "
                + driver.getCurrentUrl());
    }

    @Test
    public final void testLogOut() {

        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .doLogIn(ADMINISTRATOR_USERNAME, ADMINISTRATOR_PASSWORD);
        final UserInfoPage userInfoPage = new UserInfoPage(driver);
        final AdministrationPage administrationPage =
                userInfoPage
                        .clickAdministrationTab();
        administrationPage
                .doLogOut();
        Assert
                .assertEquals(driver.getCurrentUrl(), LOG_IN_PAGE, "LogOut failed!");
    }
}

