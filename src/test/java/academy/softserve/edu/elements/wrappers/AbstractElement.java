package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.utils.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class AbstractElement<T> {

    protected WebDriver driver;
    protected ILocator locator;
    final protected Wait wait;

    AbstractElement(final WebDriver driver, final ILocator locator) {
        this.driver = driver;
        this.locator = locator;
        wait = new Wait(driver, locator);
    }

    final public String getLocatorName() {
        return locator.getName();
    }

    final public WebElement getElement() {

        wait.waitUntilElementIsPresent();
        return driver.findElement(locator.getBy());
    }

    final public boolean isDisplayed() {

        wait.waitUntilElementIsPresent();
        return driver.findElement(locator.getBy()).isDisplayed();
    }

    final public boolean isEnabled() {

        wait.waitUntilElementIsPresent();
        return driver.findElement(locator.getBy()).isEnabled();
    }

    final public String getText() {

        wait.waitUntilElementIsPresent();
        return driver.findElement(locator.getBy()).getText();
    }

    final public List<WebElement> getElements() {
        return driver.findElements(locator.getBy());
    }

    final public String getId() {

        wait.waitUntilElementIsPresent();
        return driver.findElement(locator.getBy()).getAttribute("id");
    }

    final public String getName() {

        wait.waitUntilElementIsPresent();
        return driver.findElement(locator.getBy()).getAttribute("name");
    }

    final public String getValue() {

        wait.waitUntilElementIsPresent();
        return driver.findElement(locator.getBy()).getAttribute("value");
    }

    final public String getType() {

        wait.waitUntilElementIsPresent();
        return driver.findElement(locator.getBy()).getAttribute("type");
    }
}
