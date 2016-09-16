package academy.softserve.edu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MerchandiserOrderingPage extends PageObject<MerchandiserOrderingPage> {


    public static final String MERCHANDISER_ORDERING_PAGE_URL = "http://192.168.56.101:8080/oms5/order.htm";
    public static final By MERCHANDISER_PAGE_EXISTS = By.xpath(".//div[@id='edit']//td[1]");
    public static final By MERCHANDISER_SEARCH_ORDERS_DROPDOWN = By.xpath(".//select[@id='search']");
    public static final By MERCHANDISER_SEARCH_ORDERS_TEXT_BOX = By.xpath(".//input[@id='searchValue']");
    public static final By MERCHANDISER_SEARCH_ORDERS_BUTTON = By.xpath(".//input [@name='Apply']");
    public static final By IDENTIFICATION_OF_MERCHANDISER_PAGE = By.xpath(".//*[@id='searchFilter']/table/tbody/tr/td[1]");


    public MerchandiserOrderingPage(final WebDriver driver) {
        super(driver);
    }

    public final UserInfoPage clickUserInfoTab() {
        driver.findElement(UserInfoPage.USER_INFO_LINK).click();
        return new UserInfoPage(driver);
    }

    public final WebElement getIdentificationOfMerchandiserPage() {
        return getElement(IDENTIFICATION_OF_MERCHANDISER_PAGE);
    }
}
