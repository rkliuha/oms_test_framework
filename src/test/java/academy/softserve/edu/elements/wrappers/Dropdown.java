package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends AbstractClickableElement<Dropdown> {

    private Select select;

    public Dropdown(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
        select = new Select(driver.findElement(locator.getBy()));
    }

    final public Dropdown selectByIndex(final int indexOfElement) {

        wait.waitUntilElementIsPresent();
        wait.waitUntilElementIsClickable();
        select.selectByIndex(indexOfElement);
        return this;
    }

    final public Dropdown selectByValue(final String valueOfElement) {

        wait.waitUntilElementIsPresent();
        wait.waitUntilElementIsClickable();
        select.selectByValue(valueOfElement);
        return this;
    }

    final public Dropdown deselectByIndex(final int indexOfElement) {

        wait.waitUntilElementIsPresent();
        wait.waitUntilElementIsClickable();
        select.deselectByIndex(indexOfElement);
        return this;
    }

    final public Dropdown deselectByValue(final String valueOfElement) {

        wait.waitUntilElementIsPresent();
        wait.waitUntilElementIsClickable();
        select.deselectByValue(valueOfElement);
        return this;
    }
}
