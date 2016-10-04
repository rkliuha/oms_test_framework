package academy.softserve.edu.elements.locators.administrator;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.elements.LocatorsType;
import org.openqa.selenium.By;

public enum AdministrationPageLocators implements ILocator {

    ADMINISTRATION_LINK("Administration Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/descendant::a[@href='users.htm']"),

    USER_INFO_LINK("User Info Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/li[2]/a"),

    PAGE_INFO_TEXT("Page Info Text",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/h2"),

    CREATE_USER_LINK("Crete User Link",
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

    FOUND_USERS_TEXT_LABEL("Found Users Text Label",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/h4[1]"),

    RESIZE_USERS_LIST_LINK("Resize Users List Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/p/a"),

    FIRST_NAME_HEADER_LINK("First Name Header Link",
            LocatorsType.BY_XPATH,
            "//table[@id='table']//tr/th[1]/a"),

    FIRST_NAME_CELL("First Name Cell",
            LocatorsType.BY_XPATH,
            "//table[@id='table']/tbody/tr[%s]/td[1]"),

    LAST_NAME_HEADER_LINK("Last Name Header Link",
            LocatorsType.BY_XPATH,
            "//table[@id='table']//tr/th[2]/a"),

    LAST_NAME_CELL("Last Name Cell",
            LocatorsType.BY_XPATH,
            "//table[@id='table']/tbody/tr[%s]/td[2]"),

    LOGIN_HEADER_LINK("Login Header Link",
            LocatorsType.BY_XPATH,
            "//table[@id='table']//tr/th[3]/a"),

    LOGIN_CELL("Login Cell",
            LocatorsType.BY_XPATH,
            "//table[@id='table']/tbody/tr[%s]/td[3]"),

    ROLE_HEADER_LINK("Role Header Link",
            LocatorsType.BY_XPATH,
            "//table[@id='table']//tr/th[4]/a"),

    ROLE_CELL("Role Cell",
            LocatorsType.BY_XPATH,
            "//table[@id='table']/tbody/tr[%s]/td[4]"),

    REGION_HEADER_LINK("Region Header Link",
            LocatorsType.BY_XPATH,
            "//table[@id='table']//tr/th[5]/a"),

    REGION_CELL("Region Cell",
            LocatorsType.BY_XPATH,
            "//table[@id='table']/tbody/tr[%s]/td[5]"),

    EDIT_HEADER("Edit Header",
            LocatorsType.BY_XPATH,
            "//table[@id='table']//tr/th[6]"),

    EDIT_USER_CELL_LINK("Edit Cell",
            LocatorsType.BY_XPATH,
            "//table[@id='table']/tbody/tr[%s]/td[6]/a"),

    DELETE_HEADER("Delete Header",
            LocatorsType.BY_XPATH,
            "//table[@id='table']//tr/th[7]"),

    DELETE_USER_CELL_LINK("Delete Cell",
            LocatorsType.BY_XPATH,
            "//table[@id='table']/tbody/tr[%s]/td[7]/a"),

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
            "pageCount"),

    CREATE_REPORT_LINK("Create Report Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/h5/a"),

    SAVE_REPORT_LINK("Save Report Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/a");


    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;

    AdministrationPageLocators(final String elementName,
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
    public AdministrationPageLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }
}
