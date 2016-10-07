package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.utils.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class AbstractClickableElement<T> extends AbstractElement {

    AbstractClickableElement(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }

    final public T click() {

        //TODO remove redundant findElement() call - https://ssu-jira.softserveinc.com/browse/IFATQCZZ-90
        wait.waitUntilElementIsPresent();
        wait.waitUntilElementIsClickable();
        driver.findElement(locator.getBy()).click();
        Logger.logInfo("<font color='black'>Clicked On "
                + "<b>" + locator.getName() + "</b></font>");
        return (T) this;
    }

    final public T doDoubleClick() {

        //TODO remove redundant findElement() call - https://ssu-jira.softserveinc.com/browse/IFATQCZZ-90
        wait.waitUntilElementIsPresent();
        wait.waitUntilElementIsClickable();
        final Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(locator.getBy())).doubleClick().perform();
        Logger.logInfo("<font color='black'>Double Clicked On "
                + "<b>" + locator.getName() + "</b></font>");
        return (T) this;
    }

    final public T clickAndHold() {

        //TODO remove redundant findElement() call - https://ssu-jira.softserveinc.com/browse/IFATQCZZ-90
        wait.waitUntilElementIsPresent();
        wait.waitUntilElementIsClickable();
        final Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(locator.getBy())).clickAndHold().perform();
        Logger.logInfo("<font color='black'>Clicked and Held On "
                + "<b>" + locator.getName() + "</b></font>");
        return (T) this;
    }

    final public void doRightClick() {

        //TODO remove redundant findElement() call - https://ssu-jira.softserveinc.com/browse/IFATQCZZ-90
        wait.waitUntilElementIsPresent();
        wait.waitUntilElementIsClickable();
        final Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(locator.getBy())).contextClick().perform();
        Logger.logInfo("<font color='black'>Clicked by Right Button On "
                + "<b>" + locator.getName() + "</b></font>");
    }
}
