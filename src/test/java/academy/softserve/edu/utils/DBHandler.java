package academy.softserve.edu.utils;

import academy.softserve.edu.dao.MySQLDaoFactory;
import academy.softserve.edu.dao.interfaces.DaoFactory;
import academy.softserve.edu.dao.interfaces.UserDao;
import academy.softserve.edu.domains.User;

import java.sql.Connection;
import java.sql.SQLException;

public final class DBHandler {

    private DBHandler() {

    }

    public static final void createUser(final User user) throws SQLException {
        final DaoFactory daoFactory = new MySQLDaoFactory();
        final Connection connection = daoFactory.getConnection();
        final UserDao userDao = daoFactory.getUserDao(connection);
        userDao.create(user);
    }

    public static final User getUser(final int primaryKey) throws SQLException {
        final DaoFactory daoFactory = new MySQLDaoFactory();
        final Connection connection = daoFactory.getConnection();
        final UserDao userDao = daoFactory.getUserDao(connection);
        return userDao.read(primaryKey);
    }

    public static final void updateUser(final User user) throws SQLException {
        final DaoFactory daoFactory = new MySQLDaoFactory();
        final Connection connection = daoFactory.getConnection();
        final UserDao userDao = daoFactory.getUserDao(connection);
        userDao.update(user);
    }

    public static final void deleteUser(final int primaryKey) throws SQLException {
        final DaoFactory daoFactory = new MySQLDaoFactory();
        final Connection connection = daoFactory.getConnection();
        final UserDao userDao = daoFactory.getUserDao(connection);
        userDao.delete(primaryKey);
    }

}
