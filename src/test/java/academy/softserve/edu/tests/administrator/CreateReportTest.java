package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateReportTest extends TestRunner {

    @BeforeMethod
    public final void setUpTests() {

        userInfoPage = logInPage.loginAs(Roles.ADMINISTRATOR);

        administrationPage = userInfoPage.clickAdministrationTab();
    }

    @Test
    public final void testCreateReportLinkVisibility() {

        Assert.assertTrue(administrationPage
                        .getCreateReportLink()
                        .isDisplayed(),
                "Create report link is not displayed !");
    }

    @Test
    public final void testCreateReportAbility() {

        createReportPage = administrationPage.clickCreateReportLink();

        Assert.assertTrue(createReportPage
                        .getSaveReportLink()
                        .isDisplayed(),
                "Save report link is not displayed !");

        reportPage = createReportPage.clickSaveReportLink();

        Assert.assertTrue(reportPage
                        .getIdentificationOfReportPage()
                        .isDisplayed(),
                "Report is not created !");
    }

}
