package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.*;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.customer.CreateNewOrderPageLocators.*;

@Getter
//TODO reformat code into common look - private final Dropdown searchForItemDropdown = new Dropdown(driver, SEARCH_FOR_ITEM_DROPDOWN);
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
    private final Link validDeliveryDate =
            new Link(driver, VALID_DELIVERY_DATE_LINK);
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
    private final Button orderButton =
            new Button(driver, ORDER_BUTTON);
    private final TextLabel incorrectCardErrorMessage =
            new TextLabel(driver, INCORRECT_CARD_ERROR);
    private final TextInputField orderNumberTextfield =
            new TextInputField(driver, ORDER_NUMBER_FIELD);
    private final Element totalsSection =
            new Element(driver, TOTALS_FIELDSET);
    private final TextLabel orderNumberText =
            new TextLabel(driver, ORDER_NUMBER_TEXT);
    private final TextLabel statusText =
            new TextLabel(driver, STATUS_TEXT);
    private final TextLabel totalPriceText =
            new TextLabel(driver, TOTAL_PRICE_TEXT);
    private final TextLabel totalNumberOfItemsText =
            new TextLabel(driver, TOTAL_NUMBER_OF_ITEMS_TEXT);
    private final TextLabel dateOfOrderingText =
            new TextLabel(driver, DATE_OF_ORDERING_TEXT);
    private final TextInputField preferableDeliveryDateText =
            new TextInputField(driver, PREFERABLE_DELIVERY_DATE_TEXT);
    private final TextLabel deliveryDateText =
            new TextLabel(driver, DELIVERY_DATE_TEXT);
    private final TextLabel assigneeText =
            new TextLabel(driver, ASSIGNEE_TEXT);
    private final TextInputField orderNumber =
            new TextInputField(driver, ORDER_NUMBER_FIELD);
    private final TextLabel statusField =
            new TextLabel(driver, STATUS_FIELD);
    private final TextLabel totalPriceField =
            new TextLabel(driver, TOTAL_PRICE_FIELD);
    private final TextLabel totalNumberOfItemsField =
            new TextLabel(driver, TOTAL_NUMBER_OF_ITEMS_FIELD);
    private final TextLabel dateOfOrderingField =
            new TextLabel(driver, DATE_OF_ORDERING_FIELD);
    private final TextInputField preferableDeliveryDateField =
            new TextInputField(driver, PREFERABLE_DELIVERY_DATE_FIELD);
    private final Link preferableDeliveryDateChooseLink =
            new Link(driver, PREFERABLE_DELIVERY_DATE_CHOOSE_LINK);
    private final TextLabel deliveryDateField =
            new TextLabel(driver, DELIVERY_DATE_FIELD);
    private final Dropdown assigneeDropdown =
            new Dropdown(driver, ASSIGNEE_DROPDOWN);
    private final Button saveButton =
            new Button(driver, SAVE_BUTTON);
    private final Element calendarPopupElement =
            new Element(driver, CALENDAR_POPUP_ELEMENT);
    private final Button calendarMondayElement =
            new Button(driver, CALENDAR_MONDAY_ELEMENT.modify("3"));
    private final Button calendarTuesdayElement =
            new Button(driver, CALENDAR_TUESDAY_ELEMENT.modify("3"));
    private final Button calendarWednesdayElement =
            new Button(driver, CALENDAR_WEDNESDAY_ELEMENT.modify("3"));
    private final Button calendarThursdayElement =
            new Button(driver, CALENDAR_THURSDAY_ELEMENT.modify("3"));
    private final Button calendarFridayElement =
            new Button(driver, CALENDAR_FRIDAY_ELEMENT.modify("3"));
    private final Button calendarSaturdayElement =
            new Button(driver, CALENDAR_SATURDAY_ELEMENT.modify("3"));
    private final Button calendarSundayElement =
            new Button(driver, CALENDAR_SUNDAY_ELEMENT.modify("3"));
    private final Button calendarYearBackwardButton =
            new Button(driver, CALENDAR_YEAR_BACKWARD_BUTTON);
    private final Button calendarMonthBackwardButton =
            new Button(driver, CALENDAR_MONTH_BACKWARD_BUTTON);
    private final Button calendarYearForwardButton =
            new Button(driver, CALENDAR_YEAR_FORWARD_BUTTON);
    private final Button calendarMonthForwardButton =
            new Button(driver, CALENDAR_MONTH_FORWARD_BUTTON);
    private final TextLabel noItemsError =
            new TextLabel(driver, NO_ITEMS_ERROR);
    private final Button firstItemEditButton =
            new Button(driver, FIRST_ITEM_EDIT_BUTTON);
    private final Button firstItemDeleteButton =
            new Button(driver, FIRST_ITEM_DELETE_BUTTON);

    private  final Link dataLink = new Link(driver, DATA_LINK);

    private  final Link orderingLink = new Link(driver, CUSTOMER_ORDERING_LINK);

    public CreateNewOrderPage(final WebDriver driver) {
        super(driver);
    }

    //TODO rename
    public final OrderItemsErrorMessagePage getOrderItemsErrorMessage() {
        saveButton.click();
        return new OrderItemsErrorMessagePage(driver);
    }

    public final AddItemPage clickAddItemButton() {

        getAddItemButton().click();

        return new AddItemPage(driver);
    }

}
