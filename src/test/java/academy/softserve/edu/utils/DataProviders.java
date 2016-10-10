package academy.softserve.edu.utils;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.CustomerOrderingPage;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    private static final String EXCEL_FILE = PropertiesReader.getDefaultProperty("excel.file");

    @DataProvider
    static public Object[][] testDataForAllUsersRole() {
        return new Object[][]{{Roles.ADMINISTRATOR}, {Roles.MERCHANDISER}, {Roles.SUPERVISOR}, {Roles.CUSTOMER}};
    }

    @DataProvider
    static public Object[][] testDataForMerchandiser() {
        return new Object[][]{
                {"vpupkin", "qwerty"}
        };
    }

    @DataProvider
    static final public Object[][] excelLogInDataForAllUsersRole() throws IOException {
        return ExcelReader
                .getArrayFromExcel(EXCEL_FILE, "sheet1");
    }

    @DataProvider
    static final public Object[][] oneColumnOfExcelLoginData() throws IOException {
        return ExcelReader
                .getColumnByName(EXCEL_FILE, "password", "sheet1");
    }

    @DataProvider
    static final public Object[][] oneColumnFromDefaultExcelFile() throws IOException {
        return ExcelReader
                .getColumnByName("password", "sheet1");
    }
}

