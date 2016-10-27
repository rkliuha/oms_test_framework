package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.DBHelper;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.*;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;
import static academy.softserve.edu.repos.CreditCardRepo.*;

public class AddCardInfoToNewOrderTest extends TestRunner {

    private int testProductId;
    private int orderNumber;

    @BeforeClass
    public final void createTestProduct() {
        testProductId = DBHelper.createActiveProductInDB();
    }

    @BeforeMethod
    public final void setUpTests() {

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);
        customerOrderingPage = userInfoPage.goToCustomerOrderingPage();

        createNewOrderPage = customerOrderingPage.goToCreateNewOrderPage();
        addItemPage = createNewOrderPage.goToAddItemPage();

        addItemPage.selectLastAddedItem()
                .addItemToOrder();

        orderNumber = Integer.parseInt(createNewOrderPage.getOrderNumberTextField()
                .getValue());

        createNewOrderPage.chooseValidDeliveryDate()
                .chooseOrderAssignee(DBHandler.getUserByRole(Roles.MERCHANDISER).getLogin())
                .saveOrderInfo();
    }

    @Test
    public final void testAddIncorrectCardToOrder() {

        createNewOrderPage.setCreditCardInfo(getInvalidCard())
                .doOrder();

        assertThat(createNewOrderPage.getIncorrectCardErrorMessage())
                .isDisplayed();
    }

    @Test
    public final void testAddVisaCardToOrder() {

        createNewOrderPage.setCreditCardInfo(getValidVisaCard())
                .doOrder();

        customerOrderingPage.searchOrder("Order Name", "OrderName" + orderNumber);

        assertThat(customerOrderingPage.getOrderStatusByNumber(orderNumber))
                .textEquals("Ordered");
    }

    @Test
    public final void testAddMasterCardToOrder() {

        createNewOrderPage.setCreditCardInfo(getValidMasterCard())
                .doOrder();

        customerOrderingPage.searchOrder("Order Name", "OrderName" + orderNumber);

        assertThat(customerOrderingPage.getOrderStatusByNumber(orderNumber))
                .textEquals("Ordered");
    }

    @Test
    public final void testAddAmericanExpressCardToOrder() {

        createNewOrderPage.setCreditCardInfo(getValidAmericanExpressCard())
                .doOrder();

        customerOrderingPage.searchOrder("Order Name", "OrderName" + orderNumber);

        assertThat(customerOrderingPage.getOrderStatusByNumber(orderNumber))
                .textEquals("Ordered");
    }

    @Test
    public final void testAddMaestroCardToOrder() {

        createNewOrderPage.setCreditCardInfo(getValidMaestroCard())
                .doOrder();

        customerOrderingPage.searchOrder("Order Name", "OrderName" + orderNumber);

        assertThat(customerOrderingPage.getOrderStatusByNumber(orderNumber))
                .textEquals("Ordered");
    }

    @AfterMethod
    public final void deleteTestOrder() {
        DBHandler.deleteOrderByNumber(orderNumber);
        DBHandler.deleteOrderItemByOrderRef(orderNumber);
    }

    @AfterClass
    public final void deleteTestProduct() {
        DBHandler.deleteProduct(testProductId);
    }
}
