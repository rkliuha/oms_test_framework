package academy.softserve.edu.utils;

import org.testng.annotations.DataProvider;

import java.io.IOException;

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


    private static final String CONFIG_PROPERTIES = "src/resources/config.properties";
    private static final String LINK_EXCEL_DATA = PropertiesReader.getProperty("LINK_EXCEL_DATA", CONFIG_PROPERTIES);

    @DataProvider
    static final public Object[][] excelLogInDataForAllUsersRole() throws IOException {
        final Object[][] arrayObject = ExcelReader
                .saveDataInToArrayFromExcel(LINK_EXCEL_DATA);
        return arrayObject;
    }

    // defective provider
    @DataProvider
    static final public Object[][] oneColumnOfExcelLoginData() throws IOException {
        final Object[][] arrayObject = ExcelReader
                .getColumnByName(LINK_EXCEL_DATA, "password");
        return arrayObject;
    }
}
