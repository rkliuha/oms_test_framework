package academy.softserve.edu.utils;

import academy.softserve.edu.enums.Browsers;
import lombok.Getter;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    @Getter
    private WebDriver driver;

    public void setDriver(final String browser, final String version) throws MalformedURLException {

        final DesiredCapabilities capabilities = new DesiredCapabilities();

        final String remote = PropertiesReader.getDefaultProperty("remote");
        final String propertyBrowser = PropertiesReader.getDefaultProperty("browser");
        final String platform = PropertiesReader.getDefaultProperty("platform");

        final Browsers propertyBrowserTypeEnum = Browsers.valueOf(propertyBrowser.toUpperCase());

        final Browsers cmdBrowserTypeEnum = Browsers.valueOf(browser.toUpperCase());

        final boolean isRemote = Boolean.valueOf(remote);

        if (!isRemote) {

            if ("firefox".equals(browser)) {

                switch (propertyBrowserTypeEnum) {

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
            } else {

                switch (cmdBrowserTypeEnum) {

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
            }
        } else {

            capabilities
                    .setPlatform(Platform.valueOf(platform.toUpperCase()));

            capabilities
                    .setBrowserName(String.valueOf(browser));

            capabilities
                    .setVersion(version);

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        }

    }
}
