package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	WebDriver ldriver; // creating webdriver object, 'ldriver' means 'local driver'
	
	//constructor
	
	public loginPage(WebDriver rdriver) // parameter 'rdriver' means 'remote driver'
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	// locators

	@FindBy (name="uid")  // @FindBy is the annotation for object location of webelement
	@CacheLookup
	WebElement username;
	
	@FindBy (name="password")
	@CacheLookup
	WebElement pass;
	
	@FindBy (name="btnLogin")
	@CacheLookup
	WebElement loginb;
	
	@FindBy (xpath="//a[contains(text(),'Log out')]")
	@CacheLookup
	WebElement logoutb;
	//action methods
	
	public void setUsername (String uname)
	{
		username.sendKeys(uname);
	}
	
	public void setPassword (String password)
	{
		pass.sendKeys(password);
	}
	
	public void clickLogin ()
	{
		loginb.click();
	}
	
	public void clickLogout ()
	{
		logoutb.click();
	}
	
	
	
}