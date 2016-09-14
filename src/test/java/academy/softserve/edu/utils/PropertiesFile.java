package academy.softserve.edu.utils;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesFile {
    public static String getProperty(String propertyName){
        String propertyValue = null;
            try (FileReader reader = new FileReader("src/resources/config.properties")) {
                Properties properties = new Properties();
                properties.load(reader);
             propertyValue = properties.getProperty(propertyName);
            } catch (Exception e){
                e.printStackTrace();
            }
        return propertyValue;
    }
}
