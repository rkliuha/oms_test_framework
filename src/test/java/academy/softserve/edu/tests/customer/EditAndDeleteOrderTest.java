package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import academy.softserve.edu.utils.DBHelper;
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

        testOrderNumber = createNewOrderPage
                .getOrderNumberTextfield()
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

        assertThat(createNewOrderPage.getCardInfoText())
                .isDisplayed();

        createNewOrderPage.clickOrderingLink();

        customerOrderingPage.fillSearchInput("OrderName" + testOrderNumber)
                .clickApplyButton();

        customerOrderingPage.clickDeleteLink()
                .acceptAlert();

        assertThat(DBHandler.getOrderById(Integer.parseInt(testOrderNumber)))
                .isNull();
    }

    @AfterTest
    public final void deleteTestProduct() {

        DBHandler.deleteProduct(testProductId);

        DBHandler.deleteOrderByNumber(Integer.parseInt(testOrderNumber));
    }
}
