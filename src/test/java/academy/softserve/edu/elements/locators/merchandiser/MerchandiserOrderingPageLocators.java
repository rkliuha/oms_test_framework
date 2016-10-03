package academy.softserve.edu.elements.locators.merchandiser;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.elements.LocatorsType;
import org.openqa.selenium.By;

public enum MerchandiserOrderingPageLocators implements ILocator {

    MERCHANDISER_ORDERING_LINK("Ordering Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/descendant::a[@href='order.htm']"),

    USER_INFO_LINK("User Info Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/li[2]/a"),

    SEARCH_BY_TEXT("Search By Text",
            LocatorsType.BY_XPATH,
            "//form[@id='searchFilter']//tr/td[1]"),

    SEARCH_DROPDOWN("Search Dropdown",
            LocatorsType.BY_XPATH,
            "//select[@id='search']"),

    SEARCH_INPUT("Search Input",
            LocatorsType.BY_ID,
            "searchValue"),

    APPLY_BUTTON("Apply Button",
            LocatorsType.BY_XPATH,
            "//form[@id='searchFilter']//td[4]/input"),

    RESIZE_ORDERS_LIST_LINK("Resize Orders List Link",
            LocatorsType.BY_XPATH,
            "//form[@id='searchFilter']/p/a"),

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
            "//div[@id='list']/h4"),

    PAGE_NUMBER_TEXT("Page Number Text",
            LocatorsType.BY_ID,
            "pageNumber"),

    PAGE_COUNT_TEXT("Page Count Text",
            LocatorsType.BY_ID,
            "pageCount"),

    ORDER_NAME_HEADER_LINK("Order Name Header Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table//th[1]/a"),

    ORDER_NAME_CELL("Order Name Cell",
            LocatorsType.BY_XPATH,
            "//div[@id='list']//tr[%s]/td[1]"),

    TOTAL_PRICE_HEADER_LINK("Total Price Header Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table//th[2]/a"),

    TOTAL_PRICE_CELL("Total Price Cell",
            LocatorsType.BY_XPATH,
            "//div[@id='list']//tr[%s]/td[2]"),

    MAX_DISCOUNT_HEADER_LINK("Max Discount Header Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table//th[3]/a"),

    MAX_DISCOUNT_CELL("Max Discount Cell",
            LocatorsType.BY_XPATH,
            "//div[@id='list']//tr[%s]/td[3]"),

    DELIVERY_DATE_HEADER_LINK("Delivery Date Header Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table//th[4]/a"),

    DEELIVERY_DATE_CELL("Delivery Date Cell",
            LocatorsType.BY_XPATH,
            "//div[@id='list']//tr[%s]/td[4]"),

    STATUS_HEADER_LINK("Status Header Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table//th[5]/a"),

    STATUS_CELL("Status Cell",
            LocatorsType.BY_XPATH,
            "//div[@id='list']//tr[%s]/td[5]"),

    EDIT_HEADER("Edit Header",
            LocatorsType.BY_XPATH,
            "//div[@id='list']//th[6]"),

    EDIT_CELL_LINK("Edit Cell Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']//tr[%s]/td[6]/a"),

    DELETE_HEADER("Delete Header",
            LocatorsType.BY_XPATH,
            "//div[@id='list']//th[7]"),

    DELETE_CELL_LINK("Delete Cell Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/h4"),

    ORDER_NAME_COLUMN("Order Name Column",
            LocatorsType.BY_XPATH,
            "//*[@id='list']/table/tbody//td[1]"),

    TOTAL_PRICE_COLUMN("Total Price Column",
            LocatorsType.BY_XPATH,
            "//*[@id='list']/table/tbody//td[2]"),

    MAX_DISCOUNT_COLUMN("Max Discount Column",
            LocatorsType.BY_XPATH,
            "//*[@id='list']/table/tbody//td[3]"),

    DELIVERY_DATE("Delivery Date Column",
            LocatorsType.BY_XPATH,
            "//*[@id='list']/table/tbody//td[4]"),

    STATUS_COLUMN("Status Column",
            LocatorsType.BY_XPATH,
            "//*[@id='list']/table/tbody//td[5]");


    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;

    MerchandiserOrderingPageLocators(final String elementName,
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
    public MerchandiserOrderingPageLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }
}
