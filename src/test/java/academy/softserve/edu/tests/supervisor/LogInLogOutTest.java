package academy.softserve.edu.tests.supervisor;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.ItemManagementPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInLogOutTest extends TestRunner {

    @Test
    public final void testLogIn() {

        userInfoPage = logInPage.logInAs(Roles.SUPERVISOR);

        Assert.assertTrue(userInfoPage
                .getIdentificationOfUserInfoPage()
                .isDisplayed(), "LogIn failed!");
    }

    @Test
    public final void testLogOutButtonVisibility() {

        userInfoPage = logInPage.logInAs(Roles.SUPERVISOR);
        // below we have to check if logIn was successful because every page has
        // logOut button with same locator and we could get false positive result
        // after logIn failure;
        Assert.assertTrue(userInfoPage
                .getIdentificationOfUserInfoPage()
                .isDisplayed(), "LogIn failed!");

        Assert.assertTrue(userInfoPage
                .getElement(UserInfoPage.LOG_OUT_BUTTON)
                .isDisplayed(), "LogOut button is not displayed!\nURL: "
                + driver.getCurrentUrl());

        itemManagementPage = userInfoPage.clickItemManagementTab();
        // we have to check switching between pages, has the same issue with logIn check;
        Assert.assertTrue(itemManagementPage
                .getIdentificationOfSupervisePage()
                .isDisplayed(), "Page is not switched to ItemManagementPage");

        Assert.assertTrue(itemManagementPage
                .getElement(ItemManagementPage.LOG_OUT_BUTTON)
                .isDisplayed(), "LogOut button is not displayed!\nURL: "
                + driver.getCurrentUrl());
    }

    @Test
    public final void testLogOut() {

        userInfoPage = logInPage.logInAs(Roles.SUPERVISOR);

        itemManagementPage = userInfoPage.clickItemManagementTab();

        itemManagementPage.doLogOut();
        Assert.assertTrue(logInPage
                .getLogInButton()
                .isDisplayed(), "LogOut failed!");
    }
}
