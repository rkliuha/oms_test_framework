package academy.softserve.edu.enums;

public enum Roles {

    ADMINISTRATOR(1, "Administrator"),
    MERCHANDISER(2, "Merchandiser"),
    SUPERVISOR(3, "Supervisor"),
    CUSTOMER(4, "Customer");

    private final int roleRef;
    private final String roleName;

    Roles(final int roleRef, final String roleName) {
        this.roleRef = roleRef;
        this.roleName = roleName;
    }

    public static final String getRoleName(final int roleRef) {
        String roleName = null;
        for (Roles role : Roles.values()) {
            if (role.roleRef == roleRef) {
                roleName = role.roleName;
            }
        }
        return roleName;
    }

}
