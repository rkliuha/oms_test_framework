package academy.softserve.edu.tests;

import academy.softserve.edu.enums.Drivers;
import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.MerchandiserOrderingPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestMerchandiserAfterLogInPage {

    public static final String LOG_IN_PAGE =
            "http://192.168.56.101:8080/oms5/login.htm";
    public static final int TIMEOUT = 10;

    protected WebDriver driver;

    @DataProvider
    final public Object[][] testData() {
        return new Object[][]{
                {"login1", "qwerty"}
        };
    }

    @BeforeTest
    final public void setUp() {
        driver = new WebDriverFactory().getDriver(Drivers.FIREFOX);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.get(LOG_IN_PAGE);
    }

    @AfterTest
    final public void tearDown() {
        driver.close();
    }

    @Test(dataProvider = "testData")
    final public void testMerchandiserSwitchTabAbility(final String username, final String password) {

//       login and check if current page is UserInfo page opened by default
        final LogInPage logInPage = new LogInPage(driver);
        logInPage.doLogIn(username, password);
        Assert.assertEquals(driver.getCurrentUrl(), UserInfoPage.USER_INFO_PAGE_URL);

//       if user can switch between tabs "User Info" and "Ordering"
        final UserInfoPage userInfoPage = new UserInfoPage(driver);
        userInfoPage.clickMerchandiserOrderingTab();
        Assert.assertEquals(driver.getCurrentUrl(),
                MerchandiserOrderingPage.MERCHANDISER_ORDERING_PAGE_URL);

//        if user can switch back to "User Info"
        final MerchandiserOrderingPage merchandiserOrderingPage = new MerchandiserOrderingPage(driver);
        merchandiserOrderingPage.clickUserInfoTab();
        Assert.assertEquals(driver.getCurrentUrl(), UserInfoPage.USER_INFO_PAGE_URL);
    }
}
