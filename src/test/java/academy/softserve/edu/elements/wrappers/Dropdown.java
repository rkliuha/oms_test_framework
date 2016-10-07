package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.utils.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//TODO remove redundant findElement() call - https://ssu-jira.softserveinc.com/browse/IFATQCZZ-90
public class Dropdown extends AbstractClickableElement<Dropdown> {

    public Dropdown(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }

    final public Dropdown selectByIndex(final int indexOfElement) {

        wait.waitUntilElementIsPresent();
        wait.waitUntilElementIsClickable();
        new Select(driver.findElement(locator.getBy())).selectByIndex(indexOfElement);
        return this;
    }

    final public Dropdown selectByValue(final String valueOfElement) {

        wait.waitUntilElementIsPresent();
        wait.waitUntilElementIsClickable();
        new Select(driver.findElement(locator.getBy())).selectByValue(valueOfElement);
        return this;
    }

    final public Dropdown deselectByIndex(final int indexOfElement) {

        wait.waitUntilElementIsPresent();
        wait.waitUntilElementIsClickable();
        new Select(driver.findElement(locator.getBy())).deselectByIndex(indexOfElement);
        return this;
    }

    final public Dropdown deselectByValue(final String valueOfElement) {

        wait.waitUntilElementIsPresent();
        wait.waitUntilElementIsClickable();
        new Select(driver.findElement(locator.getBy())).deselectByValue(valueOfElement);
        return this;
    }

    final public void sendKeys(final String inputText) {

        wait.waitUntilElementIsPresent();
        wait.waitUntilElementIsClickable();
        driver.findElement(locator.getBy()).sendKeys(inputText);
        Logger.logInfo("<font color='black'>Selected by value: " + inputText + " into " + "<b>"
                + locator.getName() + "</b></font>");
    }

    final public WebElement getFirstSelectedOption() {

        wait.waitUntilElementIsPresent();
        wait.waitUntilElementIsClickable();
        return new Select(driver.findElement(locator.getBy())).getFirstSelectedOption();
    }

}
