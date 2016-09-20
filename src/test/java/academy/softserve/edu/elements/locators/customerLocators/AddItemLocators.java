package academy.softserve.edu.elements.locators.customerLocators;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.elements.locatorsType.LocatorsType;
import org.openqa.selenium.By;

public enum AddItemLocators implements ILocator {

    ORDERING_LINK("Ordering Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/li[1]/a"),

    USER_INFO_LINK("User Info Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/li[2]/a"),

    ITEM_SEARCH_FIELDSET("Item Search Fieldset",
            LocatorsType.BY_XPATH,
            "//div[@id='content']/fieldset/legend"),

    SEARCH_FOR_ITEM_DROPDOWN("Search For Item Dropdown",
            LocatorsType.BY_ID,
            "searchProperty"),

    SEARCH_FOR_ITEM_INPUT("Seach For Item Input",
            LocatorsType.BY_ID,
            "searchValue"),

    SEARCH_FOR_ITEM_BUTTON("Search For Item Button",
            LocatorsType.BY_XPATH,
            "//form[@id='model']/input[9]"),

    ITEM_NAME_HEADER("Item Name Header",
            LocatorsType.BY_XPATH,
            "//form[@id='sortName']/a"),

    ITEM_DESCRIPTION_HEADER("Item Description Header",
            LocatorsType.BY_XPATH,
            "//form[@id='sortDescription']/a"),

    ITEM_ADD_HEADER("Item Add Header",
            LocatorsType.BY_XPATH,
            "//div[@id='list']//tr/th[3]"),

    ITEM_TEXT("Item Text",
            LocatorsType.BY_XPATH,
            "//form[@id='doneForm']//tr[1]/td[1]"),

    ITEM_INPUT("Item Input",
            LocatorsType.BY_XPATH,
            "//form[@id='doneForm']//tr[1]/td[2]"),

    SELECT_ITEM_ERROR("Select Item Error",
            LocatorsType.BY_ID,
            "productId.errors"),

    ITEM_PRICE_TEXT("Item Price Text",
            LocatorsType.BY_XPATH,
            "//form[@id='doneForm']//tr[3]/td[1]"),

    ITEM_PRICE_FIELD("Item Price Field",
            LocatorsType.BY_XPATH,
            "//form[@id='doneForm']//tr[3]/td[2]"),

    ITEM_QUANTITY_TEXT("Item Quantity Text",
            LocatorsType.BY_XPATH,
            "//form[@id='doneForm']//tr[4]/td[1]"),

    ITEM_QUANTITY_INPUT("Item Quantity Input",
            LocatorsType.BY_ID,
            "quantity"),

    QUANTITY_ITEM_ERROR("Quantity Item Error",
            LocatorsType.BY_ID,
            "quantity.errors"),

    ITEM_DIMENSION_TEXT("Item Dimension Text",
            LocatorsType.BY_XPATH,
            "//form[@id='doneForm']//tr[6]/td[1]"),

    ITEM_DIMENSION_DROPDOWN("Item Dimension Dropdown",
            LocatorsType.BY_ID,
            "dimension"),

    RESET_BUTTON("Reset Button",
            LocatorsType.BY_XPATH,
            "//form[@id='resetForm']/input[11]"),

    DONE_BUTTON("Done Button",
            LocatorsType.BY_XPATH,
            "//div[@id='content']/fieldset/fieldset/table/tbody/tr/td[2]/input"),

    CANCEL_BUTTON("Cancel Button",
            LocatorsType.BY_XPATH,
            "//form[@id='cancelForm']/input[2]");


    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;

    AddItemLocators(final String elementName,
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
    public AddItemLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }
}
