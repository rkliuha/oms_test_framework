package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.locators.administrator.AdministrationPageLocators;
import academy.softserve.edu.elements.locators.customer.AddItemPageLocators;
import academy.softserve.edu.elements.wrappers.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

import static academy.softserve.edu.elements.locators.administrator.AdministrationPageLocators.FIRST_NAME_COLUMN;

// TODO use Lombok for getters
@Getter
public class AdministrationPage extends PageObject<AdministrationPage> {

    public static final String ADMINISTRATION_PAGE_URL = "http://192.168.56.101:8080/oms5/users.htm";
    public static final By ADMINISTRATION_PAGE_EXISTS = By.xpath(".//div[@id='list']/a");
    public static final By FIRST_FILED_FILTER_DROPDOWN = By.xpath(".//select[@id='field']");
    public static final By SECOND_FILED_FILTER_DROPDOWN = By.xpath(".//select[@id='condition']");
    public static final By FILED_FILTER_TEXT_BOX = By.xpath(".//input[@id='searchField']");
    public static final By FILED_FILTER_SEARCH_BUTTON = By.xpath(".//form[@id='searchForm']/input[2]");
    public static final By IDENTIFICATION_OF_ADMINISTRATOR_PAGE = By.xpath(".//*[@id='list']/h4[1]");
    public static final By EDIT_LAST_USER_LINK = By.xpath("//table[@id='table']/tbody/tr[last()]/td[6]/a");
    public static final By LAST_USER_PAGINATION_BUTTON = By.id("last");
    public static final By CREATE_REPORT_LINK = By.xpath("//div[@id='list']/h5/a");
    public static final By CREATE_NEW_USER_LINK = By.xpath(".//div[@id='list']/a");

    //Headers in AdminGrid
    public static final By FIRST_NAME_HEADER = By.xpath(".//*[@id='table']/thead/tr/th[1]/a");
    public static final By LAST_NAME_HEADER = By.xpath(".//*[@id='table']/thead/tr/th[2]/a");
    public static final By LOGIN_HEADER = By.xpath(".//*[@id='table']/thead/tr/th[3]/a");
    public static final By ROLE_HEADER = By.xpath(".//*[@id='table']/thead/tr/th[4]/a");
    public static final By REGION_HEADER = By.xpath(".//*[@id='table']/thead/tr/th[5]/a");

    //Locators for cells in first and second rows in AdminGrid
    public static final By FIRST_FIRST_NAME_VALUE = By.xpath(".//*[@id='table']/tbody/tr[1]/td[1]");
    public static final By FIRST_LAST_NAME_VALUE = By.xpath(".//*[@id='table']/tbody/tr[1]/td[2]");
    public static final By FIRST_LOGIN_VALUE = By.xpath(".//*[@id='table']/tbody/tr[1]/td[3]");
    public static final By FIRST_ROLE_VALUE = By.xpath(".//*[@id='table']/tbody/tr[1]/td[4]");
    public static final By FIRST_REGION_VALUE = By.xpath(".//*[@id='table']/tbody/tr[1]/td[5]");
    public static final By EDIT_USER_BUTTON_1 = By.xpath(".//*[@id='table']/tbody/tr[1]/td[6]/a");
    public static final By DELETE_USER_BUTTON_1 = By.xpath(".//*[@id='table']/tbody/tr[1]/td[7]/a");
    public static final By SECOND_LOGIN_VALUE = By.xpath(".//*[@id='table']/tbody/tr[2]/td[3]");

/*    //Locators for all columns from Admin Grid
 //   public static final By FIRST_NAME_COLUMN = By.xpath("./*//*[@id='table']/tbody/tr//td[1]");
    public static final By LAST_NAME_COLUMN = By.xpath("./*//*[@id='table']/tbody/tr//td[2]");
    public static final By LOGIN_COLUMN = By.xpath("./*//*[@id='table']/tbody/tr//td[3]");
    public static final By ROLE_COLUMN = By.xpath("./*//*[@id='table']/tbody/tr//td[4]");
    public static final By REGION_COLUMN = By.xpath("./*//*[@id='table']/tbody/tr//td[5]");*/

