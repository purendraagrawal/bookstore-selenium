package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static ConfigReader configReader = null;
	private Properties properties = null;

	private ConfigReader() throws IOException {
		properties = new Properties();
		properties.load(new FileInputStream(new File("src/test/resources/config.properties")));
	}

	public static ConfigReader getInstance() throws IOException {
		if (configReader == null)
			configReader = new ConfigReader();
		return configReader;
	}

	public String getValueOfKey(String key) {
		return properties.getProperty(key);
	}
}
