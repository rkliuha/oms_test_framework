package academy.softserve.edu.repos;

import academy.softserve.edu.domains.OrderItem;

public class OrderItemRepo {

    public OrderItemRepo() {

    }

    public static OrderItem orderItemRepo() {

        return OrderItem.newBuilder()
                .setId(0)
                .setCost(7500.0)
                .setItemPrice(500.0)
                .setQuantity(3)
                .setDimensionReference(2)
                .setOrderReference(7)
                .setProductReference(6)
                .build();
    }
}