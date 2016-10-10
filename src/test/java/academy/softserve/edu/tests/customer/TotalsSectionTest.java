package academy.softserve.edu.tests.customer;

import academy.softserve.edu.domains.Order;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.OrderItemsErrorMessagePage;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import academy.softserve.edu.utils.DBHelper;
import org.testng.annotations.*;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;

public class TotalsSectionTest extends TestRunner {

    private int orderItem;
    private String orderNumber;
    private int testProductId;
    private String dateOfOrdering;
    private OrderItemsErrorMessagePage orderItemsErrorMessagePage;

    @BeforeTest
    public final void createTestProduct() {

        testProductId = DBHelper.createActiveProductInDB();
    }

    @BeforeMethod
    public final void setUpTests() {

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);
        customerOrderingPage = userInfoPage.clickCustomerOrderingTab();
        createNewOrderPage = customerOrderingPage.clickCreateNewOrderLink();

        addItemPage = createNewOrderPage.clickAddItemButton();
        addItemPage.clickSelectLastAddedItemLink()
                .clickDoneButton();

        orderNumber = createNewOrderPage.getOrderNumberTextfield().getValue();
        //  For comparing with DateOrdering after clicking "Save" with correct parameters
        dateOfOrdering = createNewOrderPage.getStartDateMaestroTextfield().getValue();
    }

    //  Test "Totals" section is displayed below the grid on the 'Create new order' page
    @Test
    public final void testTotalsSectionElementsVisibility() {

        assertThat(createNewOrderPage.getTotalsSection())
                .isDisplayed();

        assertThat(createNewOrderPage.getOrderNumberText())
                .isDisplayed();

        assertThat(createNewOrderPage.getStatusText())
                .isDisplayed();

        assertThat(createNewOrderPage.getTotalPriceText())
                .isDisplayed();

        assertThat(createNewOrderPage.getTotalNumberOfItemsText())
                .isDisplayed();

        assertThat(createNewOrderPage.getDateOfOrderingText())
                .isDisplayed();

        assertThat(createNewOrderPage.getPreferableDeliveryDateText())
                .isDisplayed();

        assertThat(createNewOrderPage.getDeliveryDateText())
                .isDisplayed();

        assertThat(createNewOrderPage.getAssigneeText())
                .isDisplayed();

        assertThat(createNewOrderPage.getSaveButton())
                .isDisplayed();
    }

    //  Test all the required parameters of the order are displayed in the 'Totals' section
    @Test
    public final void testTotalsParametersVisibility() {

        assertThat(createNewOrderPage.getOrderNumber())
                .isNotNull();

        assertThat(createNewOrderPage.getStatusField())
                .isTextEmpty();

        assertThat(createNewOrderPage.getTotalPriceField())
                .textEquals(createNewOrderPage.getFirstItemPricePerLine().getText());

        assertThat(createNewOrderPage.getTotalNumberOfItemsField())
                .isTextNotEmpty();

        assertThat(createNewOrderPage.getDateOfOrderingField())
                .isTextEmpty();

        assertThat(createNewOrderPage.getPreferableDeliveryDateField())
                .isValueEmpty();

        assertThat(createNewOrderPage.getDeliveryDateField())
                .isTextEmpty();

        assertThat(createNewOrderPage.getAssigneeDropdown())
                .valueNotEqual(DBHandler.getUserByRole(Roles.MERCHANDISER).getLogin());
    }

    //  Test order status if the Totals are correctly specified is performed
    @Test
    public final void testItemsExist() {

        createNewOrderPage.clickPreferableDeliveryDateChooseLink();

        assertThat(createNewOrderPage.getCalendarPopupElement())
                .isDisplayed();

        createNewOrderPage.clickCalendarMonthForwardButton()
                .clickCalendarTuesdayElement();

        final String preferableDate = createNewOrderPage.getPreferableDeliveryDateField().getValue();

        createNewOrderPage.selectAssigneeDropdown(DBHandler.getUserByRole(Roles.MERCHANDISER).getLogin())
                .clickSaveButton();

        orderItem = DBHandler.getLastOrderItem().getId();

        assertThat(createNewOrderPage.getOrderNumber())
                .valueEquals(orderNumber);

        assertThat(createNewOrderPage.getStatusField())
                .textEquals("Created");

        assertThat(createNewOrderPage.getDateOfOrderingField())
                .textEquals(dateOfOrdering);

        assertThat(createNewOrderPage.getPreferableDeliveryDateField())
                .valueEquals(preferableDate);

        assertThat(createNewOrderPage.getAssigneeDropdown())
                .valueEquals(DBHandler.getUserByRole(Roles.MERCHANDISER).getLogin());

        final Order testOrder = DBHandler.getOrderByNumber(Integer.parseInt(orderNumber));

        assertThat(testOrder)
                .statusNameEquals(DBHandler.getOrderByNumber(Integer.parseInt(orderNumber)).getOrderStatusName());
    }

    //  Test error messages if some parameter incorrect
    @Test
    public final void testErrorMessages() {

        createNewOrderPage.clickSaveButton();

        assertThat(createNewOrderPage.getNoItemsError())
                .isDisplayed();

        createNewOrderPage.refreshPage();

        createNewOrderPage.clickPreferableDeliveryDateChooseLink()
                .clickCalendarMonthForwardButton()
                .clickCalendarTuesdayElement()
                .clickSaveButton();

        assertThat(createNewOrderPage.getNoItemsError())
                .isDisplayed();

        createNewOrderPage.refreshPage();

        createNewOrderPage.selectAssigneeDropdown(DBHandler.getUserByRole(Roles.MERCHANDISER).getLogin())
                .clickSaveButton();

        assertThat(createNewOrderPage.getNoItemsError())
                .isDisplayed();

        createNewOrderPage.refreshPage();

        createNewOrderPage.clickFirstItemDeleteButton()
                .clickSaveButton();

        assertThat(createNewOrderPage.getNoItemsError())
                .isDisplayed();
    }

    //  Test error message, if the Totals are correctly specified without order number
    @Test
    public final void testOrderNumberEmptyErrorMessage() {

        createNewOrderPage.clickPreferableDeliveryDateChooseLink()
                .clickCalendarMonthForwardButton()
                .clickCalendarTuesdayElement()
                .selectAssigneeDropdown(DBHandler.getUserByRole(Roles.MERCHANDISER).getLogin());

        createNewOrderPage.getOrderNumber()
                .clear();

        orderItemsErrorMessagePage = createNewOrderPage.clickSaveButtonFail();

        assertThat(orderItemsErrorMessagePage.getContentText())
                .textContains("Order Number is int value");
    }

    //  Test error message, if the Totals are correctly specified
    // with order number, what already exists
    @Test
    public final void testOrderNumberExistsErrorMessage() {

        createNewOrderPage.clickPreferableDeliveryDateChooseLink()
                .clickCalendarMonthForwardButton()
                .clickCalendarTuesdayElement()
                .selectAssigneeDropdown(DBHandler.getUserByRole(Roles.MERCHANDISER).getLogin())
                .clickSaveButton();

        customerOrderingPage = userInfoPage.clickCustomerOrderingTab();
        createNewOrderPage = customerOrderingPage.clickCreateNewOrderLink();
        createNewOrderPage.clickAddItemButton();

        addItemPage.clickSelectLastAddedItemLink()
                .clickDoneButton();

        createNewOrderPage.getOrderNumber()
                .sendKeys(orderNumber);

        createNewOrderPage.clickPreferableDeliveryDateChooseLink()
                .clickCalendarMonthForwardButton()
                .clickCalendarTuesdayElement()
                .selectAssigneeDropdown(DBHandler.getUserByRole(Roles.MERCHANDISER).getLogin());

        orderItemsErrorMessagePage = createNewOrderPage.clickSaveButtonFail();

        assertThat(orderItemsErrorMessagePage.getContentText())
                .textContains("such order number already exists");
    }

    @AfterMethod
    public final void deleteTestOrder() {
        DBHandler.deleteOrderByNumber(Integer.parseInt(orderNumber));
        DBHandler.deleteOrderItemById(orderItem);
    }

    @AfterTest
    public final void deleteTestProduct() {
        DBHandler.deleteProduct(testProductId);
    }
}
