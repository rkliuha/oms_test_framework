package academy.softserve.edu.tests.administrator;


import academy.softserve.edu.domains.User;
import academy.softserve.edu.elements.locators.administrator.AdministrationPageLocators;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.AdministrationPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.TestRunner;
import academy.softserve.edu.utils.TestUtil;
import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import lombok.Getter;

import static org.testng.Assert.assertTrue;

public class AdminGridTest extends TestRunner {

    private User lastAddedUserForUpdate;

    @BeforeMethod
    public final void setAdminGridTests() {
        logInPage
                .logInAs(Roles
                        .ADMINISTRATOR);

        userInfoPage = new UserInfoPage(driver);

        // after if logIn failure;
        assertTrue(userInfoPage
                        .getIdentificationOfUserInfoPage()
                        .isDisplayed(),
                "LogIn failed!");

        administrationPage =
                userInfoPage
                        .clickAdministrationTab();
    }


    // To check Admin grid is enable or not. And Edit and Delete function is available
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSortingAdminGrid")
    final public void testAdminGridIsEnable() {

        Assert.assertTrue(administrationPage
                        .getElement(AdministrationPage.EDIT_USER_BUTTON_1)
                        .isDisplayed(),
                "Edit function should be available! or There is no any users in the grid!");

        Assert
                .assertTrue(administrationPage
                                .getElement(AdministrationPage.DELETE_USER_BUTTON_1)
                                .isDisplayed(),
                        "Delete user function should be available!");
    }

    //To check is sorting function is available for all columns in Admin Grid.
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSortingAdminGrid")
    public final void testSortingGridsData(final String headersName, final By columnHeader, final By adminsGridColumn) {

        Assert
                .assertTrue(administrationPage
                                .getElement(AdministrationPage.SECOND_LOGIN_VALUE)
                                .isDisplayed(),
                        "If we want to check sorting functions, in grid should be 2 or more users!");

        administrationPage
                .click(columnHeader);

        Assert
                .assertTrue(Ordering
                                .natural()
                                .isOrdered(administrationPage
                                        .pullStringsValueFromGetElements(adminsGridColumn)),
                        headersName + " data should be sorted by descend");
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
                                        .getElement(AdministrationPage.FIRST_ROLE_VALUE)
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
                                        .getElement(AdministrationPage.FIRST_FIRST_NAME_VALUE)
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
                                        .getElement(AdministrationPage.FIRST_LAST_NAME_VALUE)
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
                                        .getElement(AdministrationPage.FIRST_LOGIN_VALUE)
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
                                        .getElement(AdministrationPage.FIRST_ROLE_VALUE)
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
                                        .getElement(AdministrationPage.FIRST_REGION_VALUE)
                                        .getText()),
                        "With filters Region and " + secondSearchFilter + " Searching function is failed");
    }

    //Check how many users shows in the Admin Grid, after click on the Show 5 or Show 10 buttons.
    @Test
    public final void testVisibleUsersInGrid() {

        int numberOfFoundUsers = Integer
                .parseInt(administrationPage
                        .getElement(AdministrationPage.QUANTITY_OF_USERS)
                        .getText());
        Assert
                .assertTrue(numberOfFoundUsers > 5,
                        "If we want to check Show 10 items, should found more than 5 users in the Admin Grid ");

        administrationPage
                .getElement(AdministrationPage.SHOW_QUANTITY_OF_ITEMS)
                .click();
        Assert
                .assertTrue(administrationPage.getFirstNameColumn()
                                .size() > 5 &&
                                administrationPage
                                        .getElements(AdministrationPage.LOGIN_COLUMN)
                                        .size() <= 10,
                        "Amount of visible users in the table, after click Show 10 Items," +
                                " should be in the range from 6 to 10");
        administrationPage
                .getElement(AdministrationPage.SHOW_QUANTITY_OF_ITEMS)
                .click();

        Assert
                .assertTrue(administrationPage
                                .getElements(AdministrationPage.LOGIN_COLUMN)
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
                                .getElements(AdministrationPage.LOGIN_COLUMN)
                                .size() == 1,
                        "Should be only 1 user with login justlogin!");

        DBHandler.deleteUser(DBHandler.getLastUser().getId());
    }


    @Test
    public final void testAdminTableNavigation() {

        final int quantityOfGridsPages = Integer
                .parseInt(administrationPage
                        .getElement(AdministrationPage.QUANTITY_OF_GRIDS_PAGES)
                        .getText());

        Assert
                .assertTrue(quantityOfGridsPages >= 2,
                        "If we want to check navigation functions, should be more than 5 users in the Admin Grid ");
        Assert
                .assertFalse(administrationPage
                                .getElement(AdministrationPage.FIRST_BUTTON)
                                .isEnabled() &&
                                administrationPage
                                        .getElement(AdministrationPage.BACKWARD_BUTTON)
                                        .isEnabled(),
                        "FIRST and BACKWARD buttons should be disabled at the first page of the Admin Grid  ");

        administrationPage
                .clickForwardButton();
        Assert
                .assertTrue(Integer
                                .parseInt(administrationPage
                                        .getElement(AdministrationPage.GRIDS_PAGE_NUMBER)
                                        .getText()) == 2,
                        "After FORWARD buttons click should shows the next page of the table");

        administrationPage
                .clickBackwardButton();
        Assert
                .assertTrue(Integer
                                .parseInt(administrationPage
                                        .getElement(AdministrationPage.GRIDS_PAGE_NUMBER)
                                        .getText()) == 1,
                        "After BACKWARD buttons click should shows previous AdminGrid page");

        administrationPage
                .clickLastButton();
        Assert
                .assertTrue(Integer
                                .parseInt(administrationPage
                                        .getElement(AdministrationPage.GRIDS_PAGE_NUMBER)
                                        .getText()) == quantityOfGridsPages,
                        "After LAST button click should shows last page in the Admin Grid");

        administrationPage
                .clickFirstButton();
        Assert
                .assertTrue(Integer
                                .parseInt(administrationPage
                                        .getElement(AdministrationPage.GRIDS_PAGE_NUMBER)
                                        .getText()) == quantityOfGridsPages,
                        "After FIRST button click should shows first page in the Admin Grid");
    }
}
