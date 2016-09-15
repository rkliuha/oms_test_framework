package academy.softserve.edu.tests.customer;

import academy.softserve.edu.pageobjects.CustomerOrderingPage;
<<<<<<< HEAD
import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.DataProviders;
=======
>>>>>>> f882beeb1a5bdba80d7c859834b19290187987af
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static academy.softserve.edu.pageobjects.CustomerOrderingPage.CUSTOMER_PAGE_EXISTS;
import static academy.softserve.edu.pageobjects.UserInfoPage.*;

public class SwitchTabsByCustomerTest extends TestRunner {

<<<<<<< HEAD
    private LogInPage logInPage;
    private UserInfoPage userInfoPage;

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForCustomer")
    public void testDefaultUserInfoPage(String name, String password) {
=======
    public static final String USER_LOGIN = "vpopkin";
    public static final String USER_PASSWORD = "qwerty";

    @Test
    public void testDefaultUserInfoPage() {
>>>>>>> f882beeb1a5bdba80d7c859834b19290187987af

        userInfoPage = logInPage
                .doLogIn(name, password);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_PAGE_EXISTS)
                .isDisplayed(), "Element " + USER_INFO_PAGE_EXISTS + " isn't displayed");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForCustomer")
    public void testUserInfoButtonCheck(String name, String password) {

        userInfoPage = logInPage
                .doLogIn(name, password);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_LINK)
                .isDisplayed(), "Element " + USER_INFO_LINK + " isn't displayed");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForCustomer")
    public void testOrderingButtonCheck(String name, String password) {

        userInfoPage = logInPage
                .doLogIn(name, password);

        Assert.assertTrue(userInfoPage
                .getElement(CUSTOMER_ORDERING_LINK)
                .isDisplayed(), "Element " + CUSTOMER_ORDERING_LINK + " isn't displayed");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForCustomer")
    public void testActiveOrderingPage(String name, String password) {

        userInfoPage = logInPage
                .doLogIn(name, password);

        userInfoPage
                .click(CUSTOMER_ORDERING_LINK);

        Assert.assertTrue(userInfoPage
                .getElement(CUSTOMER_PAGE_EXISTS)
                .isDisplayed(), "Element " + CUSTOMER_PAGE_EXISTS + " isn't displayed");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForUser")
    public void testSwitchTabsUserOrdering(String name, String password) {

        userInfoPage = logInPage
                .doLogIn(name, password);

        userInfoPage
                .click(CUSTOMER_ORDERING_LINK);

        Assert.assertTrue(userInfoPage
                .getElement(CUSTOMER_PAGE_EXISTS)
                .isDisplayed(), "Element " + CUSTOMER_PAGE_EXISTS + " isn't displayed");

        customerOrderingPage = new CustomerOrderingPage(driver);

        customerOrderingPage
                .click(USER_INFO_LINK);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_PAGE_EXISTS)
                .isDisplayed(), "Element " + CUSTOMER_PAGE_EXISTS + " isn't displayed");
    }
}
