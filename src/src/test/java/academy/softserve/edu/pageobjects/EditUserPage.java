package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.Button;
import academy.softserve.edu.elements.wrappers.Dropdown;
import academy.softserve.edu.elements.wrappers.TextInputField;
import academy.softserve.edu.elements.wrappers.TextLabel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.administrator.EditUserPageLocators.*;

@Getter
public class EditUserPage extends PageObject<EditUserPage> {

    // newPasswordTExt is unique EditUserPage element
    private final TextLabel newPasswordText = new TextLabel(driver, NEW_PASSWORD_TEXT);
    private final TextInputField firstNameInput = new TextInputField(driver, FIRST_NAME_INPUT);
    private final TextInputField lastNameInput = new TextInputField(driver, LAST_NAME_INPUT);
    private final TextInputField newPasswordInput = new TextInputField(driver, NEW_PASSWORD_INPUT);
    private final TextInputField confirmPasswordInput = new TextInputField(driver, CONFIRM_PASSWORD_INPUT);
    private final TextInputField emailAddressInput = new TextInputField(driver, EMAIL_ADDRESS_INPUT);
    private final Dropdown regionDropdown = new Dropdown(driver, REGION_DROPDOWN);
    private final Dropdown roleDropdown = new Dropdown(driver, ROLE_DROPDOWN);
    private final Button saveChangesButton = new Button(driver, SAVE_CHANGES_BUTTON);
    private final Button cancelButton = new Button(driver, CANCEL_BUTTON);

    public EditUserPage(final WebDriver driver) {
        super(driver);
    }

    public final AdministrationPage clickSaveChangesButton() {
        saveChangesButton.click();
        return new AdministrationPage(driver);
    }

    public final AdministrationPage clickCancelButton() {
        cancelButton.click();
        return new AdministrationPage(driver);
    }
}
