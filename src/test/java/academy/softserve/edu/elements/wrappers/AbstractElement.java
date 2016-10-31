package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.utils.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class AbstractElement<T> {

    private final WebDriver driver;
    protected final ILocator locator;
    protected final Wait wait;

    AbstractElement(final WebDriver driver, final ILocator locator) {

        this.driver = driver;
        this.locator = locator;
        wait = new Wait(driver, locator);
    }

    public final String getLocatorName() {
        return locator.getName();
    }

    public final By getLocatorValue() {
        return locator.getBy();
    }

    public final WebElement getElement() {
        return wait.waitUntilElementIsPresent();
    }

    public final boolean isDisplayed() {
        return wait.waitUntilElementIsPresent().isDisplayed();
    }

    public final boolean isEnabled() {
        return wait.waitUntilElementIsPresent().isEnabled();
    }

    public final String getText() {
        return wait.waitUntilElementIsPresent().getText();
    }

    public final List<WebElement> getElements() {

        wait.waitUntilElementIsPresent();
        return driver.findElements(locator.getBy());
    }

    public final String getId() {
        return wait.waitUntilElementIsPresent().getAttribute("id");
    }

    public final String getValue() {
        return wait.waitUntilElementIsPresent().getAttribute("value");
    }

}
