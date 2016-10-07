package academy.softserve.edu.tests.supervisor;

import academy.softserve.edu.domains.Product;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;

public class AddNewProductTest extends TestRunner {

    private int testProductId;
    private Product testProduct;

    @BeforeMethod
    public final void setUpTests() {

        userInfoPage = logInPage.logInAs(Roles.SUPERVISOR);
        itemManagementPage = userInfoPage.clickItemManagementTab();
        addProductPage = itemManagementPage.clickAddProductLink();
    }

    @Test
    public final void testElementsVisibility() {

        assertThat(addProductPage.getProductNameInput())
                .isTextEmpty();
        assertThat(addProductPage.getProductDescriptionInput())
                .isTextEmpty();
        assertThat(addProductPage.getProductPriceInput())
                .isTextEmpty();
        assertThat(addProductPage.getOkButton())
                .isEnabled();
        assertThat(addProductPage.getCancelButton())
                .isEnabled();
    }

    @Test
    public final void testAddingProduct() {

        final String testProductName = "productName6";
        final String testProductDescription = "productDescription6";
        final String testProductPrice = "6.0";

        addProductPage
                .getProductNameInput()
                .sendKeys(testProductName);
        addProductPage
                .getProductDescriptionInput()
                .sendKeys(testProductDescription);
        addProductPage
                .getProductPriceInput()
                .sendKeys(testProductPrice);
        addProductPage
                .getOkButton()
                .click();

        testProduct = DBHandler.getLastProduct();
        testProductId = testProduct.getId();

        assertThat(itemManagementPage.getSearchInput())
                .isTextEmpty();

        itemManagementPage
                .getSearchInput()
                .sendKeys(testProductName);
        itemManagementPage
                .getSearchButton()
                .click();

        assertThat(itemManagementPage.getEditProductLinkById(String.valueOf(testProductId)))
                .isDisplayed();

        assertThat(testProduct)
                .nameEquals(testProductName);
        assertThat(testProduct)
                .descriptionEquals(testProductDescription);
        assertThat(testProduct)
                .priceEquals(testProductPrice);
    }

    @Test
    public final void testCancelAddingProduct() {

        final String testProductName = "productName6";
        final String testProductDescription = "productDescription6";
        final String testProductPrice = "6.0";

        addProductPage
                .getProductNameInput()
                .sendKeys(testProductName);
        addProductPage
                .getProductDescriptionInput()
                .sendKeys(testProductDescription);
        addProductPage
                .getProductPriceInput()
                .sendKeys(testProductPrice);
        addProductPage
                .getCancelButton()
                .click();

        testProduct = DBHandler.getLastProduct();

        assertThat(itemManagementPage.getSearchInput())
                .isTextEmpty();

        itemManagementPage
                .getSearchInput()
                .sendKeys(testProductName);
        itemManagementPage
                .getSearchButton()
                .click();

        assertThat(itemManagementPage.getRecordsCountText())
                .textEquals("0");

        assertThat(testProduct)
                .nameNotEqual(testProductName);
        assertThat(testProduct)
                .descriptionNotEqual(testProductDescription);
        assertThat(testProduct)
                .priceNotEqual(testProductPrice);
    }

    @Test
    public final void testInvalidAttributes() {

        final String invalidLowBoundName = "PN";
        final String invalidHighBoundName = "NewProductName";
        final String invalidDescription = "InvalidProductDescription6";
        final String invalidPrice = "12345678901234";

        addProductPage
                .getProductNameInput()
                .sendKeys("");
        addProductPage
                .getProductDescriptionInput()
                .sendKeys("");
        addProductPage
                .getProductPriceInput()
                .sendKeys("");
        addProductPage
                .getOkButton()
                .click();

        assertThat(addProductPage.getProductNameErrorText())
                .textEquals("Please enter product name!");
        assertThat(addProductPage.getProductDescriptionErrorText())
                .isTextEmpty();
        assertThat(addProductPage.getProductPriceErrorText())
                .textEquals("Please enter product price!");

        addProductPage
                .getProductNameInput()
                .sendKeys(invalidLowBoundName);
        addProductPage
                .getProductDescriptionInput()
                .sendKeys(invalidDescription);
        addProductPage
                .getProductPriceInput()
                .sendKeys(invalidPrice);
        addProductPage
                .getOkButton()
                .click();

        assertThat(addProductPage.getProductNameErrorText())
                .textEquals("Enter value in range: 3-13");
        assertThat(addProductPage.getProductDescriptionErrorText())
                .textEquals("Enter less then 25 letters");
        assertThat(addProductPage.getProductPriceErrorText())
                .textEquals("Please enter double value!");

        addProductPage
                .getProductNameInput()
                .sendKeys(invalidHighBoundName);
        addProductPage
                .getProductDescriptionInput()
                .sendKeys(invalidDescription);
        addProductPage
                .getProductPriceInput()
                .sendKeys(invalidPrice);
        addProductPage
                .getOkButton()
                .click();

        assertThat(addProductPage.getProductNameErrorText())
                .textEquals("Enter value in range: 3-13");
        assertThat(addProductPage.getProductDescriptionErrorText())
                .textEquals("Enter less then 25 letters");
        assertThat(addProductPage.getProductPriceErrorText())
                .textEquals("Please enter double value!");
    }

    @AfterMethod
    public final void deleteTestProduct() {
        DBHandler.deleteProduct(testProductId);
    }
}
