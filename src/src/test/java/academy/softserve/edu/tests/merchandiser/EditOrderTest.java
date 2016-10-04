package academy.softserve.edu.tests.merchandiser;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;

public class EditOrderTest extends TestRunner {
    private boolean isChangedToStandardValues;

    @BeforeMethod
    public final void setUpTests() {
        userInfoPage = logInPage.logInAs(Roles.MERCHANDISER);
        merchandiserOrderingPage = userInfoPage.clickMerchandiserOrderingTab();
    }

    @Test
    public final void testEditFieldsChangingCorrectly() {
        merchandiserEditOrderPage = merchandiserOrderingPage
                .clickEditOrder(merchandiserOrderingPage
                        .getOrderLinkByNumber("2"));
        merchandiserEditOrderPage
                .changeOrderStatusTo("Ordered")
                .clickSaveButton();
        assertThat(merchandiserOrderingPage.getOrderStatusByNumber("2"))
        .textEquals("Ordered");
        isChangedToStandardValues = true;
    }

    @Test
    public final void testShowItemsChanging() {
        merchandiserEditOrderPage = merchandiserOrderingPage
                .clickEditOrder(merchandiserOrderingPage
                        .getOrderLinkByNumber("2"));
        assertThat(merchandiserEditOrderPage.getShowItems())
                .isDisplayed();
        assertThat(merchandiserEditOrderPage.getShowItems())
                .isEnabled();
        assertThat(merchandiserEditOrderPage.getShowItems())
                .textEquals("Show 10 items");
        merchandiserEditOrderPage.clickShowItemsLink();
        assertThat(merchandiserEditOrderPage.getShowItems())
                .isDisplayed();
        assertThat(merchandiserEditOrderPage.getShowItems())
                .isEnabled();
        assertThat(merchandiserEditOrderPage.getShowItems())
                .textEquals("Show 5 items");
        isChangedToStandardValues = false;
    }

    @AfterMethod()
    public final void changeToStandardValues() {
        if (isChangedToStandardValues) {
            merchandiserEditOrderPage = merchandiserOrderingPage
                    .clickEditOrder(merchandiserOrderingPage
                            .getOrderLinkByNumber("2"));
            merchandiserEditOrderPage
                    .changeOrderStatusTo("Created")
                    .clickSaveButton();
        }
    }
}
