package academy.softserve.edu.tests.merchandiser;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditOrderTest extends TestRunner {
    private boolean changeToStandardValues;

    @BeforeMethod
    public final void setUpTests() {
        userInfoPage = logInPage.logInAs(Roles.MERCHANDISER);
        merchandiserOrderingPage = userInfoPage.clickMerchandiserOrderingTab();
    }

    @Test
    public final void testEditFieldsChangingCorrectly() {
        editOrderByMerchandiserPage = merchandiserOrderingPage.clickEditFirstOrder();
        editOrderByMerchandiserPage
                .changeOrderStatusTo("Ordered")
                .clickSaveButton();
        Assert.assertTrue(merchandiserOrderingPage.getFirstStatusOrder().getText().equals("Ordered"),
                "Status doesn't changed");
        changeToStandardValues = true;
    }

    @Test(dependsOnMethods = {"testEditFieldsChangingCorrectly"})
    public final void testShowItemsChanging() {
        editOrderByMerchandiserPage = merchandiserOrderingPage.clickEditFirstOrder();
        Assert.assertTrue(editOrderByMerchandiserPage.getShowItems().isDisplayed() &&
                        editOrderByMerchandiserPage.getShowItems().isEnabled() &&
                        editOrderByMerchandiserPage.getShowItems().getText().contains("Show 10 items"),
                "Show 10 items is't correct, enabled and displayed");
        editOrderByMerchandiserPage.clickShowItemsLink();
        Assert.assertTrue(editOrderByMerchandiserPage.getShowItems().isDisplayed() &&
                        editOrderByMerchandiserPage.getShowItems().isEnabled() &&
                        editOrderByMerchandiserPage.getShowItems().getText().contains("Show 5 items"),
                "Show 5 items isn't correct, enabled and displayed");
        changeToStandardValues = false;
    }

    @AfterMethod()
    public final void changeToStandardValues() {
        if (changeToStandardValues) {
            editOrderByMerchandiserPage = merchandiserOrderingPage.clickEditFirstOrder();
            editOrderByMerchandiserPage
                    .changeOrderStatusTo("Created")
                    .clickSaveButton();
        }
    }
}
