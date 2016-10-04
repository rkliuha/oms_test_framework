package academy.softserve.edu.elements.locators.supervisor;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.elements.LocatorsType;
import org.openqa.selenium.By;

public enum AddProductPageLocators implements ILocator {

    ITEM_MANAGEMENT_LINK("Item Management Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/descendant::a[@href='itemManagement.htm']"),

    USER_INFO_LINK("User Info Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/li[2]/a"),

    PAGE_NAME_TEXT("Page Name Text",
            LocatorsType.BY_XPATH,
            "//div[@id='edit']/h3"),

    PRODUCT_NAME_TEXT("Product Name Text",
            LocatorsType.BY_XPATH,
            "//form[@id='productModel']//tr[1]/td[1]"),

    PRODUCT_DESCRIPTION_TEXT("Product Description Text",
            LocatorsType.BY_XPATH,
            "//form[@id='productModel']//tr[2]/td[1]"),

    PRODUCT_PRICE_TEXT("Product Price Text",
            LocatorsType.BY_XPATH,
            "//form[@id='productModel']//tr[3]/td[1]"),

    PRODUCT_NAME_INPUT("Product Name Input",
            LocatorsType.BY_ID,
            "name"),

    PRODUCT_DESCRIPTION_INPUT("Product Description Input",
            LocatorsType.BY_ID,
            "description"),

    PRODUCT_PRICE_INPUT("Product Price Input",
            LocatorsType.BY_ID,
            "price"),

    OK_BUTTON("OK Button",
            LocatorsType.BY_XPATH,
            "//form[@id='productModel']/input[2]"),

    CANCEL_BUITON("Cancel Button",
            LocatorsType.BY_XPATH,
            "//form[@id='productModel']/input[2]");

    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;

    AddProductPageLocators(final String elementName,
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
    public AddProductPageLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }
}
