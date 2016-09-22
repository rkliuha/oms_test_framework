package academy.softserve.edu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// TODO use Lombok for getters
public class ItemManagementPage extends PageObject<ItemManagementPage> {

    //TODO remove
    public static final String ITEM_MANAGEMENT_PAGE_URL = "http://192.168.56.101:8080/oms5/itemManagement.htm";
    public static final By ITEM_MANAGEMENT_PAGE_EXISTS = By.xpath(".//div[@id='list']/a[1]");
    public static final By FIELD_FILTER_DROPDOWN = By.xpath(".//select[@id='field']");
    public static final By FIELD_FILTER_TEXT_BOX = By.xpath(".//input[@id='searchField']");
    public static final By FIELD_FILTER_BUTTON = By.xpath(".//input [@name='search']");

    //TODO rename into SUPERVISOR_PAGE_EXISTS
    public static final By IDENTIFICATION_OF_SUPERVISOR_PAGE = By.xpath(".//*[@id='list']/fieldset/legend");


    public ItemManagementPage(final WebDriver driver) {
        super(driver);
    }

    public final WebElement getIdentificationOfSupervisePage() {
        return getElement(IDENTIFICATION_OF_SUPERVISOR_PAGE);
    }

}
