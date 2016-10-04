package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.*;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static academy.softserve.edu.elements.locators.customer.CustomerOrderingPageLocators.*;
import static academy.softserve.edu.elements.locators.merchandiser.MerchandiserOrderingPageLocators.STATUS_CELL;

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

    private final Element searchResult = new Element(driver, SEARCH_RESULT);

    private final Element searchStatusResult = new Element(driver, SEARCH_STATUS_RESULT);

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

    public final Element getSearchResult(final String statusNumber) {

        return new Element(driver, SEARCH_RESULT.modify(statusNumber));
    }
}
