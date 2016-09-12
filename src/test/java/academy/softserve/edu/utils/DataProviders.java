package academy.softserve.edu.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    static public Object[][] testDataForMerchandiser() {
        return new Object[][]{
                {"login1", "qwerty"}
        };
    }

}
