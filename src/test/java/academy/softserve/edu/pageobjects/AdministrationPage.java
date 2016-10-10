package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.elements.wrappers.*;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.administrator.AdministrationPageLocators.*;
import static academy.softserve.edu.elements.locators.userinfo.UserInfoPageLocators.USER_INFO_LINK;

@Getter
public class AdministrationPage extends PageObject<AdministrationPage> {

    private final Link administrationLink = new Link(driver, ADMINISTRATION_LINK);

    private final Link userInfoLink = new Link(driver, USER_INFO_LINK);

    private final Dropdown searchFieldFilterDropdown = new Dropdown(driver, SEARCH_FIELD_FILTER_DROPDOWN);

    private final Dropdown searchConditionDropdown = new Dropdown(driver, SEARCH_CONDITION_DROPDOWN);

    private final TextInputField searchInput = new TextInputField(driver, SEARCH_INPUT);

    private final Button searchButton = new Button(driver, SEARCH_BUTTON);

    // foundUsersTextLabel is unique AdministrationPage element
    private final TextLabel foundUsersTextLabel = new TextLabel(driver, FOUND_USERS_TEXT_LABEL);

    private final Link editLastUserCellLink = new Link(driver, EDIT_USER_CELL_LINK.modify("//table[@id='table']/tbody/tr[last()]/td[6]/a"));

    private final Button lastNavigationButton = new Button(driver, LAST_NAVIGATION_BUTTON);

    private final Link deleteFirstUserCellLink = new Link(driver, DELETE_USER_CELL_LINK.modify("1"));

    private final Link createReportLink = new Link(driver, CREATE_REPORT_LINK);

    private final Link createUserLink = new Link(driver, CREATE_USER_LINK);

    private final Link editUserLink = new Link(driver, EDIT_USER_LINK);


    public AdministrationPage(final WebDriver driver) {
        super(driver);
    }

    public final Link clickEditUserById(final String userId) {

        return new Link(driver, EDIT_USER_LINK.modify(userId))
                .click();
    }

    public final UserInfoPage clickUserInfoTab() {
        userInfoLink.click();
        return new UserInfoPage(driver);
    }

    public final EditUserPage clickEditLastUserLink() {
        editLastUserCellLink.click();
        return new EditUserPage(driver);
    }

    public final AdministrationPage clickLastUserPaginationButton() {
        lastNavigationButton.click();
        return this;
    }

    public final AdministrationPage clickDeleteFirstUserLink() {
        deleteFirstUserCellLink.click();
        return this;
    }

    public final CreateReportPage clickCreateReportLink() {
        createReportLink.click();
        return new CreateReportPage(driver);
    }
}
