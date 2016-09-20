package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.WebDriver;

public class Checkbox extends AbstractClickableElement<Checkbox> {

    public Checkbox(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }

    final public void selectCheckboxElement() {
        if (!driver.findElement(locator.getBy()).isSelected()) {
            driver.findElement(locator.getBy()).click();
        }
    }

    final public void undoSelectedCheckbox() {
        if (driver.findElement(locator.getBy()).isSelected()) {
            driver.findElement(locator.getBy()).click();
        }
    }
}
