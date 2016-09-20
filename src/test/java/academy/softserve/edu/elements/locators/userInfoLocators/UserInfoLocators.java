package academy.softserve.edu.elements.locators.userInfoLocators;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.elements.locatorsType.LocatorsType;
import org.openqa.selenium.By;

public enum UserInfoLocators implements ILocator {

    ROLE_LINK("Role Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/li[1]/a"),

    USER_INFO_LINK("User Info Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/li[2]/a"),

    ENGLISH_SWITCH_LINK("English Switch Link",
            LocatorsType.BY_XPATH,
            "//a[@id='en_US']"),

    UKRAINIAN_SWITCH_LINK("Ukrainian Switch Link",
            LocatorsType.BY_XPATH,
            "//a[@id='uk_UA']"),

    USER_INFO_FIELDSET("User Info Fieldset",
            LocatorsType.BY_XPATH,
            "//div[@id='content']//legend"),

    FIRST_NAME_TEXT("First Name Text",
            LocatorsType.BY_XPATH,
            "//div[@id='content']//tr[1]/td[1]"),

    FIRST_NAME_VALUE_TEXT("First Name Value Text",
            LocatorsType.BY_XPATH,
            "//div[@id='content']//tr[1]/td[2]"),

    LAST_NAME_TEXT("Last Name Text",
            LocatorsType.BY_XPATH,
            "//div[@id='content']//tr[2]/td[1]"),

    LAST_NAME_VALUE_TEXT("Last Name Value Text",
            LocatorsType.BY_XPATH,
            "//div[@id='content']//tr[2]/td[2]"),

    CUSTOMER_TYPE_TEXT("Customer Type Text",
            LocatorsType.BY_XPATH,
            "//div[@id='content']//tr[3]/td[1]"),

    CUSTOMER_TYPE_VALUE_TEXT("Customer Type Value Text",
            LocatorsType.BY_XPATH,
            "//div[@id='content']//tr[3]/td[2]"),

    ROLE_TEXT("Role Text",
            LocatorsType.BY_XPATH,
            "//div[@id='content']//tr[4]/td[1]"),

    ROLE_VALUE_TEXT("Role Value Text",
            LocatorsType.BY_XPATH,
            "//div[@id='content']//tr[4]/td[2]");


    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String parameter;
    private String modifiedLocator;

    UserInfoLocators(final String elementName,
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
    public UserInfoLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }
}