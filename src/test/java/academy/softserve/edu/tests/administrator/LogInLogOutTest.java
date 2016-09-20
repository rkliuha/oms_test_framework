package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.pageobjects.AdministrationPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInLogOutTest extends TestRunner {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForAdministrator")
    public final void testLogIn(final String name, final String password) {

        userInfoPage = logInPage.doLogIn(name, password);

        Assert.assertTrue(userInfoPage
                .getIdentificationOfUserInfoPage()
                .isDisplayed(), "LogIn failed!");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForAdministrator")
    public final void testLogOutButtonVisibility(final String name, final String password) {

        userInfoPage = logInPage.doLogIn(name, password);
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

        administrationPage = userInfoPage.clickAdministrationTab();
        // we have to check switching between pages, has the same issue with logIn check;
        Assert.assertTrue(administrationPage
                .identificationOfAdministratorPage()
                .isDisplayed(), "Page is not switched to: "
                + AdministrationPage.ADMINISTRATION_PAGE_URL);

        Assert.assertTrue(administrationPage
                .getElement(AdministrationPage.LOG_OUT_BUTTON)
                .isDisplayed(), "LogOut button is not displayed!\nURL: "
                + driver.getCurrentUrl());
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForAdministrator")
    public final void testLogOut(String name, String password) {

        userInfoPage = logInPage.doLogIn(name, password);

        administrationPage = userInfoPage.clickAdministrationTab();

        administrationPage.doLogOut();
        Assert.assertTrue(logInPage
                .getLogInButton()
                .isDisplayed(), "LogOut failed!");
    }

}