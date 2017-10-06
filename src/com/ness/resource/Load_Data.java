package com.ness.resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Load_Data {
	public Properties readProp(String propertyFile) {
		Properties loadProp = new Properties();
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFile);
		try {
			if (inputStream != null) {
				loadProp.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propertyFile + "' not found in the classpath");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return loadProp;
	}
}
