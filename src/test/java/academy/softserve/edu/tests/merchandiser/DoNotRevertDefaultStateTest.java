package academy.softserve.edu.tests.merchandiser;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.MerchandiserOrderingPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoNotRevertDefaultStateTest extends TestRunner {

    public static final String SEARCH_ORDERS = "Status";
    public static final String SEARCH_ORDERS_VALUE = "Ordered";
    public static final String TAG_ATRIBUT = "value";

    @Test
    public void testUserInfoOrderingButtonCheck() {

        userInfoPage = logInPage
                .logInAs(Roles.MERCHANDISER);

        Assert.assertTrue(userInfoPage
                .getUserInfoLink()
                .isDisplayed(), "Element " + userInfoPage.getUserInfoLink().getLocatorValue() + " isn't displayed");

        Assert.assertTrue(userInfoPage
                .getMerchandiserOrderingLink()
                .isDisplayed(), "Element " + userInfoPage.getMerchandiserOrderingLink().getLocatorValue() + " isn't displayed");
    }

    @Test
    public void testDoNotRevertDefaultState() {

        userInfoPage = logInPage
                .logInAs(Roles.MERCHANDISER);

        userInfoPage
                .getMerchandiserOrderingLink()
                .click();

        merchandiserOrderingPage = new MerchandiserOrderingPage(driver);

        merchandiserOrderingPage
                .getSearchDropdown()
                .sendKeys(SEARCH_ORDERS);

        merchandiserOrderingPage
                .getSearchInput()
                .sendKeys(SEARCH_ORDERS_VALUE);

        merchandiserOrderingPage
                .getApplyButton()
                .click();

        merchandiserOrderingPage
                .getUserInfoLink()
                .click();

        userInfoPage
                .getMerchandiserOrderingLink()
                .click();

        Assert.assertTrue(merchandiserOrderingPage
                .getSearchDropdown()
                .getText()
                .contains(SEARCH_ORDERS), "Search order in the search order drop down is different of " + SEARCH_ORDERS);

        Assert.assertTrue(merchandiserOrderingPage
                .getSearchInput()
                .getValue()
                .contains(SEARCH_ORDERS_VALUE), "Search order value in the search order text box is different of " + SEARCH_ORDERS_VALUE);
    }
}
