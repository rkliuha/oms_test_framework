package academy.softserve.edu.asserts;

import academy.softserve.edu.domains.User;
import academy.softserve.edu.utils.Logger;
import org.assertj.core.api.AbstractAssert;

import static org.testng.Reporter.log;

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

        if (!user.equals(condition)) {

            failWithMessage("User does not equal to expected");
            log(Logger.logInfo("Assert <userEquals> failed: required user"
                    + "does not equal to actual"));
        } else {
            log(Logger.logInfo("Assert <userEquals> passed"));
        }
        return this;
    }

    @Override
    public final UserAssert isNotNull() {

        if (user == null) {

            failWithMessage("Required user is null !");
            log(Logger.logInfo("Assert <isNotNull> failed: required user is null"));
        } else {
            log(Logger.logInfo("Assert <isNotNull> passed"));
        }
        return this;
    }

}
