package academy.softserve.edu.utils;

import academy.softserve.edu.domains.User;
import academy.softserve.edu.enums.CustomerTypes;
import academy.softserve.edu.enums.Regions;
import academy.softserve.edu.enums.Roles;

public final class TestUtil {

    private TestUtil() {

    }

    public static final void createValidUserInDB() {

        DBHandler.createUser(User.newBuilder()
                .setId(0)
                .setUserActive(1)
                .setBalance(20000)
                .setEmail("email@mail.ua")
                .setFirstName("Miranda")
                .setLastName("Lawson")
                .setLogin("justlogin")
                .setPassword("12345")
                .setCustomerTypeReference(CustomerTypes.STANDART.ordinal() + 1)
                .setRegionReference(Regions.NORTH.ordinal() + 1)
                .setRoleReference(Roles.CUSTOMER.ordinal() + 1)
                .build());
    }

}
