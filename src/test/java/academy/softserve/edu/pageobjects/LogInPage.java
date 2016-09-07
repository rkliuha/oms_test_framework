package academy.softserve.edu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends PageObject {

    public static final By USER_NAME_FIELD = By.name("j_username");
    public static final By PASSWORD_FIELD = By.name("j_password");
    public static final By LOG_IN_BUTTON = By.name("submit");
    public static final String OMS_HOME_PAGE = "http://192.168.56.101:8080/oms5/login.htm";

    public LogInPage(final WebDriver driver) {
        super(driver);
    }

    public final UserInfoPage doLogIn(final String userName,
                                      final String password) {
        getElement(USER_NAME_FIELD).sendKeys(userName);
        getElement(PASSWORD_FIELD).sendKeys(password);
        getElement(LOG_IN_BUTTON).click();
        return new UserInfoPage(driver);
    }

}