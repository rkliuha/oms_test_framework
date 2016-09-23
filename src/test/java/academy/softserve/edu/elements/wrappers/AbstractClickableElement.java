package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.utils.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractClickableElement<T> extends AbstractElement {

    private int timeout = 20;

    AbstractClickableElement(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }

    final public T click() {

        waitUntilElementIsPresent();
        waitUntilElementIsClickable();
        driver.findElement(locator.getBy()).click();
        Logger.logInfo("<b><font size='1' color='black'>Clicked On "
                + locator.getName() + "</font></b>");
        return (T) this;
    }

    final public T doDoubleClick() {

        waitUntilElementIsPresent();
        waitUntilElementIsClickable();
        final Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(locator.getBy())).doubleClick().perform();
        Logger.logInfo("<b><font size='1' color='black'>Double Clicked On "
                + locator.getName() + "</font></b>");
        return (T) this;
    }

    final public T clickAndHold() {

        waitUntilElementIsPresent();
        waitUntilElementIsClickable();
        final Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(locator.getBy())).clickAndHold().perform();
        Logger.logInfo("<b><font size='1' color='black'>Clicked and Held On "
                + locator.getName() + "</font></b>");
        return (T) this;
    }

    final public void doRightClick() {

        waitUntilElementIsPresent();
        waitUntilElementIsClickable();
        final Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(locator.getBy())).contextClick().perform();
        Logger.logInfo("<b><font size='1' color='black'>Clicked with Right Button On "
                + locator.getName() + "</font></b>\n");
    }

    private void waitUntilElementIsPresent() {

        new WebDriverWait(driver, timeout)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(locator.getBy()));
    }

    private void waitUntilElementIsClickable() {

        new WebDriverWait(driver, timeout)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(locator.getBy()));

    }
}
