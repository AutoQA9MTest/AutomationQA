package com.qa.accelarator;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.reports.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestEngine extends Reporter{
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	public static WebDriver driver;
	
	@BeforeSuite
	public void fnCrreateTestSuite() throws Exception
	{
		extentReport=setupExtentReport();
	}
	
	@AfterSuite
	public void fnEndTestSuitte()
	{
		fnCloseExtentReport();
	}
	
	@BeforeMethod
	@Parameters({"Browser"})
	public static void fnIntilizeDriver(String Browser,Method method)
	{
		String strTestName=method.getName();
		fnCreateTest(strTestName);
		String strBrowserName=Browser;
		driver=fnGetDriver(strBrowserName);
	}
	
	public static WebDriver fnGetDriver(String strBrowserNamer)
	{
		WebDriver driver=null;
		if(strBrowserNamer.toLowerCase().startsWith("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(strBrowserNamer.toLowerCase().startsWith("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	@AfterMethod
	public static void fnCloseDriver() throws InterruptedException
	{
		Thread.sleep(10000);
		if(driver!=null)
		{
			driver.quit();
		}
	}
}
