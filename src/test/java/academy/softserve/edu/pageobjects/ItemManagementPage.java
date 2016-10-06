package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.*;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.supervisor.ItemManagementPageLocators.*;
import static academy.softserve.edu.elements.locators.userinfo.UserInfoPageLocators.USER_INFO_LINK;

@Getter
public class ItemManagementPage extends PageObject<ItemManagementPage> {

    private final Link userInfoLink = new Link(driver, USER_INFO_LINK);
    private final Dropdown searchFieldFilterDropdown = new Dropdown(driver, SEARCH_FIELD_FILTER_DROPDOWN);
    private final TextInputField searchInput = new TextInputField(driver, SEARCH_INPUT);
    private final Button searchButton = new Button(driver, SEARCH_BUTTON);
    private final Link addProductLink = new Link(driver, ADD_PRODUCT_LINK);
    // searchByFieldSet is unique ItemManagementPage element
    private final TextLabel searchByFieldSet = new TextLabel(driver, SEARCH_BY_FIELDSET);
    private final TextLabel recordsCountText = new TextLabel(driver, RECORDS_COUNT_TEXT);

    public final Link getEditProductLinkById(final String productId) {
        return new Link(driver, EDIT_PRODUCT_LINK.modify(productId));
    }

    public ItemManagementPage(final WebDriver driver) {
        super(driver);
    }

    public final AddProductPage clickAddProductLink() {
        getAddProductLink().click();
        return new AddProductPage(driver);
    }

}


