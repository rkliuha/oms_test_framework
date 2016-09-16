package academy.softserve.edu.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum CustomerTypes {

    STANDART,
    SILVER,
    GOLD,
    PLATINUM;

    public static final String getCustomerTypeNameByReference(final int customerTypeReference) {

        return Arrays.stream(CustomerTypes.values())
                .filter(customerTypes -> (customerTypes.ordinal() + 1) == customerTypeReference)
                .map(Enum::toString)
                .collect(Collectors.joining());
    }

}
