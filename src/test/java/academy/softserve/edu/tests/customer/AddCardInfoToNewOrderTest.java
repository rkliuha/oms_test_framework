package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.AddItemPage;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import academy.softserve.edu.utils.TestUtil;
import org.testng.annotations.*;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class AddCardInfoToNewOrderTest extends TestRunner {

    //TODO move inline
    private static final String CVV2_CODE = "456";
    private static final String EXPIRE_DATE_MONTH = "10";
    private static final String EXPIRE_DATE_YEAR = "2017";

    private int testProductId;
    private String orderNumber;

    @BeforeTest
    public final void createTestProduct() {
        testProductId = TestUtil.createActiveProductInDB();
    }

    @BeforeMethod
    public final void setUpTests() {

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);
        customerOrderingPage = userInfoPage.clickCustomerOrderingTab();

        createNewOrderPage = customerOrderingPage.clickCreateNewOrderLink();
        createNewOrderPage.getAddItemButton().click();

        addItemPage = new AddItemPage(driver);
        addItemPage.getSelectLastAddedItemLink().click();
        addItemPage.getDoneButton().click();

        orderNumber = createNewOrderPage.getOrderNumberTextfield().getValue();

        createNewOrderPage.getPreferableDeliveryDateChooseLink().click();
        createNewOrderPage.getValidDeliveryDate().click();
        createNewOrderPage.getAssigneeDropdown().sendKeys(DBHandler.getUserByRole(Roles.MERCHANDISER).getLogin());
    }

    @Test
    //TODO remove, no need, you interact with elements in other tests
    public final void testElementsVisibility() {

        assertThat(createNewOrderPage.getCardInfoText())
                .isDisplayed();

        assertThat(createNewOrderPage.getCreditCardTypeText())
                .isDisplayed();

        assertThat(createNewOrderPage.getCreditCardNumberText())
                .isDisplayed();

        assertThat(createNewOrderPage.getCVV2Text())
                .isDisplayed();

        assertThat(createNewOrderPage.getExpireDateText())
                .isDisplayed();

        assertThat(createNewOrderPage.getStartDateMaestroText())
                .isDisplayed();

        assertThat(createNewOrderPage.getIssueNumberMaestroText())
                .isDisplayed();

        assertThat(createNewOrderPage.getOrderButton())
                .isDisabled();

        createNewOrderPage.getSaveButton().click();

        assertThat(createNewOrderPage.getOrderButton())
                .isEnabled();
    }

    @Test
    public final void testAddIncorrectCardToOrder() {

        createNewOrderPage.getSaveButton().click();

        createNewOrderPage.getCreditCardTypeDropdown().sendKeys("Visa");
        createNewOrderPage.getCreditCardNumberTextfield().sendKeys("2562624");
        createNewOrderPage.getCVV2Textfield().sendKeys(CVV2_CODE);
        createNewOrderPage.getExpireDateMonthDropdown().sendKeys(EXPIRE_DATE_MONTH);
        createNewOrderPage.getExpireDateYearDropdown().sendKeys(EXPIRE_DATE_YEAR);

        createNewOrderPage.getOrderButton().click();

        assertThat(createNewOrderPage.getIncorrectCardErrorMessage())
                .isDisplayed();
    }

    @Test
    public final void testAddVisaCardToOrder() {

        createNewOrderPage.getSaveButton().click();

        createNewOrderPage.getCreditCardTypeDropdown().sendKeys("Visa");
        createNewOrderPage.getCreditCardNumberTextfield().sendKeys("4532543327732234");
        createNewOrderPage.getCVV2Textfield().sendKeys(CVV2_CODE);
        createNewOrderPage.getExpireDateMonthDropdown().sendKeys(EXPIRE_DATE_MONTH);
        createNewOrderPage.getExpireDateYearDropdown().sendKeys(EXPIRE_DATE_YEAR);

        createNewOrderPage.getOrderButton().click();

        assertThat(customerOrderingPage.getOrderStatusByNumber(orderNumber))
                .textEquals("Ordered");
    }

    @Test
    public final void testAddMasterCardToOrder() {

        createNewOrderPage.getSaveButton().click();

        createNewOrderPage.getCreditCardTypeDropdown().sendKeys("MasterCard");
        createNewOrderPage.getCreditCardNumberTextfield().sendKeys("5408694520868818");
        createNewOrderPage.getCVV2Textfield().sendKeys(CVV2_CODE);
        createNewOrderPage.getExpireDateMonthDropdown().sendKeys(EXPIRE_DATE_MONTH);
        createNewOrderPage.getExpireDateYearDropdown().sendKeys(EXPIRE_DATE_YEAR);

        createNewOrderPage.getOrderButton().click();

        assertThat(customerOrderingPage.getOrderStatusByNumber(orderNumber))
                .textEquals("Ordered");
    }

    @Test
    public final void testAddAmericanExpressCardToOrder() {

        createNewOrderPage.getSaveButton().click();

        createNewOrderPage.getCreditCardTypeDropdown().sendKeys("American Express");
        createNewOrderPage.getCreditCardNumberTextfield().sendKeys("345024720300379");
        createNewOrderPage.getCVV2Textfield().sendKeys(CVV2_CODE);
        createNewOrderPage.getExpireDateMonthDropdown().sendKeys(EXPIRE_DATE_MONTH);
        createNewOrderPage.getExpireDateYearDropdown().sendKeys(EXPIRE_DATE_YEAR);

        createNewOrderPage.getOrderButton().click();

        assertThat(customerOrderingPage.getOrderStatusByNumber(orderNumber))
                .textEquals("Ordered");
    }

    @Test
    public final void testAddMaestroCardToOrder() {

        createNewOrderPage.getSaveButton().click();

        createNewOrderPage.getCreditCardTypeDropdown().sendKeys("Maestro");
        createNewOrderPage.getCreditCardNumberTextfield().sendKeys("6759316694729609");
        createNewOrderPage.getCVV2Textfield().sendKeys(CVV2_CODE);
        createNewOrderPage.getExpireDateMonthDropdown().sendKeys(EXPIRE_DATE_MONTH);
        createNewOrderPage.getExpireDateYearDropdown().sendKeys(EXPIRE_DATE_YEAR);
        createNewOrderPage.getStartDateMaestroTextfield().sendKeys("29/09/2016");
        createNewOrderPage.getIssueNumberMaestroTextfield().sendKeys("4");

        createNewOrderPage.getOrderButton().click();

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
