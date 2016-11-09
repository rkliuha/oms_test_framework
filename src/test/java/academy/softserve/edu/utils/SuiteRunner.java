package academy.softserve.edu.utils;

import academy.softserve.edu.enums.Browsers;
import academy.softserve.edu.enums.Suites;
import org.apache.commons.io.FileUtils;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.uncommons.reportng.HTMLReporter;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public final class SuiteRunner {

    private SuiteRunner() {

    }

    public static void main(final String[] args) throws IOException, SAXException, ParserConfigurationException {

        Suites testSuite = Suites.PARENTSUITE;

        if (args.length > 0) {

            try {
                testSuite = Suites.valueOf(args[0].toUpperCase());
            } catch (IllegalArgumentException e) {
                System.err.println("\nInvalid suite name. Available: \n" +
                        Arrays.toString(Suites.values()).toLowerCase() +
                        "\nAs default: " + testSuite.toString().toLowerCase());

                System.exit(0);
            }

            try {
                final Browsers browser = Browsers.valueOf(args[1].toUpperCase());
                prepareDriver(browser);
            } catch (ArrayIndexOutOfBoundsException ignored) {
            } catch (IllegalArgumentException e) {
                System.err.println("\nInvalid browser name. Available: \n" +
                        Arrays.toString(Browsers.values()).toLowerCase() +
                        "\nAs default: " + PropertiesReader.getProperty("browser"));

                System.exit(0);
            }
        }

        final List<Class> listeners = Arrays.asList(TestListener.class, HTMLReporter.class);

        System.setProperty("org.uncommons.reportng.escape-output", "false");
        System.setProperty("org.uncommons.reportng.title", "OMS Test Results");

        final TestNG testNG = new TestNG();

        testNG.setXmlSuites(new Parser(getSuiteAsStream(testSuite))
                .parseToList());
        testNG.setUseDefaultListeners(false);
        testNG.setListenerClasses(listeners);
        testNG.run();

        FileUtils.deleteDirectory(new File("src/"));
    }

    private static InputStream getSuiteAsStream(final Suites testSuite) {

        return SuiteRunner.class
                .getClassLoader()
                .getResourceAsStream("suites/" + testSuite.toString().toLowerCase() + ".xml");
    }

    private static void prepareDriver(final Browsers browser) {

        final String driverPath;

        switch (browser) {

            case CHROME:
                driverPath = "chromedriver_win.exe";
                break;
            case CHROME_MAC:
                driverPath = "chromedriver_mac";
                break;
            case EXPLORER:
                driverPath = "IEDriverServer.exe";
                break;
            default:
                return;
        }

        System.setProperty("browser", browser.toString().toLowerCase());

        try (final InputStream resource = SuiteRunner.class
                .getClassLoader()
                .getResourceAsStream("drivers/" + driverPath)) {

            FileUtils.copyInputStreamToFile(resource, new File("src/resources/drivers/" + driverPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
