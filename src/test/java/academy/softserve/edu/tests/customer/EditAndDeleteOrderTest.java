package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.DBHelper;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;
import static academy.softserve.edu.repos.CreditCardRepo.getValidMasterCard;

public class EditAndDeleteOrderTest extends TestRunner {

    private int testProductId;
    private String testOrderNumber;

    @BeforeMethod
    public final void createTestOrder() {

        testProductId = DBHelper.createActiveProductInDB();

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        customerOrderingPage = userInfoPage.goToCustomerOrderingPage();

        createNewOrderPage = customerOrderingPage.goToCreateNewOrderPage();

        addItemPage = createNewOrderPage.goToAddItemPage();

        addItemPage.searchItem("Item Name", "Baileys")
                .selectLastAddedItem()
                .addItemToOrder();

        testOrderNumber = createNewOrderPage.getOrderNumberTextField()
                .getValue();

        createNewOrderPage.chooseValidDeliveryDate();

        createNewOrderPage.chooseOrderAssignee("login1")
                .saveOrderInfo();

        createNewOrderPage.goToCustomerOrderingPage();
    }

    @Test
    public final void testOrderEdit() {

        customerOrderingPage.searchOrder("Order Name", "OrderName" + testOrderNumber);

        customerOrderingPage.editFirstOrder();

        createNewOrderPage.setOrderNumber("8")
                .setCreditCardInfo(getValidMasterCard())
                .saveOrderInfo();

        final String testOrderNumberCreated = createNewOrderPage.getOrderNumberTextField()
                .getValue();

        createNewOrderPage.goToCustomerOrderingPage();

        customerOrderingPage.searchOrder("Order Name", "OrderName" + testOrderNumberCreated);

        assertThat(DBHandler.getOrderByNumber(Integer.parseInt(testOrderNumberCreated)))
                .orderNumberEquals(Integer.parseInt(testOrderNumberCreated));
    }

    @Test
    public final void testOrderDelete() {

        createNewOrderPage.goToCustomerOrderingPage();

        customerOrderingPage.searchOrder("Order Name", "OrderName" + testOrderNumber);

        customerOrderingPage.deleteFirstOrder()
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
