package academy.softserve.edu.pageobjects;

import academy.softserve.edu.domains.User;
import academy.softserve.edu.elements.wrappers.Button;
import academy.softserve.edu.elements.wrappers.Dropdown;
import academy.softserve.edu.elements.wrappers.TextInputField;
import academy.softserve.edu.elements.wrappers.TextLabel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.administrator.EditUserPageLocators.*;

@Getter
public class EditUserPage extends PageObject<EditUserPage> {

    /**
     * newPasswordText is an unique element on the EditUserPage,
     * can be used as identification of page;
     */
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

    public final EditUserPage fillLastName(final String lastName) {

        lastNameInput.sendKeys(lastName);
        return this;
    }

    public final EditUserPage fillFirstName(final String firstName) {

        firstNameInput.sendKeys(firstName);
        return this;
    }

    public final EditUserPage fillNewPassword(final String password) {

        newPasswordInput.sendKeys(password);
        return this;
    }

    public final EditUserPage fillConfirmPassword(final String password) {

        confirmPasswordInput.sendKeys(password);
        return this;
    }

    public final EditUserPage fillEmailAddress(final String emailAddress) {

        emailAddressInput.sendKeys(emailAddress);
        return this;
    }

    public final EditUserPage selectRegion(final String region) {

        regionDropdown.sendKeys(region);
        return this;
    }

    public final EditUserPage selectRole(final String role) {

        roleDropdown.sendKeys(role);
        return this;
    }

    public final AdministrationPage clickSaveChanges() {

        saveChangesButton.click();
        return new AdministrationPage(driver);
    }

    public final AdministrationPage clickCancel() {

        cancelButton.click();
        return new AdministrationPage(driver);
    }

    public final EditUserPage setUserFields(final User newUser) {

        return fillFirstName(newUser.getFirstName())
                .fillLastName(newUser.getLastName())
                .fillNewPassword(newUser.getPassword())
                .fillConfirmPassword(newUser.getPassword())
                .fillEmailAddress(newUser.getEmail())
                .selectRegion(newUser.getRegionName())
                .selectRole(newUser.getRoleName());
    }

    public final AdministrationPage editUser() {

        return clickSaveChanges();
    }

    public final AdministrationPage doNotEditUser() {

        return clickCancel();
    }

}
