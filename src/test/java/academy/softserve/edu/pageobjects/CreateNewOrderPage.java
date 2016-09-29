package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.Button;
import academy.softserve.edu.elements.wrappers.Element;
import academy.softserve.edu.elements.wrappers.TextLabel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.customer.CreateNewOrderPageLocators.*;

@Getter
public class CreateNewOrderPage extends PageObject<CreateNewOrderPage> {

    /**
     * CVV2Text is an unique element on the CreateNewOrderPage,
     * can be used as identification of page;
     */
    private final TextLabel CVV2Text =
            new TextLabel(driver, CVV2_TEXT);
    private final Button addItemButton =
            new Button(driver, ADD_ITEM_BUTTON);
    private final Element itemSelectionSection =
            new Element(driver, ITEM_SELECTION_SECTION);
    private final TextLabel firstItemNumber =
            new TextLabel(driver, FIRST_ITEM_NUMBER);
    private final TextLabel firstItemName =
            new TextLabel(driver, FIRST_ITEM_NAME);
    private final TextLabel firstItemDescription =
            new TextLabel(driver, FIRST_ITEM_DESCRIPTION);
    private final TextLabel firstItemDimension =
            new TextLabel(driver, FIRST_ITEM_DIMENSION);
    private final TextLabel firstItemPrice =
            new TextLabel(driver, FIRST_ITEM_PRICE);
    private final TextLabel firstItemQuantity =
            new TextLabel(driver, FIRST_ITEM_QUANTITY);
    private final TextLabel firstItemPricePerLine =
            new TextLabel(driver, FIRST_ITEM_PRICE_PER_LINE);

    public CreateNewOrderPage(final WebDriver driver) {
        super(driver);
    }

}
