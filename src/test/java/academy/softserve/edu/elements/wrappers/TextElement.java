package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.WebDriver;

public class TextElement extends AbstractElement<TextElement> {

    public TextElement(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }

}
