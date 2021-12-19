package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static ConfigReader configReader = null;
	private Properties properties = null;

	private ConfigReader() {
		properties = new Properties();
		try {
			properties.load(new FileInputStream(new File("src/test/resources/config.properties")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ConfigReader getInstance() {
		if (configReader == null)
			configReader = new ConfigReader();
		return configReader;
	}

	public String getValueOfKey(String key) {
		return properties.getProperty(key);
	}
}
