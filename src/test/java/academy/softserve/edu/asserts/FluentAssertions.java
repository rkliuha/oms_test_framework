package academy.softserve.edu.asserts;

import academy.softserve.edu.domains.User;
import academy.softserve.edu.elements.wrappers.AbstractElement;

public class FluentAssertions {

    public static final AbstractElementAssert assertThat(final AbstractElement actual) {
        return new AbstractElementAssert(actual);
    }

    public static final UserAssert assertThat(final User actual) {
        return new UserAssert(actual);
    }

}