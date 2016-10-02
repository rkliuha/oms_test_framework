package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.*;
import academy.softserve.edu.utils.PropertiesReader;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.merchandiser.MerchandiserEditOrderPageLocators.*;
import static academy.softserve.edu.elements.locators.userinfo.UserInfoPageLocators.USER_INFO_LINK;

@Getter
public class EditOrderByMerchandiserPage extends PageObject<EditOrderByMerchandiserPage> {

    public static final String MERCHANDISER_EDIT_USER_PAGE_URL = PropertiesReader.getDefaultProperty("merchandiser_edit_order_page");
    private final Link userInfoLink = new Link(driver, USER_INFO_LINK);
    private final Dropdown orderStatusDropdown = new Dropdown(driver, ORDER_STATUS_DROPDOWN);
    private final Link showItems = new Link(driver, SHOW_ITEMS);
    private final Button saveButton = new Button(driver, SAVE_BUTTON);

    public EditOrderByMerchandiserPage(final WebDriver driver) {
        super(driver);
    }

    public final EditOrderByMerchandiserPage changeOrderStatusTo(final String status){
        orderStatusDropdown.selectByValue(status);
        return this;
    }
    public final MerchandiserOrderingPage clickSaveButton(){
        saveButton.click();
        return new MerchandiserOrderingPage(driver);
    }
    public final EditOrderByMerchandiserPage clickShowItemsLink(){
        showItems.click();
        return this;
    }
}