package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.*;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    private final TextLabel cardInfoText =
            new TextLabel(driver, CARD_INFO_TEXT);
    private final TextLabel creditCardTypeText =
            new TextLabel(driver, CREDIT_CARD_TYPE_TEXT);
    private final TextLabel creditCardNumberText =
            new TextLabel(driver, CREDIT_CARD_NUMBER_TEXT);
    private final TextLabel expireDateText =
            new TextLabel(driver, EXPIRY_DATE);
    private final TextLabel startDateMaestroText =
            new TextLabel(driver, START_DATE_MAESTRO_TEXT);
    private final TextLabel issueNumberMaestroText =
            new TextLabel(driver, ISSUE_NUMBER_MAESTRO_TEXT);
    private final Link preferableDeliveryDateChooseLink =
            new Link(driver, PREFERABLE_DELIVERY_DATE_CHOOSE_LINK);
    private final Link validDeliveryDate =
            new Link(driver, VALID_DELIVERY_DATE_LINK);
    private final Dropdown assigneeDropdown =
            new Dropdown(driver, ASSIGNEE_DROPDOWN);
    private final Dropdown creditCardTypeDropdown =
            new Dropdown(driver, CREDIT_CARD_TYPE_DROPDOWN);
    private final TextInputField creditCardNumberTextfield =
            new TextInputField(driver, CREDIT_CARD_NUMBER_TEXTFIELD);
    private final TextInputField CVV2Textfield =
            new TextInputField(driver, CVV2_INPUT);
    private final Dropdown expireDateMonthDropdown =
            new Dropdown(driver, EXPIRY_DATE_MONTH_DROPDOWN);
    private final Dropdown expireDateYearDropdown =
            new Dropdown(driver, EXPIRY_DATE_YEAR_DROPDOWN);
    private final TextInputField startDateMaestroTextfield =
            new TextInputField(driver, START_DATE_MAESTRO_INPUT);
    private final TextInputField issueNumberMaestroTextfield =
            new TextInputField(driver, ISSUE_NUMBER_MAESTRO_INPUT);
    private final Button saveButton =
            new Button(driver, SAVE_BUTTON);
    private final Button orderButton =
            new Button(driver, ORDER_BUTTON);
    private final TextLabel incorrectCardErrorMessage =
            new TextLabel(driver, INCORRECT_CARD_ERROR);
    private final TextInputField orderNumberTextfield =
            new TextInputField(driver, ORDER_NUMBER_FIELD);

    public CreateNewOrderPage(final WebDriver driver) {
        super(driver);
    }

}
