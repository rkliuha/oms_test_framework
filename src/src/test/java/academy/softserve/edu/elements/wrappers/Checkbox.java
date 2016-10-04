package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.utils.Logger;
import org.openqa.selenium.WebDriver;

public class Checkbox extends AbstractClickableElement<Checkbox> {

    public Checkbox(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }

    final public void select() {

        wait.waitUntilElementIsPresent();
        wait.waitUntilElementIsClickable();
        if (!driver.findElement(locator.getBy()).isSelected()) {
            driver.findElement(locator.getBy()).click();
        }
        Logger.logInfo("<font color='black'>Selected Element "
                + "<b>" + locator.getName() + "</b></font>");
    }

    final public void deselect() {

        wait.waitUntilElementIsPresent();
        wait.waitUntilElementIsClickable();
        if (driver.findElement(locator.getBy()).isSelected()) {
            driver.findElement(locator.getBy()).click();
        }
        Logger.logInfo("<font color='black'>Deselected Element "
                + "<b>" + locator.getName() + "</b></font>");
    }
}
