package academy.softserve.edu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemManagementPage extends PageObject<ItemManagementPage> {

    public static final String ITEM_MANAGEMENT_PAGE_URL = "http://192.168.56.101:8080/oms5/itemManagement.htm";
    public static final By ITEM_MANAGEMENT_PAGE_EXISTS = By.xpath(".//div[@id='list']/a[1]");
    public static final By FIELD_FILTER_DROPDOWN = By.xpath(".//select[@id='field']");
    public static final By FIELD_FILTER_TEXT_BOX = By.xpath(".//input[@id='searchField']");
    public static final By FIELD_FILTER_BUTTON = By.xpath(".//input [@name='search']");


    public ItemManagementPage(final WebDriver driver) {
        super(driver);
    }

}
