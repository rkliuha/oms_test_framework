package academy.softserve.edu.utils;

import academy.softserve.edu.domains.Order;
import academy.softserve.edu.domains.OrderItem;
import academy.softserve.edu.domains.Product;
import academy.softserve.edu.domains.User;
import academy.softserve.edu.enums.CustomerTypes;
import academy.softserve.edu.enums.Regions;
import academy.softserve.edu.enums.Roles;

//TODO rename
public final class TestUtil {

    private TestUtil() {

    }

    public static final int createValidUserInDB() {

        return DBHandler.createUser(User.newBuilder()
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

    public static final int createActiveProductInDB() {

        return DBHandler.createProduct(Product.newBuilder()
                .setId(0)
                .setProductActive(1)
                .setProductDescription("Original Irish Cream")
                .setProductName("Baileys")
                .setProductPrice(500.0)
                .build());
    }

    //  Quantity of Orders must be "<=6"
    public static final int createValidOrderInDB() {
        return DBHandler.createOrder(Order.newBuilder()
                .setId(0)
                .setDeliveryDate(null)
                .setGift(0)
                .setMaxDiscount(0)
                .setOrderDate("2016-11-15 23:25:00")
                .setOrderName("NewOrderName")
                .setOrderNumber(7)
                .setPreferableDeliveryDate("2016-11-14 19:10:00")
                .setTotalPrice(25)
                .setAssignee(8)
                .setCustomer(13)
                .setOrderStatusReference(1)
                .build()
        );
    }
}
