package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.utils.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class Checkbox extends AbstractClickableElement<Checkbox> {

    public Checkbox(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }

    final public void select() {

        waitUntilElementIsPresent();
        if (!driver.findElement(locator.getBy()).isSelected()) {
            driver.findElement(locator.getBy()).click();
        }
        Reporter.log(Logger.logInfo("<b><font size='1' color='black'>Selected element "
                + locator.getName() + "</font></b>"));
    }

    final public void deselect() {

        waitUntilElementIsPresent();
        if (driver.findElement(locator.getBy()).isSelected()) {
            driver.findElement(locator.getBy()).click();
        }
        Reporter.log(Logger.logInfo("<b><font size='1' color='black'>Deselected element "
                + locator.getName() + "</font></b>"));
    }

    private void waitUntilElementIsPresent() {

        new WebDriverWait(driver, 20)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(locator.getBy()));
    }
}
