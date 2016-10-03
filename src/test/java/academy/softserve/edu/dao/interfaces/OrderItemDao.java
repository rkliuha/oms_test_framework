package academy.softserve.edu.dao.interfaces;

import academy.softserve.edu.domains.OrderItem;

public interface OrderItemDao {

    int createOrderItem(final OrderItem orderItem);

    OrderItem getOrderItemById(final int orderItemId);

    OrderItem getOrderItemByReference(final int orderItemReference);

    OrderItem getLastOrderItem();

    void updateOrderItem(final OrderItem orderItem);

    void deleteOrderItemById(final int orderItemId);

    void deleteOrderItemByOrderRef(final int orderRef);

}
