package academy.softserve.edu.utils;

import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//TODO re-do waits - https://ssu-jira.softserveinc.com/browse/IFATQCZZ-90
public class Wait {

    private WebDriver driver;
    private ILocator locator;
    final private int timeout = 20;

    public Wait(final WebDriver driver, final ILocator locator) {

        this.driver = driver;
        this.locator = locator;
    }

    public final void waitUntilElementIsPresent() {

        new WebDriverWait(driver, timeout)
                //TODO replace StaleElementReferenceException with NoSuchElement
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(locator.getBy()));
    }

    public final void waitUntilElementIsClickable() {

        new WebDriverWait(driver, timeout)
                //TODO replace StaleElementReferenceException with NoSuchElement
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(locator.getBy()));
    }
}
