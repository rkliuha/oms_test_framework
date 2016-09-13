package academy.softserve.edu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MerchandiserOrderingPage extends PageObject {

    public static final String MERCHANDISER_ORDERING_PAGE_URL = "http://192.168.56.101:8080/oms5/order.htm";
    public static final By MERCHANDISER_PAGE_EXISTS = By.xpath(".//div[@id='edit']//td[1]");


    public MerchandiserOrderingPage(final WebDriver driver) {
        super(driver);
    }

}
