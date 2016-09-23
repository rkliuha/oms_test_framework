package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.utils.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkbox extends AbstractClickableElement<Checkbox> {

    private int timeout = 20;

    public Checkbox(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }

    final public void select() {

        waitUntilElementIsPresent();
        waitUntilElementIsClickable();
        if (!driver.findElement(locator.getBy()).isSelected()) {
            driver.findElement(locator.getBy()).click();
        }
        Logger.logInfo("<b><font size='1' color='black'>Selected element "
                + locator.getName() + "</font></b>");
    }

    final public void deselect() {

        waitUntilElementIsPresent();
        waitUntilElementIsClickable();
        if (driver.findElement(locator.getBy()).isSelected()) {
            driver.findElement(locator.getBy()).click();
        }
        Logger.logInfo("<b><font size='1' color='black'>Deselected element "
                + locator.getName() + "</font></b>");
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
