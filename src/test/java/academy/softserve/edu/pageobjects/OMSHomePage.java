package academy.softserve.edu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OMSHomePage extends PageObject {
    private final String homePage = "http://192.168.56.101:8080/oms5/";
    private final String userName = "//input[@type = 'text']";
    private final String userPassword = "//input[@type = 'password']";
    private final String logInButton = "//input[@type = 'submit']";

  public OMSHomePage(WebDriver driver) {
        super(driver);
    }
    public  OMSHomePage openHomePage() {
        driver.get(homePage);
        return this;
    }
    public OMSHomePage enterUser(final String text) {
        driver.findElement(By.xpath(userName)).sendKeys(text);
        return this;
    }
    public OMSHomePage enterPassword(final String text) {
        driver.findElement(By.xpath(userPassword)).sendKeys(text);
        return this;
    }
    public OMSHomePage loginClick() {
        driver.findElement(By.xpath(logInButton)).click();
        return this;
    }
}
