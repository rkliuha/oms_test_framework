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
        return wait.getPresentElement();
    }

    public final boolean isDisplayed() {
        return wait.getPresentElement().isDisplayed();
    }

    public final boolean isEnabled() {
        return wait.getPresentElement().isEnabled();
    }

    public final String getText() {
        return wait.getPresentElement().getText();
    }

    public final List<WebElement> getElements() {

        wait.getPresentElement();
        return driver.findElements(locator.getBy());
    }

    public final String getId() {
        return wait.getPresentElement().getAttribute("id");
    }

    public final String getValue() {
        return wait.getPresentElement().getAttribute("value");
    }

}
