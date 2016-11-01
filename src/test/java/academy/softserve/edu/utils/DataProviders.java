package academy.softserve.edu.utils;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.enums.administration_page.SearchConditions;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public final class DataProviders {

    private DataProviders() {
    }

    private static final String EXCEL_FILE = PropertiesReader.getDefaultProperty("excel.file");

    @DataProvider
    public static Object[][] testDataForAllUsersRole() {
        return new Object[][]{
                {Roles.ADMINISTRATOR},
                {Roles.MERCHANDISER},
                {Roles.SUPERVISOR},
                {Roles.CUSTOMER}};
    }

    @DataProvider
    public static final Object[][] excelLogInDataForAllUsersRole() throws IOException {
        return ExcelReader.getArrayFromExcel(EXCEL_FILE, "sheet1");
    }

    @DataProvider
    public static final Object[][] oneColumnOfExcelLoginData() throws IOException {
        return ExcelReader.getColumnByName(EXCEL_FILE, "password", "sheet1");
    }

    @DataProvider
    public static final Object[][] oneColumnFromDefaultExcelFile() throws IOException {
        return ExcelReader.getColumnByName("password", "sheet1");
    }


    @DataProvider
    public static final Object[][] testSearchingForAllColumnsFilter() {
        return new Object[][]{
                {SearchConditions.EQUALS, "Customer", "Customer"},
                {SearchConditions.NOT_EQUALS_TO, "Sarumjan", "Administrator"},
                {SearchConditions.STARTS_WITH, "C", "Customer"},
                {SearchConditions.CONTAINS, "Admin", "Administrator"},
                {SearchConditions.DOES_NOT_CONTAIN, "Admin", "Merchandiser"},

        };
    }

    @DataProvider
    public static final Object[][] testSearchingForFirstNameFilter() {
        return new Object[][]{
                {SearchConditions.EQUALS, "ivanka", "ivanka"},
                {SearchConditions.NOT_EQUALS_TO, "Sarumjan", "ivanka"},
                {SearchConditions.STARTS_WITH, "i", "ivanka"},
                {SearchConditions.CONTAINS, "ivank", "ivanka"},
                {SearchConditions.DOES_NOT_CONTAIN, "rom", "ivanka"},
        };
    }

    @DataProvider
    public static final Object[][] testSearchingForLastNameFilter() {
        return new Object[][]{
                {SearchConditions.EQUALS, "horoshko", "horoshko"},
                {SearchConditions.NOT_EQUALS_TO, "shram", "horoshko"},
                {SearchConditions.STARTS_WITH, "h", "horoshko"},
                {SearchConditions.CONTAINS, "horosh", "horoshko"},
                {SearchConditions.DOES_NOT_CONTAIN, "a", "horoshko"},
        };
    }

    @DataProvider
    public static final Object[][] testSearchingForLoginFilter() {
        return new Object[][]{
                {SearchConditions.EQUALS, "login1", "login1"},
                {SearchConditions.NOT_EQUALS_TO, "sha", "iva"},
                {SearchConditions.STARTS_WITH, "l", "login1"},
                {SearchConditions.CONTAINS, "login1", "login1"},
                {SearchConditions.DOES_NOT_CONTAIN, "login1", "iva"},
        };
    }

    @DataProvider
    public static final Object[][] testSearchingForRoleFilter() {
        return new Object[][]{
                {SearchConditions.EQUALS, "Merchandiser", "Merchandiser"},
                {SearchConditions.NOT_EQUALS_TO, "Administrator", "Merchandiser"},
                {SearchConditions.STARTS_WITH, "Cust", "Customer"},
                {SearchConditions.CONTAINS, "Merchandiser", "Merchandiser"},
                {SearchConditions.DOES_NOT_CONTAIN, "Administrator", "Merchandiser"},
        };
    }

    @DataProvider
    public static final Object[][] testSearchingForRegionFilter() {
        return new Object[][]{
                {SearchConditions.EQUALS, "West", "West"},
                {SearchConditions.NOT_EQUALS_TO, "West", "South"},
                {SearchConditions.STARTS_WITH, "North", "North"},
                {SearchConditions.CONTAINS, "South", "South"},
                {SearchConditions.DOES_NOT_CONTAIN, "East", "West"}
        };
    }
}

