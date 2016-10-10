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

    // logInFieldSet is unique LogInPage element
    private final TextLabel logInFieldSet = new TextLabel(driver, LOGIN_FIELDSET);

    public LogInPage(final WebDriver driver) {
        super(driver);
    }

    public final UserInfoPage logInAs(final Roles role) {
        String userName;
        String userPassword;
        switch (role) {
            case ADMINISTRATOR:
            default:
                userName = PropertiesReader.getDefaultProperty("administrator.login");
                userPassword = PropertiesReader.getDefaultProperty("administrator.password");
                break;
            case MERCHANDISER:
                userName = PropertiesReader.getDefaultProperty("merchandiser.login");
                userPassword = PropertiesReader.getDefaultProperty("merchandiser.password");
                break;
            case SUPERVISOR:
                userName = PropertiesReader.getDefaultProperty("supervisor.login");
                userPassword = PropertiesReader.getDefaultProperty("supervisor.password");
                break;
            case CUSTOMER:
                userName = PropertiesReader.getDefaultProperty("customer.login");
                userPassword = PropertiesReader.getDefaultProperty("customer.password");
                break;
            case INVALID_USER:
                userName = PropertiesReader.getDefaultProperty("invalid.user.login");
                userPassword = PropertiesReader.getDefaultProperty("invalid.user.password");
                break;
        }
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(userPassword);
        logInButton.click();
        return new UserInfoPage(driver);
    }

    public UserInfoPage logInAs(final String login, final String password) {

        inputName(login);

        inputPassword(password);

        clickLogInButton();

        return new UserInfoPage(driver);
    }

    public LogInPage inputName(final String name) {
        getUserNameInput().sendKeys(name);
        return this;
    }

    public LogInPage inputPassword(final String password) {
        getPasswordInput().sendKeys(password);
        return this;
    }

    public UserInfoPage clickLogInButton() {
        logInButton.click();
        return new UserInfoPage(driver);
    }

    public LogInPage clickRememberMeCheckbox() {
        rememberMeCheckbox.click();
        return this;
    }
}
