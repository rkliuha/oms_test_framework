package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.locators.customer.AddItemPageLocators;
import academy.softserve.edu.elements.wrappers.*;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class AddItemPage extends PageObject<AddItemPage> {

    private final Button addItemPageExists =
            new Button(driver, AddItemPageLocators.RESET_BUTTON);
    private final Link selectLastAddedItemLink =
            new Link(driver, AddItemPageLocators.SELECT_LAST_ADDED_ITEM_LINK);
    private final TextLabel itemTextField =
            new TextLabel(driver, AddItemPageLocators.ITEM_TEXT_FIELD);
    private final TextLabel itemPriceField =
            new TextLabel(driver, AddItemPageLocators.ITEM_PRICE_FIELD);
    private final TextInputField itemQuantityTextfield =
            new TextInputField(driver, AddItemPageLocators.ITEM_QUANTITY_INPUT);
    private final Dropdown itemDimensionDropdown =
            new Dropdown(driver, AddItemPageLocators.ITEM_DIMENSION_DROPDOWN);
    private final Button doneButton =
            new Button(driver, AddItemPageLocators.DONE_BUTTON);

    public AddItemPage(final WebDriver driver) {
        super(driver);
    }

}
