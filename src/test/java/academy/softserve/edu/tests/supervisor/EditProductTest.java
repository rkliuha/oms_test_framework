package academy.softserve.edu.tests.supervisor;

import academy.softserve.edu.domains.Product;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.EditProductPage;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import academy.softserve.edu.utils.TestUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.*;

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
        itemManagementPage.getSearchInput()
                .sendKeys(testProduct.getProductName());
        itemManagementPage.getSearchButton()
                .click();
        itemManagementPage.getEditProductLinkById(String.valueOf(testProductId))
                .click();

        editProductPage = new EditProductPage(driver);
    }

    @Test
    public final void testEditProductAndClickOk() {

        assertThat(editProductPage.getProductNameInput())
                .isValueNotEmpty();

        final String testProductName = "someName";
        final String testProductDescription = "someProductDescription";
        final String testProductPrice = "100";

        editProductPage.getProductNameInput()
                .sendKeys(testProductName);
        editProductPage.getProductDescriptionInput()
                .sendKeys(testProductDescription);
        editProductPage.getProductPriceInput()
                .sendKeys(testProductPrice);
        editProductPage.getOkButton()
                .click();

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

        editProductPage.getProductNameInput()
                .sendKeys("AnotherName");
        editProductPage.getProductDescriptionInput()
                .sendKeys("AnotherDescription");
        editProductPage.getProductPriceInput()
                .sendKeys("500");
        editProductPage.getCancelButton()
                .click();

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
