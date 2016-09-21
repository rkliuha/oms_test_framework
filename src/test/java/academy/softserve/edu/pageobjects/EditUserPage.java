package academy.softserve.edu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditUserPage extends PageObject<EditUserPage> {

    public static final By EDIT_USER_PAGE_EXISTS = By.xpath(".//div[@id='edit']/h3");
    public static final By LOGIN_NAME_TEXT_FIELD = By.id("login");
    public static final By FIRST_NAME_TEXT_FIELD = By.id("firstName");
    public static final By LAST_NAME_TEXT_FIELD = By.id("lastName");
    public static final By NEW_PASSWORD_TEXT_FIELD = By.id("password");
    public static final By CONFIRM_PASSWORD_TEXT_FIELD = By.id("confirmPassword");
    public static final By EMAIL_ADDRESS_TEXT_FIELD = By.id("email");
    public static final By REGION_DROPDOWN = By.id("regionID");
    public static final By ROLE_DROPDOWN = By.id("roleID");
    public static final By SAVE_CHANGES_BUTTON = By.xpath("//form[@id='userModel']//input[@value='Save changes']");
    public static final By CREATE_BUTTON = By.xpath(".//form[@id='userModel']/input[4]");
    public static final By CANCEL_BUTTON = By.xpath("//form[@id='userModel']//input[@value='Cancel']");

    public EditUserPage(final WebDriver driver) {
        super(driver);
    }

    public final WebElement getIdentificationOfEditUserPage() {
        return driver.findElement(EDIT_USER_PAGE_EXISTS);
    }

    public final AdministrationPage clickSaveChangesButton() {
        driver.findElement(SAVE_CHANGES_BUTTON).click();
        return new AdministrationPage(driver);
    }

    public final AdministrationPage clickCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
        return new AdministrationPage(driver);
    }

    public final WebElement getFirstNameTextField() {
        return driver.findElement(FIRST_NAME_TEXT_FIELD);
    }

    public final WebElement getLastNameTextField() {
        return driver.findElement(LAST_NAME_TEXT_FIELD);
    }

    public final WebElement getNewPasswordTextField() {
        return driver.findElement(NEW_PASSWORD_TEXT_FIELD);
    }

    public final WebElement getConfirmPasswordTextField() {
        return driver.findElement(CONFIRM_PASSWORD_TEXT_FIELD);
    }

    public final WebElement getEmailAddressTextField() {
        return driver.findElement(EMAIL_ADDRESS_TEXT_FIELD);
    }

    public final WebElement getRegionDropdown() {
        return driver.findElement(REGION_DROPDOWN);
    }

    public final WebElement getRoleDropdown() {
        return driver.findElement(ROLE_DROPDOWN);
    }

}
