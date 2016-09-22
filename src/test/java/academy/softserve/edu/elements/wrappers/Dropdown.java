package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Dropdown extends AbstractClickableElement<Dropdown> {

    public Dropdown(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }

    private Select select;

    final public Dropdown selectByIndex(final int indexOfElement) {

        waitUntilElementIsPresent();
        select = new Select(driver.findElement(locator.getBy()));
        select.selectByIndex(indexOfElement);
        return this;
    }

    final public Dropdown selectByValue(final String valueOfElement) {

        waitUntilElementIsPresent();
        select = new Select(driver.findElement(locator.getBy()));
        select.selectByValue(valueOfElement);
        return this;
    }

    final public Dropdown deselectByIndex(final int indexOfElement) {

        waitUntilElementIsPresent();
        select = new Select(driver.findElement(locator.getBy()));
        select.deselectByIndex(indexOfElement);
        return this;
    }

    final public Dropdown deselectByValue(final String valueOfElement) {

        waitUntilElementIsPresent();
        select = new Select(driver.findElement(locator.getBy()));
        select.deselectByValue(valueOfElement);
        return this;
    }

    private void waitUntilElementIsPresent() {

        new WebDriverWait(driver, 20)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(locator.getBy()));
    }
}
