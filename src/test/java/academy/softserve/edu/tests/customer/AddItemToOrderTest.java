package academy.softserve.edu.tests.customer;

import academy.softserve.edu.domains.Product;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.AddItemPage;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import academy.softserve.edu.utils.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

        Assert.assertTrue(createNewOrderPage
                        .getCVV2Text()
                        .isDisplayed(),
                "Page is not switched to CreateNewOrderPage !");

        Assert.assertTrue(createNewOrderPage
                        .getItemSelectionSection()
                        .isDisplayed(),
                "Item Selection Section is not displayed !");

        createNewOrderPage.getAddItemButton().click();

        addItemPage = new AddItemPage(driver);

        Assert.assertTrue(addItemPage
                        .getResetButton()
                        .isDisplayed(),
                "Page is not switched to AddItemPage");
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

        Assert.assertTrue(addItemPage
                        .getItemTextField()
                        .getText()
                        .equals(testProduct.getProductName()),
                "Item name in doneForm does not equal to selected one !");

        Assert.assertTrue(addItemPage
                        .getItemPriceField()
                        .getText()
                        .equals(String.valueOf(testProduct.getProductPrice())),
                "Item price in doneForm does not equal to selected one !");

        addItemPage.getDoneButton().click();

        Assert.assertTrue(createNewOrderPage
                        .getFirstItemNumber()
                        .getText()
                        .equals(String.valueOf(testProduct.getId())),
                "Item number does not equal to selected one");

        Assert.assertTrue(createNewOrderPage
                        .getFirstItemName()
                        .getText()
                        .equals(testProduct.getProductName()),
                "Item name does not equal to selected one");

        Assert.assertTrue(createNewOrderPage
                        .getFirstItemDescription()
                        .getText()
                        .equals(testProduct.getProductDescription()),
                "Item description does not equal to selected one");

        Assert.assertTrue(createNewOrderPage
                        .getFirstItemDimension()
                        .getText()
                        .equals(dimensionOfItem),
                "Item dimension does not equal to selected one");

        Assert.assertTrue(createNewOrderPage
                        .getFirstItemPrice()
                        .getText()
                        .equals(String.valueOf(testProduct.getProductPrice())),
                "Item price does not equal to selected one");

        Assert.assertTrue(createNewOrderPage
                        .getFirstItemQuantity()
                        .getText().equals(quantityOfItem),
                "Item quantity does not equal to selected one");

        // if dimensionOfItem == "Item" - set multiplier = 1,
        // if == "Box" - set 5, if == "Package" - set 10;
        final int multiplierOfItem = 5;

        Assert.assertTrue(createNewOrderPage
                        .getFirstItemPricePerLine()
                        .getText()
                        .equals(String.valueOf(testProduct.getProductPrice() *
                                multiplierOfItem * Integer.parseInt(quantityOfItem))),
                "Total price counted incorrectly !");
    }

    @AfterTest
    public final void deleteTestProduct() {
        DBHandler.deleteProduct(testProductId);
    }

}
