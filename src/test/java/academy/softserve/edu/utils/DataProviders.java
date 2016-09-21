package academy.softserve.edu.utils;

import academy.softserve.edu.enums.Roles;
import org.testng.annotations.DataProvider;

import static academy.softserve.edu.utils.TestRunner.CONFIG_PROPERTIES;

public class DataProviders {

    @DataProvider
    static public Object[][] testDataForAllUsersRole() {
        return new Object[][]{{Roles.ADMINISTRATOR}, {Roles.MERCHANDISER}, {Roles.SUPERVISOR}, {Roles.CUSTOMER}};
    }

    @DataProvider
    static public Object[][] testDataForAdministrator() {
        return new Object[][]{
                {Roles.ADMINISTRATOR}
        };
    }

    @DataProvider
    static public Object[][] testDataForMerchandiser() {
        return new Object[][]{
                {Roles.MERCHANDISER}
        };
    }

    @DataProvider
    static public Object[][] testDataForSupervisor() {
        return new Object[][]{
                {Roles.SUPERVISOR}
        };
    }


    @DataProvider
    static public Object[][] testDataForCustomer() {
        return new Object[][]{
                {Roles.CUSTOMER}
        };
    }

    @DataProvider
    static public Object[][] testDataForInvalidUser() {
        return new Object[][]{
                {Roles.INVALID_USER}
        };
    }

}
