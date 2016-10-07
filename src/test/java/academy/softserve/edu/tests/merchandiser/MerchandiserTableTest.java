package academy.softserve.edu.tests.merchandiser;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.SortUtil;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;

public class MerchandiserTableTest extends TestRunner {

    @BeforeMethod
    public final void setMerchandiserTableTest() {
        logInPage.logInAs(Roles.MERCHANDISER);

        userInfoPage = new UserInfoPage(driver);

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

        merchandiserOrderingPage
                .getOrderNameHeaderButton()
                .click();

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

        merchandiserOrderingPage
                .getTotalPriceHeaderButton()
                .click();

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

        merchandiserOrderingPage
                .getMaxDiscountHeaderButton()
                .click();

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

        merchandiserOrderingPage
                .getStatusHeaderButton()
                .click();

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

        merchandiserOrderingPage
                .getForwardButton()
                .click();

        assertThat(merchandiserOrderingPage
                .getNumberOfGridPages())
                .isParseIntQuantityEqualTo(2);

        merchandiserOrderingPage
                .getBackwardButton()
                .click();

        assertThat(merchandiserOrderingPage
                .getNumberOfGridPages())
                .isParseIntQuantityEqualTo(1);

        merchandiserOrderingPage
                .getLastButton()
                .click();

        assertThat(merchandiserOrderingPage
                .getNumberOfGridPages())
                .isParseIntQuantityEqualTo(quantityOfGridPages);

        merchandiserOrderingPage
                .getFirstButton()
                .click();

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

        merchandiserOrderingPage
                .getResizeOrdersListLinks()
                .click();

        assertThat(merchandiserOrderingPage.getOrderNameColumnLink())
                .isQuantityMoreThan(5);

        assertThat(merchandiserOrderingPage
                .getOrderNameColumnLink())
                .isQuantityLessOrEqualsThan(10);

        merchandiserOrderingPage
                .getResizeOrdersListLinks()
                .click();

        assertThat(merchandiserOrderingPage
                .getOrderNameColumnLink())
                .isQuantityEqualTo(5);
    }

    // To check searching function in Merchandiser Table by Status
    @Test
    public final void testSearchForStatusFilter() {

        merchandiserOrderingPage
                .getSearchDropdown()
                .sendKeys("Status");
        merchandiserOrderingPage
                .getSearchInput()
                .sendKeys("Created");
        merchandiserOrderingPage
                .getApplyButton()
                .click();

        assertThat(merchandiserOrderingPage
                .getStatusCell())
                .textEquals("Created");
    }

    // To check searching function in Merchandiser Table by Status
    @Test
    public final void testSearchForOrderNameFilter() {

        merchandiserOrderingPage
                .getSearchDropdown()
                .sendKeys("Order Name");
        merchandiserOrderingPage
                .getSearchInput()
                .sendKeys("OrderName7");
        merchandiserOrderingPage
                .getApplyButton()
                .click();

        assertThat(merchandiserOrderingPage
                .getOrderNameFirstCellLink())
                .textEquals("OrderName7");
    }


}

