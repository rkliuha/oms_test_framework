package academy.softserve.edu.pageobjects;

import org.openqa.selenium.WebDriver;

public class MerchandiserOrderingPage extends PageObject {

    public static final String MERCHANDISER_ORDERING_PAGE_URL =
            "http://192.168.56.101:8080/oms5/order.htm";

    public MerchandiserOrderingPage(final WebDriver driver) {
        super(driver);
    }

}
