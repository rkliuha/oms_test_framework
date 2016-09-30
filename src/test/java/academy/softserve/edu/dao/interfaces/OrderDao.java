package academy.softserve.edu.dao.interfaces;

import academy.softserve.edu.domains.Order;

public interface OrderDao {

    int createOrder(final Order order);

    Order getOrderById(final int orderId);

    Order getOrderByNumber(final int orderNumber);

    Order getLastOrder();

    void deleteOrderById(final int orderId);

    void deleteOrderByNumber(final int orderNumber);

}
