package academy.softserve.edu.tests.merchandiser;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class DoNotRevertDefaultStateTest extends TestRunner {

    @Test
    public void testUserInfoOrderingButtonCheck() {

        userInfoPage = logInPage
                .logInAs(Roles.MERCHANDISER);

        assertThat(userInfoPage.getUserInfoLink())
                .isDisplayed();

        assertThat(userInfoPage.getMerchandiserOrderingLink())
                .isDisplayed();
    }

    @Test
    public void testDoNotRevertDefaultState() {

        final String searchOrders = "Status";
        final String searchOrdersValue = "Ordered";

        userInfoPage = logInPage
                .logInAs(Roles.MERCHANDISER);

        merchandiserOrderingPage = userInfoPage.clickMerchandiserOrderingTab();

        merchandiserOrderingPage.selectSearchDropdown(searchOrders)
                .fillSearchInput(searchOrdersValue)
                .clickApplyButton()
                .clickUserInfoLink();

        userInfoPage.clickMerchandiserOrderingTab();

        assertThat(merchandiserOrderingPage.getSearchDropdown())
                .selectedDropdownEquals(searchOrders);

        assertThat(merchandiserOrderingPage.getSearchInput())
                .valueEquals(searchOrdersValue);
    }

}
