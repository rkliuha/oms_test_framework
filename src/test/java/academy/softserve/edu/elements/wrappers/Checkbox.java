package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.utils.Logger;
import org.openqa.selenium.WebDriver;

//TODO remove redundant findElement() call - https://ssu-jira.softserveinc.com/browse/IFATQCZZ-90
public class Checkbox extends AbstractClickableElement<Checkbox> {

    public Checkbox(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }

    final public void select() {

        //TODO use click()
        wait.waitUntilElementIsPresent();
        wait.waitUntilElementIsClickable();
        if (!driver.findElement(locator.getBy()).isSelected()) {
            driver.findElement(locator.getBy()).click();
        }
        Logger.logInfo("<font color='black'>Selected Element "
                + "<b>" + locator.getName() + "</b></font>");
    }

    final public void deselect() {

        //TODO use click()
        wait.waitUntilElementIsPresent();
        wait.waitUntilElementIsClickable();
        if (driver.findElement(locator.getBy()).isSelected()) {
            driver.findElement(locator.getBy()).click();
        }
        Logger.logInfo("<font color='black'>Deselected Element "
                + "<b>" + locator.getName() + "</b></font>");
    }
}
