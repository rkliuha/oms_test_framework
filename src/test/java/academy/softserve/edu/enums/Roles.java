package academy.softserve.edu.enums;

public enum Roles {

    ADMINISTRATOR(1, "Administrator"),
    MERCHANDISER(2, "Merchandiser"),
    SUPERVISOR(3, "Supervisor"),
    CUSTOMER(4, "Customer");

    private final int roleReference;
    private final String roleName;

    Roles(final int roleReference, final String roleName) {
        this.roleReference = roleReference;
        this.roleName = roleName;
    }

    public static final String getRoleNameByReference(final int roleReference) {

        String roleName = null;
        for (final Roles role : Roles.values()) {
            if (role.roleReference == roleReference) {
                roleName = role.roleName;
            }
        }
        return roleName;
    }

    public final int getRoleReference() {
        return roleReference;
    }

    public final String getRoleName() {
        return roleName;
    }

}
