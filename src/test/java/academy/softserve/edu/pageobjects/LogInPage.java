package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.Button;
import academy.softserve.edu.elements.wrappers.Checkbox;
import academy.softserve.edu.elements.wrappers.TextInputField;
import academy.softserve.edu.elements.wrappers.TextLabel;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.PropertiesReader;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.login.LogInPageLocators.*;

@Getter
public class LogInPage extends PageObject<LogInPage> {

    private final TextInputField userNameInput = new TextInputField(driver, USER_NAME_INPUT);

    private final TextInputField passwordInput = new TextInputField(driver, PASSWORD_INPUT);

    private final Button logInButton = new Button(driver, LOG_IN_BUTTON);

    private final Button cancelButton = new Button(driver, CANCEL_BUTTON);

    private final Checkbox rememberMeCheckbox = new Checkbox(driver, REMEMBER_ME_CHECKBOX);

    private final TextLabel logInErrorMessage = new TextLabel(driver, LOGIN_ERROR_MESSAGE);

    /**
     * logInFieldSet is an unique element on the LogInPage,
     * can be used as identification of page;
     */
    private final TextLabel logInFieldSet = new TextLabel(driver, LOGIN_FIELDSET);

    public LogInPage(final WebDriver driver) {
        super(driver);
    }

    public final UserInfoPage logInAs(final Roles role) {

        String userName;
        String userPassword;

        switch (role) {

            case MERCHANDISER:
                userName = PropertiesReader.getProperty("merchandiser.login");
                userPassword = PropertiesReader.getProperty("merchandiser.password");
                break;
            case SUPERVISOR:
                userName = PropertiesReader.getProperty("supervisor.login");
                userPassword = PropertiesReader.getProperty("supervisor.password");
                break;
            case CUSTOMER:
                userName = PropertiesReader.getProperty("customer.login");
                userPassword = PropertiesReader.getProperty("customer.password");
                break;
            case INVALID_USER:
                userName = PropertiesReader.getProperty("invalid.user.login");
                userPassword = PropertiesReader.getProperty("invalid.user.password");
                break;
            case ADMINISTRATOR:
            default:
                userName = PropertiesReader.getProperty("administrator.login");
                userPassword = PropertiesReader.getProperty("administrator.password");
                break;
        }
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(userPassword);
        logInButton.click();
        return new UserInfoPage(driver);
    }

    public final UserInfoPage logInAs(final String login, final String password) {

        setUserName(login)
                .setPassword(password)
                .clickLogIn();
        return new UserInfoPage(driver);
    }

    public final LogInPage setUserName(final String userName) {

        userNameInput.sendKeys(userName);
        return this;
    }

    public final LogInPage setPassword(final String password) {

        passwordInput.sendKeys(password);
        return this;
    }

    public final UserInfoPage clickLogIn() {

        logInButton.click();
        return new UserInfoPage(driver);
    }

    public final UserInfoPage clickCancel() {

        cancelButton.click();
        return new UserInfoPage(driver);
    }

    public final LogInPage clickRememberMe() {

        rememberMeCheckbox.click();
        return this;
    }
}
