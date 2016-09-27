package academy.softserve.edu.utils;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesReader {

    private static final String CONFIG_PROPERTIES = "src/resources/config.properties";

    public static String getDefaultProperty(final String propertyName){
        String propertyValue = null;
        try (final FileReader reader = new FileReader(CONFIG_PROPERTIES)) {
            final Properties properties = new Properties();
            properties.load(reader);
            propertyValue = properties.getProperty(propertyName);
        } catch (final Exception e){
            e.printStackTrace();
        }
        return propertyValue;
    }

    public static String getProperty(final String propertyName, final String propertyPath){
        String propertyValue = null;
            try (final FileReader reader = new FileReader(propertyPath)) {
                final Properties properties = new Properties();
                properties.load(reader);
             propertyValue = properties.getProperty(propertyName);
            } catch (final Exception e){
                e.printStackTrace();
            }
        return propertyValue;
    }
}
