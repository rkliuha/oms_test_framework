package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.AddItemPage;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import academy.softserve.edu.utils.TestUtil;
import org.testng.Assert;
import org.testng.annotations.*;

public class AddCardInfoToNewOrderTest extends TestRunner {

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
    public final void testElementsVisibility() {

        Assert.assertTrue(createNewOrderPage
                        .getCardInfoText()
                        .isDisplayed(),
                "Card Info Label is not displayed !");

        Assert.assertTrue(createNewOrderPage
                        .getCreditCardTypeText()
                        .isDisplayed(),
                "Credit Card Type Label is not displayed !");

        Assert.assertTrue(createNewOrderPage
                        .getCreditCardNumberText()
                        .isDisplayed(),
                "Credit Card Number Label is not displayed !");

        Assert.assertTrue(createNewOrderPage
                        .getCVV2Text()
                        .isDisplayed(),
                "CVV2 Label is not displayed !");

        Assert.assertTrue(createNewOrderPage
                        .getExpireDateText()
                        .isDisplayed(),
                "Expire Date Label is not displayed !");

        Assert.assertTrue(createNewOrderPage
                        .getStartDateMaestroText()
                        .isDisplayed(),
                "Start Date Maestro Label is not displayed !");

        Assert.assertTrue(createNewOrderPage
                        .getIssueNumberMaestroText()
                        .isDisplayed(),
                "Issue Number Maestro Label is not displayed !");

        Assert.assertFalse(createNewOrderPage
                        .getOrderButton()
                        .isEnabled(),
                "Order Button should be disabled while order is not saved !");

        createNewOrderPage.getSaveButton().click();

        Assert.assertTrue(createNewOrderPage
                        .getOrderButton()
                        .isEnabled(),
                "Order Button should be enabled when order is saved !");
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

        Assert.assertTrue(createNewOrderPage
                        .getIncorrectCardErrorMessage()
                        .isDisplayed(),
                "Incorrect card credentials error message does not appear");
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

        Assert.assertTrue("Ordered".equals(customerOrderingPage
                        .getOrderStatusByNumber(orderNumber)
                        .getText()),
                "Order is not finished with Ordered status");
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

        Assert.assertTrue("Ordered".equals(customerOrderingPage
                        .getOrderStatusByNumber(orderNumber)
                        .getText()),
                "Order is not finished with Ordered status");
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

        Assert.assertTrue("Ordered".equals(customerOrderingPage
                        .getOrderStatusByNumber(orderNumber)
                        .getText()),
                "Order is not finished with Ordered status");
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

        Assert.assertTrue("Ordered".equals(customerOrderingPage
                        .getOrderStatusByNumber(orderNumber)
                        .getText()),
                "Order is not finished with Ordered status");
    }

    @AfterMethod
    public final void deleteTestOrder() {
        DBHandler.deleteOrderByNumber(Integer.parseInt(orderNumber));
    }

    @AfterTest
    public final void deleteTestProduct() {
        DBHandler.deleteProduct(testProductId);
    }

}
