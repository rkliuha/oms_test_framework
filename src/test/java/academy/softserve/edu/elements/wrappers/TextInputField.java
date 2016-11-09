package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.utils.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextInputField extends AbstractClickableElement<TextInputField> {

    public TextInputField(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }


    public final WebElement clear() {
        final WebElement element = wait.getClickableElement();
        element.clear();
        Logger.logInfo("<font color='black'>Cleared Element "
                + "<b>" + locator.getName() + "</b></font>");
        return element;
    }

    public final void sendKeys(final String inputText) {
        clear().sendKeys(inputText);
        Logger.logInfo("<font color='black'>Made input: " + inputText + " into " + "<b>"
                + locator.getName() + "</b></font>");
    }
}
