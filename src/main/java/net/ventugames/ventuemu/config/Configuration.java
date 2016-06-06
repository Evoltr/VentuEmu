package net.ventugames.ventuemu.config;

import net.ventugames.ventuemu.VentuEmu;

import java.io.*;
import java.nio.file.Files;
import java.util.Properties;

/**
 * Created by yarno on 6/6/2016.
 */
public class Configuration {
    private File file;
    private Properties properties;

    public Configuration(File file) {
        this.file = file;
    }

    public void load() throws IOException {

        //If the file does not exist then create it.
        if (!file.exists()) {
            Files.copy(VentuEmu.class.getResourceAsStream("/config.properties"), file.toPath());
        }

        //Convert the file into an input stream.
        InputStream inputStream = new FileInputStream(file);

        //Load the properties file from the input stream.
        properties = new Properties();
        properties.load(inputStream);

    }

    public void save() throws IOException {

        //Convert the file into an output stream.
        FileOutputStream outputStream = new FileOutputStream(file);

        //Store the properties in this file.
        properties.store(outputStream, null);

    }

    public boolean getBoolean(String key) {
        return Boolean.valueOf(getSetting(key));
    }

    public String getSetting(String key) {
        return properties.getProperty(key);
    }

    public void setSetting(String key, String value) {
        properties.setProperty(key, value);

        try {
            save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}