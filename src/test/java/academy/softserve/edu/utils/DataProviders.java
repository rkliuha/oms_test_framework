package academy.softserve.edu.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    static public Object[][] testDataForAdministrator() {
        return new Object[][]{{"iva", "qwerty"}, {"marko", "qwerty"}, {"myroslav", "qwerty"}, {"orest", "qwerty"},
                {"romanN", "qwerty"}, {"romanS", "qwerty"}, {"vitalik", "qwerty"}, {"vpupkin", "qwerty"}};
    }

    @DataProvider
    static public Object[][] testDataForCustomer() {
        return new Object[][]{{"vpopkin", "qwerty"}, {"login3", "qwerty"}, {"login4", "qwerty"}};
    }

    @DataProvider
    static public Object[][] testDataForMerchandiser() {
        return new Object[][]{{"login1", "qwerty"}};
    }

    @DataProvider
    static public Object[][] testDataForSupervisor() {
        return new Object[][]{{"login2", "qwerty"}};
    }
}
