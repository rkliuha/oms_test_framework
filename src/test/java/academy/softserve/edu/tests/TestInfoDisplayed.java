package academy.softserve.edu.tests;

import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static academy.softserve.edu.enums.Drivers.FIREFOX;
import static org.testng.AssertJUnit.assertTrue;

public class TestInfoDisplayed {
    private UserInfoPage infoPage;
    private LogInPage loginPage;
    public static final String LOG_IN_PAGE =
            "http://192.168.56.101:8080/oms5/login.htm";
    public static final int TIMEOUT = 10;
    protected WebDriver driver;

    @DataProvider
    public final Object[][] dataTables() {
        return new Object[][]{
                {"iva"}, {"vpopkin"}, {"login2"}, {"login3"}, {
                "login4"}, {"marko"}, {"myroslav"}, {"orest"}, {"romanN"}, {"romanS"}, {
                "vitalik"}, {"login1"}, {"vpupkin"}
        };
    }

    @BeforeTest
    public final void setUp() {
        driver = new WebDriverFactory().getDriver(FIREFOX);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.get(LOG_IN_PAGE);
    }

    @Test(dataProvider = "dataTables")
    public void startTest(String userName) throws InterruptedException {
        try {
            loginPage = new LogInPage(driver);
            infoPage = new UserInfoPage(driver);
            loginPage.doLogIn(userName, "qwerty");
          for (int i=0;i<infoPage.fieldNotEmpty().length;i++)
          assertTrue(!infoPage.fieldNotEmpty()[i].isEmpty());
            infoPage.doLogOut();
        } catch (AssertionError e) {
            infoPage.doLogOut();
            System.out.println(userName + " test Failed!");
        }
    }

    @AfterTest
    public final void tearDown() {
        driver.close();
    }
}
