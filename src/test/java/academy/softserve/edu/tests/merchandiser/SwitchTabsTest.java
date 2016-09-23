package academy.softserve.edu.tests.merchandiser;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.MerchandiserOrderingPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static academy.softserve.edu.pageobjects.MerchandiserOrderingPage.MERCHANDISER_ORDERING_PAGE_URL;
import static academy.softserve.edu.pageobjects.UserInfoPage.USER_INFO_PAGE_URL;

public class SwitchTabsTest extends TestRunner {

    @Test
    final public void testMerchandiserSwitchTabAbility() {

//       login and check if current page is UserInfo page opened by default

        final LogInPage logInPage = new LogInPage(driver);
        logInPage.loginAs(Roles.MERCHANDISER);
        Assert.assertEquals(driver.getCurrentUrl(),
                USER_INFO_PAGE_URL,
                "Current page: " + driver.getCurrentUrl() + " is not 'UserInfo' page: "
                        + USER_INFO_PAGE_URL);

//       if user can switch between tabs "User Info" and "Ordering"
        final UserInfoPage userInfoPage = new UserInfoPage(driver);
        userInfoPage.clickMerchandiserOrderingTab();
        Assert.assertEquals(driver.getCurrentUrl(),
                MERCHANDISER_ORDERING_PAGE_URL,
                "Current page: " + driver.getCurrentUrl() + " is not 'Ordering' page: "
                        + MERCHANDISER_ORDERING_PAGE_URL);

//        if user can switch back to "User Info"
        final MerchandiserOrderingPage merchandiserOrderingPage = new MerchandiserOrderingPage(driver);
        merchandiserOrderingPage.clickUserInfoTab();
        Assert.assertEquals(driver.getCurrentUrl(), USER_INFO_PAGE_URL,
                "Current page: " + driver.getCurrentUrl() + " is not 'UserInfo' page: "
                        + USER_INFO_PAGE_URL);
    }
}
