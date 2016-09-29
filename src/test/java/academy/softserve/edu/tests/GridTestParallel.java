package academy.softserve.edu.tests;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static academy.softserve.edu.pageobjects.UserInfoPage.ADMINISTRATION_LINK;
import static academy.softserve.edu.pageobjects.UserInfoPage.USER_INFO_LINK;

public class GridTestParallel extends TestRunner {

    @Test
    public void test() throws InterruptedException {

        userInfoPage = logInPage
                .logInAs(Roles.ADMINISTRATOR);

        Assert.assertTrue(userInfoPage
                .getElement(USER_INFO_LINK)
                .isDisplayed()
                ,"Element " + USER_INFO_LINK + " isn't displayed");

        Assert.assertTrue(userInfoPage
                .getElement(ADMINISTRATION_LINK)
                .isDisplayed()
                ,"Element " + ADMINISTRATION_LINK + " isn't displayed");
    }
}
