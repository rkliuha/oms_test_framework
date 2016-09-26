package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.AdministrationPage;
import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInLogOutTest extends TestRunner {

    @Test
    public final void testLogIn() {

        logInPage = new LogInPage(driver);
        logInPage
                .loginAs(Roles.ADMINISTRATOR);
        userInfoPage = new UserInfoPage(driver);
        Assert.assertTrue(userInfoPage.getIdentificationOfUserInfoPage().isDisplayed(),
                "LogIn failed!");
    }

    @Test
    public final void testLogOutButtonVisibility() {

        logInPage = new LogInPage(driver);
        logInPage
                .loginAs(Roles.ADMINISTRATOR);

        userInfoPage = new UserInfoPage(driver);
        // below we have to check if logIn was successful because every page has
        // logOut button with same locator and we could get false positive result
        // after logIn failure;
        Assert.assertTrue(userInfoPage.getIdentificationOfUserInfoPage().isDisplayed(),
                "LogIn failed!");

        Assert.assertTrue(userInfoPage
                .getElement(UserInfoPage.LOG_OUT_BUTTON)
                .isDisplayed(), "LogOut button is not displayed!\nURL: "
                + driver.getCurrentUrl());

        administrationPage =
                userInfoPage.clickAdministrationTab();
        // we have to check switching between pages, has the same issue with logIn check;
        Assert.assertTrue(administrationPage.identificationOfAdministratorPage().isDisplayed(),
                "Page is not switched to: "
                        + AdministrationPage.ADMINISTRATION_PAGE_URL);

        Assert.assertTrue(administrationPage
                .getElement(AdministrationPage.LOG_OUT_BUTTON)
                .isDisplayed(), "LogOut button is not displayed!\nURL: "
                + driver.getCurrentUrl());
    }

    @Test
    public final void testLogOut() {

        logInPage = new LogInPage(driver);
        logInPage
                .loginAs(Roles.ADMINISTRATOR);
        userInfoPage = new UserInfoPage(driver);
        administrationPage =
                userInfoPage
                        .clickAdministrationTab();
        administrationPage
                .doLogOut();
        Assert
                .assertTrue(logInPage.getLogInButton().isDisplayed(),
                        "LogOut failed!");
    }
}

