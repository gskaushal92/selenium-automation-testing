package com.ness.resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RegisterPage {

	public Properties readProp() {
		String propFileName = "register.properties";
		Properties registerProp = new Properties();
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		try {
			if (inputStream != null) {
				registerProp.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
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
		return registerProp;
	}
}
