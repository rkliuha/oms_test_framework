package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class AbstractElement<T> {

    protected final WebDriver driver;
    protected ILocator locator;

    AbstractElement(final WebDriver driver, final ILocator locator) {
        this.driver = driver;
        this.locator = locator;
    }

    final public WebElement getElement() {
        return driver.findElement(locator.getBy());
    }

    final public boolean isDisplayed() {
        return driver.findElement(locator.getBy()).isDisplayed();
    }

    final public boolean isEnabled() {
        return driver.findElement(locator.getBy()).isEnabled();
    }

    final public String getText() {
        return driver.findElement(locator.getBy()).getText();
    }

    final public List<WebElement> getElements() {
        return driver.findElements(locator.getBy());
    }

    final public String getIdAttribute() {
        return driver.findElement(locator.getBy()).getAttribute("id");
    }

    final public String getNameAttribute() {
        return driver.findElement(locator.getBy()).getAttribute("name");
    }

    final public String getValueAttribute() {
        return driver.findElement(locator.getBy()).getAttribute("value");
    }

    final public String getTypeAttribute() {
        return driver.findElement(locator.getBy()).getAttribute("type");
    }
}
