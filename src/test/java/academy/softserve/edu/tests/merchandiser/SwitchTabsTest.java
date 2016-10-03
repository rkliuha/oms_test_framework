package academy.softserve.edu.tests.merchandiser;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwitchTabsTest extends TestRunner {

    @Test
    final public void testMerchandiserSwitchTabAbility() {

//       login and check if current page is UserInfo page opened by default
        logInPage.logInAs(Roles.MERCHANDISER);

        userInfoPage = new UserInfoPage(driver);
        Assert.assertTrue(userInfoPage.getUserInfoFieldSet().isDisplayed(),
                "The page: " + driver.getCurrentUrl() + " is not 'User Info' page");

//       if user can switch between tabs "User Info" and "Ordering"
        userInfoPage
                .getMerchandiserOrderingLink()
                .click();

        merchandiserOrderingPage = new MerchandiserOrderingPage(driver);

        Assert.assertTrue(merchandiserOrderingPage.getSearchByText().isDisplayed(),
                "The page: " + driver.getCurrentUrl() + " is not 'Merchandiser Ordering' page");

//        if user can switch back to "User Info"
        merchandiserOrderingPage
                .getUserInfoLink()
                .click();

        Assert.assertTrue(userInfoPage.getUserInfoFieldSet().isDisplayed(),
                "The page: " + driver.getCurrentUrl() + " is not 'User Info' page");
    }
}
