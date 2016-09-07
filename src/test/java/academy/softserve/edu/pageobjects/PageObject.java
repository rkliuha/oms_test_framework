package academy.softserve.edu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class PageObject {

    public static final By LOG_OUT_BUTTON = By.id("logout");

    protected WebDriver driver;

    public PageObject(final WebDriver driver) {
        this.driver = driver;
    }

    public final WebElement getElement(final By elementLocation) {
        return driver.findElement(elementLocation);
    }

    public final LogInPage doLogOut() {
        driver.findElement(LOG_OUT_BUTTON).click();
        driver.switchTo().alert().accept();
        return new LogInPage(driver);

    }
    public final PageObject pause() throws InterruptedException {
        Thread.sleep(2000);
        return this;
    }
}
