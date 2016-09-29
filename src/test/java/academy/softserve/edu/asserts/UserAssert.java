package academy.softserve.edu.asserts;

import academy.softserve.edu.domains.User;
import org.assertj.core.api.AbstractAssert;

import static academy.softserve.edu.utils.Logger.logFail;
import static academy.softserve.edu.utils.Logger.logPass;

//TODO improve logging possibility
public class UserAssert extends AbstractAssert<UserAssert, User> {

    UserAssert(final User actual) {
        super(actual, UserAssert.class);
    }

    public static final UserAssert assertThat(final User actual) {
        return new UserAssert(actual);
    }

    public final UserAssert userEquals(final User condition) {

        isNotNull();

        if (!condition.equals(actual)) {

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

        if (actual == null) {

            failWithMessage("Required user is null !");
            logFail("Assert <isNotNull> failed: required user is null");
        } else {
            logPass("Assert <isNotNull> passed");
        }
        return this;
    }

}
