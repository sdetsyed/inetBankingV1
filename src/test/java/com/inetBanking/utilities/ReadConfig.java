package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro; // 'pro' is an object of Properties class
	
	public ReadConfig() {  // constructor 
		File src= new File ("./Configurations/config.properties");
		
		try {
		FileInputStream fis= new FileInputStream (src);
		pro= new Properties(); // instantiating the 'pro' object
		pro.load(fis); // using 'pro' object, we are loading the config file
		
		}
		
		catch (Exception e) {
			
			System.out.println("Exception is " + e.getMessage());
		}
		
	}
	
	public String getAppUrl() {
		String url= pro.getProperty("Url");
		return url;
	}
	
	public String getUsername() {
		String username= pro.getProperty("uname");
		return username;
	}
	
	public String getPassword() {
		String password= pro.getProperty("password");
		return password;
	}
	
	public String getChromePath() {
		String chromepath= pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFirefoxPath() {
		String firefoxpath= pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getIePath() {
		String iepath= pro.getProperty("iepath");
		return iepath;
	}
	
	public String getEdgePath() {
		String edgepath= pro.getProperty("edgepath");
		return edgepath;
	}

}
