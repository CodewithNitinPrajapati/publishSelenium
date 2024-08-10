package com.selenium.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {
	 public static Properties prop;
	
	public ReadConfigFile() {
		String filepath = "./Configuration/config.properties";
		File src = new File(filepath);
		//System.out.println(filepath);
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);		
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
//	public  String getUrl() {
//		String url = prop.getProperty("url");
//		System.out.println(prop.getProperty("url"));
//		return url;
//	}
//	
//	public  String getUserName() {
//		String username = prop.getProperty("username");
//		System.out.println(username);
//		return username;
//	}
//	
//	public  String getPassword() {
//		String pass = prop.getProperty("password");
//		System.out.println(pass);
//		return pass;
//	}
//	public String getItem() {
//		String productName = prop.getProperty("product");
//		return productName;
//	}
//	
//	public String getBrowserName() {
//		String browserName  = prop.getProperty("browser");
//		return browserName;
//	}

	
}
