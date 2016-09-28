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

    private final static String QUANTITY_OF_ITEM = "3";
    private final static String DIMENSION_OF_ITEM = "Box";
    // if DIMENSION_OF_ITEM = "Item" - set multiplier = 1,
    // if "Box" - set 5, if "Package" - set 10;
    private final static int MULTIPLIER_OF_ITEM = 5;

    private Product product;

    @BeforeTest
    public final void createTestProduct() {

        TestUtil.createActiveProductInDB();
        product = DBHandler.getLastProduct();
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
                        .getCreateNewOrderPageExists()
                        .isDisplayed(),
                "Page is not switched to CreateNewOrderPage !");

        Assert.assertTrue(createNewOrderPage
                        .getItemSelectionSection()
                        .isDisplayed(),
                "Item Selection Section is not displayed !");

        createNewOrderPage.getAddItemButton().click();

        addItemPage = new AddItemPage(driver);

        Assert.assertTrue(addItemPage
                        .getAddItemPageExists()
                        .isDisplayed(),
                "Page is not switched to AddItemPage");
    }

    @Test
    public final void testAddItemToOrderAbility() {

        createNewOrderPage.getAddItemButton().click();

        addItemPage = new AddItemPage(driver);

        addItemPage.getSelectLastAddedItemLink().click();

        addItemPage.getItemDimensionDropdown().sendKeys(DIMENSION_OF_ITEM);
        addItemPage.getItemQuantityTextfield().sendKeys(QUANTITY_OF_ITEM);

        Assert.assertTrue(addItemPage
                        .getItemTextField()
                        .getText()
                        .equals(product.getProductName()),
                "Item name in doneForm does not equal to selected one !");

        Assert.assertTrue(addItemPage
                        .getItemPriceField()
                        .getText()
                        .equals(String.valueOf(product.getProductPrice())),
                "Item price in doneForm does not equal to selected one !");

        addItemPage.getDoneButton().click();

        Assert.assertTrue(createNewOrderPage
                        .getFirstItemNumber()
                        .getText()
                        .equals(String.valueOf(product.getId())),
                "Item number does not equal to selected one");

        Assert.assertTrue(createNewOrderPage
                        .getFirstItemName()
                        .getText()
                        .equals(product.getProductName()),
                "Item name does not equal to selected one");

        Assert.assertTrue(createNewOrderPage
                        .getFirstItemDescription()
                        .getText()
                        .equals(product.getProductDescription()),
                "Item description does not equal to selected one");

        Assert.assertTrue(createNewOrderPage
                        .getFirstItemDimension()
                        .getText()
                        .equals(DIMENSION_OF_ITEM),
                "Item dimension does not equal to selected one");

        Assert.assertTrue(createNewOrderPage
                        .getFirstItemPrice()
                        .getText()
                        .equals(String.valueOf(product.getProductPrice())),
                "Item price does not equal to selected one");

        Assert.assertTrue(createNewOrderPage
                        .getFirstItemQuantity()
                        .getText().equals(QUANTITY_OF_ITEM),
                "Item quantity does not equal to selected one");

        Assert.assertTrue(createNewOrderPage
                        .getFirstItemPricePerLine()
                        .getText()
                        .equals(String.valueOf(product.getProductPrice() *
                                MULTIPLIER_OF_ITEM * Integer.parseInt(QUANTITY_OF_ITEM))),
                "Total price counted incorrectly !");
    }

    @AfterTest
    public final void deleteTestProduct() {
        DBHandler.deleteProduct(product.getId());
    }

}
