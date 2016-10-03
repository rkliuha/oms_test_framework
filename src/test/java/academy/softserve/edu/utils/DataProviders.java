package academy.softserve.edu.utils;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.AdministrationPage;

import org.testng.annotations.DataProvider;

import java.io.IOException;

import static academy.softserve.edu.elements.locators.administrator.AdministrationPageLocators.*;
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


    @DataProvider
    static final public Object[][] testSearchingForAllColumnsFilter() {
        return new Object[][]{
                {"equals", "Customer", "Customer"},
                {"not equals to", "Sarumjan", "Administrator"},
                {"starts with", "C", "Customer"},
                {"contains", "Admin", "Administrator"},
                {"does not contain", "Admin", "Merchandiser"},

        };
    }

    @DataProvider
    static final public Object[][] testSearchingForFirstNameFilter() {
        return new Object[][]{
                {"equals", "ivanka", "ivanka"},
                {"not equals to", "Sarumjan", "ivanka"},
                {"starts with", "i", "ivanka"},
                {"contains", "ivank", "ivanka"},
                {"does not contain", "rom", "ivanka"},
        };
    }

    @DataProvider
    static final public Object[][] testSearchingForLastNameFilter() {
        return new Object[][]{
                {"equals", "horoshko", "horoshko"},
                {"not equals to", "shram", "horoshko"},
                {"starts with", "h", "horoshko"},
                {"contains", "horosh", "horoshko"},
                {"does not contain", "a", "horoshko"},
        };
    }

    @DataProvider
    static final public Object[][] testSearchingForLoginFilter() {
        return new Object[][]{
                {"equals", "login1", "login1"},
                {"not equals to", "sha", "iva"},
                {"starts with", "l", "login1"},
                {"contains", "login1", "login1"},
                {"does not contain", "login1", "iva"},
        };
    }

    @DataProvider
    static final public Object[][] testSearchingForRoleFilter() {
        return new Object[][]{
                {"equals", "Merchandiser", "Merchandiser"},
                {"not equals to", "Administrator", "Merchandiser"},
                {"starts with", "Cust", "Customer"},
                {"contains", "Merchandiser", "Merchandiser"},
                {"does not contain", "Administrator", "Merchandiser"},
        };
    }

    @DataProvider
    static final public Object[][] testSearchingForRegionFilter() {
        return new Object[][]{
                {"equals", "West", "West"},
                {"not equals to", "West", "South"},
                {"starts with", "North", "North"},
                {"contains", "South", "South"},
                {"does not contain", "East", "West"}
        };
    }
}

