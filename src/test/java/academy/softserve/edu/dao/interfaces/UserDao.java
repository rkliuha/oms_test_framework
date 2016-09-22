package academy.softserve.edu.dao.interfaces;

import academy.softserve.edu.domains.User;
import academy.softserve.edu.enums.Roles;

public interface UserDao {

    void createUser(final User user);

    User getUserById(final int userId);

    User getUserByRole(final Roles role);

    User getLastUser();

    void updateUser(final User user);

    void deleteUser(final int userId);

}
