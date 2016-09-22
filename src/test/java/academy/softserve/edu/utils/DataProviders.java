package academy.softserve.edu.utils;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    private static final String LINK_EXCEL_FILE = PropertiesReader.getProperty("LINK_EXCEL_FILE");

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


    @DataProvider
    static final public Object[][] excelLogInDataForAllUsersRole() throws IOException {
        return ExcelReader
                .saveDataInToArrayFromExcel(LINK_EXCEL_FILE, "sheet1");
    }


    @DataProvider
    static final public Object[][] oneColumnOfExcelLoginData() throws IOException {
        return ExcelReader
                .getColumnByName(LINK_EXCEL_FILE, "password", "sheet1");
    }


    @DataProvider
    static final public Object[][] oneColumnFromDefaultExcelFile() throws IOException {
        return ExcelReader
                .getColumnByNameDefaultFile("password", "sheet1");
    }
}
