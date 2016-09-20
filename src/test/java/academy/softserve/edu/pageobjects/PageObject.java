package academy.softserve.edu.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//TODO use Lombok for getters
import java.util.List;

public abstract class PageObject<T> {

    public static final By LOG_OUT_BUTTON = By.id("logout");
    private static final By UKRAINIAN_BUTTON = By.id("uk_UA");
    private static final By ENGLISH_BUTTON = By.id("en_US");

    protected WebDriver driver;

    public PageObject(final WebDriver driver) {
        this.driver = driver;
    }

    public final WebElement getElement(final By elementLocation) {
        return driver.findElement(elementLocation);
    }

    public final List<WebElement> getElements(final By elementLocation) {
        return driver.findElements(elementLocation);
    }

    public final LogInPage doLogOut() {

        driver
                .findElement(LOG_OUT_BUTTON)
                .click();
        acceptAlert();
        return new LogInPage(driver);

    }


    public final void acceptAlert() {
        driver
                .switchTo()
                .alert()
                .accept();
    }

    public final void dismissAlert() {
        driver
                .switchTo()
                .alert()
                .dismiss();
    }

    public final String getCurrentUrl() {
        return driver
                .getCurrentUrl();
    }

    public final String getPageSource() {
        return driver
                .getPageSource();
    }

    public final void navigateBack() {
        driver
                .navigate().back();
    }

    //TODO rename
    public final void navigateForvard() {
        driver
                .navigate().forward();
    }

    public final T refreshPage() {
        driver.navigate().refresh();
        return (T) this;
    }

    public T clickUkrainianButton() {
        getElement(UKRAINIAN_BUTTON).click();
        return (T) this;
    }

    public T clickEnglishButton() {
        getElement(ENGLISH_BUTTON).click();
        return (T) this;
    }

    public WebElement getEnglishButton() {
        return driver
                .findElement(ENGLISH_BUTTON);
    }

    public WebElement getUkrainianButton() {
        return driver
                .findElement(UKRAINIAN_BUTTON);
    }

    public void click(final By path) {

        driver
                .findElement(path)
                .click();
    }
}
