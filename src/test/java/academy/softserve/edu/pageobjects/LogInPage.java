package academy.softserve.edu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage extends PageObject<LogInPage> {

    public static final By USER_NAME_FIELD = By.name("j_username");
    public static final By PASSWORD_FIELD = By.name("j_password");
    public static final By LOG_IN_BUTTON = By.name("submit");
    public static final By RESET_BUTTON = By.name("reset");
    public static final By REMEMBER_ME_BUTTON = By.name("_spring_security_remember_me");
    public static final By ERROR_MESSAGE = By.cssSelector("#edit>fieldset>font");
    public static final String OMS_HOME_PAGE = "http://192.168.56.101:8080/oms5/login.htm";
    public static final By LOG_IN_PAGE_EXISTS = By.xpath(".//div[@id='edit']//legend");



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

    public WebElement getInputNameField() {
        return getElement(USER_NAME_FIELD);
    }

    public WebElement getInputPasswordField() {
        return getElement(PASSWORD_FIELD);
    }

    public LogInPage inputName(final String name) {
        getInputNameField().sendKeys(name);
        return this;
    }

    public LogInPage inputPassword(final String password) {
        getInputPasswordField().sendKeys(password);
        return this;
    }

    public UserInfoPage clickLogInButton() {
        getElement(LOG_IN_BUTTON).click();
        return new UserInfoPage(driver);
    }

    public LogInPage clickResetButton() {
        getElement(RESET_BUTTON).click();
        return this;
    }

    public WebElement getNameField() {
        return getElement(USER_NAME_FIELD);
    }

    public WebElement getPasswordField() {
        return getElement(PASSWORD_FIELD);
    }

    public LogInPage clickRememberMeButton() {
        getElement(REMEMBER_ME_BUTTON).click();
        return this;
    }
}
