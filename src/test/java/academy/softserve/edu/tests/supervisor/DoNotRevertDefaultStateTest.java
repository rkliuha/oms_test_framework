package academy.softserve.edu.tests.supervisor;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.ItemManagementPage;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoNotRevertDefaultStateTest extends TestRunner {

    public static final String FIELD_FILTER = "Description";
    public static final String FIELD_FILTER_VALUE = "Fruits";
    public static final String TAG_ATRIBUT = "value";

    @Test
    public void testUserInfoItemManagementButtonCheck() {

        userInfoPage = logInPage
                .logInAs(Roles.SUPERVISOR);

        Assert.assertTrue(userInfoPage
                .getUserInfoLink()
                .isDisplayed(), "Element " + userInfoPage.getUserInfoLink().getLocatorValue() + " isn't displayed");

        Assert.assertTrue(userInfoPage
                .getItemManagementLink()
                .isDisplayed(), "Element " + userInfoPage.getItemManagementLink().getLocatorValue() + " isn't displayed");
    }

    @Test
    public void testDoNotRevertDefaultState() {

        userInfoPage = logInPage
                .logInAs(Roles.SUPERVISOR);

        userInfoPage
                .getItemManagementLink()
                .click();

        itemManagementPage = new ItemManagementPage(driver);

        itemManagementPage
                .getSearchFieldFilterDropdown()
                .sendKeys(FIELD_FILTER);

        itemManagementPage
                .getSearchInput()
                .sendKeys(FIELD_FILTER_VALUE);

        itemManagementPage
                .getSearchButton()
                .click();

        itemManagementPage
                .getUserInfoLink()
                .click();

        userInfoPage
                .getItemManagementLink()
                .click();

        Assert.assertTrue(itemManagementPage
                .getSearchFieldFilterDropdown()
                .getText()
                .contains(FIELD_FILTER), "Field filter in the field filter order drop down is different of " + FIELD_FILTER);

        Assert.assertTrue(itemManagementPage
                .getSearchInput()
                .getValue()
                .contains(FIELD_FILTER_VALUE), "Field filter value in the field filter text box is different of " + FIELD_FILTER_VALUE);
    }
}
