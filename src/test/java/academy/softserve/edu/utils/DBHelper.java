package academy.softserve.edu.utils;

import academy.softserve.edu.domains.Order;
import academy.softserve.edu.domains.OrderItem;
import academy.softserve.edu.domains.Product;
import academy.softserve.edu.domains.User;
import academy.softserve.edu.enums.CustomerTypes;
import academy.softserve.edu.enums.Regions;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.repos.OrderItemRepo;
import academy.softserve.edu.repos.OrderRepo;
import academy.softserve.edu.repos.ProductRepo;
import academy.softserve.edu.repos.UserRepo;

public final class DBHelper {

    private DBHelper() {

    }

    public static final int createValidUserInDB() {

        return DBHandler.createUser(UserRepo.userRepo());
    }

    public static final int createActiveProductInDB() {

        return DBHandler.createProduct(ProductRepo.productRepo());
    }

    //  Quantity of Orders must be "<=6"
    public static final int createValidOrderInDB() {

        return DBHandler.createOrder(OrderRepo.orderRepo());
    }

    public static final int createOrderItemInDB() {

        return DBHandler.createOrderItem(OrderItemRepo.orderItemRepo());
    }
}