    private final Button firstNameColumn =
            new Button(driver, FIRST_NAME_COLUMN);
    private final Button lastNameColumn =
            new Button(driver, AdministrationPageLocators.LAST_NAME_COLUMN);
    private final Button loginColumn =
            new Button(driver, AdministrationPageLocators.LOGIN_COLUMN);
    private final Button roleColumn =
            new Button(driver, AdministrationPageLocators.ROLE_COLUMN);
    private final Button regionColumn =
            new Button(driver, AdministrationPageLocators.REGION_COLUMN);


    //Locators for navigation in the Admin Grid
    public static final By QUANTITY_OF_USERS = By.xpath(".//*[@id='usersFound']");
    public static final By SHOW_QUANTITY_OF_ITEMS = By.xpath(".//*[@id='list']/p/a");
    public static final By GRIDS_PAGE_NUMBER = By.xpath(".//*[@id='pageNumber']");
    public static final By QUANTITY_OF_GRIDS_PAGES = By.xpath(".//*[@id='pageCount']");
    public static final By FIRST_BUTTON = By.xpath(".//*[@id='list']/h4[2]");
    public static final By BACKWARD_BUTTON = By.xpath(".//*[@id='previous']");
    public static final By FORWARD_BUTTON = By.xpath(".//*[@id='next']");
    public static final By LAST_BUTTON = By.xpath(".//*[@id='last']");


    public final List<String> gridsColumnValues = new LinkedList<>();

    public AdministrationPage(final WebDriver driver) {
        super(driver);
    }


    public final UserInfoPage clickUserInfoTab() {
        driver.findElement(UserInfoPage.USER_INFO_LINK).click();
        return new UserInfoPage(driver);
    }

    public final EditUserPage clickEditLastUserLink() {
        driver.findElement(EDIT_LAST_USER_LINK).click();
        return new EditUserPage(driver);
    }

    public final AdministrationPage clickLastUserPaginationButton() {
        driver.findElement(LAST_USER_PAGINATION_BUTTON).click();
        return this;
    }

    public final WebElement identificationOfAdministratorPage() {
        return getElement(IDENTIFICATION_OF_ADMINISTRATOR_PAGE);
    }

    public final CreateReportPage clickCreateReportLink() {
        getCreateReportLink().click();
        return new CreateReportPage(driver);
    }

    public final WebElement getCreateReportLink() {
        return driver.findElement(CREATE_REPORT_LINK);
    }


    //Methods for adminGridTests

    //Pull String to List from Admins Grid column cells.
    public final List<String> pullStringsValueFromGetElements(final By adminGridColumn) {
        for (int i = 0; i < getElements(adminGridColumn).size(); i++) {
            gridsColumnValues.add(i, getElements(adminGridColumn).get(i).getText());
        }
        return gridsColumnValues;
    }

    // 3 methods for searching
    public final AdministrationPage selectFirstFilterValue(final String firstSearchFilter) {
        getElement(AdministrationPage.FIRST_FILED_FILTER_DROPDOWN)
                .sendKeys(firstSearchFilter);
        return this;
    }

    public final AdministrationPage selectSecondFilterValue(final String secondSearchFilter) {
        getElement(AdministrationPage.SECOND_FILED_FILTER_DROPDOWN)
                .sendKeys(secondSearchFilter);
        return this;
    }

    public final AdministrationPage putValueToTextBoxAndClick(final String searchingValue) {
        getElement(AdministrationPage.FILED_FILTER_TEXT_BOX)
                .sendKeys(searchingValue);
        getElement(AdministrationPage.FILED_FILTER_SEARCH_BUTTON)
                .click();
        return this;
    }


    public final void putValue(final String searchingValue) {
        System.out.println(driver.findElement(QUANTITY_OF_USERS).getText());

    }

    public AdministrationPage clickForwardButton() {
        getElement(FORWARD_BUTTON).click();
        return this;
    }

    public AdministrationPage clickBackwardButton() {
        getElement(BACKWARD_BUTTON).click();
        return this;
    }

    public AdministrationPage clickLastButton() {
        getElement(LAST_BUTTON).click();
        return this;
    }

    public AdministrationPage clickFirstButton() {
        getElement(LAST_BUTTON).click();
        return this;
    }
}
