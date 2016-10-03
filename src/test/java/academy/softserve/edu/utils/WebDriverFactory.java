package academy.softserve.edu.utils;

import academy.softserve.edu.enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {

    private WebDriver driver;

    public WebDriver getDriver(final Browsers browser) {

        //TODO re-factor into moving out set property methods
        switch (browser) {

            case CHROME_MAC:
                System.setProperty("webdriver.chrome.driver", "src//resources//drivers//chromedriver_mac");
                driver = new ChromeDriver();
                break;

            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src//resources//drivers//chromedriver_win.exe");
                driver = new ChromeDriver();
                break;

            case EXPLORER:
                System.setProperty("webdriver.ie.driver", "src//resources//drivers//IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;

            case FIREFOX:
            default:
                driver = new FirefoxDriver();
                break;
        }

        return driver;
    }
}
