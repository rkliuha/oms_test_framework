package academy.softserve.edu.dao.interfaces;

import academy.softserve.edu.domains.User;

import java.sql.SQLException;

public interface UserDao {

    void create(final User user) throws SQLException;
    User read(final int primaryKey) throws SQLException;
    void update(final User user) throws SQLException;
    void delete(final int primaryKey) throws SQLException;

}
