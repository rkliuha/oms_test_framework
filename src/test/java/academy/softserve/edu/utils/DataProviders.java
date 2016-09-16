package academy.softserve.edu.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    static public Object[][] testDataForAllUsersRole() {
        return new Object[][]{{"iva", "qwerty"}, {"login1", "qwerty"}, {"login2", "qwerty"}, {"login3", "qwerty"}};
    }

    @DataProvider
    static public Object[][] testDataForAdministrator() {
        return new Object[][]{
                {"iva", "qwerty"}
        };
    }
}
