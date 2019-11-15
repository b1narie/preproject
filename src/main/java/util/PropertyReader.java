package util;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    public static Properties readProperties(String filename) {
        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(filename + ".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
