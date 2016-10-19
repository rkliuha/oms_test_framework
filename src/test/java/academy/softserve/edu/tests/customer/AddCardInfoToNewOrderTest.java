package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import academy.softserve.edu.utils.DBHelper;
import org.testng.annotations.*;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class AddCardInfoToNewOrderTest extends TestRunner {

    private static final String CVV2_CODE = "456";
    private static final String EXPIRE_DATE_MONTH = "10";
    private static final String EXPIRE_DATE_YEAR = "2017";

    private int testProductId;
    private String orderNumber;

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

        orderNumber = createNewOrderPage.getOrderNumberTextfield()
                .getValue();

        createNewOrderPage.clickPreferableDeliveryDateChooseLink()
                .clickValidDeliveryDateLink()
                .selectAssigneeDropdown(DBHandler.getUserByRole(Roles.MERCHANDISER).getLogin());
    }

    @Test
    public final void testAddIncorrectCardToOrder() {

        createNewOrderPage.clickSaveButton();

        createNewOrderPage.selectCreditCardTypeDropdown("Visa")
                .fillCreditCardNumberTextfield("2562624")
                .fillCVV2Textfield(CVV2_CODE)
                .selectExpireDateMonthDropdown(EXPIRE_DATE_MONTH)
                .selectExpireDateYearDropdown(EXPIRE_DATE_YEAR)
                .clickOrderButton();

        assertThat(createNewOrderPage.getIncorrectCardErrorMessage())
                .isDisplayed();
    }

    @Test
    public final void testAddVisaCardToOrder() {

        createNewOrderPage.clickSaveButton();

        createNewOrderPage.selectCreditCardTypeDropdown("Visa")
                .fillCreditCardNumberTextfield("4532543327732234")
                .fillCVV2Textfield(CVV2_CODE)
                .selectExpireDateMonthDropdown(EXPIRE_DATE_MONTH)
                .selectExpireDateYearDropdown(EXPIRE_DATE_YEAR)
                .clickOrderButton();

        customerOrderingPage.fillSearchInput("OrderName" + orderNumber)
                .clickApplyButton();

        assertThat(customerOrderingPage.getOrderStatusByNumber(orderNumber))
                .textEquals("Ordered");
    }

    @Test
    public final void testAddMasterCardToOrder() {

        createNewOrderPage.clickSaveButton();

        createNewOrderPage.selectCreditCardTypeDropdown("MasterCard")
                .fillCreditCardNumberTextfield("5408694520868818")
                .fillCVV2Textfield(CVV2_CODE)
                .selectExpireDateMonthDropdown(EXPIRE_DATE_MONTH)
                .selectExpireDateYearDropdown(EXPIRE_DATE_YEAR)
                .clickOrderButton();

        customerOrderingPage.fillSearchInput("OrderName" + orderNumber)
                .clickApplyButton();

        assertThat(customerOrderingPage.getOrderStatusByNumber(orderNumber))
                .textEquals("Ordered");
    }

    @Test
    public final void testAddAmericanExpressCardToOrder() {

        createNewOrderPage.clickSaveButton();

        createNewOrderPage.selectCreditCardTypeDropdown("American Express")
                .fillCreditCardNumberTextfield("345024720300379")
                .fillCVV2Textfield(CVV2_CODE)
                .selectExpireDateMonthDropdown(EXPIRE_DATE_MONTH)
                .selectExpireDateYearDropdown(EXPIRE_DATE_YEAR)
                .clickOrderButton();

        customerOrderingPage.fillSearchInput("OrderName" + orderNumber)
                .clickApplyButton();

        assertThat(customerOrderingPage.getOrderStatusByNumber(orderNumber))
                .textEquals("Ordered");
    }

    @Test
    public final void testAddMaestroCardToOrder() {

        createNewOrderPage.clickSaveButton();

        createNewOrderPage.selectCreditCardTypeDropdown("Maestro")
                .fillCreditCardNumberTextfield("6759316694729609")
                .fillCVV2Textfield(CVV2_CODE)
                .selectExpireDateMonthDropdown(EXPIRE_DATE_MONTH)
                .selectExpireDateYearDropdown(EXPIRE_DATE_YEAR)
                .fillStartDateMaestroTextfield("29/09/2016")
                .fillIssueNumberMaestroTextfield("4")
                .clickOrderButton();

        customerOrderingPage.fillSearchInput("OrderName" + orderNumber)
                .clickApplyButton();

        assertThat(customerOrderingPage.getOrderStatusByNumber(orderNumber))
                .textEquals("Ordered");
    }

    @AfterMethod
    public final void deleteTestOrder() {
        DBHandler.deleteOrderByNumber(Integer.parseInt(orderNumber));
        DBHandler.deleteOrderItemByOrderRef(Integer.parseInt(orderNumber));
    }

    @AfterTest
    public final void deleteTestProduct() {
        DBHandler.deleteProduct(testProductId);
    }
}
