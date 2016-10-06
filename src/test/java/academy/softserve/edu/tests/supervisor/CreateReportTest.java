package academy.softserve.edu.tests.supervisor;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class CreateReportTest extends TestRunner {

    @BeforeMethod
    public final void setUpTests() {

        userInfoPage = logInPage.logInAs(Roles.SUPERVISOR);
        itemManagementPage = userInfoPage.clickItemManagementTab();
    }

    @Test
    public final void testCreateReportAbility() {

        supervisorCreateReportPage = itemManagementPage.clickCreateReportLink();

        assertThat(supervisorCreateReportPage.getSaveReportLink())
                .isDisplayed();

        supervisorReportPage = supervisorCreateReportPage.clickSaveReportLink();

        assertThat(supervisorReportPage.getReportPageExists())
                .isDisplayed();
    }
}
