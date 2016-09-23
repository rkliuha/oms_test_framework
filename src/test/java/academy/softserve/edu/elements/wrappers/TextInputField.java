package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.utils.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class TextInputField extends AbstractClickableElement<TextInputField> {

    private int timeout = 20;

    public TextInputField(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }

    final public void clear() {

        waitUntilElementIsPresent();
        driver.findElement(locator.getBy()).clear();
        Logger.logInfo("<b><font size='1' color='black'>Cleared element "
                + locator.getName() + "</font></b>");
    }

    final public void sendKeys(final String inputText) {

        waitUntilElementIsPresent();
        driver.findElement(locator.getBy()).sendKeys(inputText);
        Logger.logInfo("<b><font size='1' color='black'>Made input: " + inputText + " into "
                + locator.getName() + "</font></b>");
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
