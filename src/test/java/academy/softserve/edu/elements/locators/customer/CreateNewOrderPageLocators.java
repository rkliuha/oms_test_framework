package academy.softserve.edu.elements.locators.customer;

import academy.softserve.edu.elements.LocatorsType;
import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.By;

public enum CreateNewOrderPageLocators implements ILocator {

    CUSTOMER_ORDERING_LINK("Ordering Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/descendant::a[@href='order.htm']"),

    USER_INFO_LINK("User Info Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/li[2]/a"),

    ITEM_SELECTION_FIELDSET("Item Selection Fieldset",
            LocatorsType.BY_XPATH,
            "//div[@id='content']/fieldset/legend"),

    ADD_ITEM_BUTTON("Add Item Button",
            LocatorsType.BY_XPATH,
            "//form[@id='addItem']/input[@value = 'Add Item']"),

    RESIZE_ITEMS_LIST_LINK("Resize Items List Link",
            LocatorsType.BY_XPATH,
            "//div[@id='content']/fieldset//tr/td[2]/a"),

    ITEM_NUMBER_HEADER("Item Number Header",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']//th[1]"),

    ITEM_NAME_HEADER("Item Name Header",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']//th[2]"),

    ITEM_DESCRIPTION_HEADER("Item Description Header",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']//th[3]"),

    DIMENSION_HEADER("Dimension Header",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']//th[4]"),

    PRICE_HEADER("Price Header",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']//th[5]"),

    QUANTITY_HEADER("Quantity Header",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']//th[6]"),

    PRICE_PER_LINE_HEADER("Price Per Line Header",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']//th[7]"),

    EDIT_HEADER("Edit Header",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']//th[8]"),

    DELETE_HEADER("Delete Header",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']//th[9]"),

    FIRST_NAVIGATION_BUTTON("First Navigation Button",
            LocatorsType.BY_XPATH,
            "//div[@id='list']//form[1]/input[3]"),

    BACKWARD_NAVIGATION_BUTTON("Backward Navigation Button",
            LocatorsType.BY_XPATH,
            "//div[@id='list']//form[2]/input[3]"),

    FORWARD_NAVIGATION_BUTTON("Forward Navigation Button",
            LocatorsType.BY_XPATH,
            "//div[@id='list']//form[3]/input[3]"),

    LAST_NAVIGATION_BUTTON("Last Navigation Button",
            LocatorsType.BY_XPATH,
            "//div[@id='list']//form[4]/input[3]"),

    PAGE_NUMBER_CONTAINER("Page Number Container",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/h4"),

    PAGE_NUMBER_TEXT("Page Number Text",
            LocatorsType.BY_ID,
            "pageNumber"),

    PAGE_COUNT_TEXT("Page Count Text",
            LocatorsType.BY_ID,
            "pageCount"),

    TOTALS_FIELDSET("Totals Fieldset",
            LocatorsType.BY_XPATH,
            "//legend[@id='legendHeight']/strong"),

    ORDER_NUMBER_TEXT("Order Number Text",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[1]/td[1]"),

    ORDER_NUMBER_FIELD("Order Number Field",
            LocatorsType.BY_ID,
            "orderNum"),

    STATUS_TEXT("Status Text",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[2]/td[1]"),

    STATUS_FIELD("Status Field",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[2]/td[2]"),

    TOTAL_PRICE_TEXT("Total Price Text",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[3]/td[1]"),

    TOTAL_PRICE_FIELD("Total Price Field",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[3]/td[2]"),

    TOTAL_NUMBER_OF_ITEMS_TEXT("Total Number Of Items Text",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[4]/td[1]"),

    TOTAL_NUMBER_OF_ITEMS_FIELD("Total Number Of Items Field",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[4]/td[2]"),

    DATE_OF_ORDERING_TEXT("Data Of Ordering Text",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[5]/td[1]"),

    DATE_OF_ORDERING_FIELD("Date Of Ordering Field",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[5]/td[2]"),

    PREFERABLE_DELIVERY_DATE_TEXT("Preferable Delivery Date Text",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[6]/td[1]"),

    PREFERABLE_DELIVERY_DATE_FIELD("Preferable Delivery Date Field",
            LocatorsType.BY_ID,
            "dateDays"),

    PREFERABLE_DELIVERY_DATE_CHOOSE_LINK("Preferable Delivery Date Choose Link",
            LocatorsType.BY_CLASS_NAME,
            "dp-choose-date"),

    DELIVERY_DATE_TEXT("Delivery Date Text",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[7]/td[1]"),

    DELIVERY_DATE_FIELD("Delivery Date Field",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[7]/td[2]"),

    ASSIGNEE_TEXT("Assignee Text",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[8]/td[1]"),

    ASSIGNEE_DROPDOWN("Assignee Dropdown",
            LocatorsType.BY_ID,
            "assignee"),

    CARD_INFO_FIELDSET("Card Info Fieldset",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//legend/strong"),

    CREDIT_CARD_TYPE_TEXT("Credit Card Type Text",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//tr[1]/td[1]//strong[1]"),

    CREDIT_CARD_TYPE_ASTERISK("Credit Card Type Asterisk",
            LocatorsType.BY_ID,
            "redAsterisk3"),

    VISA_CREDIT_CARD_IMG("Visa Credit Card Img",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//tr[1]/td[1]//strong[2]/img[1]"),

    MASTERCARD_CREDIT_CARD_IMG("MasterCard Credit Card Img",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//tr[1]/td[1]//strong[2]/img[2]"),

    AMERICANEXPRESS_CREDIT_CARD_IMG("AmericanExpress Credit Card Img",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//tr[1]/td[1]//strong[2]/img[3]"),

    MAESTRO_CREDIT_CARD_IMG("Maestro Credit Card Img",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//tr[1]/td[1]//strong[2]/img[4]"),

    CREDIT_CARD_TYPE_DROPDOWN("Credit Card Type Dropdown",
            LocatorsType.BY_ID,
            "cardTypes"),

    CREDIT_CARD_NUMBER_TEXT("Credit Card Number Text",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//tr[2]/td[1]/strong"),

    CREDIT_CARD_NUMBER_ASTERISK("Credit Card Number Asterisk",
            LocatorsType.BY_ID,
            "redAsterisk4"),

    CREDIT_CARD_NUMBER_INPUT("Credit Card Number Input",
            LocatorsType.BY_ID,
            "cardNum"),

    CVV2_TEXT("CVV2 Text",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//tr[3]/td[1]/strong"),

    CVV2_WHAT_IS_THIS_LINK("CVV2 What Is This Link",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//tr[3]/td[1]/strong/a"),

    CVV2_ASTERISK("CVV2 Asterisk",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//tr[3]/td[1]/strong/span"),

    CVV2_INPUT("CVV2 Input",
            LocatorsType.BY_ID,
            "cvv2"),

    EXPIRY_DATE("Expiry Date",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//tr[4]/td[1]/strong"),

    EXPIRY_DATE_ASTERISK("Expiry Date Asterisk",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//tr[3]/td[1]/strong/span"),

    EXPIRY_DATE_MONTH_DROPDOWN("Expiry Date Month Dropdown",
            LocatorsType.BY_ID,
            "newCreditCardMonth"),

    EXPIRY_DATE_YEAR_DROPDOWN("Expiry Date Year Dropdown",
            LocatorsType.BY_ID,
            "newCreditCardYear"),

    START_DATE_MAESTRO_TEXT("Start Date Maestro Text",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//tr[5]/td[1]/strong"),

    START_DATE_MAESTRO_ASTERISK("Start Date Maestro Asterisk",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//tr[5]/td[1]/strong/span"),

    START_DATE_MAESTRO_INPUT("Start Date Maestro Input",
            LocatorsType.BY_ID,
            "startDate2"),

    START_DATE_MAESTRO_CHOOSE_LINK("Start date Maestro Choose Link",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//tr[5]/td[2]/strong/a"),

    ISSUE_NUMBER_MAESTRO_TEXT("Issue Number Maestro Text",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//tr[6]/td[1]/strong"),

    ISSUE_NUMBER_MAESTRO_INPUT("Issue Number Maestro Input",
            LocatorsType.BY_ID,
            "issueNumber2"),

    ASTERISK_FIELDS_ARE_MANDATORY_TEXT("Asterisk Fields Are Mandatory Text",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//tr[10]/td[2]/span"),

    SAVE_BUTTON("Save Button",
            LocatorsType.BY_ID,
            "save"),

    ORDER_BUTTON("Order Button",
            LocatorsType.BY_XPATH,
            "//form[@id='orderButton']/input[2]"),

    CANCEL_BUTTON("Cancel Button",
            LocatorsType.BY_XPATH,
            "//form[@id='cancelButton']/input[2]"),

    NO_ITEMS_ERROR("No Items ERROR",
            LocatorsType.BY_ID,
            "totalsError"),

    FIRST_ITEM_NUMBER("First Item Number",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']/tbody/tr[1]/td[1]"),

    FIRST_ITEM_NAME("First Item Name",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']/tbody/tr[1]/td[2]"),

    FIRST_ITEM_DESCRIPTION("First Item Description",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']/tbody/tr[1]/td[3]"),

    FIRST_ITEM_DIMENSION("First Item Dimension",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']/tbody/tr[1]/td[4]"),

    FIRST_ITEM_PRICE("First Item Price",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']/tbody/tr[1]/td[5]"),

    FIRST_ITEM_QUANTITY("First Item Quantity",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']/tbody/tr[1]/td[6]"),

    FIRST_ITEM_PRICE_PER_LINE("First Item Price Per Line",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']/tbody/tr[1]/td[7]"),

    ITEM_SELECTION_SECTION("Item Selection Section",
            LocatorsType.BY_XPATH,
            "//div[@id='content']/fieldset");

    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;

    CreateNewOrderPageLocators(final String elementName,
                               final LocatorsType locatorType, final String locatorValue) {
        this.elementName = elementName;
        this.locatorType = locatorType;
        this.locatorValue = locatorValue;
    }

    @Override
    public String getName() {
        return this.elementName;
    }

    @Override
    public By getBy() {
        By by;
        if (this.modifiedLocator == null) {
            by = this.locatorType.getBy(this.locatorValue);
        } else {
            by = this.locatorType.getBy(this.modifiedLocator);
        }
        return by;
    }

    @Override
    public CreateNewOrderPageLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }
}
