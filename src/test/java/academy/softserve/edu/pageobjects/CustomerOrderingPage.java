package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.*;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.customer.CustomerOrderingPageLocators.*;

@Getter
public class CustomerOrderingPage extends PageObject<CustomerOrderingPage> {

    private final Link userInfoLink = new Link(driver, USER_INFO_LINK);
    // createNewOrderLink is an unique CustomerOrderingPage element
    private final Link createNewOrderLink = new Link(driver, CREATE_NEW_ORDER_LINK);
    private final Dropdown searchDropdown = new Dropdown(driver, SEARCH_DROPDOWN);
    private final TextInputField searchInput = new TextInputField(driver, SEARCH_INPUT);
    private final Button applyButton = new Button(driver, APPLY_BUTTON);

    private final Link resizeShowItemsLink = new Link(driver, RESIZE_SHOW_ITEMS_LINK);

    private final Link editLink = new Link(driver, EDIT_LINK);

    private final Link deleteLink = new Link(driver, DELETE_LINK);

    private final Element orderRow = new Element(driver, ORDER_ROW);

    private final Element searchStatusResult = new Element(driver, SEARCH_STATUS_RESULT);

    //TODO remove, turn ORDER_STATUS into class field
    private final Element searchNameResult = new Element(driver, SEARCH_NAME_RESULT);

    private final Element searchResultElements = new Element(driver, SEARCH_RESULT_ELEMENTS);

    public final TextLabel getOrderStatusByNumber(final String orderNumber) {
        return new TextLabel(driver, ORDER_STATUS.modify(orderNumber));
    }

    public CustomerOrderingPage(WebDriver driver) {
        super(driver);
    }

    public final UserInfoPage clickUserInfoTab() {

        userInfoLink.click();
        return new UserInfoPage(driver);
    }

    public final CreateNewOrderPage clickCreateNewOrderLink() {

        createNewOrderLink.click();
        return new CreateNewOrderPage(driver);
    }

    public final CustomerOrderingPage clickResizeShowItemsLink() {

        resizeShowItemsLink.click();
        return this;
    }

    public final CustomerOrderingPage clickApplyButton() {

        applyButton.click();
        return this;
    }

    public final CreateNewOrderPage clickEditLink() {

        editLink.click();
        return new CreateNewOrderPage(driver);
    }

    public final CustomerOrderingPage clickDeleteLink() {

        deleteLink.click();
        return this;
    }

    public final CustomerOrderingPage selectSearchDropdown(final String condition) {

        searchDropdown.sendKeys(condition);
        return this;
    }

    public final CustomerOrderingPage fillSearchInput(final String searchText) {

        searchInput.sendKeys(searchText);
        return this;
    }

    //TODO remove, turn ORDER_STATUS into class field
    public final Element getSearchResult(final String statusNumber) {

        return new Element(driver, SEARCH_STATUS_RESULT.modify(statusNumber));
    }


    //TODO - Kostya - remove
    final public boolean checkElementsAmount(final Element elements, final int elementsAmount) {

        if (elements.getElements().size() == elementsAmount) {

            return true;

        } else return false;
    }
}
