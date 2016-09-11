package academy.softserve.edu.tests.supervisor;

import academy.softserve.edu.pageobjects.ItemManagementPage;
import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogOut extends TestRunner {

    public static final String SUPERVISOR_USERNAME = "login2";
    public static final String SUPERVISOR_PASSWORD = "qwerty";

    @Test
    public final void testLogOutButtonAbilityAndVisibility() {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage.doLogIn(SUPERVISOR_USERNAME, SUPERVISOR_PASSWORD);

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

        final ItemManagementPage itemManagementPage =
                userInfoPage.clickItemManagementTab();
        // we have to check switching between pages, has the same issue with logIn check;
        Assert.assertEquals(driver.getCurrentUrl(),
                ItemManagementPage.ITEM_MANAGEMENT_PAGE_URL,
                "Page is not switched to: "
                        + ItemManagementPage.ITEM_MANAGEMENT_PAGE_URL);

        Assert.assertTrue(itemManagementPage
                .getElement(ItemManagementPage.LOG_OUT_BUTTON)
                .isDisplayed(), "LogOut button is not displayed!\nURL: "
                + driver.getCurrentUrl());

        itemManagementPage.doLogOut();
        Assert.assertEquals(driver.getCurrentUrl(), LOG_IN_PAGE, "LogOut failed!");
    }

}
