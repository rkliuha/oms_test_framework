package academy.softserve.edu.tests;


import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserInfoPageTest extends TestRunner {

    //To check English by default
    @Test
    public final void testDefaultEnglish() {

        logInPage
                .loginAs(Roles.MERCHANDISER);
        userInfoPage = new UserInfoPage(driver);
        Assert.assertTrue("Ordering".equals(userInfoPage.getMerchandiserOrderingTab().getText()),
                "English should be by default!");
    }

    //To check switch to Ukrainian language from default English language
    @Test
    public final void testSwitchToUkrainian() {

        logInPage
                .loginAs(Roles.MERCHANDISER);
        final UserInfoPage userInfoPage = new UserInfoPage(driver);
        userInfoPage
                .clickUkrainianButton();
        Assert.assertTrue("Замовлення".equals(userInfoPage.getMerchandiserOrderingTab().getText()),
                "This is not Ukrainian language");
    }

    //To check switch to English from Ukrainian
    @Test
    public final void testSwitchToEnglish() {

        logInPage
                .loginAs(Roles.MERCHANDISER);
        userInfoPage = new UserInfoPage(driver);
        userInfoPage
                .clickUkrainianButton()
                .clickEnglishButton();
        Assert.assertTrue("Ordering".equals(userInfoPage.getMerchandiserOrderingTab().getText()),
                "The language of the page should switched on English");
    }

    //To check English button is bold or not, when enabled English
    @Test
    public final void testEnglishButtonBold() {

        logInPage
                .loginAs(Roles.MERCHANDISER);
        userInfoPage = new UserInfoPage(driver);
        Assert.assertTrue("700".equals(userInfoPage.getEnglishButton().getCssValue("font-weight")),
                "English Button should be bold");
    }

    //To check Ukrainian button is bold or not, when enabled Ukrainian
    @Test
    public final void testUkrainianButtonBold() {

        logInPage
                .loginAs(Roles.MERCHANDISER);
        userInfoPage = new UserInfoPage(driver);
        userInfoPage
                .clickUkrainianButton();
        Assert.assertTrue("700".equals(userInfoPage.getUkrainianButton().getCssValue("font-weight")),
                "Ukrainian button should be bold!");
    }

}