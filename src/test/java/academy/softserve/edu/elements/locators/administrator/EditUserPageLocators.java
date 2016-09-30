package academy.softserve.edu.elements.locators.administrator;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.elements.LocatorsType;
import org.openqa.selenium.By;

public enum EditUserPageLocators implements ILocator {

    ADMINISTRATION_LINK("Administration Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/descendant::a[@href='users.htm']"),

    USER_INFO_LINK("User Info Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/li[2]/a"),

    PAGE_INFO_TEXT("Page Info Text",
            LocatorsType.BY_XPATH,
            "//div[@id='edit']/h3"),

    PASSWORD_EDIT_ADVISE_TEXT("Password Edit Advise Page",
            LocatorsType.BY_XPATH,
            "//div[@id='edit']/span"),

    FIRST_NAME_TEXT("First Name Text",
            LocatorsType.BY_XPATH,
            "//form[@id='userModel']//tr[1]/td[1]"),

    FIRST_NAME_INPUT("First Name Input",
            LocatorsType.BY_ID,
            "firstName"),

    LAST_NAME_TEXT("Last Name Text",
            LocatorsType.BY_XPATH,
            "//form[@id='userModel']//tr[2]/td[1]"),

    LAST_NAME_INPUT("Last Name Input",
            LocatorsType.BY_ID,
            "lastName"),

    NEW_PASSWORD_TEXT("New Password Text",
            LocatorsType.BY_XPATH,
            "//td[contains(., 'New password:')]"),

    NEW_PASSWORD_INPUT("New Password Input",
            LocatorsType.BY_ID,
            "password"),

    CONFIRM_PASSWORD_TEXT("Confirm Password Text",
            LocatorsType.BY_XPATH,
            "//form[@id='userModel']//tr[4]/td[1]"),

    CONFIRM_PASSWORD_INPUT("Confirm Password Input",
            LocatorsType.BY_ID,
            "confirmPassword"),

    EMAIL_ADDRESS_TEXT("Last Name Text",
            LocatorsType.BY_XPATH,
            "//form[@id='userModel']//tr[5]/td[1]"),

    EMAIL_ADDRESS_INPUT("Email Address Input",
            LocatorsType.BY_ID,
            "email"),

    REGION_TEXT("Region Text",
            LocatorsType.BY_XPATH,
            "//form[@id='userModel']//tr[6]/td[1]"),

    REGION_DROPDOWN("Region Dropdown",
            LocatorsType.BY_ID,
            "regionID"),

    ROLE_TEXT("Role Text",
            LocatorsType.BY_XPATH,
            "//form[@id='userModel']//tr[7]/td[1]"),

    ROLE_DROPDOWN("Role Dropdown",
            LocatorsType.BY_ID,
            "roleID"),

    SAVE_CHANGES_BUTTON("Save Changes Button",
            LocatorsType.BY_XPATH,
            "//form[@id='userModel']/input[5]"),

    CANCEL_BUTTON("Cancel Button",
            LocatorsType.BY_XPATH,
            "//form[@id='userModel']/input[6]");


    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;

    EditUserPageLocators(final String elementName,
                         final LocatorsType locatorType, final String locatorValue) {
        this.elementName = elementName;
        this.locatorType = locatorType;
        this.locatorValue = locatorValue;
    }

    @Override
    public String getName() {
        return this.elementName;
    }

    @Override
    public By getBy() {
        By by;
        if (this.modifiedLocator == null) {
            by = this.locatorType.getBy(this.locatorValue);
        } else {
            by = this.locatorType.getBy(this.modifiedLocator);
        }
        return by;
    }

    @Override
    public EditUserPageLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }
}
