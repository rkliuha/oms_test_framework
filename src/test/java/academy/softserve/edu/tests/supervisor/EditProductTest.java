package academy.softserve.edu.tests.supervisor;

import academy.softserve.edu.domains.Product;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import academy.softserve.edu.utils.TestUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;

public class EditProductTest extends TestRunner {

    private int testProductId;
    private Product testProduct;

    @BeforeClass
    public final void createTestProduct() {

        testProductId = TestUtil.createActiveProductInDB();
        testProduct = DBHandler.getProductById(testProductId);
    }

    @BeforeMethod
    public final void setUpTests() {

        userInfoPage = logInPage.logInAs(Roles.SUPERVISOR);

        itemManagementPage = userInfoPage.clickItemManagementTab();

        itemManagementPage.fillSearchInput(testProduct.getProductName())
                .clickSearchButton();

        editProductPage = itemManagementPage.clickEditProductLinkById(String.valueOf(testProductId));
    }

    @Test
    public final void testEditProductAndClickOk() {

        assertThat(editProductPage.getProductNameInput())
                .isValueNotEmpty();

        final String testProductName = "someName";
        final String testProductDescription = "someProductDescription";
        final String testProductPrice = "100";

        editProductPage.fillProductNameInput(testProductName)
                .fillProductDescriptionInput(testProductDescription)
                .fillProductPriceInput(testProductPrice)
                .clickOkButton();

        assertThat(itemManagementPage.getSearchByFieldSet())
                .isDisplayed();

        testProduct = DBHandler.getProductById(testProductId);

        assertThat(testProduct).nameEquals(testProductName);

        assertThat(testProduct).descriptionEquals(testProductDescription);

        assertThat(testProduct).priceEquals(testProductPrice);
    }

    @Test
    public final void testEditProductAndClickCancel() {

        assertThat(editProductPage.getProductNameInput())
                .isValueNotEmpty();

        editProductPage.fillProductNameInput("AnotherName")
                .fillProductDescriptionInput("AnotherDescription")
                .fillProductPriceInput("500")
                .clickCancelButton();

        assertThat(itemManagementPage.getSearchByFieldSet())
                .isDisplayed();

        assertThat(DBHandler.getProductById(testProductId))
                .productEquals(testProduct);
    }

    @AfterClass
    public final void deleteTestProduct() {
        DBHandler.deleteProduct(testProductId);
    }
}
