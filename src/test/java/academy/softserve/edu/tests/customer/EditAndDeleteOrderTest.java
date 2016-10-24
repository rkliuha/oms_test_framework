package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import academy.softserve.edu.utils.DBHelper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;

public class EditAndDeleteOrderTest extends TestRunner {

    private int testProductId;
    private String testOrderNumber;

    @BeforeMethod
    public final void createTestOrder() {

        testProductId = DBHelper.createActiveProductInDB();

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        customerOrderingPage = userInfoPage.clickCustomerOrderingTab();

        createNewOrderPage = customerOrderingPage.clickCreateNewOrderLink();

        addItemPage = createNewOrderPage.clickAddItemButton();

        addItemPage.selectSearchForItemDropdown("Item Name")
                .fillSearchForItemInput("Baileys")
                .clickSearchForItemButton()
                .clickSelectLastAddedItemLink()
                .clickDoneButton();

        testOrderNumber = createNewOrderPage.getOrderNumberTextField()
                .getValue();

        createNewOrderPage.clickPreferableDeliveryDateChooseLink();

        createNewOrderPage.clickValidDeliveryDateLink();

        createNewOrderPage.selectAssigneeDropdown("login1")
                .selectCreditCardTypeDropdown("Visa")
                .fillCreditCardNumberTextfield("1111111111111111")
                .fillCVV2Textfield("666")
                .clickSaveButton()
                .clickOrderingLink();
    }

    @Test
    public final void testOrderEdit() {

        customerOrderingPage.fillSearchInput("OrderName" + testOrderNumber)
                .clickApplyButton();

        customerOrderingPage.clickEditLink();

        createNewOrderPage.fillOrderNumberTextField("8")
                .selectCreditCardTypeDropdown("MasterCard")
                .fillCreditCardNumberTextfield("2222222222222222")
                .fillCVV2Textfield("555")
                .clickSaveButton();

        final String testOrderNumberCreated = createNewOrderPage.getOrderNumberTextField()
                .getValue();

        createNewOrderPage.clickOrderingLink();

        customerOrderingPage.fillSearchInput("OrderName" + testOrderNumberCreated)
                .clickApplyButton();

        assertThat(DBHandler.getOrderByNumber(Integer.parseInt(testOrderNumberCreated)))
                .orderNumberEquals(Integer.parseInt(testOrderNumberCreated));
    }

    @Test
    public final void testOrderDelete() {

        createNewOrderPage.clickOrderingLink();

        customerOrderingPage.fillSearchInput("OrderName" + testOrderNumber)
                .clickApplyButton();

        customerOrderingPage.clickDeleteLink()
                .acceptAlert();

        customerOrderingPage.refreshPage();

        assertThat(DBHandler.getOrderById(Integer.parseInt(testOrderNumber)))
                .isNull();
    }

    @AfterClass
    public final void deleteTestProduct() {

        DBHandler.deleteProduct(testProductId);

        DBHandler.deleteOrderByNumber(Integer.parseInt(testOrderNumber));
    }
}
