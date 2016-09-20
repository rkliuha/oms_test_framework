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


    public AdministrationPage(final WebDriver driver) {
        super(driver);
    }

    public final UserInfoPage clickUserInfoTab() {
        driver.findElement(UserInfoPage.USER_INFO_LINK).click();
        return new UserInfoPage(driver);
    }

    public final WebElement identificationOfAdministratorPage() {
        return getElement(IDENTIFICATION_OF_ADMINISTRATOR_PAGE);
    }
}

