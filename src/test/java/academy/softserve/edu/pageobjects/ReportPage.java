package academy.softserve.edu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReportPage extends PageObject<ReportPage> {

    public static final By REPORT_PAGE_EXISTS = By.id("grid");

    public ReportPage(final WebDriver driver) {
        super(driver);
    }

    public final WebElement getIdentificationOfReportPage() {
        return driver.findElement(REPORT_PAGE_EXISTS);
    }
}
