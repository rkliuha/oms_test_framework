package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.WebDriver;

public class Checkbox extends AbstractClickableElement<Checkbox> {

    public Checkbox(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }

    final public void select() {

        wait.waitUntilElementIsPresent();
        if (!wait.waitUntilElementIsClickable().isSelected()) {
            this.click();
        }
    }

}
