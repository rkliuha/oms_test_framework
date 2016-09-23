package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdown extends AbstractClickableElement<Dropdown> {

    private Select select;
    private int timeout = 20;

    public Dropdown(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
        select = new Select(driver.findElement(locator.getBy()));
    }

    final public Dropdown selectByIndex(final int indexOfElement) {

        waitUntilElementIsPresent();
        waitUntilElementIsClickable();
        select.selectByIndex(indexOfElement);
        return this;
    }

    final public Dropdown selectByValue(final String valueOfElement) {

        waitUntilElementIsPresent();
        waitUntilElementIsClickable();
        select.selectByValue(valueOfElement);
        return this;
    }

    final public Dropdown deselectByIndex(final int indexOfElement) {

        waitUntilElementIsPresent();
        waitUntilElementIsClickable();
        select.deselectByIndex(indexOfElement);
        return this;
    }

    final public Dropdown deselectByValue(final String valueOfElement) {

        waitUntilElementIsPresent();
        waitUntilElementIsClickable();
        select.deselectByValue(valueOfElement);
        return this;
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
