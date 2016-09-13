package academy.softserve.edu.domains;

import academy.softserve.edu.enums.Roles;

public class User {

    private int id;
    private int userActive;
    private int balance;
    private String email;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private int customerTypeRef;
    private int regionRef;
    private int roleRef;

    private User() {

    }

    public static FirstIdStep newBuilder() {
        return new Builder();
    }

    public interface FirstIdStep {
        UserActiveStep setId(final int id);
    }

    public interface UserActiveStep {
        BalanceStep setUserActive(final int userActive);
    }

    public interface BalanceStep {
        EmailStep setBalance(final int balance);
    }

    public interface EmailStep {
        FirstNameStep setEmail(final String email);
    }

    public interface FirstNameStep {
        LastNameStep setFirstName(final String firstName);
    }

    public interface LastNameStep {
        LoginStep setLastName(final String lastName);
    }

    public interface LoginStep {
        PasswordStep setLogin(final String login);
    }

    public interface PasswordStep {
        CustomerTypeRefStep setPassword(final String password);
    }

    public interface CustomerTypeRefStep {
        RegionRefStep setCustomerTypeRef(final int customerTypeRef);
    }

    public interface RegionRefStep {
        RoleRefStep setRegionRef(final int regionRef);
    }

    public interface RoleRefStep {
        BuildStep setRoleRef(final int roleRef);
    }

    public interface BuildStep {
        User build();
    }

    private static class Builder implements FirstIdStep, UserActiveStep, BalanceStep,
            EmailStep, FirstNameStep, LastNameStep, LoginStep, PasswordStep,
            CustomerTypeRefStep, RegionRefStep, RoleRefStep, BuildStep {

        private int id;
        private int userActive;
        private int balance;
        private String email;
        private String firstName;
        private String lastName;
        private String login;
        private String password;
        private int customerTypeRef;
        private int regionRef;
        private int roleRef;


        @Override
        public UserActiveStep setId(final int id) {
            this.id = id;
            return this;
        }

        @Override
        public BalanceStep setUserActive(final int userActive) {
            this.userActive = userActive;
            return this;
        }

        @Override
        public EmailStep setBalance(final int balance) {
            this.balance = balance;
            return this;
        }

        @Override
        public FirstNameStep setEmail(final String email) {
            this.email = email;
            return this;
        }

        @Override
        public LastNameStep setFirstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        @Override
        public LoginStep setLastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        @Override
        public PasswordStep setLogin(final String login) {
            this.login = login;
            return this;
        }

        @Override
        public CustomerTypeRefStep setPassword(final String password) {
            this.password = password;
            return this;
        }

        @Override
        public RegionRefStep setCustomerTypeRef(final int customerTypeRef) {
            this.customerTypeRef = customerTypeRef;
            return this;
        }

        @Override
        public RoleRefStep setRegionRef(final int regionRef) {
            this.regionRef = regionRef;
            return this;
        }

        @Override
        public BuildStep setRoleRef(final int roleRef) {
            this.roleRef = roleRef;
            return this;
        }

        @Override
        public User build() {
            final User user = new User();

            user.setId(id);
            user.setUserActive(userActive);
            user.setBalance(balance);
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setLogin(login);
            user.setPassword(password);
            user.setCustomerTypeRef(customerTypeRef);
            user.setRegionRef(regionRef);
            user.setRoleRef(roleRef);

            return user;
        }
    }

    public final String getRoleName() {
        return Roles.getRoleName(roleRef);
    }

    @Override
    public final String toString() {
        return "User {" +
                "ID=" + id +
                ", isUserActive=" + userActive +
                ", Balance=" + balance +
                ", Email=" + email +
                ", FirstName=" + firstName +
                ", LastName=" + lastName +
                ", Login=" + login +
                ", Password=" + password +
                ", CustomerTypeRef=" + customerTypeRef +
                ", RegionRef=" + regionRef +
                ", RoleRef=" + roleRef +
                "}";
    }

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final int isUserActive() {
        return userActive;
    }

    public final void setUserActive(final int userActive) {
        this.userActive = userActive;
    }

    public final int getBalance() {
        return balance;
    }

    public final void setBalance(final int balance) {
        this.balance = balance;
    }

    public final String getEmail() {
        return email;
    }

    public final void setEmail(final String email) {
        this.email = email;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public final String getLogin() {
        return login;
    }

    public final void setLogin(final String login) {
        this.login = login;
    }

    public final String getPassword() {
        return password;
    }

    public final void setPassword(final String password) {
        this.password = password;
    }

    public final int getCustomerTypeRef() {
        return customerTypeRef;
    }

    public final void setCustomerTypeRef(final int customerTypeRef) {
        this.customerTypeRef = customerTypeRef;
    }

    public final int getRegionRef() {
        return regionRef;
    }

    public final void setRegionRef(final int regionRef) {
        this.regionRef = regionRef;
    }

    public final int getRoleRef() {
        return roleRef;
    }

    public final void setRoleRef(final int roleRef) {
        this.roleRef = roleRef;
    }

}
