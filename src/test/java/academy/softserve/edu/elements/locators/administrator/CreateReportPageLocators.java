package academy.softserve.edu.elements.locators.administrator;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.elements.LocatorsType;
import org.openqa.selenium.By;

//TODO remove unused locators
public enum CreateReportPageLocators implements ILocator {

    ADMINISTRATION_LINK("Administration Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/descendant::a[@href='users.htm']"),

    USER_INFO_LINK("User Info Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/li[2]/a"),

    PAGE_INFO_TEXT("Page Info Text",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/h2"),

    SAVE_REPORT_LINK("Save Report Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/a"),

    FOUND_USERS_CONTAINER("Found Users Container",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/h4[1]"),

    SEARCH_BY_FIELDSET("Search By Fieldset",
            LocatorsType.BY_XPATH,
            "//div[@id='list']//legend"),

    SEARCH_FIELD_FILTER("Search Field Filter",
            LocatorsType.BY_XPATH,
            "//form[@id='searchForm']/label"),

    SEARCH_FIELD_FILTER_DROPDOWN("Search Field Filter Dropdown",
            LocatorsType.BY_XPATH,
            "//select[@id='field']"),

    SEARCH_CONDITION_DROPDOWN("Search Condition Dropdown",
            LocatorsType.BY_XPATH,
            "//select[@id='condition']"),

    SEARCH_INPUT("Search Input",
            LocatorsType.BY_XPATH,
            "//input[@id='searchField']"),

    SEARCH_BUTTON("Search Button",
            LocatorsType.BY_XPATH,
            "//form[@id='searchForm']/input[2]"),

    RESIZE_USERS_LIST_LINK("Resize Users List Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/p/a"),

    FIRST_NAME_HEADER_LINK("First Name Header Link",
            LocatorsType.BY_XPATH,
            "//table[@id='table']//tr/th[1]/a"),

    FIRST_NAME_CELL("First Name Cell",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table/tbody/tr[%s]/td[1]"),

    LAST_NAME_HEADER_LINK("Last Name Header Link",
            LocatorsType.BY_XPATH,
            "//table[@id='table']//tr/th[2]/a"),

    LAST_NAME_CELL("Last Name Cell",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table/tbody/tr[%s]/td[2]"),

    LOGIN_HEADER_LINK("Login Header Link",
            LocatorsType.BY_XPATH,
            "//table[@id='table']//tr/th[3]/a"),

    LOGIN_CELL("Login Cell",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table/tbody/tr[%s]/td[3]"),

    ROLE_HEADER_LINK("Role Header Link",
            LocatorsType.BY_XPATH,
            "//table[@id='table']//tr/th[4]/a"),

    ROLE_CELL("Role Cell",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table/tbody/tr[%s]/td[4]"),

    REGION_HEADER_LINK("Region Header Link",
            LocatorsType.BY_XPATH,
            "//table[@id='table']//tr/th[5]/a"),

    REGION_CELL("Region Cell",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table/tbody/tr[%s]/td[5]"),

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
            "//div[@id='list']/h4[2]"),

    PAGE_NUMBER_TEXT("Page Number Text",
            LocatorsType.BY_ID,
            "pageNumber"),

    PAGE_COUNT_TEXT("Page Count Text",
            LocatorsType.BY_ID,
            "pageCount");

    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;

    CreateReportPageLocators(final String elementName,
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
    public CreateReportPageLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }
}
