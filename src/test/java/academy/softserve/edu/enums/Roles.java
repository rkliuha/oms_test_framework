package academy.softserve.edu.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Roles {

    ADMINISTRATOR,
    MERCHANDISER,
    SUPERVISOR,
    CUSTOMER;

    public static final String getRoleNameByReference(final int roleReference) {

        return Arrays.stream(Roles.values())
                .filter(roles -> (roles.ordinal() + 1) == roleReference)
                .map(Enum::toString)
                .collect(Collectors.joining());
    }

}
