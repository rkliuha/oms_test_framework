package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

public class CreatedUserLogInTest extends TestRunner {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "testDataForAdministrator")
    public void testCreatedUserLogIn(final String login, final String password) {

        userInfoPage = loginPage
                .doLogIn(login, password);


    }
}
