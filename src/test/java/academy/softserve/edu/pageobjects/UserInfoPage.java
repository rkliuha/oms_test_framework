package academy.softserve.edu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserInfoPage extends PageObject {

    public static final By ADMINISTRATION_PAGE =
            By.xpath("//ul[@id='nav']//a[1]");
    public static final By ITEM_MANAGEMENT_PAGE =
            By.xpath("//ul[@id='nav']//a[1]");
    public static final By CUSTOMER_ORDERING_PAGE =
            By.xpath("//ul[@id='nav']//a[1]");
    public static final By MERCHANDISER_ORDERING_PAGE =
            By.xpath("//ul[@id='nav']//a[1]");
    public static final String USER_INFO_PAGE_URL =
            "http://192.168.56.101:8080/oms5/userInfo.htm";

    public UserInfoPage(final WebDriver driver) {
        super(driver);
    }

    public final AdministrationPage clickAdministrationTab() {
        driver.findElement(ADMINISTRATION_PAGE).click();
        return new AdministrationPage(driver);
    }

    public final CustomerOrderingPage clickCustomerOrderingTab() {
        driver.findElement(CUSTOMER_ORDERING_PAGE).click();
        return new CustomerOrderingPage(driver);
    }

    public final ItemManagementPage clickItemManagementTab() {
        driver.findElement(ITEM_MANAGEMENT_PAGE).click();
        return new ItemManagementPage(driver);
    }

    public final MerchandiserOrderingPage clickMerchandiserOrderingTab() {
        driver.findElement(MERCHANDISER_ORDERING_PAGE).click();
        return new MerchandiserOrderingPage(driver);
    }

}
