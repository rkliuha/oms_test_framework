
package academy.softserve.edu.tests.merchandiser;

import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class TestMerchandiserInfoDisplayed extends TestRunner {
    private UserInfoPage infoPage;

    @DataProvider
    public final Object[][] dataTables() {
        return new Object[][]{
                {"login1"}
        };
    }

    @Test(dataProvider = "dataTables")
    public void startTest(String userName) {
        try {
            LogInPage loginPage = new LogInPage(driver);
            infoPage = new UserInfoPage(driver);
            loginPage.doLogIn(userName, "qwerty");
            for (int i = 0; i < infoPage.fieldNotEmpty().length; i++)
                assertTrue(!infoPage.fieldNotEmpty()[i].isEmpty());
            infoPage.doLogOut();
        } catch (AssertionError e) {
            infoPage.doLogOut();
            System.out.println(userName + " test Failed!");
        }
    }
}

