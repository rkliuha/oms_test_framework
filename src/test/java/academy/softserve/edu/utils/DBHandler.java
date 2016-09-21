package academy.softserve.edu.utils;

import academy.softserve.edu.dao.MySQLDaoFactory;
import academy.softserve.edu.dao.interfaces.DaoFactory;
import academy.softserve.edu.dao.interfaces.UserDao;
import academy.softserve.edu.domains.User;
import academy.softserve.edu.enums.Roles;

import java.sql.Connection;
import java.sql.SQLException;

public final class DBHandler {

    private DBHandler() {

    }

    public static final void createUser(final User user) {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final UserDao userDao;

        try (final Connection connection = daoFactory.getConnection()) {
            userDao = daoFactory.getUserDao(connection);
            userDao.createUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static final User getUserById(final int userId) {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final UserDao userDao;
        User user = null;

        try (final Connection connection = daoFactory.getConnection()) {
            userDao = daoFactory.getUserDao(connection);
            user = userDao.getUserById(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static final User getUserByRole(final Roles role) {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final UserDao userDao;
        User user = null;

        try (final Connection connection = daoFactory.getConnection()) {
            userDao = daoFactory.getUserDao(connection);
            user = userDao.getUserByRole(role);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static final User getLastUser() {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final UserDao userDao;
        User user = null;

        try (final Connection connection = daoFactory.getConnection()) {
            userDao = daoFactory.getUserDao(connection);
            user = userDao.getLastUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static final void updateUser(final User user) {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final UserDao userDao;

        try (final Connection connection = daoFactory.getConnection()) {
            userDao = daoFactory.getUserDao(connection);
            userDao.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static final void deleteUser(final int userId) {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final UserDao userDao;

        try (final Connection connection = daoFactory.getConnection()) {
            userDao = daoFactory.getUserDao(connection);
            userDao.deleteUser(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
