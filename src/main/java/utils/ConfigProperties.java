package utils;

import tests.BaseTest;
import java.io.*;
import java.util.Properties;

public class ConfigProperties {
    public Properties config = new Properties();
    private final String propertyFilePath = BaseTest.resourcesRoot+"config.properties";// Set Path of config.properties
    File file;

    public ConfigProperties() throws IOException {

        file = new File(propertyFilePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        config.load(fileInputStream);
    }
/*
    public void writeConfigInFile(String key, String data) throws IOException {
        config.setProperty(key,data);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        config.store(fileOutputStream,"properties changed");
        fileOutputStream.close();
    }*/
}
