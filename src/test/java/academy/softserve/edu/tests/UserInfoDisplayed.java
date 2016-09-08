package academy.softserve.edu.tests;

import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class UserInfoDisplayed {
    private  WebDriver driver;
    private UserInfoPage infoPage;
    private LogInPage loginPage;
    private final String homePage2 = "http://192.168.56.101:8080/oms5/";

    @DataProvider
    public final Object[][] dataTables() {
        return new Object[][]{
                {"iva"}, {"vpopkin"}, {"login2"}, {"login3"}, {
                "login4"}, {"marko"}, {"myroslav"}, {"orest"}, {"romanN"}, {"romanS"}, {
                "vitalik"}, {"login1"}, {"vpupkin"}
        };
    }

    @BeforeTest
    public final void driverSetUp() {
       System.setProperty("webdriver.chrome.driver", ".//src/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(homePage2);
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
    private void quit() {
        driver.quit();
    }
}
