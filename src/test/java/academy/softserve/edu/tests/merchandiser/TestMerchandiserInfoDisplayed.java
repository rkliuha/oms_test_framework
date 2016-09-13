package academy.softserve.edu.tests.merchandiser;

import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class TestMerchandiserInfoDisplayed extends TestRunner {
    private UserInfoPage infoPage;

    @Test(dataProvider = "testDataForMerchandiser", dataProviderClass = DataProviders.class)
    public void testAdminInfoDisplayed(final String userName, final String userPassword) {
        infoPage = new UserInfoPage(driver);
        final LogInPage loginPage = new LogInPage(driver);
        loginPage.doLogIn(userName, userPassword);
        for (int i = 0; i < infoPage.getUserInfoData().length; i++)
            assertTrue(!infoPage.getUserInfoData()[i].isEmpty());
        infoPage.doLogOut();
    }
}
