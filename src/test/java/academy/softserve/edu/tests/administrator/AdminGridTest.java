package academy.softserve.edu.tests.administrator;


import academy.softserve.edu.domains.User;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.TestRunner;
import academy.softserve.edu.utils.TestUtil;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class AdminGridTest extends TestRunner {

    private User lastAddedUserForUpdate;

    @BeforeMethod
    public final void setAdminGridTests() {
        logInPage.logInAs(Roles.ADMINISTRATOR);

        userInfoPage = new UserInfoPage(driver);

        // after if logIn failure;
        assertThat(userInfoPage
                        .getUserInfoFieldSet())
                        .isDisplayed();

        administrationPage = userInfoPage.clickAdministrationTab();
    }


    // To check Admin grid is enable or not. And Edit and Delete function is available
    @Test
    final public void testAdminGridIsEnable() {

        assertThat(administrationPage
                        .getEditFirstUserCellLink())
                        .isDisplayed();

                assertThat(administrationPage
                                .getDeleteFirstUserCellLink())
                                .isDisplayed();
    }


    // To check searching function in Admin Grid with first filter All Columns.
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForAllColumnsFilter")
    public final void testSearchForAllColumnsFilter(final String secondSearchFilter,
                                                    final String searchingValue, final String comparisonValue) {

        administrationPage
                .selectFirstFilterValue("All columns")
                .selectSecondFilterValue(secondSearchFilter)
                .putValueToTextBoxAndClick(searchingValue);

        assertThat(administrationPage
                                        .getRoleFirstCellLink())
                .as( "With filters: All columns and " + secondSearchFilter + " Searching function is failed")
                .textEquals(comparisonValue);
    }


    // To check searching function in Admin Grid with first filter First Name.
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForFirstNameFilter")
    public final void testSearchForFirstNameFilter(final String secondSearchFilter,
                                                   final String searchingValue, final String comparisonValue) {

        administrationPage
                .selectFirstFilterValue("First Name")
                .selectSecondFilterValue(secondSearchFilter)
                .putValueToTextBoxAndClick(searchingValue);


                assertThat(administrationPage
                                        .getFirstNameFirstCellLink())
                .as("With filters First Name and " + secondSearchFilter + " Searching function is failed")
                .textEquals(comparisonValue);
    }


    // To check searching function in Admin Grid with first filter Last Name
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForLastNameFilter")
    public final void testSearchForLastNameFilter(final String secondSearchFilter,
                                                  final String searchingValue, final String comparisonValue) {

        administrationPage
                .selectFirstFilterValue("Last Name")
                .selectSecondFilterValue(secondSearchFilter)
                .putValueToTextBoxAndClick(searchingValue);

        assertThat(administrationPage
                .getLastNameFirstCellLink())
                .as("With filters Last Name and " + secondSearchFilter + " Searching function is failed")
                .textEquals(comparisonValue);
    }


    // To check searching function in Admin Grid with first filter Login.
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForLoginFilter")
    public final void testSearchForLoginFilter(final String secondSearchFilter,
                                               final String searchingValue, final String comparisonValue) {

        administrationPage
                .selectFirstFilterValue("Login")
                .selectSecondFilterValue(secondSearchFilter)
                .putValueToTextBoxAndClick(searchingValue);

        assertThat(administrationPage
                .getLoginFirstCellLink())
                .as("With filters Login and " + secondSearchFilter + " Searching function is failed")
                .textEquals(comparisonValue);
    }


    // To check searching function in Admin Grid with first filter Role.
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForRoleFilter")
    public final void testSearchForRoleFilter(final String secondSearchFilter,
                                              final String searchingValue, final String comparisonValue) {

        administrationPage
                .selectFirstFilterValue("Role")
                .selectSecondFilterValue(secondSearchFilter)
                .putValueToTextBoxAndClick(searchingValue);

        assertThat(administrationPage
                .getRoleFirstCellLink())
                .as("With filters Role and " + secondSearchFilter + " Searching function is failed")
                .textEquals(comparisonValue);

    }


    // To check searching function in Admin Grid with first filter Region
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForRegionFilter")
    public final void testSearchForRegionFilter(final String secondSearchFilter,
                                                final String searchingValue, final String comparisonValue) {

        administrationPage
                .selectFirstFilterValue("Region")
                .selectSecondFilterValue(secondSearchFilter)
                .putValueToTextBoxAndClick(searchingValue);

        assertThat(administrationPage
                .getRegionFirstCellLink())
                .as("With filters Region and " + secondSearchFilter + " Searching function is failed")
                .textEquals(comparisonValue);
    }

    //Check how many users shows in the Admin Grid, after click on the Show 5 or Show 10 buttons.
    @Test
    public final void testVisibleUsersInGrid() {

        assertThat(administrationPage
                .getQuantityOfFoundUsers())
                .as("If we want to check Show 10 items, should found more than 5 users in the Admin Grid ")
                .isParseMoreThan(5);
        
        administrationPage
                .getShowQuantityOfItems()
                .click();

        assertThat(administrationPage
                .getFirstNameColumn())
                .isMoreThan(5);

        assertThat(administrationPage
                .getFirstNameColumn())
                .isLessOrEqualsThan(10);

        administrationPage
                .getShowQuantityOfItems()
                .click();

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
                .selectFirstFilterValue("Login")
                .selectSecondFilterValue("equals")
                .putValueToTextBoxAndClick("justlogin");

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

        assertThat(administrationPage
                .getFirstNameColumn())
                .isSortedByAscent();
    }

    //To check is sorting function is available for Last Name column in the Admin Grid.
    @Test
    public final void testSortingLastNameColumn() {

        assertThat(administrationPage
                .getLoginSecondCellLink())
                .isDisplayed();

        administrationPage
                .getLastNameHeaderButton()
                .click();

        assertThat(administrationPage
                .getLastNameColumn())
                .isSortedByAscent();
    }

    //To check is sorting function is available for Login column in the Admin Grid.
    @Test
    public final void testSortingLoginColumn() {

        assertThat(administrationPage
                .getLoginSecondCellLink())
                .isDisplayed();

        administrationPage
                .getLoginHeaderButton()
                .click();

        assertThat(administrationPage
                .getLoginColumn())
                .isSortedByAscent();
    }

    //To check is sorting function is available for Role column in the Admin Grid.
    @Test
    public final void testSortingRoleColumn() {

        assertThat(administrationPage
                .getLoginSecondCellLink())
                .isDisplayed();

        administrationPage
                .getRoleHeaderButton();

        assertThat(administrationPage
                .getRoleColumn())
                .isSortedByAscent();
    }

    //To check is sorting function is available for Region column in the Admin Grid.
    @Test
    public final void testSortingGridsData() {

        assertThat(administrationPage
                .getLoginSecondCellLink())
                .isDisplayed();

        administrationPage
                .getRegionHeaderButton()
                .click();

        assertThat(administrationPage
                .getRegionColumn())
                .isSortedByAscent();
    }


    @Test
    public final void testAdminTableNavigation() {

        int quantityOfGridsPages = Integer
                .parseInt(administrationPage
                        .getPageCountText()
                        .getText());

        assertThat(administrationPage
                .getPageCountText())
                .as("If we want to check navigation functions, should be more than 5 users in the Admin Grid ")
                .isParseMoreThan(1);

        assertThat(administrationPage
                .getFirstNavigationButton())
                .isDisabled();

        assertThat(administrationPage
                .getBackwardNavigationButton())
                .isDisabled();

        administrationPage
                .getForwardNavigationButton()
                .click();

        assertThat(administrationPage
                .getPageNumberText())
                .as("After FORWARD buttons click should shows the next page of the table")
                .isParseEqualTo(2);

        administrationPage
                .getBackwardNavigationButton()
                .click();

        assertThat(administrationPage
                .getPageNumberText())
                .as("After BACKWARD buttons click should shows previous AdminGrid page")
                .isParseEqualTo(1);

        administrationPage
                .getLastNavigationButton()
                .click();

        assertThat(administrationPage
                .getPageNumberText())
                .as("After LAST button click should shows last page in the Admin Grid")
                .isParseEqualTo(quantityOfGridsPages);

        administrationPage
                .getFirstNavigationButton()
                .click();

        assertThat(administrationPage
                .getPageNumberText())
                .as( "After FIRST button click should shows first page in the Admin Grid")
                .isParseEqualTo(1);
    }

}
