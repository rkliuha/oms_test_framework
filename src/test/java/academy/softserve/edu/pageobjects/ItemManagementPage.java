package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.*;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.supervisor.ItemManagementPageLocators.*;
import static academy.softserve.edu.elements.locators.userinfo.UserInfoPageLocators.USER_INFO_LINK;

@Getter
public class ItemManagementPage extends PageObject<ItemManagementPage> {

    private final Link userInfoLink = new Link(driver, USER_INFO_LINK);
    private final Dropdown searchFieldFilterDropdown = new Dropdown(driver, SEARCH_FIELD_FILTER_DROPDOWN);
    private final TextInputField searchInput = new TextInputField(driver, SEARCH_INPUT);
    private final Button searchButton = new Button(driver, SEARCH_BUTTON);
    // searchByFieldSet is unique ItemManagementPage element
    private final TextLabel searchByFieldSet = new TextLabel(driver, SEARCH_BY_FIELDSET);
    private final Link createReportLink = new Link(driver, CREATE_REPORT_LINK);

    public ItemManagementPage(final WebDriver driver) {
        super(driver);
    }

    public final SupervisorCreateReportPage clickCreateReportLink() {
        createReportLink.click();
        return new SupervisorCreateReportPage(driver);
    }
}
