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
    static final public Object[][] testDataSearchElementsCustomer() {
        return new Object[][]{
                {SHOW_10_ITEMS_LINK, 10},
                {SHOW_5_ITEMS_LINK, 5}
        };
    }

    @DataProvider
    static final public Object[][] testDataSearchStatusCustomer() {
        return new Object[][]{
                {"Status", "ordered"},
                {"Order Name", "orderName1"}
        };
    }


    @DataProvider
    static public Object[][] testDataForMerchandiser() {
        return new Object[][]{
                {"vpupkin", "qwerty"}
        };
    }

}
