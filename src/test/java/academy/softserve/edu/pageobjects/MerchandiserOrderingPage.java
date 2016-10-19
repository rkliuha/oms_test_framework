package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.*;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.merchandiser.MerchandiserOrderingPageLocators.*;
import static academy.softserve.edu.elements.locators.userinfo.UserInfoPageLocators.USER_INFO_LINK;

@Getter
public class MerchandiserOrderingPage extends PageObject<MerchandiserOrderingPage> {

    /**
     * searchByText is an unique element on the MerchandiserOrderingPage,
     * can be used as identification of page;
     */
    private final TextLabel searchByText = new TextLabel(driver, SEARCH_BY_TEXT);

    private final Link userInfoLink = new Link(driver, USER_INFO_LINK);

    private final Dropdown searchDropdown = new Dropdown(driver, SEARCH_DROPDOWN);

    private final TextInputField searchInput = new TextInputField(driver, SEARCH_INPUT);

    private final Button applyButton = new Button(driver, APPLY_BUTTON);

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

    private final Element orderNameColumnLink = new Element(driver, ORDER_NAME_COLUMN);

    private final Element totalPriceColumnLink = new Element(driver, TOTAL_PRICE_COLUMN);

    private final Element maxDiscountColumnLink = new Element(driver, MAX_DISCOUNT_COLUMN);

    private final Element statusColumnLink = new Element(driver, STATUS_COLUMN);

    private final Link numberOfGridPages = new Link(driver, PAGE_NUMBER_TEXT);

    private final Link pageCount = new Link(driver, PAGE_COUNT_TEXT);

    private final Link resizeOrdersListLink = new Link(driver, RESIZE_ORDERS_LIST_LINK);

    private final Link showItemsLink = new Link(driver, SHOW_ITEMS_LINK);

    public final Link getOrderLinkByNumber(final String editOrderNumber) {

        return new Link(driver, EDIT_CELL_LINK.modify(editOrderNumber));
    }

    public final Link getOrderStatusByNumber(final String statusNumber) {

        return new Link(driver, STATUS_CELL.modify(statusNumber));
    }

    public final TextLabel getOrderNameByCellId(final String cellId) {

        return new TextLabel(driver, ORDER_NAME_CELL.modify(cellId));
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

    public final UserInfoPage clickUserInfoLink() {

        userInfoLink.click();
        return new UserInfoPage(driver);
    }

    public final MerchandiserOrderingPage clickApplyButton() {

        applyButton.click();
        return this;
    }

    public final MerchandiserOrderingPage clickOrderNameHeaderButton() {

        orderNameHeaderButton.click();
        return this;
    }

    public final MerchandiserOrderingPage clickTotalPriceHeaderButton() {

        totalPriceHeaderButton.click();
        return this;
    }

    public final MerchandiserOrderingPage clickMaxDiscountHeaderButton() {

        maxDiscountHeaderButton.click();
        return this;
    }

    public final MerchandiserOrderingPage clickStatusHeaderButton() {

        statusHeaderButton.click();
        return this;
    }

    public final MerchandiserOrderingPage clickForwardButton() {

        forwardButton.click();
        return this;
    }

    public final MerchandiserOrderingPage clickBackwardButton() {

        backwardButton.click();
        return this;
    }

    public final MerchandiserOrderingPage clickLastButton() {

        lastButton.click();
        return this;
    }

    public final MerchandiserOrderingPage clickFirstButton() {

        firstButton.click();
        return this;
    }

    public final MerchandiserOrderingPage clickResizeOrdersListLink() {

        resizeOrdersListLink.click();
        return this;
    }

    public final MerchandiserOrderingPage clickDeleteCellLink() {

        deleteCellLink.click();
        return this;
    }

    public final MerchandiserOrderingPage selectSearchDropdown(final String condition) {

        searchDropdown.sendKeys(condition);
        return this;
    }

    public final MerchandiserOrderingPage fillSearchInput(final String searchText) {

        searchInput.sendKeys(searchText);
        return this;
    }

}
