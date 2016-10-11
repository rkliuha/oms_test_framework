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

        wait.waitUntilElementIsPresent();
        wait.waitUntilElementIsClickable().click();
        Logger.logInfo("<font color='black'>Clicked On "
                + "<b>" + locator.getName() + "</b></font>");
        return (T) this;
    }
}
