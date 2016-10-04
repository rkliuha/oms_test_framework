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
