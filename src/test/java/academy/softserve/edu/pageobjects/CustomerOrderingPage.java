package academy.softserve.edu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerOrderingPage extends PageObject {

    public static final String CUSTOMER_ORDERING_PAGE_URL = "http://192.168.56.101:8080/oms5/order.htm";
    public static final By USER_INFO_BUTTON = By.xpath("(.//ul[@id='nav']//a)[2]");
    public static final By CUSTOMER_PAGE_EXISTS = By.xpath(".//div[@id='content']/a");


    public CustomerOrderingPage(WebDriver driver) {
        super(driver);
    }

    public final UserInfoPage clickUserInfoTab() {

        driver
                .findElement(USER_INFO_BUTTON)
                .click();

        return new UserInfoPage(driver);
    }
}
