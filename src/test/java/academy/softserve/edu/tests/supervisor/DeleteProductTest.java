package academy.softserve.edu.tests.supervisor;

import academy.softserve.edu.domains.Product;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import academy.softserve.edu.utils.DBHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;

public class DeleteProductTest extends TestRunner {

    private int testProductId;
    private Product testProduct;

    @BeforeMethod
    public final void createTestOrder() {

        testProductId = DBHelper.createActiveProductInDB();
        testProduct = DBHandler.getProductById(testProductId);
    }

    @Test
    public final void testDismissAlert(){

        userInfoPage = logInPage.logInAs(Roles.SUPERVISOR);

        itemManagementPage = userInfoPage.clickItemManagementTab();

        itemManagementPage.fillSearchInput(testProduct.getProductName())
                .clickSearchButton();

        itemManagementPage.clickDeleteProductLinkById(String.valueOf(testProductId));

        itemManagementPage.dismissAlert();

        assertThat(itemManagementPage.getDeleteProductLinkById(String.valueOf(testProductId)))
                .isDisplayed();
    }

    @Test
    public final void testDeleteProduct(){

        userInfoPage = logInPage.logInAs(Roles.SUPERVISOR);

        itemManagementPage = userInfoPage.clickItemManagementTab();

        itemManagementPage.fillSearchInput(testProduct.getProductName())
                .clickSearchButton();

        itemManagementPage.clickDeleteProductLinkById(String.valueOf(testProductId));

        itemManagementPage.acceptAlert();

        assertThat(DBHandler.getProductById(testProductId))
                .isInactive();
    }

    @AfterMethod
    public final void deleteTestProduct() {

        DBHandler.deleteProduct(testProductId);
    }
}
