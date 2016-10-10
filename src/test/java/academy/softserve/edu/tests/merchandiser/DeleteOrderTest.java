package academy.softserve.edu.tests.merchandiser;

import academy.softserve.edu.domains.Order;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import academy.softserve.edu.utils.DBHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;
import static academy.softserve.edu.asserts.OrderAssert.assertThat;

public class DeleteOrderTest extends TestRunner {

    private Order testOrder;
    private int testOrderId;

    @BeforeMethod
    public final void setUpTests() {

        testOrderId = DBHelper.createValidOrderInDB();
        testOrder = DBHandler.getOrderById(testOrderId);
        userInfoPage = logInPage.logInAs(Roles.MERCHANDISER);
        merchandiserOrderingPage = userInfoPage.clickMerchandiserOrderingTab();
    }

    @Test
    public final void testOrdersElementsPresence() {

        // checks if there is valid order name and if delete order button is displayed
        merchandiserOrderingPage
                .getSearchDropdown()
                .sendKeys("Order Name");

        merchandiserOrderingPage
                .getSearchInput()
                .sendKeys(testOrder.getOrderName());

        merchandiserOrderingPage
                .getApplyButton()
                .click();

        assertThat(merchandiserOrderingPage.getOrderNameCell())
                .textEquals(testOrder.getOrderName());

        assertThat(merchandiserOrderingPage.getDeleteCellLink())
                .isDisplayed();
    }

    @Test
    public final void testDeleteOrderAndConfirm() {

        merchandiserOrderingPage
                .getSearchDropdown()
                .sendKeys("Order Name");

        merchandiserOrderingPage
                .getSearchInput()
                .sendKeys(testOrder.getOrderName());

        merchandiserOrderingPage
                .getApplyButton()
                .click();

        merchandiserOrderingPage
                .getDeleteCellLink()
                .click();

        merchandiserOrderingPage
                .acceptAlert();

        assertThat(DBHandler.getOrderByNumber(testOrder.getOrderNumber()))
                .isNull();
    }


    @Test
    public final void testDeleteOrderAndCancelConfirmation() {

        merchandiserOrderingPage
                .getSearchDropdown()
                .sendKeys("Order Name");

        merchandiserOrderingPage
                .getSearchInput()
                .sendKeys(testOrder.getOrderName());

        merchandiserOrderingPage
                .getApplyButton()
                .click();

        merchandiserOrderingPage
                .getDeleteCellLink()
                .click();

        merchandiserOrderingPage
                .dismissAlert();

        assertThat(DBHandler.getOrderByNumber(testOrder.getOrderNumber()))
                .orderNumberEquals(testOrder.getOrderNumber());

    }

    @AfterMethod
    public final void deleteTestOrder() {
        DBHandler.deleteOrderById(testOrderId);
    }
}
