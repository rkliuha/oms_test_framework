package academy.softserve.edu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateNewUserPage extends PageObject<CreateNewUserPage> {


    public CreateNewUserPage(WebDriver driver) {
        super(driver);
    }

    public static final By CREATE_USER_PAGE_EXISTS = By.xpath(".//div[@id='edit']/h3");
    public static final By LOGIN_NAME_TEXT_FIELD = By.id("login");
    public static final By FIRST_NAME_TEXT_FIELD = By.id("firstName");
    public static final By LAST_NAME_TEXT_FIELD = By.id("lastName");
    public static final By PASSWORD_TEXT_FIELD = By.id("password");
    public static final By CONFIRM_PASSWORD_TEXT_FIELD = By.id("confirmPassword");
    public static final By EMAIL_ADDRESS_TEXT_FIELD = By.id("email");
    public static final By REGION_DROPDOWN = By.id("regionID");
    public static final By ROLE_DROPDOWN = By.id("roleID");
    public static final By SAVE_CHANGES_BUTTON = By.xpath("//form[@id='userModel']//input[@value='Save changes']");
    public static final By CREATE_BUTTON = By.xpath(".//form[@id='userModel']/input[4]");
    public static final By CANCEL_BUTTON = By.xpath("//form[@id='userModel']//input[@value='Cancel']");
}
