package academy.softserve.edu.tests;

import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.MerchandiserOrderingPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestMerchandiserAfterLogInPage {

    public static final String LOG_IN_PAGE =
            "http://192.168.56.101:8080/oms5/login.htm";

    private WebDriver driver;
    private UserInfoPage userInfoPage;

    @DataProvider
    final public Object[][] testData() {
        return new Object[][]{
                {"login1", "qwerty"}
        };
    }

    @BeforeTest
    final public void setUp() {
        driver = new FirefoxDriver();
        driver.get(LOG_IN_PAGE);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterTest
    final public void tearDown() {
        userInfoPage.doLogOut();
        driver.close();
    }

    @Test(dataProvider = "testData")
    final public void testMerchandiserSwitchTabAbility(final String username, final String password) {

//       login and check if current page is UserInfo page opened by default
        final LogInPage logInPage = new LogInPage(driver);
        logInPage.doLogIn(username, password);
        Assert.assertEquals(driver.getCurrentUrl(), UserInfoPage.USER_INFO_PAGE_URL);

//       if user can switch between tabs "User Info" and "Ordering"
        userInfoPage = new UserInfoPage(driver);
        userInfoPage.clickMerchandiserOrderingTab();
        Assert.assertEquals(driver.getCurrentUrl(),
                MerchandiserOrderingPage.MERCHANDISER_ORDERING_PAGE_URL);

//        if user can switch back to "User Info"
        final MerchandiserOrderingPage merchandiserOrderingPage = new MerchandiserOrderingPage(driver);
        merchandiserOrderingPage.clickUserInfoTab();
        Assert.assertEquals(driver.getCurrentUrl(), UserInfoPage.USER_INFO_PAGE_URL);
    }
}
