package academy.softserve.edu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class PageObject<T> {

    public static final By LOG_OUT_BUTTON = By.id("logout");

    protected WebDriver driver;

    public PageObject(final WebDriver driver) {
        this.driver = driver;
    }

    public final WebElement getElement(final By elementLocation) {
        return driver.findElement(elementLocation);
    }

    public final T doLogOut() {
        driver.findElement(LOG_OUT_BUTTON).click();
        return acceptAlert();
    }

    public final T acceptAlert() {
        driver.switchTo().alert().accept();
        return (T) this;
    }

    public final T dismissAlert() {
        driver.switchTo().alert().dismiss();
        return (T) this;
    }

    public final String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public final String getPageSource() {
        return driver.getPageSource();
    }

    public final T navigateBack() {
        driver.navigate().back();
        return (T) this;
    }

    public final T navigateForvard() {
        driver.navigate().forward();
        return (T) this;
    }

    public final T refreshPage() {
        driver.navigate().refresh();
        return (T) this;
    }
}
