package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.Link;
import academy.softserve.edu.elements.wrappers.TextLabel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.administrator.AdministrationPageLocators.ADMINISTRATION_LINK;
import static academy.softserve.edu.elements.locators.customer.CustomerOrderingPageLocators.CUSTOMER_ORDERING_LINK;
import static academy.softserve.edu.elements.locators.merchandiser.MerchandiserOrderingPageLocators.MERCHANDISER_ORDERING_LINK;
import static academy.softserve.edu.elements.locators.shared.SharedLocators.ENGLISH_SWITCH_LINK;
import static academy.softserve.edu.elements.locators.shared.SharedLocators.UKRAINIAN_SWITCH_LINK;
import static academy.softserve.edu.elements.locators.supervisor.ItemManagementPageLocators.ITEM_MANAGEMENT_LINK;
import static academy.softserve.edu.elements.locators.userinfo.UserInfoPageLocators.*;

@Getter
public class UserInfoPage extends PageObject<UserInfoPage> {

    private final Link administrationLink = new Link(driver, ADMINISTRATION_LINK);
    private final Link itemManagementLink = new Link(driver, ITEM_MANAGEMENT_LINK);
    private final Link customerOrderingLink = new Link(driver, CUSTOMER_ORDERING_LINK);
    private final Link merchandiserOrderingLink = new Link(driver, MERCHANDISER_ORDERING_LINK);
    //TODO remove
    public static final String USER_INFO_PAGE_URL = "http://192.168.56.101:8080/oms5/userInfo.htm";
    private final Link ukrainianSwitchLink = new Link(driver, UKRAINIAN_SWITCH_LINK);
    private final Link englishSwitchLink = new Link(driver, ENGLISH_SWITCH_LINK);
    private final Link userInfoLink = new Link(driver, USER_INFO_LINK);
    // userInfoFieldSet is unique UserInfoPage element
    private final TextLabel userInfoFieldSet = new TextLabel(driver, USER_INFO_FIELDSET);
    private final TextLabel firstNameValue = new TextLabel(driver, FIRST_NAME_VALUE);
    private final TextLabel lastNameValue = new TextLabel(driver, LAST_NAME_VALUE);
    private final TextLabel customerTypeValue = new TextLabel(driver, CUSTOMER_TYPE_VALUE);
    private final TextLabel roleValue = new TextLabel(driver, ROLE_VALUE);

    public UserInfoPage(final WebDriver driver) {
        super(driver);
    }

    public final AdministrationPage clickAdministrationTab() {
        administrationLink.click();
        return new AdministrationPage(driver);
    }

    public final CustomerOrderingPage clickCustomerOrderingTab() {
        customerOrderingLink.click();
        return new CustomerOrderingPage(driver);
    }

    public final ItemManagementPage clickItemManagementTab() {
        itemManagementLink.click();
        return new ItemManagementPage(driver);
    }

    public final MerchandiserOrderingPage clickMerchandiserOrderingTab() {
        merchandiserOrderingLink.click();
        return new MerchandiserOrderingPage(driver);
    }

    public UserInfoPage clickUkrainianButton() {
        ukrainianSwitchLink.click();
        return this;
    }

    public UserInfoPage clickEnglishButton() {
        englishSwitchLink.click();
        return this;
    }
}
