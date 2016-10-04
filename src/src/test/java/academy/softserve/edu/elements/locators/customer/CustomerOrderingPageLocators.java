package academy.softserve.edu.elements.locators.customer;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.elements.LocatorsType;
import org.openqa.selenium.By;

public enum CustomerOrderingPageLocators implements ILocator {

    CUSTOMER_ORDERING_LINK("Customer Ordering Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/descendant::a[@href='order.htm']"),

    USER_INFO_LINK("User Info Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/li[2]/a"),

    CREATE_NEW_ORDER_LINK("Create New Order Link",
            LocatorsType.BY_XPATH,
            "//div[@id='content']/a"),

    SEARCH_BY_TEXT("Search By Text",
            LocatorsType.BY_XPATH,
            "//form[@id='searchFilter']//tr/td[1]"),

    SEARCH_DROPDOWN("Search Dropdown",
            LocatorsType.BY_XPATH,
            "//select[@id='search']"),

    SEARCH_DROPDOWN_SELECTED_OPTION("Search Dropdown Selected Option",
            LocatorsType.BY_XPATH,
            "//select[@id='search']/option[@selected='selected']"),

    SEARCH_INPUT("Search Input",
            LocatorsType.BY_XPATH,
            "//input[@id='searchValue']"),

    APPLY_BUTTON("Apply Button",
            LocatorsType.BY_XPATH,
            "//form[@id='searchFilter']//td[4]/input"),

    RESIZE_ORDERS_LIST_LINK("Resize Orders List Link",
            LocatorsType.BY_XPATH,
            "//form[@id='searchFilter']/p/a"),

    ORDER_NAME_HEADER_LINK("Order Name Header Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table//th[1]/a"),

    TOTAL_PRICE_HEADER_LINK("Total Price Header Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table//th[2]/a"),

    MAX_DISCOUNT_HEADER_LINK("Max Discount Header Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table//th[3]/a"),

    DELIVERY_DATE_HEADER_LINK("Delivery Date Header Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table//th[4]/a"),

    STATUS_HEADER_LINK("Status Header Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table//th[5]/a"),

    ASSIGNEE_HEADER_LINK("Assignee Header Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table//th[6]/a"),

    EDIT_HEADER("Edit Header",
            LocatorsType.BY_XPATH,
            "//div[@id='list']//th[7]"),

    DELETE_HEADER("Delete Header",
            LocatorsType.BY_XPATH,
            "//div[@id='list']//th[8]"),

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

    PAGE_NUMBER_CONTAINER("Page Number Container",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/h4"),

    PAGE_NUMBER_TEXT("Page Number Text",
            LocatorsType.BY_ID,
            "pageNumber"),

    PAGE_COUNT_TEXT("Page Count Text",
            LocatorsType.BY_ID,
            "pageCount"),

    ORDER_STATUS("Order Status 1",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table/tbody/tr/"
                    + "td[contains(text(), 'OrderName%s')]/following-sibling::td[4]"),

    EDIT_LINK("Edit link",
            LocatorsType.BY_XPATH,
            "(//div[@id='list']//tbody/tr[2]//a)[1]"),

    DELETE_LINK("Delete link",
            LocatorsType.BY_XPATH,
            "(//div[@id='list']//tbody/tr[2]//a)[2]"),

    ORDER_ROW("Order row",
              LocatorsType.BY_XPATH,
            "//div[@id='list']/table//tr[2]"),

    RESIZE_SHOW_ITEMS_LINK("Resize show items link",
            LocatorsType.BY_XPATH,
            "//form[@id='searchFilter']//a"),

    SEARCH_RESULT("Search_result",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table//tr[%s]"),

    SEARCH_STATUS_RESULT("Search status result",
                  LocatorsType.BY_XPATH,
            "//div[@id='list']/table/tbody/tr[2]");

    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;

    CustomerOrderingPageLocators(final String elementName,
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
    public CustomerOrderingPageLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }
}
