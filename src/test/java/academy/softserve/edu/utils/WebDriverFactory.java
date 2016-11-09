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

    final void setDriver(final String browser, final String version) throws MalformedURLException {

        final DesiredCapabilities capabilities = new DesiredCapabilities();

        final String remote = PropertiesReader.getProperty("remote");
        final String propertyBrowser = PropertiesReader.getProperty("browser");
        final String platform = PropertiesReader.getProperty("platform");

        final String webDriverChrome = PropertiesReader.getProperty("webDriver.chrome");
        final String webDriverIe = PropertiesReader.getProperty("webDriver.ie");

        final String pathWebDriverChromeMac = PropertiesReader.getProperty("path.webDriver.chrome.mac");
        final String pathWebDriverChromeWin = PropertiesReader.getProperty("path.webDriver.chrome.win");
        final String pathWebDriverIe = PropertiesReader.getProperty("path.webDriver.ie");

        final String remoteWebDriverUrl = PropertiesReader.getProperty("remote.webDriver.url");

        final Browsers propertyBrowserTypeEnum = Browsers.valueOf(propertyBrowser.toUpperCase());

        final Browsers cmdBrowserTypeEnum = Browsers.valueOf(browser.toUpperCase());

        final boolean isRemote = Boolean.valueOf(remote);

        if (!isRemote) {

            if ("default".equals(browser)) {

                switch (propertyBrowserTypeEnum) { //Switching browser if using property

                    case CHROME_MAC:
                        System.setProperty(webDriverChrome, pathWebDriverChromeMac);
                        driver = new ChromeDriver();
                        break;

                    case CHROME:
                        System.setProperty(webDriverChrome, pathWebDriverChromeWin);
                        driver = new ChromeDriver();
                        break;

                    case EXPLORER:
                        System.setProperty(webDriverIe, pathWebDriverIe);
                        driver = new InternetExplorerDriver();
                        break;

                    case FIREFOX:
                    default:
                        driver = new FirefoxDriver();
                        break;
                }
            } else {

                switch (cmdBrowserTypeEnum) { //Switching browser if using command line
                    case CHROME_MAC:
                        System.setProperty(webDriverChrome, pathWebDriverChromeMac);
                        driver = new ChromeDriver();
                        break;

                    case CHROME:
                        System.setProperty(webDriverChrome, pathWebDriverChromeWin);
                        driver = new ChromeDriver();
                        break;

                    case EXPLORER:
                        System.setProperty(webDriverIe, pathWebDriverIe);
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

            driver = new RemoteWebDriver(new URL(remoteWebDriverUrl), capabilities);
        }

    }
}
