package academy.softserve.edu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateReportPage extends PageObject<CreateReportPage> {

    public static final By SAVE_REPORT_LINK = By.xpath("//div[@id='list']/a");

    public CreateReportPage(final WebDriver driver) {
        super(driver);
    }

    public final ReportPage clickSaveReportLink() {
        getSaveReportLink().click();
        return new ReportPage(driver);
    }

    public final WebElement getSaveReportLink() {
        return driver.findElement(SAVE_REPORT_LINK);
    }

}
