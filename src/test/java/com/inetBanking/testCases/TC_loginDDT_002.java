package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.loginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_loginDDT_002 extends BaseClass
{

	@DataProvider (name="loginData")
	String[][] getData() throws IOException
	{
	
		String path= System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		int rownum= XLUtils.getRowCount(path,"Sheet1");
		int colnum= XLUtils.getCellCount(path, "Sheet1", 1);
		
		String data [][]= new String [rownum][colnum];
		
		for(int r=1; r<=rownum; r++)
		{
			for (int c=0;c<colnum;c++) 
			{
				data[r-1][c]=XLUtils.getCellData(path,"Sheet1", r, c);
			}
		}
		
		return data;
		
	}
	
	
	@Test (dataProvider="loginData")
	public void loginDDT(String uname, String password) throws InterruptedException
	{
		loginPage lp= new loginPage(driver);
		lp.setUsername(uname);
		logger.info("user name is provided");
		lp.setPassword(password);
		logger.info("password name is provided");
		lp.clickLogin();
		logger.info("login button clicked");
		
		Thread.sleep(3000);
		
		if (isAlertPresent()==true) {
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
			}
		
		else {
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
	}
	
	public boolean isAlertPresent() {  // user defined class to check if the alert present or not
		
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
		
	}
	
	
	
	
	
	
	
	
}
