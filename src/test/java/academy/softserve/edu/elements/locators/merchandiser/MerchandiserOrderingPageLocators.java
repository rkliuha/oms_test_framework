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

    ORDER_NAME_CELL("Order Name Cell",
            LocatorsType.BY_XPATH,
            "//div[@id='list']//tr[%s]/td[1]"),

    STATUS_CELL("Status Cell",
            LocatorsType.BY_XPATH,
            "//div[@id='list']//tr[%s]/td[5]"),

    EDIT_CELL_LINK("Edit Cell Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']//tr[%s]/td[6]/a"),

    DELETE_CELL_LINK("Delete Cell Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']//tr[%s]/td[7]"),

    SHOW_ITEMS_LINK("Show items",
            LocatorsType.BY_XPATH,
            "//a[@href='resizeOrdersLisr.htm']");

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
