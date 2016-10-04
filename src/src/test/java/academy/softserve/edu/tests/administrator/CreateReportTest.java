package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class CreateReportTest extends TestRunner {

    @BeforeMethod
    public final void setUpTests() {

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);

        administrationPage = userInfoPage.clickAdministrationTab();
    }

    @Test
    public final void testCreateReportLinkVisibility() {

        assertThat(administrationPage.getCreateReportLink())
                .isDisplayed();
    }

    @Test
    public final void testCreateReportAbility() {

        createReportPage = administrationPage.clickCreateReportLink();

        assertThat(createReportPage.getSaveReportLink())
                .isDisplayed();

        reportPage = createReportPage.clickSaveReportLink();

        assertThat(reportPage.getReportPageExists())
                .isDisplayed();
    }
}
