package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.loginPage;



public class TC_loginTest_001 extends BaseClass
{

	@Test 
	public void loginTest() throws IOException 
	{
	
		
		logger.info("url has opened");
		
		
		loginPage lp= new loginPage(driver);
		lp.setUsername(uname);
		logger.info("username has entered");
		lp.setPassword(password);
		logger.info("password has entered");
		lp.clickLogin();
		logger.info("login button has clicked");
		System.out.println(driver.getTitle());
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("login test passed");
		}
		
		else 
		{
			screenshot(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("login test failed");
			
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
