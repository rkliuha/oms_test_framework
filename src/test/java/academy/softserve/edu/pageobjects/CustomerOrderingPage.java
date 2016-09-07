package academy.softserve.edu.pageobjects;

import org.openqa.selenium.WebDriver;

public class CustomerOrderingPage extends PageObject {

    public static final String CUSTOMER_ORDERING_PAGE_URL =
            "http://192.168.56.101:8080/oms5/order.htm";

    public CustomerOrderingPage(final WebDriver driver) {
        super(driver);
    }

}
