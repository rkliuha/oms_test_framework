package academy.softserve.edu.utils;

import org.testng.annotations.DataProvider;

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
    static final public Object[][] testDataForCustomer() {
        return new Object[][]{
                {"vpopkin", "qwerty"}
        };
    }

}
