package academy.softserve.edu.enums;

public enum Regions {

    NORTH(1, "North"),
    EAST(2, "East"),
    SOUTH(3, "South"),
    WEST(4, "West");

    private final int regionReference;
    private final String regionName;

    Regions(final int regionReference, final String regionName) {
        this.regionReference = regionReference;
        this.regionName = regionName;
    }

    public static final String getRegionNameByReference(final int regionReference) {

        String regionName = null;
        for (final Regions region : Regions.values()) {
            if (region.regionReference == regionReference) {
                regionName = region.regionName;
            }
        }
        return regionName;
    }

    public int getRegionReference() {
        return regionReference;
    }

    public String getRegionName() {
        return regionName;
    }
}
