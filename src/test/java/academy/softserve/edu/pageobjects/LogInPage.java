package academy.softserve.edu.pageobjects;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static academy.softserve.edu.utils.TestRunner.CONFIG_PROPERTIES;

// TODO use Lombok for getters

public class LogInPage extends PageObject<LogInPage> {

    public static final By USER_NAME_FIELD = By.name("j_username");
    public static final By PASSWORD_FIELD = By.name("j_password");
    public static final By LOG_IN_BUTTON = By.name("submit");
    public static final By RESET_BUTTON = By.name("reset");
    public static final By REMEMBER_ME_BUTTON = By.name("_spring_security_remember_me");
    public static final By ERROR_MESSAGE = By.cssSelector("#edit>fieldset>font");

    public LogInPage(final WebDriver driver) {
        super(driver);
    }

    public final UserInfoPage logInAs(final Roles role) {
        String userName;
        String userPassword;
        switch (role) {
            case ADMINISTRATOR:
            default:
                userName = PropertiesReader.getProperty("administrator.login", CONFIG_PROPERTIES);
                userPassword = PropertiesReader.getProperty("administrator.password", CONFIG_PROPERTIES);
                break;
            case MERCHANDISER:
                userName = PropertiesReader.getProperty("merchandiser.login", CONFIG_PROPERTIES);
                userPassword = PropertiesReader.getProperty("merchandiser.password", CONFIG_PROPERTIES);
                break;
            case SUPERVISOR:
                userName = PropertiesReader.getProperty("supervisor.login", CONFIG_PROPERTIES);
                userPassword = PropertiesReader.getProperty("supervisor.password", CONFIG_PROPERTIES);
                break;
            case CUSTOMER:
                userName = PropertiesReader.getProperty("customer.login", CONFIG_PROPERTIES);
                userPassword = PropertiesReader.getProperty("customer.password", CONFIG_PROPERTIES);
                break;
            case INVALID_USER:
                userName = PropertiesReader.getProperty("invalid_user.login", CONFIG_PROPERTIES);
                userPassword = PropertiesReader.getProperty("invalid_user.password", CONFIG_PROPERTIES);
                break;
        }
        getElement(USER_NAME_FIELD).sendKeys(userName);
        getElement(PASSWORD_FIELD).sendKeys(userPassword);
        getElement(LOG_IN_BUTTON).click();
        return new UserInfoPage(driver);
    }

    public UserInfoPage logInAs(final String login, final String password){

        inputName(login);

        inputPassword(password);

        clickLogInButton();

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

    public WebElement getLogInButton() { return getElement(LOG_IN_BUTTON); }

    public LogInPage clickRememberMeButton() {
        getElement(REMEMBER_ME_BUTTON).click();
        return this;
    }
}
