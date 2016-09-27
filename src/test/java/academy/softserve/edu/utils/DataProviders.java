package academy.softserve.edu.utils;

import academy.softserve.edu.enums.Roles;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import static academy.softserve.edu.pageobjects.CustomerOrderingPage.SHOW_10_ITEMS_LINK;
import static academy.softserve.edu.pageobjects.CustomerOrderingPage.SHOW_5_ITEMS_LINK;

public class DataProviders {

    private static final String EXCEL_FILE = PropertiesReader.getDefaultProperty("EXCEL_FILE");

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

