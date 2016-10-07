package academy.softserve.edu.tests.supervisor;


import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.SortUtil;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;

public class SupervisorTableTest extends TestRunner {


    @BeforeMethod
    public final void setSupervisorTableTests() {
        logInPage.logInAs(Roles.SUPERVISOR);

        userInfoPage = new UserInfoPage(driver);

        // after if logIn failure;
        assertThat(userInfoPage
                .getUserInfoFieldSet())
                .isDisplayed();

        itemManagementPage = userInfoPage.clickItemManagementTab();
    }


    // To check Admin table is enable or not. And Edit and Delete function is available
    @Test
    final public void testSupervisorTableIsEnable() {

        assertThat(itemManagementPage
                .getEditFirstProductCellLink())
                .isDisplayed();

        assertThat(itemManagementPage
                .getDeleteFirstProductCellLink())
                .isDisplayed();
    }

    // To check searching function in Supervisor Table by Name.
    @Test
    public final void testSearchForNameFilter() {

        itemManagementPage
                .getSearchFieldFilterDropdown()
                .sendKeys("Name");
        itemManagementPage
                .getSearchInput()
                .sendKeys("carabiner");
        itemManagementPage
                .getSearchButton()
                .click();

        assertThat(itemManagementPage
                .getFirstProductNameCellLink())
                .textEquals("carabiner");
    }

    // To check searching function in Supervisor Table by Description.
    @Test
    public final void testSearchForDescriptionFilter() {

        itemManagementPage
                .getSearchFieldFilterDropdown()
                .sendKeys("Description");
        itemManagementPage
                .getSearchInput()
                .sendKeys("climbing devices");
        itemManagementPage
                .getSearchButton()
                .click();

        assertThat(itemManagementPage
                .getFirstDescriptionProductCellLink())
                .textEquals("Climbing devices");
    }

    //Check how many products shows in the Supervisor Table, after click on the Show 5 or Show 10 buttons.
    @Test
    public final void testVisibleProductsInTable() {

        assertThat(itemManagementPage
                .getQuantityOfProducts())
                .isParseIntQuantityMoreThan(5);

        itemManagementPage
                .getResizeProductsListButton()
                .click();

        assertThat(itemManagementPage
                .getNameCellColumn())
                .isQuantityMoreThan(5);

        assertThat(itemManagementPage
                .getNameCellColumn())
                .isQuantityLessOrEqualsThan(10);

        itemManagementPage
                .getResizeProductsListButton()
                .click();

        assertThat(itemManagementPage
                .getNameCellColumn())
                .isQuantityEqualTo(5);
    }

    //To check is number of found products displays the actual number of products for this criterion.
    @Test
    public final void testRealSearchResult() {

        itemManagementPage
                .getSearchFieldFilterDropdown()
                .sendKeys("Name");
        itemManagementPage
                .getSearchInput()
                .sendKeys("carabiner");
        itemManagementPage
                .getSearchButton()
                .click();

        assertThat(itemManagementPage
                .getNameCellColumn())
                .isQuantityEqualTo(1);
    }

    //To check is sorting function is available for Name column in the Supervisor Table.
    @Test
    public final void testSortingNameColumn() {

        assertThat(itemManagementPage
                .getSearchByFieldSet())
                .isDisplayed();

        itemManagementPage
                .getNameHeaderButton()
                .click();

        boolean isSortedByAscent = SortUtil
                .isListSortedByAsc(itemManagementPage
                        .getNameCellColumn()
                        .getElements());

        assertThat(isSortedByAscent).isTrue();
    }

    //To check is sorting function is available for Description column in the Supervisor Table.
    @Test
    public final void testSortingDescriptionColumn() {

        assertThat(itemManagementPage
                .getSearchByFieldSet())
                .isDisplayed();

        itemManagementPage
                .getDescriptionHeaderButton()
                .click();

        boolean isSortedByAscent = SortUtil
                .isListSortedByAsc(itemManagementPage
                        .getDescriptionCellColumn()
                        .getElements());

        assertThat(isSortedByAscent).isTrue();
    }


    //To check is sorting function is available for Price column in the Supervisor Table.
    @Test
    public final void testSortingPriceColumn() {

        assertThat(itemManagementPage
                .getSearchByFieldSet())
                .isDisplayed();

        itemManagementPage
                .getPriceHeaderButton()
                .click();

        boolean isSortedByAscent = SortUtil
                .isListDoubleSortedByAscent(itemManagementPage
                        .getPriceCellColumn()
                        .getElements());

        assertThat(isSortedByAscent).isTrue();
    }


    @Test
    public final void testSupervisorTableNavigation() {

        int quantityOfGridsPages = Integer
                .parseInt(itemManagementPage
                        .getQuantityOfTablePages()
                        .getText());

        assertThat(itemManagementPage
                .getQuantityOfTablePages())
                .isParseIntQuantityMoreThan(1);

        assertThat(itemManagementPage
                .getFirstNavigationButton())
                .isDisabled();

        assertThat(itemManagementPage
                .getBackwardNavigationButton())
                .isDisabled();

        itemManagementPage
                .getForwardNavigationButton()
                .click();

        assertThat(itemManagementPage
                .getNumberOfTablePage())
                .isParseIntQuantityEqualTo(2);

        itemManagementPage
                .getBackwardNavigationButton()
                .click();

        assertThat(itemManagementPage
                .getNumberOfTablePage())
                .isParseIntQuantityEqualTo(1);

        itemManagementPage
                .getLastNavigationButton()
                .click();

        assertThat(itemManagementPage
                .getNumberOfTablePage())
                .isParseIntQuantityEqualTo(quantityOfGridsPages);

        itemManagementPage
                .getFirstNavigationButton()
                .click();

        assertThat(itemManagementPage
                .getNumberOfTablePage())
                .isParseIntQuantityEqualTo(1);
    }

}
