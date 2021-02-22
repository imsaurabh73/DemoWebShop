package com.demoshop.verify;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(com.demoshop.utility.Itest.class)
public class BaseClass 
{

	public WebDriver driver; 
	
	static Logger log=Logger.getLogger(BaseClass.class);
	
	
	Properties pro=new Properties();
	
	
	@BeforeSuite
	public void browsersetup() throws IOException
	{
		BasicConfigurator.configure();
		PropertyConfigurator.configure("log4j.properties"); 
	
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Zenith\\eclipse-workspace\\DemoWebshop\\parameter.properties");
		pro.load(fis);
		
	if(pro.getProperty("browser").equalsIgnoreCase("chrome"))
	{
			System.setProperty("webdriver.chrome.driver","E:\\testing classes\\external jar files\\Chrome\\chromedriver.exe");
		    driver=new ChromeDriver();
	}
	else
	{
		
	}
		
		driver.manage().window().maximize();
		log.info("Successfully Browser open");
	}
	
	@BeforeTest
	public void openurl()
	{
		//implicitlyWait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(pro.getProperty("url"));
		
		log.info("Url passed");
		
	}
	
	public void capturescreen(String ssname) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(src, new File("C:\\Users\\Zenith\\eclipse-workspace\\DemoWebshop\\Screenshots\\"+ssname+".png"));
	}
	
	
	
}
