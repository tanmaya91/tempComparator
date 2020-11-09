package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CoreUtils {
	
	public static Properties prop;
	
	 public static Properties loadPropertiesFromDataFile() throws IOException {
		 prop= new Properties();
		 FileInputStream fis = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\data.properties");
		} catch (FileNotFoundException e) {
			//
			e.printStackTrace();
		}

		prop.load(fis);
		return prop;
		
	 }

}
