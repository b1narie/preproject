package util;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static Properties properties = new Properties();

    public static Properties readProperties() {
        if (properties.isEmpty()) {
            try {
                properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("all.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    public static String readProperty(String property) {
        return properties.getProperty(property);
    }
}
