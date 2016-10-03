package academy.softserve.edu.tests.administrator;


import academy.softserve.edu.domains.User;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.TestRunner;
import academy.softserve.edu.utils.TestUtil;
import com.google.common.collect.Ordering;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.elements.locators.administrator.AdministrationPageLocators.*;

public class AdminGridTest extends TestRunner {

    private User lastAddedUserForUpdate;

    @BeforeMethod
    public final void setAdminGridTests() {
        logInPage
                .logInAs(Roles
                        .ADMINISTRATOR);

        userInfoPage = new UserInfoPage(driver);

        // after if logIn failure;
        Assert.assertTrue(userInfoPage
                        .getUserInfoFieldSet()
                        .isDisplayed(),
                "LogIn failed!");

        administrationPage =
                userInfoPage
                        .clickAdministrationTab();
    }


    // To check Admin grid is enable or not. And Edit and Delete function is available
    @Test
    final public void testAdminGridIsEnable() {

        Assert.assertTrue(administrationPage
                        .getEditFirstUserCellLink()
                        .isDisplayed(),
                "Edit function should be available! or There is no any users in the grid!");

        Assert
                .assertTrue(administrationPage
                                .getDeleteFirstUserCellLink()
                                .isDisplayed(),
                        "Delete user function should be available!");
    }


    // To check searching function in Admin Grid with first filter All Columns.
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForAllColumnsFilter")
    public final void testSearchForAllColumnsFilter(final String secondSearchFilter,
                                                    final String searchingValue, final String comparisonValue) {

        administrationPage
                .selectFirstFilterValue("All columns")
                .selectSecondFilterValue(secondSearchFilter)
                .putValueToTextBoxAndClick(searchingValue);

        Assert
                .assertTrue(comparisonValue
                                .equalsIgnoreCase(administrationPage
                                        .getRoleFirstCellLink()
                                        .getText()),
                        "With filters: All columns and " + secondSearchFilter + " Searching function is failed");
    }


    // To check searching function in Admin Grid with first filter First Name.
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForFirstNameFilter")
    public final void testSearchForFirstNameFilter(final String secondSearchFilter,
                                                   final String searchingValue, final String comparisonValue) {

        administrationPage
                .selectFirstFilterValue("First Name")
                .selectSecondFilterValue(secondSearchFilter)
                .putValueToTextBoxAndClick(searchingValue);

        Assert
                .assertTrue(comparisonValue
                                .equalsIgnoreCase(administrationPage
                                        .getFirstNameFirstCellLink()
                                        .getText()),
                        "With filters First Name and " + secondSearchFilter + " Searching function is failed");
    }


    // To check searching function in Admin Grid with first filter Last Name
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForLastNameFilter")
    public final void testSearchForLastNameFilter(final String secondSearchFilter,
                                                  final String searchingValue, final String comparisonValue) {

        administrationPage
                .selectFirstFilterValue("Last Name")
                .selectSecondFilterValue(secondSearchFilter)
                .putValueToTextBoxAndClick(searchingValue);

        Assert
                .assertTrue(comparisonValue
                                .equalsIgnoreCase(administrationPage
                                        .getLastNameFirstCellLink()
                                        .getText()),
                        "With filters Last Name and " + secondSearchFilter + " Searching function is failed");
    }


    // To check searching function in Admin Grid with first filter Login.
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForLoginFilter")
    public final void testSearchForLoginFilter(final String secondSearchFilter,
                                               final String searchingValue, final String comparisonValue) {

        administrationPage
                .selectFirstFilterValue("Login")
                .selectSecondFilterValue(secondSearchFilter)
                .putValueToTextBoxAndClick(searchingValue);

        Assert
                .assertTrue(comparisonValue
                                .equalsIgnoreCase(administrationPage
                                        .getLoginFirstCellLink()
                                        .getText()),
                        "With filters Login and " + secondSearchFilter + " Searching function is failed");
    }


    // To check searching function in Admin Grid with first filter Role.
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForRoleFilter")
    public final void testSearchForRoleFilter(final String secondSearchFilter,
                                              final String searchingValue, final String comparisonValue) {

        administrationPage
                .selectFirstFilterValue("Role")
                .selectSecondFilterValue(secondSearchFilter)
                .putValueToTextBoxAndClick(searchingValue);

        Assert
                .assertTrue(comparisonValue
                                .equalsIgnoreCase(administrationPage
                                        .getRoleFirstCellLink()
                                        .getText()),
                        "With filters Role and " + secondSearchFilter + " Searching function is failed");
    }


    // To check searching function in Admin Grid with first filter Region
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForRegionFilter")
    public final void testSearchForRegionFilter(final String secondSearchFilter,
                                                final String searchingValue, final String comparisonValue) {

        administrationPage
                .selectFirstFilterValue("Region")
                .selectSecondFilterValue(secondSearchFilter)
                .putValueToTextBoxAndClick(searchingValue);

        Assert
                .assertTrue(comparisonValue
                                .equalsIgnoreCase(administrationPage
                                        .getRegionFirstCellLink()
                                        .getText()),
                        "With filters Region and " + secondSearchFilter + " Searching function is failed");
    }

