package academy.softserve.edu.utils;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesReader {
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
