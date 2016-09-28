package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.locators.customer.CreateNewOrderPageLocators;
import academy.softserve.edu.elements.wrappers.Button;
import academy.softserve.edu.elements.wrappers.Element;
import academy.softserve.edu.elements.wrappers.TextLabel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class CreateNewOrderPage extends PageObject<CreateNewOrderPage> {

    private final Button addItemButton =
            new Button(driver, CreateNewOrderPageLocators.ADD_ITEM_BUTTON);
    private final TextLabel createNewOrderPageExists =
            new TextLabel(driver, CreateNewOrderPageLocators.CREATE_NEW_ORDER_PAGE_EXISTS);
    private final Element itemSelectionSection =
            new Element(driver, CreateNewOrderPageLocators.ITEM_SELECTION_SECTION);
    private final TextLabel firstItemNumber =
            new TextLabel(driver, CreateNewOrderPageLocators.FIRST_ITEM_NUMBER);
    private final TextLabel firstItemName =
            new TextLabel(driver, CreateNewOrderPageLocators.FIRST_ITEM_NAME);
    private final TextLabel firstItemDescription =
            new TextLabel(driver, CreateNewOrderPageLocators.FIRST_ITEM_DESCRIPTION);
    private final TextLabel firstItemDimension =
            new TextLabel(driver, CreateNewOrderPageLocators.FIRST_ITEM_DIMENSION);
    private final TextLabel firstItemPrice =
            new TextLabel(driver, CreateNewOrderPageLocators.FIRST_ITEM_PRICE);
    private final TextLabel firstItemQuantity =
            new TextLabel(driver, CreateNewOrderPageLocators.FIRST_ITEM_QUANTITY);
    private final TextLabel firstItemPricePerLine =
            new TextLabel(driver, CreateNewOrderPageLocators.FIRST_ITEM_PRICE_PER_LINE);

    public CreateNewOrderPage(final WebDriver driver) {
        super(driver);
    }

}
