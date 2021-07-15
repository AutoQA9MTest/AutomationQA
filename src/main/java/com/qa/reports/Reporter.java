package com.qa.reports;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.accelarator.TestEngine;
import com.qa.utilities.FileUtilities;

public class Reporter {
	public static boolean blnReportTempStatus=true;
	public static boolean blnStatus=true;
	ExtentTest extentTest; 
	/***
	 * Name of Function 	:- setupExtentReport
	  * Class Name :- Reporter 
	 * Function Description :- Create Extent Report
	 * @param Exception
	 */
	
	public static ExtentReports setupExtentReport() throws Exception {
		String strPath=fnGetRunTimeReportPath();
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(strPath);
		sparkReport.config().setDocumentTitle("Automation");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("Test Report");
		ExtentReports extentReport = new ExtentReports();
		extentReport.attachReporter(sparkReport);	
		extentReport.setSystemInfo("OS : ", "Windows");
		extentReport.setSystemInfo("Browser : ", "Chrome");
		extentReport.setSystemInfo("Environment : ", "QA");
		extentReport.setSystemInfo("User Name : ","TestUser");
		return extentReport;
	}
	/***
	 * Name of Function 	:- fnGetRunTimeReportPath()
	  * Class Name :- Reporter 
	 * Function Description :- Create Report Folder and Extent HTML File
	 * @param Exception
	 */
	public static String fnGetRunTimeReportPath()
	{
		String strReportFolderName="Execution_Result_"+FileUtilities.GetCurrentTimeStampAsString();
		String strReportPath=FileUtilities.fnGetCurrentUserDir()+"/Reports";
		String strReportName=FileUtilities.fnGetCurrentUserDir()+"/Reports/"+strReportFolderName+"/Automation_Report.html";
		FileUtilities.createfolder(strReportPath, strReportFolderName);
		return strReportName;
	}
	
	public static void fnCreateTest(String strTestName)
	{
		TestEngine.extentTest=TestEngine.extentReport.createTest(strTestName);
	}
	
	public void fnCloseExtentReport()
	{
		TestEngine.extentReport.flush();
	}
		/***
	 * Name of Function 	:- pass
	  * Class Name :- Reporter 
	 * Function Description :- To Log pass in Extent Report
	 * @param Exception
	 */
	public static void pass(String stepName, String description) 
	{
		try{
			TestEngine.extentTest.pass(stepName + " : " + description);
		}catch(Exception e){}			
	}
	
	/***
	 * Name of Function 	:- info
	 * Class Name :- Reporter 
	 * Function Description :- To Log info in Extent Report
	 * @param Exception
	 */
	public static void info(String stepName, String description) 
	{
		try{
			TestEngine.extentTest.info(stepName + " : " + description);
		}catch(Exception e){}	
	}
	
	/***
	 * Name of Function 	:- skip
	 * Class Name :- Reporter 
	 * Function Description :- To Log skip in Extent Report
	 * @param Exception
	 */
	public static void skip(String stepName, String description) 
	{
		try{
			TestEngine.extentTest.skip(stepName + " : " + description);
		}catch(Exception e){}	
	}
	

	/***
	 * Name of Function 	:- fail
	  * Class Name :- Reporter 
	 * Function Description :- To Log fail in Extent Report
	 * @param Exception
	 */
	public static void fail(String stepName, String description) 
	{
		try{
				String strHTML="<img src=\""+getScreenshotAsBase64()+"\" alt style=\"width:50%\"";
				TestEngine.extentTest.fail(stepName + " : " + description + "\n" +strHTML );
				Reporter.blnStatus=false;
				blnReportTempStatus=false;
		}catch(Exception e){}	
	}
	
	/***
	 * Name of Function 	:- fatal
	 * Class Name :- Reporter 
	 * Function Description :- To Log fatal in Extent Report
	 * @param Exception
	 */
	public static void fatal(String stepName, String description) 
	{
		try{
			TestEngine.extentTest.fatal(stepName + " : " + description);
			Reporter.blnStatus=false;
		}catch(Exception e){}	
	}
	
	/***
	 * Name of Function 	:- error
	  * Class Name :- Reporter 
	 * Function Description :- To Log error in Extent Report
	 * @param Exception
	 */
	public static void error(String stepName, String description) 
	{
		try{
			TestEngine.extentTest.error(stepName + " : " + description);
			Reporter.blnStatus=false;
		}catch(Exception e){}	
	}
	
	/***
	 * Name of Function 	:- warning
	  * Class Name :- Reporter 
	 * Function Description :- To Log warning in Extent Report
	 * @param Exception
	 */
	public static void warning(String stepName, String description) 
	{
		try{
			TestEngine.extentTest.warning(stepName + " : " + description);
		}catch(Exception e){}	
	}
	
	/***
	 * Name of Function 	:- getScreenshot
	 * Class Name :- Reporter 
	 * Function Description :- To get Screenshot in Extent Report
	 * @param Exception
	 */
	public static String getScreenshotAsBase64() throws IOException
	{
		String strScreenshotName=null;
		try
		{
			TakesScreenshot ts = (TakesScreenshot) TestEngine.driver;
			strScreenshotName = ts.getScreenshotAs(OutputType.BASE64);
		}
		catch(Exception e){}
		return "data:image/jpg;base64, " + strScreenshotName ;
	}	
}
