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

    PAGE_INFO_TEXT("Page Info Text",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/h2"),

    ADD_PRODUCT_LINK("Add Product Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/a[1]"),

    PRODUCT_FOUND_CONTAINER("Product Found Container",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/h4[1]"),

    RECORDS_COUNT_TEXT("Records Count Text",
            LocatorsType.BY_ID,
            "recordsFound"),

    SEARCH_BY_FIELDSET("Search By Fieldset",
            LocatorsType.BY_XPATH,
            "//div[@id='list']//legend"),

    SEARCH_FIELD_FILTER_TEXT("Search Field Filter",
            LocatorsType.BY_XPATH,
            "//form[@id='searchForm']/label"),

    SEARCH_FIELD_FILTER_DROPDOWN("Search Field Filter Dropdown",
            LocatorsType.BY_XPATH,
            "//select[@id='field']"),

    SEARCH_INPUT("Search Input",
            LocatorsType.BY_XPATH,
            "//input[@id='searchField']"),

    SEARCH_BUTTON("Search Button",
            LocatorsType.BY_XPATH,
            "//form[@id='searchForm']/input[2]"),

    RESIZE_PRODUCTS_LIST_LINK("Resize Products List Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/p/a"),

    NAME_HEADER_LINK("Name Header Link",
            LocatorsType.BY_XPATH,
            "//table[@id='table']//tr/th[1]/a"),

    DESCRIPTION_HEADER_LINK("Description Header Link",
            LocatorsType.BY_XPATH,
            "//table[@id='table']//tr/th[2]/a"),

    PRICE_HEADER_LINK("Price Header Link",
            LocatorsType.BY_XPATH,
            "//table[@id='table']//tr/th[3]/a"),

    EDIT_HEADER("Edit Header",
            LocatorsType.BY_XPATH,
            "//table[@id='table']//tr/th[4]"),

    DELETE_HEADER("Delete Header",
            LocatorsType.BY_XPATH,
            "//table[@id='table']//tr/th[5]"),

    FIRST_NAVIGATION_BUTTON("First Navigation Button",
            LocatorsType.BY_ID,
            "first"),

    BACKWARD_NAVIGATION_BUTTON("Backward Navigation Button",
            LocatorsType.BY_ID,
            "previous"),

    FORWARD_NAVIGATION_BUTTON("Forward Navigation Button",
            LocatorsType.BY_ID,
            "next"),

    LAST_NAVIGATION_BUTTON("Last Navigation Button",
            LocatorsType.BY_ID,
            "last"),

    PAGE_NUMBER_CONTAINER("Page Number Text Container",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/h4[2]"),

    PAGE_NUMBER_TEXT("Page Number Text",
            LocatorsType.BY_ID,
            "pageNumber"),

    PAGE_COUNT_TEXT("Page Count Text",
            LocatorsType.BY_ID,
            "pageCount"),

    CREATE_REPORT_LINK("Create Report Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/a[2]"),

    PRODUCT_SEARCH_RESULT("Product search result",
            LocatorsType.BY_XPATH,
            "//table[@id='table']/tbody/tr"),

    DELETE_PRODUCT_LINK("Delete product link",
            LocatorsType.BY_XPATH,
            "//table[@id='table']//a[@href='javascript:deleteItem(\"%s\");']"),

    EDIT_PRODUCT_LINK("Edit Product Link",
            LocatorsType.BY_XPATH,
            "//table[@id='table']//a[@href='editItem.htm?productID=%s']");

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
