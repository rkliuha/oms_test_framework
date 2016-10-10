package academy.softserve.edu.tests.merchandiser;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class DoNotRevertDefaultStateTest extends TestRunner {

    //TODO move inline
    public static final String SEARCH_ORDERS = "Status";
    public static final String SEARCH_ORDERS_VALUE = "Ordered";

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

        userInfoPage = logInPage
                .logInAs(Roles.MERCHANDISER);

        merchandiserOrderingPage = userInfoPage.clickMerchandiserOrderingTab();

        merchandiserOrderingPage.selectSearchDropdown(SEARCH_ORDERS)
                .fillSearchInput(SEARCH_ORDERS_VALUE)
                .clickApplyButton()
                .clickUserInfoLink();

        userInfoPage.clickMerchandiserOrderingTab();

        assertThat(merchandiserOrderingPage.getSearchDropdown())
                .selectedDropdownEquals(SEARCH_ORDERS);

        assertThat(merchandiserOrderingPage.getSearchInput())
                .valueEquals(SEARCH_ORDERS_VALUE);
    }

}
