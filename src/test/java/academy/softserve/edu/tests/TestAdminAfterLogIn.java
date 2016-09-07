package academy.softserve.edu.tests;


import academy.softserve.edu.pageobjects.AdministrationPage;
import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestAdminAfterLogIn {
    public static final String LOG_IN_PAGE = "http://192.168.56.101:8080/oms5";
    public static final String ADMIN_USERNAME = "iva";
    public static final String ADMIN_PASSWORD = "qwerty";
    public static final int TIMEOUT = 5;

    WebDriver driver;
    private LogInPage logInPage;
    private AdministrationPage administrationPage;
    private UserInfoPage userInfoPage;

    @BeforeClass
    final public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.get(LOG_IN_PAGE);

        logInPage = new LogInPage(driver);
        logInPage.doLogIn(ADMIN_USERNAME, ADMIN_PASSWORD);
    }

    //  This test checks if Administrator user can see the following tabs: ‘Administration’ and ‘User Info’(default).
    @Test
    final public void checkDefaultTab() {
        Assert.assertEquals(driver.getCurrentUrl(), UserInfoPage.USER_INFO_PAGE_URL);
        userInfoPage = new UserInfoPage(driver);
        Assert.assertTrue(userInfoPage.getElement(UserInfoPage.USER_INFO_LINK).isDisplayed() &&
                userInfoPage.getElement(UserInfoPage.ADMINISTRATION_LINK).isDisplayed());
    }

    //  This test checks if Administrator user can switch between tabs.
    @Test
    public void checkSwitchingBetweenTabs() {
        userInfoPage.clickAdministrationTab();
        administrationPage = new AdministrationPage(driver);
        Assert.assertTrue(administrationPage.getElement(UserInfoPage.USER_INFO_LINK).isDisplayed() &&
                administrationPage.getElement(UserInfoPage.ADMINISTRATION_LINK).isDisplayed());
        administrationPage.clickUserInfoTab();
        Assert.assertTrue(userInfoPage.getElement(UserInfoPage.USER_INFO_LINK).isDisplayed() &&
                userInfoPage.getElement(UserInfoPage.ADMINISTRATION_LINK).isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        administrationPage.doLogOut();
        driver.close();
    }
}
