package academy.softserve.edu.utils;

import org.testng.annotations.DataProvider;

import static academy.softserve.edu.pageobjects.CustomerOrderingPage.SHOW_10_ITEMS_LINK;
import static academy.softserve.edu.pageobjects.CustomerOrderingPage.SHOW_5_ITEMS_LINK;

public class DataProviders {

    @DataProvider
    static final public Object[][] testDataForAllUsersRole() {
        return new Object[][]{{"iva", "qwerty"}, {"login1", "qwerty"}, {"login2", "qwerty"}, {"login3", "qwerty"}};
    }

    @DataProvider
    static final public Object[][] testDataForAdministrator() {
        return new Object[][]{
                {"iva", "qwerty"}
        };
    }

    @DataProvider
    static final public Object[][] testDataForMerchandiser() {
        return new Object[][]{
                {"login1", "qwerty"}
        };
    }

    @DataProvider
    static final public Object[][] testDataForSupervisor() {
        return new Object[][]{
                {"login2", "qwerty"}
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
    static final public Object[][] testDataForCustomer() {
        return new Object[][]{
                {"login4", "qwerty"}
        };
    }

}
