package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends AbstractClickableElement<Dropdown> {

    public Dropdown(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }

    private Select select;

    final public Dropdown selectByIndex(final int indexOfElement) {

        select = new Select(driver.findElement(locator.getBy()));
        select.selectByIndex(indexOfElement);
        return this;
    }

    final public Dropdown selectByValue(final String valueOfElement) {

        select = new Select(driver.findElement(locator.getBy()));
        select.selectByValue(valueOfElement);
        return this;
    }

    final public Dropdown deselectByIndex(final int indexOfElement) {

        select = new Select(driver.findElement(locator.getBy()));
        select.deselectByIndex(indexOfElement);
        return this;
    }

    final public Dropdown deselectByValue(final String valueOfElement) {

        select = new Select(driver.findElement(locator.getBy()));
        select.deselectByValue(valueOfElement);
        return this;
    }
}
