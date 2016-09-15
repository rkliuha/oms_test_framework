package academy.softserve.edu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdministrationPage extends PageObject {

    public static final String ADMINISTRATION_PAGE_URL = "http://192.168.56.101:8080/oms5/users.htm";
    public static final By ADMINISTRATION_PAGE_EXISTS = By.xpath(".//div[@id='list']/a");
    public static final By FIRST_FILED_FILTER_DROPDOWN = By.xpath(".//select[@id='field']");
    public static final By SECOND_FILED_FILTER_DROPDOWN = By.xpath(".//select[@id='condition']");
    public static final By FILED_FILTER_TEXT_BOX = By.xpath(".//input[@id='searchField']");
    public static final By FILED_FILTER_SEARCH_BUTTON = By.xpath(".//form[@id='searchForm']/input[2]");



    public AdministrationPage(final WebDriver driver) {
        super(driver);
    }

    public final UserInfoPage clickUserInfoTab() {
        driver.findElement(UserInfoPage.USER_INFO_LINK).click();
        return new UserInfoPage(driver);
    }
}

