package academy.softserve.edu.tests.customer;

import academy.softserve.edu.domains.Product;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.AddItemPage;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import academy.softserve.edu.utils.TestUtil;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class AddItemToOrderTest extends TestRunner {

    private Product testProduct;
    private int testProductId;

    @BeforeTest
    public final void createTestProduct() {

        testProductId = TestUtil.createActiveProductInDB();
        testProduct = DBHandler.getProductById(testProductId);
    }

    @BeforeMethod
    public final void setUpTests() {

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);
        customerOrderingPage = userInfoPage.clickCustomerOrderingTab();
        createNewOrderPage = customerOrderingPage.clickCreateNewOrderLink();
    }

    @Test
    public final void testElementsVisibility() {

        assertThat(createNewOrderPage.getCVV2Text())
                .isDisplayed();

        assertThat(createNewOrderPage.getItemSelectionSection())
                .isDisplayed();

        createNewOrderPage.getAddItemButton().click();

        addItemPage = new AddItemPage(driver);

        assertThat(addItemPage.getResetButton())
                .isDisplayed();
    }

    @Test
    public final void testAddItemToOrderAbility() {

        createNewOrderPage.getAddItemButton().click();

        addItemPage = new AddItemPage(driver);

        addItemPage.getSelectLastAddedItemLink().click();

        final String quantityOfItem = "3";
        final String dimensionOfItem = "Box";

        addItemPage.getItemDimensionDropdown().sendKeys(dimensionOfItem);
        addItemPage.getItemQuantityTextfield().sendKeys(quantityOfItem);

        assertThat(addItemPage.getItemTextField())
                .textEquals(testProduct.getProductName());

        assertThat(addItemPage.getItemPriceField())
                .textEquals(String.valueOf(testProduct.getProductPrice()));

        addItemPage.getDoneButton().click();

        assertThat(createNewOrderPage.getFirstItemNumber())
                .textEquals(String.valueOf(testProduct.getId()));

        assertThat(createNewOrderPage.getFirstItemName())
                .textEquals(testProduct.getProductName());

        assertThat(createNewOrderPage.getFirstItemDescription())
                .textEquals(testProduct.getProductDescription());

        assertThat(createNewOrderPage.getFirstItemDimension())
                .textEquals(dimensionOfItem);

        assertThat(createNewOrderPage.getFirstItemPrice())
                .textEquals(String.valueOf(testProduct.getProductPrice()));

        assertThat(createNewOrderPage.getFirstItemQuantity())
                .textEquals(quantityOfItem);

        // if dimensionOfItem == "Item" - set multiplier = 1,
        // if == "Box" - set 5, if == "Package" - set 10;
        final int multiplierOfItem = 5;

        assertThat(createNewOrderPage.getFirstItemPricePerLine())
                .textEquals(String.valueOf(testProduct.getProductPrice() *
                        multiplierOfItem * Integer.parseInt(quantityOfItem)));
    }

    @AfterTest
    public final void deleteTestProduct() {
        DBHandler.deleteProduct(testProductId);
    }

}
