package academy.softserve.edu.tests.supervisor;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.ItemManagementPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static academy.softserve.edu.pageobjects.ItemManagementPage.*;
import static academy.softserve.edu.pageobjects.UserInfoPage.ITEM_MANAGEMENT_LINK;
import static academy.softserve.edu.pageobjects.UserInfoPage.USER_INFO_LINK;

public class DoNotRevertDefaultStateTest extends TestRunner {

    public static final String USER_LOGIN = "login2";
    public static final String USER_PASSWORD = "qwerty";
    public static final String FIELD_FILTER = "Description";
    public static final String FIELD_FILTER_VALUE = "Fruits";
    public static final String TAG_ATRIBUT = "value";

    @Test
    public void testUserInfoItemManagementButtonCheck() {

        userInfoPage = logInPage
                .loginAs(Roles.SUPERVISOR);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_LINK)
                .isDisplayed(), "Element " + USER_INFO_LINK + " isn't displayed");

        Assert.assertTrue(userInfoPage
                .getElement(ITEM_MANAGEMENT_LINK)
                .isDisplayed(), "Element " + ITEM_MANAGEMENT_LINK + " isn't displayed");
    }

    @Test
    public void testDoNotRevertDefaultState() {

        userInfoPage = logInPage
                .loginAs(Roles.SUPERVISOR);

        userInfoPage
                .click(ITEM_MANAGEMENT_LINK);

        itemManagementPage = new ItemManagementPage(driver);

        itemManagementPage
                .getElement(FIELD_FILTER_DROPDOWN)
                .sendKeys(FIELD_FILTER);

        itemManagementPage
                .getElement(FIELD_FILTER_TEXT_BOX)
                .sendKeys(FIELD_FILTER_VALUE);

        itemManagementPage
                .click(FIELD_FILTER_BUTTON);

        itemManagementPage
                .click(USER_INFO_LINK);

        userInfoPage
                .click(ITEM_MANAGEMENT_LINK);

        Assert.assertTrue(itemManagementPage
                .getElement(FIELD_FILTER_DROPDOWN)
                .getText()
                .contains(FIELD_FILTER), "Field filter in the field filter order drop down is different of " + FIELD_FILTER);

        Assert.assertTrue(itemManagementPage
                .getElement(FIELD_FILTER_TEXT_BOX)
                .getAttribute(TAG_ATRIBUT)
                .contains(FIELD_FILTER_VALUE), "Field filter value in the field filter text box is different of " + FIELD_FILTER_VALUE);
    }
}
