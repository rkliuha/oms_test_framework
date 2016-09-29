package academy.softserve.edu.pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
public class CustomerOrderingPage extends PageObject<CustomerOrderingPage> {

    //TODO remove
    public static final String CUSTOMER_ORDERING_PAGE_URL = "http://192.168.56.101:8080/oms5/order.htm";
    public static final By USER_INFO_BUTTON = By.xpath("(.//ul[@id='nav']//a)[2]");
    public static final By CUSTOMER_PAGE_EXISTS = By.xpath(".//div[@id='content']/a");
    public static final By SEARCH_ORDERS_DROPDOWN = By.xpath(".//select[@id='search']");
    public static final By SEARCH_ORDERS_TEXT_BOX = By.xpath(".//input[@id='searchValue']");
    public static final By SEARCH_ORDERS_BUTTON = By.xpath(".//input[@name='Apply']");
    public static final By IDENTIFICATION_OF_CUSTOMER_PAGE = By.xpath(".//*[@id='content']/a");
    public static final By SHOW_10_ITEMS_LINK = By.xpath(".//form[@id='searchFilter']//a");
    public static final By SHOW_5_ITEMS_LINK = By.xpath(".//form[@id='searchFilter']//a");

    public CustomerOrderingPage(WebDriver driver) {
        super(driver);
    }

    public final UserInfoPage clickUserInfoTab() {

        driver
                .findElement(USER_INFO_BUTTON)
                .click();

        return new UserInfoPage(driver);
    }

    public final WebElement getIdentificationOfCustomerPage() {
        return getElement(IDENTIFICATION_OF_CUSTOMER_PAGE);
    }
}
