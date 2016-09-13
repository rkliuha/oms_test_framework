package academy.softserve.edu.dao;

import academy.softserve.edu.domains.User;
import academy.softserve.edu.dao.interfaces.UserDao;

import java.sql.*;

public class MySQLUserDao implements UserDao {

    private static final String READ_QUERY = "SELECT ID, IsUserActive, Balance, Email,"
            + " FirstName, LastName, Login, Password, CustomerTypeRef, RegionRef," +
            " RoleRef FROM Users WHERE ID = ?;";
    private static final String CREATE_QUERY = "INSERT INTO Users (IsUserActive, Balance, Email,"
            + " FirstName, LastName, Login, Password, CustomerTypeRef, RegionRef," +
            " RoleRef) VALUES(?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?);";
    private static final String UPDATE_QUERY = "UPDATE Users SET IsUserActive = ?, Balance = ?, Email = ?,"
            + " FirstName = ?, LastName = ?, Login = ?, Password = ?, CustomerTypeRef = ?, RegionRef = ?," +
            " RoleRef = ? WHERE ID = ?;";
    private static final String DELETE_QUERY = "DELETE FROM Users WHERE ID = ?";

    private final Connection connection;
    private PreparedStatement preparedStatement;

    public MySQLUserDao(final Connection connection) {
        this.connection = connection;
    }

    @Override
    public final void create(final User user) throws SQLException {
        preparedStatement = connection.prepareStatement(CREATE_QUERY);
        preparedStatement.setInt(1, user.isUserActive());
        preparedStatement.setInt(2, user.getBalance());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getFirstName());
        preparedStatement.setString(5, user.getLastName());
        preparedStatement.setString(6, user.getLogin());
        preparedStatement.setString(7, user.getPassword());
        preparedStatement.setInt(8, user.getCustomerTypeRef());
        preparedStatement.setInt(9, user.getRegionRef());
        preparedStatement.setInt(10, user.getRoleRef());
        preparedStatement.execute();
    }

    @Override
    public final User read(final int primaryKey) throws SQLException {
        preparedStatement = connection.prepareStatement(READ_QUERY);
        preparedStatement.setInt(1, primaryKey);
        final ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        return User.newBuilder()
                .setId(resultSet.getInt("ID"))
                .setUserActive(resultSet.getInt("IsUserActive"))
                .setBalance(resultSet.getInt("Balance"))
                .setEmail(resultSet.getString("Email"))
                .setFirstName(resultSet.getString("FirstName"))
                .setLastName(resultSet.getString("LastName"))
                .setLogin(resultSet.getString("Login"))
                .setPassword(resultSet.getString("Password"))
                .setCustomerTypeRef(resultSet.getInt("CustomerTypeRef"))
                .setRegionRef(resultSet.getInt("RegionRef"))
                .setRoleRef(resultSet.getInt("RoleRef"))
                .build();
    }

    @Override
    public final void update(final User user) throws SQLException {
        preparedStatement = connection.prepareStatement(UPDATE_QUERY);
        preparedStatement.setInt(1, user.isUserActive());
        preparedStatement.setInt(2, user.getBalance());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getFirstName());
        preparedStatement.setString(5, user.getLastName());
        preparedStatement.setString(6, user.getLogin());
        preparedStatement.setString(7, user.getPassword());
        preparedStatement.setInt(8, user.getCustomerTypeRef());
        preparedStatement.setInt(9, user.getRegionRef());
        preparedStatement.setInt(10, user.getRoleRef());
        preparedStatement.setInt(11, user.getId());
        preparedStatement.execute();
    }

    @Override
    public final void delete(final int primaryKey) throws SQLException {
        preparedStatement = connection.prepareStatement(DELETE_QUERY);
        preparedStatement.setInt(1, primaryKey);
        preparedStatement.execute();
    }

}
