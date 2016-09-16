package academy.softserve.edu.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Regions {

    NORTH,
    EAST,
    SOUTH,
    WEST;

    public static final String getRegionNameByReference(final int regionReference) {

        return Arrays.stream(Regions.values())
                .filter(regions -> (regions.ordinal() + 1) == regionReference)
                .map(Enum::toString)
                .collect(Collectors.joining());
    }

}
