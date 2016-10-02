package academy.softserve.edu.dao;

import academy.softserve.edu.dao.interfaces.OrderDao;
import academy.softserve.edu.domains.Order;
import lombok.RequiredArgsConstructor;
import org.apache.xpath.operations.Or;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RequiredArgsConstructor
public class MySQLOrderDao implements OrderDao {

    private static final String CREATE_ORDER_QUERY = "INSERT INTO Orders(DeliveryDate," +
            " IsGift, MaxDiscount, OrderDate, OrderName, OrderNumber, PreferableDeliveryDate," +
            " TotalPrice, Assigne, Customer, OrderStatusRef) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String GET_ORDER_BY_ID_QUERY = "SELECT ID, DeliveryDate, IsGift, MaxDiscount," +
            " OrderDate, OrderName, OrderNumber, PreferableDeliveryDate, TotalPrice, Assigne, Customer," +
            " OrderStatusRef FROM Orders WHERE ID = ?;";
    private static final String GET_ORDER_BY_NUMBER_QUERY = "SELECT ID, DeliveryDate, IsGift, MaxDiscount," +
            " OrderDate, OrderName, OrderNumber, PreferableDeliveryDate, TotalPrice, Assigne, Customer," +
            " OrderStatusRef FROM Orders WHERE OrderNumber = ?;";
    private static final String GET_LAST_ORDER_QUERY = "SELECT ID, DeliveryDate, IsGift, MaxDiscount," +
            " OrderDate, OrderName, OrderNumber, PreferableDeliveryDate, TotalPrice, Assigne, Customer," +
            " OrderStatusRef FROM Orders ORDER BY ID DESC LIMIT 1;";
    private static final String DELETE_ORDER_BY_ID_QUERY = "DELETE FROM Orders WHERE ID = ?;";
    private static final String DELETE_ORDER_BY_NUMBER_QUERY = "DELETE FROM Orders WHERE OrderNumber = ?;";

    private final Connection connection;

    @Override
    public final void createOrder(final Order order) {
        try (final PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ORDER_QUERY)) {
            preparedStatement.setString(1, order.getDeliveryDate());
            preparedStatement.setInt(2, order.getGift());
            preparedStatement.setInt(3, order.getMaxDiscount());
            preparedStatement.setString(4, order.getOrderDate());
            preparedStatement.setString(5, order.getOrderName());
            preparedStatement.setInt(6, order.getOrderNumber());
            preparedStatement.setString(7, order.getPreferableDeliveryDate());
            preparedStatement.setInt(8, order.getTotalPrice());
            preparedStatement.setInt(9, order.getAssignee());
            preparedStatement.setInt(10, order.getCustomer());
            preparedStatement.setInt(11, order.getOrderStatusReference());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public final Order getOrderById(final int orderId) {

        Order order = null;
        try (final PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_ID_QUERY)) {
            preparedStatement.setInt(1, orderId);
            final ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            order = Order.newBuilder()
                    .setId(resultSet.getInt("ID"))
                    .setDeliveryDate(resultSet.getString("DeliveryDate"))
                    .setGift(resultSet.getInt("IsGift"))
                    .setMaxDiscount(resultSet.getInt("MaxDiscount"))
                    .setOrderDate(resultSet.getString("OrderDate"))
                    .setOrderName(resultSet.getString("OrderName"))
                    .setOrderNumber(resultSet.getInt("OrderNumber"))
                    .setPreferableDeliveryDate(resultSet.getString("PreferableDeliveryDate"))
                    .setTotalPrice(resultSet.getInt("TotalPrice"))
                    .setAssignee(resultSet.getInt("Assigne"))
                    .setCustomer(resultSet.getInt("Customer"))
                    .setOrderStatusReference(resultSet.getInt("OrderStatusRef"))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public final Order getOrderByNumber(final int orderNumber) {

        Order order = null;
        try (final PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_NUMBER_QUERY)) {
            preparedStatement.setInt(1, orderNumber);
            final ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            order = Order.newBuilder()
                    .setId(resultSet.getInt("ID"))
                    .setDeliveryDate(resultSet.getString("DeliveryDate"))
                    .setGift(resultSet.getInt("IsGift"))
                    .setMaxDiscount(resultSet.getInt("MaxDiscount"))
                    .setOrderDate(resultSet.getString("OrderDate"))
                    .setOrderName(resultSet.getString("OrderName"))
                    .setOrderNumber(resultSet.getInt("OrderNumber"))
                    .setPreferableDeliveryDate(resultSet.getString("PreferableDeliveryDate"))
                    .setTotalPrice(resultSet.getInt("TotalPrice"))
                    .setAssignee(resultSet.getInt("Assigne"))
                    .setCustomer(resultSet.getInt("Customer"))
                    .setOrderStatusReference(resultSet.getInt("OrderStatusRef"))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public final Order getLastOrder() {

        Order order = null;
        try (final PreparedStatement preparedStatement = connection.prepareStatement(GET_LAST_ORDER_QUERY)) {
            final ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            order = Order.newBuilder()
                    .setId(resultSet.getInt("ID"))
                    .setDeliveryDate(resultSet.getString("DeliveryDate"))
                    .setGift(resultSet.getInt("IsGift"))
                    .setMaxDiscount(resultSet.getInt("MaxDiscount"))
                    .setOrderDate(resultSet.getString("OrderDate"))
                    .setOrderName(resultSet.getString("OrderName"))
                    .setOrderNumber(resultSet.getInt("OrderNumber"))
                    .setPreferableDeliveryDate(resultSet.getString("PreferableDeliveryDate"))
                    .setTotalPrice(resultSet.getInt("TotalPrice"))
                    .setAssignee(resultSet.getInt("Assigne"))
                    .setCustomer(resultSet.getInt("Customer"))
                    .setOrderStatusReference(resultSet.getInt("OrderStatusRef"))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public final void deleteOrderById(final int orderId) {

        try (final PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_BY_ID_QUERY)) {
            preparedStatement.setInt(1, orderId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public final void deleteOrderByNumber(final int orderNumber) {

        try (final PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_BY_NUMBER_QUERY)) {
            preparedStatement.setInt(1, orderNumber);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
