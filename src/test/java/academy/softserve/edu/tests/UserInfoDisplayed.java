package academy.softserve.edu.tests;

import academy.softserve.edu.pageobjects.OMSHomePage;
import academy.softserve.edu.pageobjects.UserInfoTab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;

public class UserInfoDisplayed {
    private final WebDriver driver = new FirefoxDriver();
    private final OMSHomePage homePage = new OMSHomePage(driver);
    private final UserInfoTab infoPage = new UserInfoTab(driver);

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
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "dataTables")
    public void startTest(String userName) throws InterruptedException {
        try {
            homePage
                    .openHomePage()
                    .enterUser(userName)
                    .enterPassword("qwerty")
                    .loginClick()
                    .pause();
            assertTrue(infoPage.firstNameNotEmpty() && infoPage.lastNameNotEmpty()
                    && infoPage.customerTypeNotEmpty() && infoPage.roleNotEmpty());
            infoPage.logOut()
                    .pause();
            driver.switchTo().alert().accept();
            homePage.pause();
        } catch (AssertionError e) {
            infoPage.logOut()
                    .pause();
            driver.switchTo().alert().accept();
            homePage.pause();
            System.out.println(userName + " test Failed!");
        }
    }

    @AfterTest
    private void quit() {
        driver.quit();
    }
}
