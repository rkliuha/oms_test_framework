package academy.softserve.edu.enums;

public enum CustomerTypes {

    STANDART(1, "Standart"),
    SILVER(2, "Silver"),
    GOLD(3, "Gold"),
    PLATINUM(4, "Platinum");

    private final int customerTypeReference;
    private final String customerTypeName;

    CustomerTypes(final int customerTypeReference, final String customerTypeName) {
        this.customerTypeReference = customerTypeReference;
        this.customerTypeName = customerTypeName;
    }

    public static final String getCustomerTypeNameByReference(final int customerTypeReference) {

        String customerTypeName = null;
        for (final CustomerTypes customerType : CustomerTypes.values()) {
            if (customerType.customerTypeReference == customerTypeReference) {
                customerTypeName = customerType.customerTypeName;
            }
        }
        return customerTypeName;
    }

    public final int getCustomerTypeReference() {
        return customerTypeReference;
    }

    public final String getCustomerTypeName() {
        return customerTypeName;
    }
}
