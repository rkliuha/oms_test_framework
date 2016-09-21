package academy.softserve.edu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReportPage extends PageObject<ReportPage> {

    public static final By IDENTIFICATION_OF_REPORT_PAGE = By.id("grid");

    public ReportPage(final WebDriver driver) {
        super(driver);
    }

    public final WebElement getIdentificationOfReportPage() {
        return driver.findElement(IDENTIFICATION_OF_REPORT_PAGE);
    }

}
