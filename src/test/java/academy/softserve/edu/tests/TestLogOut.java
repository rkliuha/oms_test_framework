package academy.softserve.edu.tests;

import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.PageObject;
import academy.softserve.edu.pageobjects.UserInfoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static academy.softserve.edu.utils.ExtraPageParser.getExtraPage;

public class TestLogOut {

    public static final String LOG_IN_PAGE =
            "http://192.168.56.101:8080/oms5/login.htm";
    public static final int TIMEOUT = 10;

    private WebDriver driver;

    @BeforeClass
    public final void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.get(LOG_IN_PAGE);
    }

    @Test(dataProvider = "allTypesOfUsers")
    public final void testLogOutButton(final String userType,
                                       final String username,
                                       final String password) {
        final LogInPage logInPage = new LogInPage(driver);
        logInPage.doLogIn(username, password);

        final UserInfoPage userInfoPage = new UserInfoPage(driver);
        Assert.assertEquals(driver.getCurrentUrl(), UserInfoPage.USER_INFO_PAGE_URL);

        Assert.assertTrue(userInfoPage
                .getElement(PageObject.LOG_OUT_BUTTON)
                .isDisplayed());

        userInfoPage.getElement(UserInfoPage.VISITOR_EXTRA_LINK)
                .click();

        final PageObject pageObject = getExtraPage(userType, driver);
        Assert.assertTrue(pageObject
                .getElement(PageObject.LOG_OUT_BUTTON)
                .isDisplayed());

        pageObject.doLogOut();

        Assert.assertEquals(driver.getCurrentUrl(), LOG_IN_PAGE);
    }

    @AfterClass
    public final void tearDown() {
        driver.close();
    }

    @DataProvider(name = "allTypesOfUsers")
    public final Object[][] allTypesOfUsers() {
        return new Object[][]{
                {"Administrator", "RomanS", "qwerty"},
                {"Merchandiser", "login1", "qwerty"},
                {"Supervisor", "login2", "qwerty"},
                {"Customer", "vpopkin", "qwerty"}};
    }

}
