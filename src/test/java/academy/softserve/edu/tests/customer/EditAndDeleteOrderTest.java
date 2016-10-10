package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import academy.softserve.edu.utils.TestUtil;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;

public class EditAndDeleteOrderTest extends TestRunner {

    private int testProductId;
    private String testOrderNumber;

    @BeforeMethod
    public final void createTestOrder() {

        testProductId = TestUtil.createActiveProductInDB();

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

        createNewOrderPage.clickDataLink();

        createNewOrderPage.selectAssigneeDropdown("login1")
                .selectCreditCardTypeDropdown("Visa")
                .fillCreditCardNumberTextfield("1111111111111111")
                .fillCVV2Textfield("666")
                .clickSaveButton()
                .clickOrderingLink();
    }

    @Test
    public final void testOrderEdit() {

        customerOrderingPage.clickEditLink();

        assertThat(createNewOrderPage.getCardInfoText())
                .isDisplayed();

        createNewOrderPage.clickOrderingLink();

        customerOrderingPage.clickDeleteLink()
                .acceptAlert();

        assertThat(customerOrderingPage.getOrderRow())
                .isNotDisplayed();
    }

    @AfterTest
    public final void deleteTestProduct() {

        DBHandler.deleteProduct(testProductId);

        DBHandler.deleteOrderByNumber(Integer.parseInt(testOrderNumber));
    }
}
