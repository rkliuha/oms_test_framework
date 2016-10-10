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

        addItemPage
                .getSearchForItemDropdown()
                .sendKeys("Item Name");

        addItemPage
                .getSearchForItemInput()
                .sendKeys("Baileys");

        addItemPage
                .getSearchForItemButton()
                .click();

        addItemPage
                .getSelectLastAddedItemLink()
                .click();

        addItemPage
                .getDoneButton()
                .click();

        testOrderNumber = createNewOrderPage
                .getOrderNumberTextfield()
                .getValue();

        createNewOrderPage
                .getPreferableDeliveryDateChooseLink()
                .click();

        createNewOrderPage
                .getDataLink()
                .click();

        createNewOrderPage
                .getAssigneeDropdown()
                .sendKeys("login1");

        createNewOrderPage
                .getCreditCardTypeDropdown()
                .sendKeys("Visa");

        createNewOrderPage
                .getCreditCardNumberTextfield()
                .sendKeys("1111111111111111");

        createNewOrderPage
                .getCVV2Textfield()
                .sendKeys("666");

        createNewOrderPage
                .getSaveButton()
                .click();

        createNewOrderPage
                .getOrderingLink()
                .click();
    }

    @Test
    public final void testOrderEdit() {

        customerOrderingPage
                .getEditLink()
                .click();

        assertThat(createNewOrderPage.getCardInfoText())
                .isDisplayed();

        createNewOrderPage
                .getOrderingLink()
                .click();

        customerOrderingPage
                .getDeleteLink()
                .click();

        customerOrderingPage.acceptAlert();

        assertThat(customerOrderingPage.getOrderRow())
                .isNotDisplayed();
    }

    @AfterTest
    public final void deleteTestProduct() {

        DBHandler.deleteProduct(testProductId);

        DBHandler.deleteOrderByNumber(Integer.parseInt(testOrderNumber));
    }
}
