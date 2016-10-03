package academy.softserve.edu.tests.merchandiser;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class MerchandiserGridTest extends TestRunner {

    @BeforeMethod
    public final void setMerchandiserGridTest() {
        logInPage.logInAs(Roles.MERCHANDISER);

        userInfoPage = new UserInfoPage(driver);

        // after if logIn failure;
        assertThat(userInfoPage
                .getUserInfoFieldSet())
                .isDisplayed();

        merchandiserOrderingPage = userInfoPage.clickMerchandiserOrderingTab();
    }

    // To check Admin grid is enable or not. And Edit and Delete function is available
    @Test
    final public void testMerchandiserGridIsEnable() {

        assertThat(merchandiserOrderingPage
                .getEditCellLink())
                .isDisplayed();

        assertThat(merchandiserOrderingPage
                .getDeleteCellLink())
                .isDisplayed();
    }

    //To check is sorting function is available for Order Name column in the Admin Grid.
    @Test
    public final void testSortingOrderNameColumn() {

        assertThat(merchandiserOrderingPage
                .getOrderNameSecondCellLink())
                .as("In grid should be 2 or more orders!")
                .isDisplayed();

        merchandiserOrderingPage
                .getOrderNameHeaderButton()
                .click();

        assertThat(merchandiserOrderingPage
                .getOrderNameColumnLink())
                .isSortedByAscentStrings();
    }

    //To check is sorting function is available for Total Price column in the Admin Grid.
    @Test
    public final void testSortingTotalPriceColumn() {

        assertThat(merchandiserOrderingPage
                .getOrderNameSecondCellLink())
                .as("In grid should be 2 or more orders!")
                .isDisplayed();

        merchandiserOrderingPage
                .getTotalPriceHeaderButton()
                .click();

        assertThat(merchandiserOrderingPage
                .getTotalPriceColumnLink())
                .isSortedByDescendDouble();
    }

    //To check is sorting function is available for Max Discount column in the Admin Grid.
    @Test
    public final void testSortingMaxDiscountColumn() {

        assertThat(merchandiserOrderingPage
                .getOrderNameSecondCellLink())
                .as("In grid should be 2 or more orders!")
                .isDisplayed();

        merchandiserOrderingPage
                .getMaxDiscountHeaderButton()
                .click();
        assertThat(merchandiserOrderingPage
                .getMaxDiscountColumnLink())
                .isSortedByDescendDouble();
    }

    //To check is sorting function is available for Status column in the Admin Grid.
    @Test
    public final void testSortingStatusColumn() {

        assertThat(merchandiserOrderingPage
                .getOrderNameSecondCellLink())
                .as("In grid should be 2 or more orders!")
                .isDisplayed();

        merchandiserOrderingPage
                .getStatusHeaderButton()
                .click();

        assertThat(merchandiserOrderingPage
                .getStatusColumnLink())
                .isSortedByAscentStrings();
    }


    @Test
    public final void testMerchandiserGridNavigation() {

        final int quantityOfGridPages = Integer
                .parseInt(merchandiserOrderingPage
                        .getPageCount()
                        .getText());

        assertThat(merchandiserOrderingPage
                .getPageCount()).isParseIntMoreThan(1);

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
                .isParseIntEqualTo(2);

        merchandiserOrderingPage
                .getBackwardButton()
                .click();

        assertThat(merchandiserOrderingPage
                .getNumberOfGridPages())
                .isParseIntEqualTo(1);

        merchandiserOrderingPage
                .getLastButton()
                .click();

        assertThat(merchandiserOrderingPage
                .getNumberOfGridPages())
                .isParseIntEqualTo(quantityOfGridPages);

        merchandiserOrderingPage
                .getFirstButton()
                .click();
        assertThat(merchandiserOrderingPage
                .getNumberOfGridPages())
                .isParseIntEqualTo(1);
    }


    //Check how many users shows in the Merchandiser Grid, after click on the Show 5 or Show 10 buttons.
    @Test
    public final void testVisibleUsersInGrid() {

        assertThat(merchandiserOrderingPage
                .getPageCount())
                .isParseIntMoreThan(1);

        merchandiserOrderingPage
                .getResizeOrdersListLinks()
                .click();

        assertThat(merchandiserOrderingPage.getOrderNameColumnLink())
                .isMoreThan(5);

        assertThat(merchandiserOrderingPage
                .getOrderNameColumnLink())
                .isLessOrEqualsThan(10);

        merchandiserOrderingPage
                .getResizeOrdersListLinks()
                .click();

        assertThat(merchandiserOrderingPage
                .getOrderNameColumnLink())
                .isEqualTo(5);
    }

    // To check searching function in Merchandiser Grid by Status
    @Test
    public final void testSearchForStatusFilter() {

        merchandiserOrderingPage
                .getSearchDropdown()
                .sendKeys("Status");
        merchandiserOrderingPage
                .getSearchInput()
                .sendKeys("Nothing");
        merchandiserOrderingPage
                .getApplyButton()
                .click();

        assertThat(merchandiserOrderingPage
                .getOrderNameColumnLink())
                .isEqualTo(0);
    }

    // To check searching function in Merchandiser Grid by Status
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
                .getOrderNameColumnLink())
                .isEqualTo("OrderName7");
    }

}
