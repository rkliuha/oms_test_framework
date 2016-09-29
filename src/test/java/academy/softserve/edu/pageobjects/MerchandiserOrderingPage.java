package academy.softserve.edu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// TODO use Lombok for getters
public class MerchandiserOrderingPage extends PageObject<MerchandiserOrderingPage> {

    public static final By MERCHANDISER_PAGE_EXISTS = By.xpath(".//div[@id='edit']//td[1]");
    public static final By MERCHANDISER_SEARCH_ORDERS_DROPDOWN = By.xpath(".//select[@id='search']");
    public static final By MERCHANDISER_SEARCH_ORDERS_TEXT_BOX = By.xpath(".//input[@id='searchValue']");
    public static final By MERCHANDISER_SEARCH_ORDERS_BUTTON = By.xpath(".//input [@name='Apply']");

    public MerchandiserOrderingPage(final WebDriver driver) {
        super(driver);
    }

    public final UserInfoPage clickUserInfoTab() {
        driver.findElement(UserInfoPage.USER_INFO_LINK).click();
        return new UserInfoPage(driver);
    }

    public final WebElement getIdentificationOfMerchandiserPage() {
        return getElement(MERCHANDISER_PAGE_EXISTS);
    }
}
