package academy.softserve.edu.elements.locators.sharedLocators;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.elements.locatorsType.LocatorsType;
import org.openqa.selenium.By;

public enum SharedLocators implements ILocator {

    LOG_OUT_BUTTON("Log Out Button",
            LocatorsType.BY_ID,
            "logout"),

    OMS_LOGO("OMS Logo",
            LocatorsType.BY_XPATH,
            "//div[@id='logo']/h1"),

    OMS_SUBLOGO("OMS Sublogo",
            LocatorsType.BY_XPATH,
            "//div[@id='logo']/h2"),

    FOOTER_LINK("Footer Google Link",
            LocatorsType.BY_XPATH,
            "//div[@id='footer']/a"),

    FOOTER_UPDATE_INFO("Footer Update Info",
            LocatorsType.BY_XPATH,
            "//div[@id='footer']/p");

    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;


    SharedLocators(final String elementName,
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
    public SharedLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }
}
