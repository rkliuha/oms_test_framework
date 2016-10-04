package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.Button;
import academy.softserve.edu.elements.wrappers.Dropdown;
import academy.softserve.edu.elements.wrappers.TextInputField;
import academy.softserve.edu.elements.wrappers.TextLabel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.administrator.CreateUserPageLocators.*;

@Getter
public class CreateNewUserPage extends PageObject<CreateNewUserPage> {

    public CreateNewUserPage(WebDriver driver) {
        super(driver);
    }

    // pageInfoText is unique CreateNewUserPage element
    private final TextLabel pageInfoText = new TextLabel(driver, PAGE_INFO_TEXT);
    private final TextInputField logInNameInput = new TextInputField(driver, LOGIN_NAME_INPUT);
    private final TextInputField firstNameInput = new TextInputField(driver, FIRST_NAME_INPUT);
    private final TextInputField lastNameInput = new TextInputField(driver, LAST_NAME_INPUT);
    private final TextInputField passwordInput = new TextInputField(driver, PASSWORD_INPUT);
    private final TextInputField confirmPasswordInput = new TextInputField(driver, CONFIRM_PASSWORD_INPUT);
    private final TextInputField emailInput = new TextInputField(driver, EMAIL_INPUT);
    private final Dropdown regionDropdown = new Dropdown(driver, REGION_DROPDOWN);
    private final Dropdown roleDropdown = new Dropdown(driver, ROLE_DROPDOWN);
    private final Button createButton = new Button(driver, CREATE_BUTTON);
    private final Button cancelButton = new Button(driver, CANCEL_BUTTON);
}
