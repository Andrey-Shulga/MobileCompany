package com.epam.as.mobilecomp.util;

import com.epam.as.mobilecomp.TariffTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Object for input initial properties for new tariffs.
 */
public class PropertyManager {
    public static PropertyManager propertyManager = new PropertyManager();
    private final Properties properties;

    private PropertyManager() {
        properties = new Properties();
        InputStream in = TariffTest.class.getClassLoader().getResourceAsStream("app.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public int getIntProperty(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }
}
