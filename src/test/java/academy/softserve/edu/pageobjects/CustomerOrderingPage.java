package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.Button;
import academy.softserve.edu.elements.wrappers.Dropdown;
import academy.softserve.edu.elements.wrappers.Link;
import academy.softserve.edu.elements.wrappers.TextInputField;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.customer.CustomerOrderingPageLocators.*;

@Getter
public class CustomerOrderingPage extends PageObject<CustomerOrderingPage> {

    //TODO remove
    public static final String CUSTOMER_ORDERING_PAGE_URL = "http://192.168.56.101:8080/oms5/order.htm";
    private final Link userInfoLink = new Link(driver, USER_INFO_LINK);
    // createNewOrderLink is an unique CustomerOrderingPage element
    private final Link createNewOrderLink = new Link(driver, CREATE_NEW_ORDER_LINK);
    private final Dropdown searchDropdown = new Dropdown(driver, SEARCH_DROPDOWN);
    private final TextInputField searchInput = new TextInputField(driver, SEARCH_INPUT);
    private final Button applyButton = new Button(driver, APPLY_BUTTON);
    // TODO make one method instead of two
    public static final By SHOW_10_ITEMS_LINK = By.xpath(".//form[@id='searchFilter']//a");
    public static final By SHOW_5_ITEMS_LINK = By.xpath(".//form[@id='searchFilter']//a");

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
}
