package academy.softserve.edu.tests.merchandiser;

import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.MerchandiserOrderingPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInLogOutTest extends TestRunner {

    public static final String MERCHANDISER_USERNAME = "login1";
    public static final String MERCHANDISER_PASSWORD = "qwerty";

    @Test
    public final void testLogIn() {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage.doLogIn(MERCHANDISER_USERNAME, MERCHANDISER_PASSWORD);
        Assert.assertEquals(driver.getCurrentUrl(), UserInfoPage.USER_INFO_PAGE_URL,
                "LogIn failed!");
    }

    @Test
    public final void testLogOutButtonVisibility() {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage.doLogIn(MERCHANDISER_USERNAME, MERCHANDISER_PASSWORD);

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

        final MerchandiserOrderingPage merchandiserOrderingPage =
                userInfoPage.clickMerchandiserOrderingTab();
        // we have to check switching between pages, has the same issue with logIn check;
        Assert.assertEquals(driver.getCurrentUrl(),
                MerchandiserOrderingPage.MERCHANDISER_ORDERING_PAGE_URL,
                "Page is not switched to: "
                        + MerchandiserOrderingPage.MERCHANDISER_ORDERING_PAGE_URL);

        Assert.assertTrue(merchandiserOrderingPage
                .getElement(MerchandiserOrderingPage.LOG_OUT_BUTTON)
                .isDisplayed(), "LogOut button is not displayed!\nURL: "
                + driver.getCurrentUrl());
    }

    @Test
    public final void testLogOut() {

        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .doLogIn(MERCHANDISER_USERNAME, MERCHANDISER_PASSWORD);
        final UserInfoPage userInfoPage = new UserInfoPage(driver);
        final MerchandiserOrderingPage merchandiserOrderingPage =
                userInfoPage
                        .clickMerchandiserOrderingTab();
        merchandiserOrderingPage
                .doLogOut();
        Assert
                .assertEquals(driver.getCurrentUrl(), LOG_IN_PAGE, "LogOut failed!");
    }
}
