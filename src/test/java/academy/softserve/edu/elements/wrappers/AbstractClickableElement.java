package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractClickableElement<T> extends AbstractElement {

    AbstractClickableElement(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }

    final public T click() {
        driver.findElement(locator.getBy()).click();
        return (T) this;
    }

    final public T doDoubleClick() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(locator.getBy())).doubleClick().perform();
        return (T) this;
    }

    final public T clickAndHold() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(locator.getBy())).clickAndHold().perform();
        return (T) this;
    }

    final public void doRightClick() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(locator.getBy())).contextClick().perform();
    }

    // checks if element is enabled and visible
    final public boolean isClickable() throws InterruptedException {
        final WebDriverWait wait = new WebDriverWait(driver, 5);
        return wait.until(ExpectedConditions.elementToBeClickable(locator.getBy())).isDisplayed();
    }
}
