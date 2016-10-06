package academy.softserve.edu.tests.administrator;


import academy.softserve.edu.domains.User;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class AdminTableTest extends TestRunner {

    private User lastAddedUserForUpdate;

    @BeforeMethod
    public final void setAdminTableTests() {
        logInPage.logInAs(Roles.ADMINISTRATOR);

        userInfoPage = new UserInfoPage(driver);

        // after if logIn failure;
        assertThat(userInfoPage
                .getUserInfoFieldSet())
                .isDisplayed();

        administrationPage = userInfoPage.clickAdministrationTab();
    }


    // To check Admin table is enable or not. And Edit and Delete function is available
    @Test
    final public void testAdminTableIsEnable() {

        assertThat(administrationPage
                .getEditFirstUserCellLink())
                .isDisplayed();

        assertThat(administrationPage
                .getDeleteFirstUserCellLink())
                .isDisplayed();
    }


    // To check searching function in Admin Table with first filter All Columns.
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForAllColumnsFilter")
    public final void testSearchForAllColumnsFilter(final String secondSearchFilter,
                                                    final String searchingValue, final String comparisonValue) {

        administrationPage
                .getSearchFieldFilterDropdown()
                .sendKeys("All columns");
        administrationPage
                .getSearchConditionDropdown()
                .sendKeys(secondSearchFilter);
        administrationPage
                .getSearchInput()
                .sendKeys(searchingValue);
        administrationPage
                .getSearchButton()
                .click();

        assertThat(administrationPage
                .getRoleFirstCellLink())
                .textEquals(comparisonValue);
    }


    // To check searching function in Admin Table with first filter First Name.
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForFirstNameFilter")
    public final void testSearchForFirstNameFilter(final String secondSearchFilter,
                                                   final String searchingValue, final String comparisonValue) {

        administrationPage
                .getSearchFieldFilterDropdown()
                .sendKeys("First Name");
        administrationPage
                .getSearchConditionDropdown()
                .sendKeys(secondSearchFilter);
        administrationPage
                .getSearchInput()
                .sendKeys(searchingValue);
        administrationPage
                .getSearchButton()
                .click();

        assertThat(administrationPage
                .getFirstNameFirstCellLink())
                .textEquals(comparisonValue);
    }


    // To check searching function in Admin Table with first filter Last Name
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForLastNameFilter")
    public final void testSearchForLastNameFilter(final String secondSearchFilter,
                                                  final String searchingValue, final String comparisonValue) {

        administrationPage
                .getSearchFieldFilterDropdown()
                .sendKeys("Last Name");
        administrationPage
                .getSearchConditionDropdown()
                .sendKeys(secondSearchFilter);
        administrationPage
                .getSearchInput()
                .sendKeys(searchingValue);
        administrationPage
                .getSearchButton()
                .click();

        assertThat(administrationPage
                .getLastNameFirstCellLink())
                .textEquals(comparisonValue);
    }


    // To check searching function in Admin Table with first filter Login.
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForLoginFilter")
    public final void testSearchForLoginFilter(final String secondSearchFilter,
                                               final String searchingValue, final String comparisonValue) {
        administrationPage
                .getSearchFieldFilterDropdown()
                .sendKeys("Login");
        administrationPage
                .getSearchConditionDropdown()
                .sendKeys(secondSearchFilter);
        administrationPage
                .getSearchInput()
                .sendKeys(searchingValue);
        administrationPage
                .getSearchButton()
                .click();

        assertThat(administrationPage
                .getLoginFirstCellLink())
                .textEquals(comparisonValue);
    }


    // To check searching function in Admin Table with first filter Role.
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForRoleFilter")
    public final void testSearchForRoleFilter(final String secondSearchFilter,
                                              final String searchingValue, final String comparisonValue) {

        administrationPage
                .getSearchFieldFilterDropdown()
                .sendKeys("Role");
        administrationPage
                .getSearchConditionDropdown()
                .sendKeys(secondSearchFilter);
        administrationPage
                .getSearchInput()
                .sendKeys(searchingValue);
        administrationPage
                .getSearchButton()
                .click();

        assertThat(administrationPage
                .getRoleFirstCellLink())
                .textEquals(comparisonValue);

    }


    // To check searching function in Admin Table with first filter Region
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForRegionFilter")
    public final void testSearchForRegionFilter(final String secondSearchFilter,
                                                final String searchingValue, final String comparisonValue) {

        administrationPage
                .getSearchFieldFilterDropdown()
                .sendKeys("Region");
        administrationPage
                .getSearchConditionDropdown()
                .sendKeys(secondSearchFilter);
        administrationPage
                .getSearchInput()
                .sendKeys(searchingValue);
        administrationPage
                .getSearchButton()
                .click();

        assertThat(administrationPage
                .getRegionFirstCellLink())
                .textEquals(comparisonValue);
    }

    //Check how many users shows in the Admin Table, after click on the Show 5 or Show 10 buttons.
    @Test
    public final void testVisibleUsersInTable() {
//TODO to re-consider asserts for comparison with numbers
        assertThat(administrationPage
                .getQuantityOfFoundUsers())
                .isParseIntQuantityMoreThan(5);

        administrationPage
                .getShowQuantityOfItems()
                .click();
//TODO to re-consider asserts for comparison with numbers
        assertThat(administrationPage
                .getFirstNameColumn())
                .isQuantityMoreThan(5);
//TODO to re-consider asserts for comparison with numbers
        assertThat(administrationPage
                .getFirstNameColumn())
                .isLessOrEqualsThan(10);

        administrationPage
                .getShowQuantityOfItems()
                .click();
//TODO to re-consider asserts for comparison with numbers
        assertThat(administrationPage
                .getFirstNameColumn())
                .isEqualTo(5);
    }


    //To check is number of found users displays the actual number of users for this criterion.
    @Test
    public final void testRealSearchResult() {

        TestUtil
                .createValidUserInDB();
        lastAddedUserForUpdate = DBHandler
                .getLastUser();

        administrationPage
                .getSearchFieldFilterDropdown()
                .sendKeys("Login");
        administrationPage
                .getSearchConditionDropdown()
                .sendKeys("equals");
        administrationPage
                .getSearchInput()
                .sendKeys("justlogin");
        administrationPage
                .getSearchButton()
                .click();
//TODO to re-consider asserts for comparison with numbers
        assertThat(administrationPage
                .getLoginColumn())
                .isEqualTo(1);

        DBHandler.deleteUser(DBHandler.getLastUser().getId());
    }


    //To check is sorting function is available for First Name column in the Admin Grid.
    @Test
    public final void testSortingFirstNameColumn() {

        assertThat(administrationPage
                .getLoginSecondCellLink())
                .isDisplayed();

        administrationPage
                .getFirstNameHeaderButton()
                .click();

        boolean isSortedByAscent = SortUtil
                .isListSortedByAsc(administrationPage
                        .getFirstNameColumn());

        assertThat(administrationPage
                .getFirstNameColumn())
                .isTrue(isSortedByAscent);
    }

    //To check is sorting function is available for Last Name column in the Admin Table.
    @Test
    public final void testSortingLastNameColumn() {

        assertThat(administrationPage
                .getLoginSecondCellLink())
                .isDisplayed();

        administrationPage
                .getLastNameHeaderButton()
                .click();

        boolean isSortedByAscent = SortUtil
                .isListSortedByAsc(administrationPage
                        .getLastNameColumn());

        assertThat(administrationPage
                .getLastNameColumn())
                .isTrue(isSortedByAscent);


    }

    //To check is sorting function is available for Login column in the Admin Table.
    @Test
    public final void testSortingLoginColumn() {

        assertThat(administrationPage
                .getLoginSecondCellLink())
                .isDisplayed();

        administrationPage
                .getLoginHeaderButton()
                .click();

        boolean isSortedByAscent = SortUtil
                .isListSortedByAsc(administrationPage
                        .getLoginColumn());

        assertThat(administrationPage
                .getLoginColumn())
                .isTrue(isSortedByAscent);
    }

    //To check is sorting function is available for Role column in the Admin Table.
    @Test
    public final void testSortingRoleColumn() {

        assertThat(administrationPage
                .getLoginSecondCellLink())
                .isDisplayed();

        administrationPage
                .getRoleHeaderButton()
                .click();

        boolean isSortedByAscent = SortUtil
                .isListSortedByAsc(administrationPage
                        .getRoleColumn());

        assertThat(administrationPage
                .getRoleColumn())
                .isTrue(isSortedByAscent);
    }

    //To check is sorting function is available for Region column in the Admin Table.
    @Test
    public final void testSortingTablesData() {

        assertThat(administrationPage
                .getLoginSecondCellLink())
                .isDisplayed();

        administrationPage
                .getRegionHeaderButton()
                .click();

        boolean isSortedByAscent = SortUtil
                .isListSortedByAsc(administrationPage
                        .getRegionColumn());

        assertThat(administrationPage
                .getRegionColumn())
                .isTrue(isSortedByAscent);
    }


    @Test
    public final void testAdminTableNavigation() {

        int quantityOfGridsPages = Integer
                .parseInt(administrationPage
                        .getPageCountText()
                        .getText());
//TODO to re-consider asserts for comparison with numbers
        assertThat(administrationPage
                .getPageCountText())
                .isParseIntMoreThan(1);

        assertThat(administrationPage
                .getFirstNavigationButton())
                .isDisabled();

        assertThat(administrationPage
                .getBackwardNavigationButton())
                .isDisabled();

        administrationPage
                .getForwardNavigationButton()
                .click();
//TODO to re-consider asserts for comparison with numbers
        assertThat(administrationPage
                .getPageNumberText())
                .isParseIntEqualTo(2);

        administrationPage
                .getBackwardNavigationButton()
                .click();
//TODO to re-consider asserts for comparison with numbers
        assertThat(administrationPage
                .getPageNumberText())
                .isParseIntEqualTo(1);

        administrationPage
                .getLastNavigationButton()
                .click();

        assertThat(administrationPage
                .getPageNumberText())
                .isParseIntEqualTo(quantityOfGridsPages);

        administrationPage
                .getFirstNavigationButton()
                .click();
//TODO to re-consider asserts for comparison with numbers
        assertThat(administrationPage
                .getPageNumberText())
                .isParseIntEqualTo(1);
    }

}
