package academy.softserve.edu.utils;

import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    private WebDriver driver;
    private ILocator locator;
    final private int timeout = 20;

    public Wait(final WebDriver driver, final ILocator locator) {

        this.driver = driver;
        this.locator = locator;
    }

    //TODO re-do into returning web element
    public final void waitUntilElementIsPresent() {

        new WebDriverWait(driver, timeout)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(locator.getBy()));
    }

    //TODO re-do into returning web element
    public final void waitUntilElementIsClickable() {

        new WebDriverWait(driver, timeout)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(locator.getBy()));
    }
}
