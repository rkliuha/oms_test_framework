package academy.softserve.edu.tests;


import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserInfoPageTest extends TestRunner {

    //To check English by default
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public void testDefaultEnglish(String name, String password) {

        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .doLogIn(name, password);
        final UserInfoPage userInfoPage = new UserInfoPage(driver);
        Assert.assertTrue(userInfoPage.getMerchandiserOrderingTab().getText().equals("Ordering"),
                "English is not by default!");
    }

    //To check switch to Ukrainian language from default English language
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public void testSwitchToUkrainian(String name, String password) {

        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .doLogIn(name, password);
        final UserInfoPage userInfoPage = new UserInfoPage(driver);
        userInfoPage
                .clickUkrainianButton();
        Assert.assertTrue(userInfoPage.getMerchandiserOrderingTab().getText().equals("Замовлення"),
                "This is not Ukrainian language");
    }

    //To check switch to English from Ukrainian
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public void testSwitchToEnglish(String name, String password) {

        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .doLogIn(name, password);
        final UserInfoPage userInfoPage = new UserInfoPage(driver);
        userInfoPage
                .clickUkrainianButton()
                .clickEnglishButton();
        Assert.assertTrue(userInfoPage.getMerchandiserOrderingTab().getText().equals("Ordering"),
                "Does not switched to English");
    }

    //To check English button is bold or not, when enabled English
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public void testEnglishButtonBold(String name, String password) {

        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .doLogIn(name, password);
        final UserInfoPage userInfoPage = new UserInfoPage(driver);
        Assert.assertTrue(userInfoPage.getEnglishButton().getCssValue("font-weight").equals("700"),
                "English Button is not bold");
    }


    //To check Ukrainian button is bold or not, when enabled Ukrainian
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForMerchandiser")
    public void testUkrainianButtonBold(String name, String password) {

        final LogInPage logInPage = new LogInPage(driver);
        logInPage
                .doLogIn(name, password);
        final UserInfoPage userInfoPage = new UserInfoPage(driver);
        userInfoPage
                .clickUkrainianButton();
        Assert.assertTrue(userInfoPage.getUkrainianButton().getCssValue("font-weight").equals("700"),
                "Ukrainian button is not bold!");
    }

}