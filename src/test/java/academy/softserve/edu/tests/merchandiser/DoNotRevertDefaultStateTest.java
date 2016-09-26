package academy.softserve.edu.tests.merchandiser;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.MerchandiserOrderingPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static academy.softserve.edu.pageobjects.MerchandiserOrderingPage.*;
import static academy.softserve.edu.pageobjects.UserInfoPage.MERCHANDISER_ORDERING_LINK;
import static academy.softserve.edu.pageobjects.UserInfoPage.USER_INFO_LINK;

public class DoNotRevertDefaultStateTest extends TestRunner {

    public static final String SEARCH_ORDERS = "Status";
    public static final String SEARCH_ORDERS_VALUE = "Ordered";
    public static final String TAG_ATRIBUT = "value";

    @Test
    public void testUserInfoOrderingButtonCheck() {

        userInfoPage = logInPage
                .loginAs(Roles.MERCHANDISER);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_LINK)
                .isDisplayed(), "Element " + USER_INFO_LINK + " isn't displayed");

        Assert.assertTrue(userInfoPage
                .getElement(MERCHANDISER_ORDERING_LINK)
                .isDisplayed(), "Element " + MERCHANDISER_ORDERING_LINK + " isn't displayed");
    }

    @Test
    public void testDoNotRevertDefaultState() {

        userInfoPage = logInPage
                .loginAs(Roles.MERCHANDISER);

        userInfoPage
                .click(MERCHANDISER_ORDERING_LINK);

        merchandiserOrderingPage = new MerchandiserOrderingPage(driver);

        merchandiserOrderingPage
                .getElement(MERCHANDISER_SEARCH_ORDERS_DROPDOWN)
                .sendKeys(SEARCH_ORDERS);

        merchandiserOrderingPage
                .getElement(MERCHANDISER_SEARCH_ORDERS_TEXT_BOX)
                .sendKeys(SEARCH_ORDERS_VALUE);

        merchandiserOrderingPage
                .click(MERCHANDISER_SEARCH_ORDERS_BUTTON);

        merchandiserOrderingPage
                .click(USER_INFO_LINK);

        userInfoPage
                .click(MERCHANDISER_ORDERING_LINK);

        Assert.assertTrue(merchandiserOrderingPage
                .getElement(MERCHANDISER_SEARCH_ORDERS_DROPDOWN)
                .getText()
                .contains(SEARCH_ORDERS), "Search order in the search order drop down is different of " + SEARCH_ORDERS);

        Assert.assertTrue(merchandiserOrderingPage
                .getElement(MERCHANDISER_SEARCH_ORDERS_TEXT_BOX)
                .getAttribute(TAG_ATRIBUT)
                .contains(SEARCH_ORDERS_VALUE), "Search order value in the search order text box is different of " + SEARCH_ORDERS_VALUE);
    }
}
