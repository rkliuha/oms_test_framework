package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.*;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.administrator.AdministrationPageLocators.PAGE_NUMBER_TEXT;
import static academy.softserve.edu.elements.locators.merchandiser.MerchandiserOrderingPageLocators.*;
import static academy.softserve.edu.elements.locators.userinfo.UserInfoPageLocators.USER_INFO_LINK;

@Getter
public class MerchandiserOrderingPage extends PageObject<MerchandiserOrderingPage> {

    //TODO remove
    public static final String MERCHANDISER_ORDERING_PAGE_URL = "http://192.168.56.101:8080/oms5/order.htm";
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

    private final Link orderNameFirstCellLink = new Link(driver,
            ORDER_NAME_CELL.modify("//*[@id='list']/table/tbody/tr[2]/td[1]"));
    private final Link orderNameSecondCellLink = new Link(driver,
            ORDER_NAME_CELL.modify("//*[@id='list']/table/tbody/tr[3]/td[1]"));

    private final Link orderNameColumnLink = new Link(driver, ORDER_NAME_COLUMN);
    private final Link totalPriceColumnLink = new Link(driver, TOTAL_PRICE_COLUMN);
    private final Link maxDiscountColumnLink = new Link(driver, MAX_DISCOUNT_COLUMN);
    private final Link statusColumnLink = new Link(driver, STATUS_COLUMN);

    private final Link numberOfGridPages = new Link(driver, PAGE_NUMBER_TEXT);
    private final Link pageCount = new Link(driver, PAGE_COUNT_TEXT);
    private final Link resizeOrdersListLinks = new Link(driver, RESIZE_ORDERS_LIST_LINK);


    public final Link getOrderLinkByNumber(final String editOrderNumber) {
        return new Link(driver, EDIT_CELL_LINK.modify(editOrderNumber));
    }

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


}
