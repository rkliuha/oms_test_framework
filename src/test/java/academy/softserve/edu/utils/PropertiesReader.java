package academy.softserve.edu.utils;

import java.io.InputStream;
import java.util.Properties;

public final class PropertiesReader {

    private PropertiesReader() {

    }

    private static final String CONFIG_PROPERTIES = "config.properties";

    public static String getDefaultProperty(final String propertyName) {

        String propertyValue = null;

        try (final InputStream reader = PropertiesReader.class
                .getClassLoader().getResourceAsStream(CONFIG_PROPERTIES)) {

            final Properties properties = new Properties();
            properties.load(reader);
            propertyValue = properties.getProperty(propertyName);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return propertyValue;
    }

}
