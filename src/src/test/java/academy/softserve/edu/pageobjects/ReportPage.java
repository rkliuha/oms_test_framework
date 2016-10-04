package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.locators.administrator.ReportPageLocators;
import academy.softserve.edu.elements.wrappers.TextLabel;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
public class ReportPage extends PageObject<ReportPage> {

    private final TextLabel reportPageExists =
            new TextLabel(driver, ReportPageLocators.REPORT_PAGE_EXISTS);

    public ReportPage(final WebDriver driver) {
        super(driver);
    }

}
