package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AbstractElement<T> {

    protected final WebDriver driver;
    protected ILocator locator;

    AbstractElement(final WebDriver driver, final ILocator locator) {
        this.driver = driver;
        this.locator = locator;
    }

    final public WebElement getElement() {

        waitUntilElementIsPresent();
        return driver.findElement(locator.getBy());
    }

    final public boolean isDisplayed() {

        waitUntilElementIsPresent();
        return driver.findElement(locator.getBy()).isDisplayed();
    }

    final public boolean isEnabled() {

        waitUntilElementIsPresent();
        return driver.findElement(locator.getBy()).isEnabled();
    }

    final public String getText() {

        waitUntilElementIsPresent();
        return driver.findElement(locator.getBy()).getText();
    }

    final public List<WebElement> getElements() {
        return driver.findElements(locator.getBy());
    }

    final public String getId() {

        waitUntilElementIsPresent();
        return driver.findElement(locator.getBy()).getAttribute("id");
    }

    final public String getName() {

        waitUntilElementIsPresent();
        return driver.findElement(locator.getBy()).getAttribute("name");
    }

    final public String getValue() {

        waitUntilElementIsPresent();
        return driver.findElement(locator.getBy()).getAttribute("value");
    }

    final public String getType() {

        waitUntilElementIsPresent();
        return driver.findElement(locator.getBy()).getAttribute("type");
    }

    private void waitUntilElementIsPresent() {

        new WebDriverWait(driver, 20)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(locator.getBy()));
    }
}
