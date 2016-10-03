package academy.softserve.edu.pageobjects;


import academy.softserve.edu.elements.wrappers.Button;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

import static academy.softserve.edu.elements.locators.shared.SharedLocators.LOG_OUT_BUTTON;

@Getter
public abstract class PageObject<T> {

    protected WebDriver driver;

    private Button logOutButton;

    public PageObject(final WebDriver driver) {

        this.driver = driver;
        logOutButton = new Button(driver, LOG_OUT_BUTTON);
    }

    public final WebElement getElement(final By elementLocation) {
        return driver.findElement(elementLocation);
    }

    public final List<String> gridsColumnValues = new LinkedList<>();

    public final List<WebElement> getElements(final By elementLocation) {
        return driver.findElements(elementLocation);
    }

    public final void clickLogOutButton() {
        driver.findElement(LOG_OUT_BUTTON.getBy()).click();
    }

    public final LogInPage doLogOut() {

        clickLogOutButton();
        acceptAlert();
        return new LogInPage(driver);

    }

    public final void acceptAlert() {
        driver
                .switchTo()
                .alert()
                .accept();
    }

    public final void dismissAlert() {
        driver
                .switchTo()
                .alert()
                .dismiss();
    }

    public final String getCurrentUrl() {
        return driver
                .getCurrentUrl();
    }

    public final String getPageSource() {
        return driver
                .getPageSource();
    }

    public final void navigateBack() {
        driver
                .navigate().back();
    }

    //TODO rename
    public final void navigateForvard() {
        driver
                .navigate().forward();
    }

    public final T refreshPage() {
        driver.navigate().refresh();
        return (T) this;
    }

    public void click(final By path) {

        driver
                .findElement(path)
                .click();
    }

    //Pull String to List from any Grid column cells.
    public final List<String> pullStringsValueFromGetElements(final By GridColumn) {
        for (int i = 0; i < getElements(GridColumn).size(); i++) {
            gridsColumnValues.add(i, getElements(GridColumn).get(i).getText());
        }
        return gridsColumnValues;
    }
}
