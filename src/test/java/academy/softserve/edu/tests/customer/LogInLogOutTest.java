package academy.softserve.edu.tests.customer;


import academy.softserve.edu.pageobjects.CustomerOrderingPage;
import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInLogOutTest extends TestRunner {

    public static final String CUSTOMER_USERNAME = "vpopkin";
    public static final String CUSTOMER_PASSWORD = "qwerty";

    @Test
    public final void testLogIn() {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage.doLogIn(CUSTOMER_USERNAME, CUSTOMER_PASSWORD);
        Assert.assertEquals(driver.getCurrentUrl(), UserInfoPage.USER_INFO_PAGE_URL,
                "LogIn failed!");
    }

    @Test
    public final void testLogOutButtonVisibility() {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage.doLogIn(CUSTOMER_USERNAME, CUSTOMER_PASSWORD);

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

        final CustomerOrderingPage customerOrderingPage =
                userInfoPage.clickCustomerOrderingTab();
        // we have to check switching between pages, has the same issue with logIn check;
        Assert.assertEquals(driver.getCurrentUrl(),
                CustomerOrderingPage.CUSTOMER_ORDERING_PAGE_URL,
                "Page is not switched to: "
                        + CustomerOrderingPage.CUSTOMER_ORDERING_PAGE_URL);

        Assert.assertTrue(customerOrderingPage
                .getElement(CustomerOrderingPage.LOG_OUT_BUTTON)
                .isDisplayed(), "LogOut button is not displayed!\nURL: "
                + driver.getCurrentUrl());
    }

    @Test
    public final void testLogOut() {

        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .doLogIn(CUSTOMER_USERNAME, CUSTOMER_PASSWORD);
        final UserInfoPage userInfoPage = new UserInfoPage(driver);
        final CustomerOrderingPage customerOrderingPage =
                userInfoPage
                        .clickCustomerOrderingTab();
        customerOrderingPage
                .doLogOut();
        Assert
                .assertEquals(driver.getCurrentUrl(), LOG_IN_PAGE, "LogOut failed!");
    }
}
