package academy.softserve.edu.dao;

import academy.softserve.edu.dao.interfaces.*;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

//TODO not a factory, rename
public class MySQLDaoFactory implements DaoFactory {

    private static final String USERNAME = "oms";
    private static final String PASSWORD = "1qaz2wsx";
    private static final String DB_URL = "jdbc:mysql://192.168.56.101:3306/oms?allowMultiQueries=true";

    public MySQLDaoFactory() {
        try {
            final Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public final Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

    @Override
    public final UserDao getUserDao(final Connection connection) {
        return new MySQLUserDao(connection);
    }

    @Override
    public final ProductDao getProductDao(final Connection connection) {
        return new MySQLProductDao(connection);
    }

    @Override
    public final OrderDao getOrderDao(final Connection connection) {
        return new MySQLOrderDao(connection);
    }

    @Override
    public final OrderItemDao getOrderItemDao(final Connection connection) {
        return new MySQLOrderItemDao(connection);
    }

}
