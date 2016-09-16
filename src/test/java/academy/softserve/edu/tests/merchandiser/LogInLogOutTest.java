package academy.softserve.edu.tests.merchandiser;

import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.MerchandiserOrderingPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInLogOutTest extends TestRunner {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public final void testLogIn(String name, String password) {

        logInPage = new LogInPage(driver);
        logInPage
                .doLogIn(name, password);
        userInfoPage = new UserInfoPage(driver);
        Assert.assertTrue(userInfoPage.getIdentificationOfUserInfoPage().isDisplayed(),
                "LogIn failed!");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public final void testLogOutButtonVisibility(String name, String password) {

        logInPage = new LogInPage(driver);
        logInPage
                .doLogIn(name, password);

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

        merchandiserOrderingPage =
                userInfoPage.clickMerchandiserOrderingTab();
        // we have to check switching between pages, has the same issue with logIn check;
        Assert.assertTrue(merchandiserOrderingPage.getIdentificationOfMerchandiserPage().isDisplayed(),
                "Page is not switched to: "
                        + MerchandiserOrderingPage.MERCHANDISER_ORDERING_PAGE_URL);

        Assert.assertTrue(merchandiserOrderingPage
                .getElement(MerchandiserOrderingPage.LOG_OUT_BUTTON)
                .isDisplayed(), "LogOut button is not displayed!\nURL: "
                + driver.getCurrentUrl());
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public final void testLogOut(String name, String password) {

        logInPage = new LogInPage(driver);
        logInPage
                .doLogIn(name, password);
        userInfoPage = new UserInfoPage(driver);
        merchandiserOrderingPage =
                userInfoPage
                        .clickMerchandiserOrderingTab();
        merchandiserOrderingPage
                .doLogOut();
        Assert
                .assertTrue(logInPage.getLogInButton().isDisplayed(),
                        "LogOut failed!");
    }
}
