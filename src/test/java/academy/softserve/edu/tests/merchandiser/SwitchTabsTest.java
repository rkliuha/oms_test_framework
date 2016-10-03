package academy.softserve.edu.tests.merchandiser;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class SwitchTabsTest extends TestRunner {

    @Test
    final public void testMerchandiserSwitchTabAbility() {

//       login and check if current page is UserInfo page opened by default
        userInfoPage = logInPage.logInAs(Roles.MERCHANDISER);

        assertThat(userInfoPage.getUserInfoFieldSet())
                .isDisplayed();

//       if user can switch between tabs "User Info" and "Ordering"
        userInfoPage
                .getMerchandiserOrderingLink()
                .click();

        merchandiserOrderingPage = new MerchandiserOrderingPage(driver);

        assertThat(merchandiserOrderingPage.getSearchByText())
                .isDisplayed();

//        if user can switch back to "User Info"
        merchandiserOrderingPage
                .getUserInfoLink()
                .click();

        assertThat(userInfoPage.getUserInfoFieldSet())
                .isDisplayed();
    }

}
