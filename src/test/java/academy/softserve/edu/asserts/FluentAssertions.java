package academy.softserve.edu.asserts;

import academy.softserve.edu.domains.User;
import academy.softserve.edu.elements.wrappers.AbstractElement;

public class FluentAssertions {

    public static final AbstractElementAssert assertThat(final AbstractElement element) {
        return new AbstractElementAssert(element);
    }

    public static final UserAssert assertThat(final User user) {
        return new UserAssert(user);
    }

}