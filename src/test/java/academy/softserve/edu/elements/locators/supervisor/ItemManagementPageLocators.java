package academy.softserve.edu.elements.locators.supervisor;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.elements.LocatorsType;
import org.openqa.selenium.By;

public enum ItemManagementPageLocators implements ILocator {

    ITEM_MANAGEMENT_LINK("Item Management Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/descendant::a[@href='itemManagement.htm']"),

    USER_INFO_LINK("User Info Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/li[2]/a"),

    ADD_PRODUCT_LINK("Add Product Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/a[1]"),

    RECORDS_COUNT_TEXT("Records Count Text",
            LocatorsType.BY_ID,
            "recordsFound"),

    SEARCH_BY_FIELDSET("Search By Fieldset",
            LocatorsType.BY_XPATH,
            "//div[@id='list']//legend"),

    SEARCH_FIELD_FILTER_DROPDOWN("Search Field Filter Dropdown",
            LocatorsType.BY_XPATH,
            "//select[@id='field']"),

    SEARCH_INPUT("Search Input",
            LocatorsType.BY_XPATH,
            "//input[@id='searchField']"),

    SEARCH_BUTTON("Search Button",
            LocatorsType.BY_XPATH,
            "//form[@id='searchForm']/input[2]"),

    CREATE_REPORT_LINK("Create Report Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/a[2]"),

    DELETE_PRODUCT_LINK("Delete product link",
            LocatorsType.BY_XPATH,
            "//table[@id='table']//a[@href='javascript:deleteItem(\"%s\");']"),

    EDIT_PRODUCT_LINK("Edit Product Link",
            LocatorsType.BY_XPATH,
            "//table[@id='table']//a[@href='editItem.htm?productID=%s']"),

    NAME_PRODUCT_CELL_LINK("Name Cell",
            LocatorsType.BY_XPATH,
            "//*[@id='table']/tbody/tr[%s]/td[1]"),

    DESCRIPTION_CELL_LINK("Description Cell",
            LocatorsType.BY_XPATH,
            "//*[@id='table']/tbody/tr[%s]/td[2]"),

    PRICE_CELL_LINK("Price Cell",
            LocatorsType.BY_XPATH,
            "//*[@id='table']/tbody/tr[%s]/td[3]/a"),

    DELETE_PRODUCT_CELL_LINK("Delete Cell",
            LocatorsType.BY_XPATH,
            "//*[@id='table']/tbody/tr[%s]/td[5]/a"),

    EDIT_PRODUCT_CELL_LINK("Edit Cell",
            LocatorsType.BY_XPATH,
            "//*[@id='table']/tbody/tr[%s]/td[4]/a"),

    NAME_PRODUCT_CELL_COLUMN(" Name Cell Column",
            LocatorsType.BY_XPATH,
            "//*[@id='table']/tbody//td[1]"),

    DESCRIPTION_CELL_COLUMN("Description Cell Column",
            LocatorsType.BY_XPATH,
            "//*[@id='table']/tbody//td[2]"),

    PRICE_CELL_COLUMN("Price Cell Column",
            LocatorsType.BY_XPATH,
            "//*[@id='table']/tbody//td[3]");

    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;

    ItemManagementPageLocators(final String elementName,
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
    public ItemManagementPageLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }
}
