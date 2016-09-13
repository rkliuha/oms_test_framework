package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.pageobjects.AdministrationPage;
import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInLogOutTest extends TestRunner {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForAdministrator")
    public final void testLogIn(String name, String password) {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage.doLogIn(name, password);
        Assert.assertEquals(driver.getCurrentUrl(), UserInfoPage.USER_INFO_PAGE_URL,
                "LogIn failed!");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForAdministrator")
    public final void testLogOutButtonVisibility(String name, String password) {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage.doLogIn(name, password);

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

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForAdministrator")
    public final void testLogOut(String name, String password) {

        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .doLogIn(name, password);
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

