package academy.softserve.edu.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    static public Object[][] testDataForMerchandiser() {
        return new Object[][]{
                {"login1", "qwerty"}
        };
    }


    @DataProvider
    static public Object[][] testDataForAdministrator() {
        return new Object[][]{
                {"RomanS", "qwerty"}
        };
    }


    @DataProvider
    static public Object[][] testDataForSupervisor() {
        return new Object[][]{
                {"login2", "qwerty"}
        };
    }


    @DataProvider
    static public Object[][] testDataForCustomer() {
        return new Object[][]{
                {"vpopkin", "qwerty"}
        };
    }
}
