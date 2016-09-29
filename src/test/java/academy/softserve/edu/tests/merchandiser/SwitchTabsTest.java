package academy.softserve.edu.tests.merchandiser;

import academy.softserve.edu.domains.User;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.MerchandiserOrderingPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static academy.softserve.edu.pageobjects.MerchandiserOrderingPage.MERCHANDISER_PAGE_EXISTS;
import static academy.softserve.edu.pageobjects.UserInfoPage.USER_INFO_PAGE_EXISTS;

public class SwitchTabsTest extends TestRunner {

    @Test
    final public void testMerchandiserSwitchTabAbility() {

//       login and check if current page is UserInfo page opened by default
        logInPage.logInAs(Roles.MERCHANDISER);

        Assert.assertTrue(logInPage
                        .getElement(USER_INFO_PAGE_EXISTS)
                        .isDisplayed(),
                "Page element isn't exist");

//       if user can switch between tabs "User Info" and "Ordering"
        final UserInfoPage userInfoPage = new UserInfoPage(driver);
        userInfoPage.clickMerchandiserOrderingTab();

        Assert.assertTrue(userInfoPage
                        .getElement(MERCHANDISER_PAGE_EXISTS)
                        .isDisplayed(),
                "Unique page element isn't exist");

//        if user can switch back to "User Info"
        final MerchandiserOrderingPage merchandiserOrderingPage = new MerchandiserOrderingPage(driver);
        merchandiserOrderingPage.clickUserInfoTab();

        Assert.assertTrue(logInPage
                        .getElement(USER_INFO_PAGE_EXISTS)
                        .isDisplayed(),
                "Page element isn't exist");
    }
}
