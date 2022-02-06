package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig= new ReadConfig ();
	
	//declare the variables
	public String Url= readconfig.getAppUrl();
	public String uname= readconfig.getUsername();
	public String password= readconfig.getPassword(); 
	public static WebDriver driver; 
	
	//
	public static Logger logger;
	
	// common methods 
	
	@Parameters ("browser")
	@BeforeClass 
	public void setUp(String br) 
	{
	
		
		logger= Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if (br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath()  );
			driver= new ChromeDriver();
			//WebDriverManager.chromedriver().setup();
		}
		
		else if (br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath()  );
			driver= new FirefoxDriver();
		}
		
		else if (br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", readconfig.getEdgePath()  );
			driver= new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Url);
		
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void screenshot(WebDriver driver, String tname) throws IOException {
	TakesScreenshot ts= ((TakesScreenshot)driver);
	File src= ts.getScreenshotAs(OutputType.FILE);
	File trg= new File (".//Screenshots/" +tname +".jpg");
	FileUtils.copyFile(src, trg);
	System.out.println("screenshot taken");
	
	}
	
	
}
	


