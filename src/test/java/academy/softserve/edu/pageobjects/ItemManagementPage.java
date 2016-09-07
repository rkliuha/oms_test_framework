package academy.softserve.edu.pageobjects;

import org.openqa.selenium.WebDriver;

public class ItemManagementPage extends PageObject {

    public static final String ITEM_MANAGEMENT_PAGE_URL =
            "http://192.168.56.101:8080/oms5/itemManagement.htm";

    public ItemManagementPage(final WebDriver driver) {
        super(driver);
    }

}
