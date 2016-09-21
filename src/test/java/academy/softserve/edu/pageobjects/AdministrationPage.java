package academy.softserve.edu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// TODO use Lombok for getters
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
        driver.findElement(CREATE_REPORT_LINK).click();
        return new CreateReportPage(driver);
    }

    public final WebElement getCreateReportLink() {
        return driver.findElement(CREATE_REPORT_LINK);
    }

}
