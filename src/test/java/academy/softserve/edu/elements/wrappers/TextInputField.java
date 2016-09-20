package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.WebDriver;

public class TextInputField extends AbstractClickableElement<TextInputField> {

    public TextInputField(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }

    final public void clearInputField() {
        driver.findElement(locator.getBy()).clear();
    }

    final public void inputText(final String inputText) {
        driver.findElement(locator.getBy()).sendKeys(inputText);
    }
}
