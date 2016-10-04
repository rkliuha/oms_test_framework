package academy.softserve.edu.utils;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.CustomerOrderingPage;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import static academy.softserve.edu.elements.locators.customer.CustomerOrderingPageLocators.SEARCH_STATUS_RESULT;

public class DataProviders {

    private static final String EXCEL_FILE = PropertiesReader.getDefaultProperty("excel.file");

    @DataProvider
    static public Object[][] testDataForAllUsersRole() {
        return new Object[][]{{Roles.ADMINISTRATOR}, {Roles.MERCHANDISER}, {Roles.SUPERVISOR}, {Roles.CUSTOMER}};
    }


    @DataProvider
    static final public Object[][] testData5SearchElementsCustomer() {
        return new Object[][]{
                {"2"},
                {"3"},
                {"4"},
                {"5"},
                {"6"}
        };
    }

    @DataProvider
    static final public Object[][] testData10SearchElementsCustomer() {
        return new Object[][]{
                {"2"},
                {"3"},
                {"4"},
                {"5"},
                {"6"},
                {"7"},
                {"8"},
                {"9"},
                {"10"},
                {"11"}
        };
    }

    @DataProvider
    static final public Object[][] testDataSearchStatusCustomer() {
        return new Object[][]{
                {"Status", "ordered", new CustomerOrderingPage(new TestRunner().getDriver()).getSearchStatusResult()},
                {"Order Name", "orderName1", new CustomerOrderingPage(new TestRunner().getDriver()).getSearchStatusResult()}
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

