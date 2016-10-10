package academy.softserve.edu.tests.merchandiser;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.SortUtil;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;

public class MerchandiserTableTest extends TestRunner {

    @BeforeMethod
    public final void setMerchandiserTableTest() {

        userInfoPage = logInPage.logInAs(Roles.MERCHANDISER);;

        // after if logIn failure;
        assertThat(userInfoPage
                .getUserInfoFieldSet())
                .isDisplayed();

        merchandiserOrderingPage = userInfoPage.clickMerchandiserOrderingTab();
    }

    // To check Merchandiser table is enable or not. And Edit and Delete function is available
    @Test
    final public void testMerchandiserTableIsEnable() {

        assertThat(merchandiserOrderingPage
                .getEditCellLink())
                .isDisplayed();

        assertThat(merchandiserOrderingPage
                .getDeleteCellLink())
                .isDisplayed();
    }

    //To check is sorting function is available for Order Name column in the Merchandiser Table.
    @Test
    public final void testSortingOrderNameColumn() {

        assertThat(merchandiserOrderingPage
                .getOrderNameSecondCellLink())
                .isDisplayed();

        merchandiserOrderingPage.clickOrderNameHeaderButton();

        boolean isSortedByAscent = SortUtil
                .isListSortedByAsc(merchandiserOrderingPage
                        .getOrderNameColumnLink()
                        .getElements());

        assertThat(isSortedByAscent).isTrue();
    }

    //To check is sorting function is available for Total Price column in the Merchandiser Table.
    @Test
    public final void testSortingTotalPriceColumn() {

        assertThat(merchandiserOrderingPage
                .getOrderNameSecondCellLink())
                .isDisplayed();

        merchandiserOrderingPage.clickTotalPriceHeaderButton();

        boolean isSortedByDescend = SortUtil
                .isListDoubleSortedByDescend(merchandiserOrderingPage
                        .getTotalPriceColumnLink()
                        .getElements());

        assertThat(isSortedByDescend).isTrue();
    }

    //To check is sorting function is available for Max Discount column in the Merchandiser Table.
    @Test
    public final void testSortingMaxDiscountColumn() {

        assertThat(merchandiserOrderingPage
                .getOrderNameSecondCellLink())
                .isDisplayed();

        merchandiserOrderingPage.clickMaxDiscountHeaderButton();

        boolean isSortedByDescend = SortUtil
                .isListDoubleSortedByDescend(merchandiserOrderingPage
                        .getMaxDiscountColumnLink()
                        .getElements());

        assertThat(isSortedByDescend).isTrue();
    }

    //To check is sorting function is available for Status column in the Merchandiser Table.
    @Test
    public final void testSortingStatusColumn() {

        assertThat(merchandiserOrderingPage
                .getOrderNameSecondCellLink())
                .isDisplayed();

        merchandiserOrderingPage.clickStatusHeaderButton();

        boolean isSortedByAscent = SortUtil
                .isListSortedByAsc(merchandiserOrderingPage
                        .getStatusColumnLink()
                        .getElements());

        assertThat(isSortedByAscent).isTrue();
    }

    @Test
    public final void testMerchandiserTableNavigation() {

        final int quantityOfGridPages = Integer
                .parseInt(merchandiserOrderingPage
                        .getPageCount()
                        .getText());

        assertThat(merchandiserOrderingPage
                .getPageCount())
                .isParseIntQuantityMoreThan(1);

        assertThat(merchandiserOrderingPage
                .getFirstButton())
                .isDisabled();

        assertThat(merchandiserOrderingPage
                .getBackwardButton())
                .isDisabled();

        merchandiserOrderingPage.clickForwardButton();

        assertThat(merchandiserOrderingPage
                .getNumberOfGridPages())
                .isParseIntQuantityEqualTo(2);

        merchandiserOrderingPage.clickBackwardButton();

        assertThat(merchandiserOrderingPage
                .getNumberOfGridPages())
                .isParseIntQuantityEqualTo(1);

        merchandiserOrderingPage.clickLastButton();

        assertThat(merchandiserOrderingPage
                .getNumberOfGridPages())
                .isParseIntQuantityEqualTo(quantityOfGridPages);

        merchandiserOrderingPage.clickFirstButton();

        assertThat(merchandiserOrderingPage
                .getNumberOfGridPages())
                .isParseIntQuantityEqualTo(1);
    }

    //Check how many users shows in the Merchandiser Table, after click on the Show 5 or Show 10 buttons.
    @Test
    public final void testVisibleUsersInTable() {

        assertThat(merchandiserOrderingPage
                .getPageCount())
                .isParseIntQuantityMoreThan(1);

        merchandiserOrderingPage.clickResizeOrdersListLink();

        assertThat(merchandiserOrderingPage.getOrderNameColumnLink())
                .isQuantityMoreThan(5);

        assertThat(merchandiserOrderingPage
                .getOrderNameColumnLink())
                .isQuantityLessOrEqualsThan(10);

        merchandiserOrderingPage.clickResizeOrdersListLink();

        assertThat(merchandiserOrderingPage
                .getOrderNameColumnLink())
                .isQuantityEqualTo(5);
    }

    // To check searching function in Merchandiser Table by Status
    @Test
    public final void testSearchForStatusFilter() {

        merchandiserOrderingPage.selectSearchDropdown("Status")
                .fillSearchInput("Created")
                .clickApplyButton();

        assertThat(merchandiserOrderingPage
                .getStatusCell())
                .textEquals("Created");
    }

    // To check searching function in Merchandiser Table by Status
    @Test
    public final void testSearchForOrderNameFilter() {

        merchandiserOrderingPage.selectSearchDropdown("Order Name")
                .fillSearchInput("OrderName7")
                .clickApplyButton();

        assertThat(merchandiserOrderingPage
                .getOrderNameFirstCellLink())
                .textEquals("OrderName7");
    }

}

