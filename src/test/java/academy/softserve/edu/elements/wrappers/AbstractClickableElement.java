package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.utils.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public abstract class AbstractClickableElement<T> extends AbstractElement {

    AbstractClickableElement(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }

    final public T click() {

        waitUntilElementIsPresent();
        driver.findElement(locator.getBy()).click();
        Reporter.log(Logger.logInfo("<b><font size='1' color='black'>Clicked On "
                + locator.getName() + "</font></b>"));
        return (T) this;
    }

    final public T doDoubleClick() {

        waitUntilElementIsPresent();
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(locator.getBy())).doubleClick().perform();
        Reporter.log(Logger.logInfo("<b><font size='1' color='black'>Double Clicked On "
                + locator.getName() + "</font></b>"));
        return (T) this;
    }

    final public T clickAndHold() {

        waitUntilElementIsPresent();
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(locator.getBy())).clickAndHold().perform();
        Reporter.log(Logger.logInfo("<b><font size='1' color='black'>Clicked and Held On "
                + locator.getName() + "</font></b>"));
        return (T) this;
    }

    final public void doRightClick() {

        waitUntilElementIsPresent();
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(locator.getBy())).contextClick().perform();
        Reporter.log(Logger.logInfo("<b><font size='1' color='black'>Clicked with Right Button On "
                + locator.getName() + "</font></b>\n"));
    }

    private void waitUntilElementIsPresent() {

        new WebDriverWait(driver, 20)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(locator.getBy()));
    }
}
