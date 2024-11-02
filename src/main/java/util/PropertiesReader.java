package util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

public class PropertiesReader {
    private static final String PROPERTIES_NAME = "test.properties";

    public static String getProperty(String propertyValue){
        return getPropertyValue(PROPERTIES_NAME, propertyValue);
    }

    public static String getPropertyValue(String fileName, String value){
        String propertyValue = null;

        try (InputStream inputStream = PropertiesReader.class.getClassLoader().getResourceAsStream(fileName)){
            Properties properties = new Properties();
            properties.load(inputStream);
            propertyValue = properties.getProperty(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return propertyValue;
    }
}
