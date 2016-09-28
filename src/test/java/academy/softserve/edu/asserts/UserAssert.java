package academy.softserve.edu.asserts;

import academy.softserve.edu.domains.User;
import org.assertj.core.api.AbstractAssert;

import static academy.softserve.edu.utils.Logger.logFail;
import static academy.softserve.edu.utils.Logger.logPass;

public class UserAssert extends AbstractAssert<UserAssert, User> {

    private final User user;

    UserAssert(final User user) {
        super(user, UserAssert.class);
        this.user = user;
    }

    public static final UserAssert assertThat(final User user) {
        return new UserAssert(user);
    }

    public final UserAssert userEquals(final User condition) {

        isNotNull();

        if (!condition.equals(user)) {

            failWithMessage("User does not equal to expected");
            logFail("Assert <userEquals> failed: required user"
                    + "does not equal to actual");
        } else {
            logPass("Assert <userEquals> passed");
        }
        return this;
    }

    @Override
    public final UserAssert isNotNull() {

        if (user == null) {

            failWithMessage("Required user is null !");
            logFail("Assert <isNotNull> failed: required user is null");
        } else {
            logPass("Assert <isNotNull> passed");
        }
        return this;
    }

}
