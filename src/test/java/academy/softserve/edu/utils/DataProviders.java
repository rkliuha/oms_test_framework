package academy.softserve.edu.utils;

import academy.softserve.edu.enums.Roles;
import org.testng.annotations.DataProvider;

import static academy.softserve.edu.pageobjects.CustomerOrderingPage.SHOW_10_ITEMS_LINK;
import static academy.softserve.edu.pageobjects.CustomerOrderingPage.SHOW_5_ITEMS_LINK;

public class DataProviders {

    @DataProvider
    static public Object[][] testDataForAllUsersRole() {
        return new Object[][]{{Roles.ADMINISTRATOR}, {Roles.MERCHANDISER}, {Roles.SUPERVISOR}, {Roles.CUSTOMER}};
    }

    @DataProvider
    static public Object[][] testDataForAdministrator() {
        return new Object[][]{
                {Roles.ADMINISTRATOR}
        };
    }

    @DataProvider
    static public Object[][] testDataForMerchandiser() {
        return new Object[][]{
                {Roles.MERCHANDISER}
        };
    }

    @DataProvider
    static final public Object[][] testDataSearchElementsCustomer() {
        return new Object[][]{
                {"login4", "qwerty", SHOW_10_ITEMS_LINK, 10},
                {"login4", "qwerty", SHOW_5_ITEMS_LINK, 5}
        };
    }

    @DataProvider
    static final public Object[][] testDataSearchStatusCustomer() {
        return new Object[][]{
                {"login4", "qwerty", "Status", "ordered"},
                {"login4", "qwerty", "Order Name", "orderName1"}
        };
    }

    @DataProvider
    static public Object[][] testDataForSupervisor() {
        return new Object[][]{
                {Roles.SUPERVISOR}
        };
    }


    @DataProvider
    static public Object[][] testDataForCustomer() {
        return new Object[][]{
                {Roles.CUSTOMER}
        };
    }

    @DataProvider
    static public Object[][] testDataForInvalidUser() {
        return new Object[][]{
                {Roles.INVALID_USER}
        };
    }

}
