package academy.softserve.edu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//TODO use Lombok for getters
public class UserInfoPage extends PageObject<UserInfoPage> {

    public static final By ADMINISTRATION_LINK = By.xpath("//ul[@id='nav']/descendant::a[@href='users.htm']");
    public static final By ITEM_MANAGEMENT_LINK = By.xpath("//ul[@id='nav']/descendant::a[@href='itemManagement.htm']");
    public static final By CUSTOMER_ORDERING_LINK = By.xpath("//ul[@id='nav']/descendant::a[@href='order.htm']");
    public static final By MERCHANDISER_ORDERING_LINK = By.xpath("//ul[@id='nav']/descendant::a[@href='order.htm']");
    //TODO remove
    public static final String USER_INFO_PAGE_URL = "http://192.168.56.101:8080/oms5/userInfo.htm";

    public static final By USER_INFO_LINK = By.xpath("(.//ul[@id='nav']//a)[2]");
    public static final By USER_INFO_PAGE_EXISTS = By.xpath(".//div[@id='content']//legend");
    public static final By FIRST_NAME_VALUE = By.xpath("//tr[1]/td[2]");
    public static final By LAST_NAME_VALUE = By.xpath("//tr[2]/td[2]");
    public static final By CUSTOMER_TYPE_VALUE = By.xpath("//tr[3]/td[2]");
    public static final By ROLE_VALUE = By.xpath("//tr[4]/td[2]");

    //TODO rename
    public static final By IDENTIFICATION_OF_USER_INFO_PAGE = By.xpath(".//*[@id='nav']/li[2]/a");

    public UserInfoPage(final WebDriver driver) {
        super(driver);
    }

    public final AdministrationPage clickAdministrationTab() {
        driver.findElement(ADMINISTRATION_LINK).click();
        return new AdministrationPage(driver);
    }

    public final CustomerOrderingPage clickCustomerOrderingTab() {
        driver.findElement(CUSTOMER_ORDERING_LINK).click();
        return new CustomerOrderingPage(driver);
    }

    public final ItemManagementPage clickItemManagementTab() {
        driver.findElement(ITEM_MANAGEMENT_LINK).click();
        return new ItemManagementPage(driver);
    }

    public final MerchandiserOrderingPage clickMerchandiserOrderingTab() {
        driver.findElement(MERCHANDISER_ORDERING_LINK).click();
        return new MerchandiserOrderingPage(driver);
    }

    public final WebElement getMerchandiserOrderingTab() {
        return driver.findElement(MERCHANDISER_ORDERING_LINK);
    }

    public final WebElement getIdentificationOfUserInfoPage() {
        return driver.findElement(IDENTIFICATION_OF_USER_INFO_PAGE);
    }
}
