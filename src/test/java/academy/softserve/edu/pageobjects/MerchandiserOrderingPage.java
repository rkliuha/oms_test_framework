package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.*;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.merchandiser.MerchandiserOrderingPageLocators.*;
import static academy.softserve.edu.elements.locators.userinfo.UserInfoPageLocators.USER_INFO_LINK;

@Getter
public class MerchandiserOrderingPage extends PageObject<MerchandiserOrderingPage> {

    // searchByText is unique MerchandiserOrderingPage element
    private final TextLabel searchByText = new TextLabel(driver, SEARCH_BY_TEXT);
    private final Link userInfoLink = new Link(driver, USER_INFO_LINK);
    private final Dropdown searchDropdown = new Dropdown(driver, SEARCH_DROPDOWN);
    private final TextInputField searchInput = new TextInputField(driver, SEARCH_INPUT);
    private final Button applyButton = new Button(driver, APPLY_BUTTON);
    private final TextLabel orderNameCell = new TextLabel(driver, ORDER_NAME_CELL.modify("2"));
    private final TextLabel statusCell = new TextLabel(driver, STATUS_CELL.modify("2"));
    private final Link deleteCellLink = new Link(driver, DELETE_CELL_LINK.modify("2"));

    private final Link editCellLink = new Link(driver, EDIT_CELL_LINK.modify("2"));

    private final Button orderNameHeaderButton = new Button(driver, ORDER_NAME_HEADER_LINK);
    private final Button totalPriceHeaderButton = new Button(driver, TOTAL_PRICE_HEADER_LINK);
    private final Button maxDiscountHeaderButton = new Button(driver, MAX_DISCOUNT_HEADER_LINK);
    private final Button statusHeaderButton = new Button(driver, STATUS_HEADER_LINK);
    private final Button forwardButton = new Button(driver, FORWARD_NAVIGATION_BUTTON);
    private final Button backwardButton = new Button(driver, BACKWARD_NAVIGATION_BUTTON);
    private final Button firstButton = new Button(driver, FIRST_NAVIGATION_BUTTON);
    private final Button lastButton = new Button(driver, LAST_NAVIGATION_BUTTON);

    private final Link orderNameFirstCellLink = new Link(driver, ORDER_NAME_CELL_VALUE);
    private final Link orderNameSecondCellLink = new Link(driver, ORDER_NAME_CELL.modify("3"));

    private final Element orderNameColumnLink = new Element(driver, ORDER_NAME_COLUMN);
    private final Element totalPriceColumnLink = new Element(driver, TOTAL_PRICE_COLUMN);
    private final Element maxDiscountColumnLink = new Element(driver, MAX_DISCOUNT_COLUMN);
    private final Element statusColumnLink = new Element(driver, STATUS_COLUMN);

    private final Link numberOfGridPages = new Link(driver, PAGE_NUMBER_TEXT);
    private final Link pageCount = new Link(driver, PAGE_COUNT_TEXT);
    private final Link resizeOrdersListLinks = new Link(driver, RESIZE_ORDERS_LIST_LINK);
    private final Link showItemsLink = new Link(driver, SHOW_ITEMS_LINK);


    //TODO remove, turn locator into class fields
    public final Link getOrderLinkByNumber(final String editOrderNumber) {
        return new Link(driver, EDIT_CELL_LINK.modify(editOrderNumber));
    }


    //TODO remove, turn locator into class fields

    public final Link getOrderStatusByNumber(final String statusNumber) {
        return new Link(driver, STATUS_CELL.modify(statusNumber));
    }

    public MerchandiserOrderingPage(final WebDriver driver) {
        super(driver);
    }

    public final MerchandiserEditOrderPage clickEditOrder(final Link editOrderLink) {
        editOrderLink.click();
        return new MerchandiserEditOrderPage(driver);
    }

    public final MerchandiserOrderingPage clickShowItems() {
        showItemsLink.click();
        return this;
    }

}
