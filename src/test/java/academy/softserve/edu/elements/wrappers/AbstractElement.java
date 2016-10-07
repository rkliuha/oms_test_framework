package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.utils.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

//TODO remove redundant findElement() call - https://ssu-jira.softserveinc.com/browse/IFATQCZZ-90
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

    final public By getLocatorValue() {return locator.getBy();}

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

        wait.waitUntilElementIsPresent();
        return driver.findElements(locator.getBy());
    }

    final public String getId() {

        wait.waitUntilElementIsPresent();
        return driver.findElement(locator.getBy()).getAttribute("id");
    }

    final public String getNameAttribute() {

        wait.waitUntilElementIsPresent();
        return driver.findElement(locator.getBy()).getAttribute("name");
    }

    final public String getValue() {

        wait.waitUntilElementIsPresent();
        return driver.findElement(locator.getBy()).getAttribute("value");
    }

    final public String getCssValue(final String value) {

        wait.waitUntilElementIsPresent();
        return driver.findElement(locator.getBy()).getCssValue(value);
    }


    final public String getType() {

        wait.waitUntilElementIsPresent();
        return driver.findElement(locator.getBy()).getAttribute("type");
    }
}
