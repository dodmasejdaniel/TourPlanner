package service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigurationManager {
    public static String GetConfigProperty(String propertyName) throws FileNotFoundException {
        Logger log = LogManager.getLogger(ConfigurationManager.class);
        Path p = Paths.get("");
        log.debug(p.toAbsolutePath().toString());
        Properties prop = new Properties();
        String propFileName = "config.properties";
        InputStream stream = new FileInputStream(propFileName);
        try {
            prop.load(stream);
            return prop.getProperty(propertyName);
        } catch (Exception e) {
            log.error(propertyName + " was not found. " + e.getMessage());
            e.printStackTrace();
        }
        throw new FileNotFoundException(propFileName + " was not found.");
    }
}