    //Check how many users shows in the Admin Grid, after click on the Show 5 or Show 10 buttons.
    @Test
    public final void testVisibleUsersInGrid() {

        int numberOfFoundUsers = Integer
                .parseInt(administrationPage
                        .getQuantityOfFoundUsers()
                        .getText());
        Assert
                .assertTrue(numberOfFoundUsers > 5,
                        "If we want to check Show 10 items, should found more than 5 users in the Admin Grid ");

        administrationPage
                .getShowQuantityOfItems()
                .click();
        Assert
                .assertTrue(administrationPage.getFirstNameColumn()
                                .getElements()
                                .size() > 5 &&
                                administrationPage
                                        .getLoginColumn()
                                        .getElements()
                                        .size() <= 10,
                        "Amount of visible users in the table, after click Show 10 Items," +
                                " should be in the range from 6 to 10");
        administrationPage
                .getShowQuantityOfItems()
                .click();

        Assert
                .assertTrue(administrationPage
                                .getLoginColumn()
                                .getElements()
                                .size() == 5,
                        "Amount of visible users in the table, after click Show 5 Items, should be 5");

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

        Assert
                .assertTrue(administrationPage
                                .getLoginColumn()
                                .getElements()
                                .size() == 1,
                        "Should be only 1 user with login justlogin!");

        DBHandler.deleteUser(DBHandler.getLastUser().getId());
    }


    //To check is sorting function is available for First Name column in the Admin Grid.
    @Test
    public final void testSortingFirstNameColumn() {

        Assert
                .assertTrue(administrationPage
                                .getLoginSecondCellLink()
                                .isDisplayed(),
                        "If we want to check sorting functions, in grid should be 2 or more users!");

        administrationPage
                .getFirstNameHeaderButton()
                .click();

        Assert
                .assertTrue(Ordering
                                .natural()
                                .isOrdered(administrationPage
                                        .pullStringsValueFromGetElements(FIRST_NAME_COLUMN
                                                .getBy())),
                        "First Name column data should be sorted by descend");
    }

    //To check is sorting function is available for Last Name column in the Admin Grid.
    @Test
    public final void testSortingLastNameColumn() {

        Assert
                .assertTrue(administrationPage
                                .getLoginSecondCellLink()
                                .isDisplayed(),
                        "If we want to check sorting functions, in grid should be 2 or more users!");

        administrationPage
                .getLastNameHeaderButton()
                .click();

        Assert
                .assertTrue(Ordering
                                .natural()
                                .isOrdered(administrationPage
                                        .pullStringsValueFromGetElements(LAST_NAME_COLUMN.getBy())),
                        "Last Name column data should be sorted by descend");
    }

    //To check is sorting function is available for Login column in the Admin Grid.
    @Test
    public final void testSortingLoginColumn() {


        Assert
                .assertTrue(administrationPage
                                .getLoginSecondCellLink()
                                .isDisplayed(),
                        "If we want to check sorting functions, in grid should be 2 or more users!");

        administrationPage
                .getLoginHeaderButton()
                .click();

        Assert
                .assertTrue(Ordering
                                .natural()
                                .isOrdered(administrationPage
                                        .pullStringsValueFromGetElements(LOGIN_COLUMN.getBy())),
                        "Login column data should be sorted by descend");
    }

    //To check is sorting function is available for Role column in the Admin Grid.
    @Test
    public final void testSortingRoleColumn() {


        Assert
                .assertTrue(administrationPage
                                .getLoginSecondCellLink()
                                .isDisplayed(),
                        "If we want to check sorting functions, in grid should be 2 or more users!");

        administrationPage
                .getRoleHeaderButton();

        Assert
                .assertTrue(Ordering
                                .natural()
                                .isOrdered(administrationPage
                                        .pullStringsValueFromGetElements(ROLE_COLUMN.getBy())),
                        "Role column data data should be sorted by descend");
    }

    //To check is sorting function is available for Region column in the Admin Grid.
    @Test
    public final void testSortingGridsData() {


        Assert
                .assertTrue(administrationPage
                                .getLoginSecondCellLink()
                                .isDisplayed(),
                        "If we want to check sorting functions, in grid should be 2 or more users!");

        administrationPage
                .getRegionHeaderButton()
                .click();

        Assert
                .assertTrue(Ordering
                                .natural()
                                .isOrdered(administrationPage
                                        .pullStringsValueFromGetElements(REGION_COLUMN.getBy())),
                        "Region column data should be sorted by descend");
    }


    @Test
    public final void testAdminTableNavigation() {

        final int quantityOfGridsPages = Integer
                .parseInt(administrationPage
                        .getPageCountText()
                        .getText());

        Assert
                .assertTrue(quantityOfGridsPages >= 2,
                        "If we want to check navigation functions, should be more than 5 users in the Admin Grid ");
        Assert
                .assertFalse(administrationPage
                                .getFirstNavigationButton()
                                .isEnabled() &&
                                administrationPage
                                        .getBackwardNavigationButton()
                                        .isEnabled(),
                        "FIRST and BACKWARD buttons should be disabled at the first page of the Admin Grid  ");

        administrationPage
                .getForwardNavigationButton()
                .click();
        Assert
                .assertTrue(Integer
                                .parseInt(administrationPage
                                        .getPageNumberText()
                                        .getText()) == 2,
                        "After FORWARD buttons click should shows the next page of the table");

        administrationPage
                .getBackwardNavigationButton()
                .click();
        Assert
                .assertTrue(Integer
                                .parseInt(administrationPage
                                        .getPageNumberText()
                                        .getText()) == 1,
                        "After BACKWARD buttons click should shows previous AdminGrid page");

        administrationPage
                .getLastNavigationButton()
                .click();
        Assert
                .assertTrue(Integer
                                .parseInt(administrationPage
                                        .getPageNumberText()
                                        .getText()) == quantityOfGridsPages,
                        "After LAST button click should shows last page in the Admin Grid");

        administrationPage
                .getFirstNavigationButton()
                .click();
        Assert
                .assertTrue(Integer
                                .parseInt(administrationPage
                                        .getPageNumberText()
                                        .getText()) == 1,
                        "After FIRST button click should shows first page in the Admin Grid");
    }

}
