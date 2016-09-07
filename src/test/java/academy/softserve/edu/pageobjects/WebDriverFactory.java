package academy.softserve.edu.pageobjects;

import academy.softserve.edu.enums.Drivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

    private WebDriver driver;

    public WebDriver getDriver(final Drivers browser) {

        switch (browser) {

            case FIREFOX:
                driver = new FirefoxDriver();
                break;

            case CHROME:
                driver = new ChromeDriver();
                break;

            case SAFARI:
                driver = new SafariDriver();
                break;

            default:
                driver = new FirefoxDriver();
                break;
        }

        return driver;
    }
}
