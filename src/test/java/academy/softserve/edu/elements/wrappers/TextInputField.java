package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.utils.Logger;
import org.openqa.selenium.WebDriver;

public class TextInputField extends AbstractClickableElement<TextInputField> {

    public TextInputField(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }

    final public void clear() {

        wait.waitUntilElementIsPresent();
        wait.waitUntilElementIsClickable().clear();
        Logger.logInfo("<font color='black'>Cleared Element "
                + "<b>" + locator.getName() + "</b></font>");
    }

    final public void sendKeys(final String inputText) {

        wait.waitUntilElementIsPresent();
        wait.waitUntilElementIsClickable();
        this.clear();
        wait.waitUntilElementIsClickable().sendKeys(inputText);
        Logger.logInfo("<font color='black'>Made input: " + inputText + " into " + "<b>"
                + locator.getName() + "</b></font>");
    }
}
