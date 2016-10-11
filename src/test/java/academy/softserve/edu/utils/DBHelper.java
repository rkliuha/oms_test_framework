package academy.softserve.edu.utils;

import academy.softserve.edu.repos.OrderItemRepo;
import academy.softserve.edu.repos.OrderRepo;
import academy.softserve.edu.repos.ProductRepo;
import academy.softserve.edu.repos.UserRepo;

public final class DBHelper {

    private DBHelper() {

    }

    public static final int createValidUserInDB() {

        return DBHandler.createUser(UserRepo.getValidUser());
    }

    public static final int createActiveProductInDB() {

        return DBHandler.createProduct(ProductRepo.getValidProduct());
    }

    //  Quantity of Orders must be "<=6"
    public static final int createValidOrderInDB() {

        return DBHandler.createOrder(OrderRepo.getValidOrder());
    }

    public static final int createOrderItemInDB() {

        return DBHandler.createOrderItem(OrderItemRepo.getValidOrderItem());
    }
}
