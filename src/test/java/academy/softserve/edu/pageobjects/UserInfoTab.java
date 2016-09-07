package academy.softserve.edu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserInfoTab  extends  PageObject{
    private final String firstName = "//tr[1]/td[2]";
    private final String lastName = "//tr[2]/td[2]";
    private final String customerType = "//tr[3]/td[2]";
    private final String role = "//tr[4]/td[2]";
    private final String logOutButton = "//span [@id='logout']/img";


    public  UserInfoTab(WebDriver driver) {
        super(driver);
    }
    public  boolean firstNameNotEmpty() {
        return !driver.findElement(By.xpath(firstName)).getText().isEmpty();
    } public boolean lastNameNotEmpty() {
        return !driver.findElement(By.xpath(lastName)).getText().isEmpty();
    } public boolean customerTypeNotEmpty() {
        return !driver.findElement(By.xpath(customerType)).getText().isEmpty();
    } public boolean roleNotEmpty() {
        return !driver.findElement(By.xpath(role)).getText().isEmpty();
    }
    public  UserInfoTab logOut() {
        driver.findElement(By.xpath(logOutButton)).click();
        return this;
    }
}
