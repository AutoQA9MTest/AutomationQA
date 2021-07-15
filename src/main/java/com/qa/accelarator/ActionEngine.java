package com.qa.accelarator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.reports.Reporter;
public class ActionEngine  extends TestEngine{

	/***
	 * Name of Function :- fnGetURL
	 * Class Name :- ActionEngine 
	 */
	public boolean fnGetURL(String strURL,String strDescription) {
		boolean blnStatus=true;
		try
		{
			driver.get(strURL);
			Reporter.pass("Open URL " + strDescription,"Successfully Launch URL " + strURL );
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Open URL " + strDescription,"Unable to Launch URL " + strURL );
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnMaximizeBrowser
	 * Class Name :- ActionEngine 
	 */
	public void fnMaximizeBrowser() {
		driver.manage().window().maximize();
	}
	
	/***
	 * Name of Function :- fnImplicitWait
	 * Class Name :- ActionEngine 
	 */
	public void fnImplicitWait() {
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	
	/***
	 * Name of Function :- fnFullScreenBrowser
	 * Class Name :- ActionEngine 
	 */
	public void fnFullScreenBrowser() {
		driver.manage().window().fullscreen();
	}
	
	/***
	 * Name of Function :- fnDeleteAllCookies
	 * Class Name :- ActionEngine 
	 */
	public void fnDeleteAllCookies() {
		driver.manage().deleteAllCookies();
	}
	
	/***
	 * Name of Function :- fnCloseTestDriver
	 * Class Name :- ActionEngine 
	 */
	public void fnCloseTestDriver() {
		driver.close();
	}
	
	/***
	 * Name of Function :- fnQuitDriver
	 * Class Name :- ActionEngine 
	 */
	public void fnQuitDriver() {
		driver.quit();
	}
	
	
	/***
	 * Name of Function :- fnGetTitle
	 * Class Name :- ActionEngine 
	 */
	public String fnGetTitle(String strDescription) {
		String strTitle="";
		try
		{
			strTitle=driver.getTitle();
			Reporter.pass("Get Title " + strDescription,"Successfully Get Title " + strTitle );
		}
		catch(Exception e)
		{
			Reporter.fail("Get Title " + strDescription,"Unable to Get Title");
		}
		return strTitle;
	}
	
	/***
	 * Name of Function :- fnGetPageSource
	 * Class Name :- ActionEngine 
	 */
	public String fnGetPageSource(String strDescription) {
		String strPageSource="";
		try
		{
			strPageSource=driver.getPageSource();
		}
		catch(Exception e)
		{
			Reporter.fail("Get Page Source " + strDescription,"Unable to Get Page Source");
		}
		return strPageSource;
	}
	
	/***
	 * Name of Function :- fnGetCurrentURL
	 * Class Name :- ActionEngine
	 */
	public String fnGetCurrentURL(String strDescription) {
		String strCurrentURL="";
		try
		{
			strCurrentURL=driver.getCurrentUrl();
			Reporter.pass("Get Current URL " + strDescription,"Successfully Get Current URL : " + strCurrentURL );
		}
		catch(Exception e)
		{
			Reporter.fail("Get Current URL " + strDescription,"Unable to Get Current URL");
		}
		return strCurrentURL;
	}
	
	/***
	 * Name of Function :- fnNavigateTo
	 * Class Name :- ActionEngine 
	 */
	public boolean fnNavigateTo(String strURL,String strDescription) {
		boolean blnStatus=true;
		try
		{
			driver.get(strURL);
			Reporter.pass("Navigate To URL " + strDescription,"Successfully Navigate to URL " + strURL );
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Navigate To URL " + strDescription,"Unable to Navigate URL " + strURL );
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnNavigateBack
	 * Class Name :- ActionEngine 
	 */
	public boolean fnNavigateBack(String strDescription) {
		boolean blnStatus=true;
		try
		{
			driver.navigate().back();
			Reporter.pass("Navigate Back " + strDescription,"Successfully Navigate Back");
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Navigate Back " + strDescription,"Unable to Navigate Back");
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnNavigateForward
	 * Class Name :- ActionEngine 
	 */
	public boolean fnNavigateForward(String strDescription) {
		boolean blnStatus=true;
		try
		{
			driver.navigate().forward();
			Reporter.pass("Navigate Forward " + strDescription,"Successfully Navigate Forward");
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Navigate Forward " + strDescription,"Unable to Navigate Forward");
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnRefresh
	 * Class Name :- ActionEngine 
	 */
	public boolean fnRefresh(String strDescription) {
		boolean blnStatus=true;
		try
		{
			driver.navigate().refresh();
			Reporter.pass("Refresh Browser " + strDescription,"Successfully Refresh Browser");
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Refresh Browser " + strDescription,"Unable to Refresh Browser");
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnIsElementPresent
	 * Class Name :- ActionEngine 
	 */
	public boolean fnIsElementPresent(WebElement elem) {
		boolean blnStatus=true;
		try
		{
			blnStatus=elem.isDisplayed();
		}
		catch(Exception e)
		{
			blnStatus=false;
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnIsEnabled
	 * Class Name :- ActionEngine 
	 */
	public boolean fnIsEnabled(WebElement elem) {
		boolean blnStatus=true;
		try
		{
			blnStatus=elem.isEnabled();
		}
		catch(Exception e)
		{
			blnStatus=false;
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnIsEnabled
	 * Class Name :- ActionEngine 
	 */
	public boolean fnIsEnabled(By loc) {
		boolean blnStatus=true;
		try
		{
			blnStatus=driver.findElement(loc).isEnabled();
		}
		catch(Exception e)
		{
			blnStatus=false;
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnIsSelected
	 * Class Name :- ActionEngine 
	 */
	public boolean fnIsSelected(WebElement elem) {
		boolean blnStatus=true;
		try
		{
			blnStatus=elem.isSelected();
		}
		catch(Exception e)
		{
			blnStatus=false;
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnIsSelected
	 * Class Name :- ActionEngine 
	 */
	public boolean fnIsSelected(By loc) {
		boolean blnStatus=true;
		try
		{
			blnStatus=driver.findElement(loc).isSelected();
		}
		catch(Exception e)
		{
			blnStatus=false;
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnIsElementPresent
	 * Class Name :- ActionEngine 
	 */
	public boolean fnIsElementPresent(By loc) {
		boolean blnStatus=false;
		try
		{
			if(driver.findElements(loc).size()>0)
				blnStatus=true;
		}
		catch(Exception e)
		{
			blnStatus=false;
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnType
	 * Class Name :- ActionEngine
	 */
	public boolean fnType(WebElement elem,String strText,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(elem))
			{
				elem.sendKeys(strText);
				Reporter.pass("Enter Text " + strDescription,strText+" Entered Successfully");
			}
			else
			{
				Reporter.fail("Enter Text " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Enter Text " + strDescription,"Unable to  Enter Text " +strText);
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnType
	 * Class Name :- ActionEngine 
	 */
	public boolean fnType(By loc,String strText,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(loc))
			{
				driver.findElement(loc).sendKeys(strText);
				Reporter.pass("Enter Text " + strDescription,strText+" Entered Successfully");
			}
			else
			{
				Reporter.fail("Enter Text " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Enter Text " + strDescription,"Unable to  Enter Text " +strText);
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnClick
	 * Class Name :- ActionEngine 
	 */
	public boolean fnClick(WebElement elem,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(elem))
			{
				elem.click();
				Reporter.pass("Click " + strDescription,"Click Successfully");
			}
			else
			{
				Reporter.fail("Click " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Click " + strDescription,"Unable to Click");
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnClick
	 * Class Name :- ActionEngine 
	 */
	public boolean fnClick(By loc,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(loc))
			{
				driver.findElement(loc).click();
				Reporter.pass("Click " + strDescription,"Click Successfully");
			}
			else
			{
				Reporter.fail("Click " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Click " + strDescription,"Unable to Click");
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnGetText
	 * Class Name :- ActionEngine 
	 */
	public String fnGetText(WebElement elem,String strDescription) {
		String strText="";
		try
		{
			if(fnIsElementPresent(elem))
			{
				strText=elem.getText();
				Reporter.pass("Get Text " + strDescription,strText +" Text Found");
			}
			else
			{
				Reporter.fail("Get Text " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			Reporter.fail("Get Text " + strDescription,"Unable to Get Text");
		}
		return strText;
	}
	
	/***
	 * Name of Function :- fnGetText
	 * Class Name :- ActionEngine 
	  */
	public String fnGetText(By loc,String strDescription) {
		String strText="";
		try
		{
			if(fnIsElementPresent(loc))
			{
				strText=driver.findElement(loc).getText();
				Reporter.pass("Get Text " + strDescription,strText +" Text Found");
			}
			else
			{
				Reporter.fail("Get Text " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			Reporter.fail("Get Text " + strDescription,"Unable to Get Text");
		}
		return strText;
	}
	
	/***
	 * Name of Function :- fnGetTagName
	 * Class Name :- ActionEngine 
	*/
	public String fnGetTagName(WebElement elem,String strDescription) {
		String strText="";
		try
		{
			if(fnIsElementPresent(elem))
			{
				strText=elem.getTagName();
				Reporter.pass("Get Tag Name " + strDescription,strText +" Tag Found");
			}
			else
			{
				Reporter.fail("Get Tag Name " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			Reporter.fail("Get Tag Name " + strDescription,"Unable to Get Tag Name");
		}
		return strText;
	}
	
	/***
	 * Name of Function :- fnGetTagName
	 * Class Name :- ActionEngine 
	 */
	public String fnGetTagName(By loc,String strDescription) {
		String strText="";
		try
		{
			if(fnIsElementPresent(loc))
			{
				strText=driver.findElement(loc).getTagName();
				Reporter.pass("Get Tag Name " + strDescription,strText +" Tag Found");
			}
			else
			{
				Reporter.fail("Get Tag Name " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			Reporter.fail("Get Tag Name " + strDescription,"Unable to Get Tag Name");
		}
		return strText;
	}
	
	/***
	 * Name of Function :- fnGetAttribute
	 * Class Name :- ActionEngine 
	 */
	public String fnGetAttribute(WebElement elem,String strAttributeName,String strDescription) {
		String strText="";
		try
		{
			if(fnIsElementPresent(elem))
			{
				strText=elem.getAttribute(strAttributeName);
				Reporter.pass("Get Attribute "+ strAttributeName+" : " + strDescription,strText +" Attribute Found");
			}
			else
			{
				Reporter.fail("Get Attribute " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			Reporter.fail("Get Attribute " + strAttributeName+" : " + strDescription,"Unable to Get Attribute Name");
		}
		return strText;
	}
	
	/***
	 * Name of Function :- fnGetAttribute
	 * Class Name :- ActionEngine 
	*/
	public String fnGetAttribute(By loc,String strAttributeName,String strDescription) {
		String strText="";
		try
		{
			if(fnIsElementPresent(loc))
			{
				strText=driver.findElement(loc).getAttribute(strAttributeName);
				Reporter.pass("Get Attribute "+ strAttributeName+" : " + strDescription,strText +" Attribute Found");
			}
			else
			{
				Reporter.fail("Get Attribute " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			Reporter.fail("Get Attribute " + strAttributeName+" : " + strDescription,"Unable to Get Attribute Name");
		}
		return strText;
	}
	
	/***
	 * Name of Function :- fnGetCSSValue
	 * Class Name :- ActionEngine 
	 */
	public String fnGetCSSValue(WebElement elem,String strCSSValue,String strDescription) {
		String strText="";
		try
		{
			if(fnIsElementPresent(elem))
			{
				strText=elem.getAttribute(strCSSValue);
				Reporter.pass("Get CSS Value "+ strCSSValue+" : " + strDescription,strText +" CSS Value Found");
			}
			else
			{
				Reporter.fail("Get CSS Value " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			Reporter.fail("Get CSS Value " + strCSSValue+" : " + strDescription,"Unable to Get CSS Value Name");
		}
		return strText;
	}
	
	/***
	 * Name of Function :- fnGetCSSValue
	 * Class Name :- ActionEngine 
	 */
	public String fnGetCSSValue(By loc,String strCSSValue,String strDescription) {
		String strText="";
		try
		{
			if(fnIsElementPresent(loc))
			{
				strText=driver.findElement(loc).getAttribute(strCSSValue);
				Reporter.pass("Get CSS Value "+ strCSSValue+" : " + strDescription,strText +" CSS Value Found");
			}
			else
			{
				Reporter.fail("Get CSS Value " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			Reporter.fail("Get CSS Value " + strCSSValue+" : " + strDescription,"Unable to Get CSS Value Name");
		}
		return strText;
	}
	
	/***
	 * Name of Function :- fnGetSize
	 * Class Name :- ActionEngine 
	 */
	public Dimension fnGetSize(WebElement elem,String strDescription) {
		Dimension size=null;
		try
		{
			if(fnIsElementPresent(elem))
			{
				size=elem.getSize();
				Reporter.pass("Get Size "+ strDescription,"Hight : "+ size.height +" Width :"+ size.width);
			}
			else
			{
				Reporter.fail("Get Size Value " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			Reporter.fail("Get Size Value " + strDescription,"Unable to Get Size Value");
		}
		return size;
	}
	
	/***
	 * Name of Function :- fnGetSize
	 * Class Name :- ActionEngine 
	 */
	public Dimension fnGetSize(By loc,String strDescription) {
		Dimension size=null;
		try
		{
			if(fnIsElementPresent(loc))
			{
				size=driver.findElement(loc).getSize();
				Reporter.pass("Get Size "+ strDescription,"Hight : "+ size.height +" Width :"+ size.width);
			}
			else
			{
				Reporter.fail("Get Size Value " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			Reporter.fail("Get Size Value " + strDescription,"Unable to Get Size Value");
		}
		return size;
	}
	
	/***
	 * Name of Function :- fnGetLocation
	 * Class Name :- ActionEngine 
	 */
	public Point fnGetLocation(WebElement elem,String strDescription) {
		Point size=null;
		try
		{
			if(fnIsElementPresent(elem))
			{
				size=elem.getLocation();
				Reporter.pass("Get Location "+ strDescription,"X : "+ size.x +" Y :"+ size.y);
			}
			else
			{
				Reporter.fail("Get Location Value " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			Reporter.fail("Get Location Value " + strDescription,"Unable to Get Location Value");
		}
		return size;
	}
	
	/***
	 * Name of Function :- fnGetLocation
	 * Class Name :- ActionEngine 
	  */
	public Point fnGetLocation(By loc,String strDescription) {
		Point size=null;
		try
		{
			if(fnIsElementPresent(loc))
			{
				size=driver.findElement(loc).getLocation();
				Reporter.pass("Get Location "+ strDescription,"X : "+ size.x +" Y :"+ size.y);
			}
			else
			{
				Reporter.fail("Get Location Value " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			Reporter.fail("Get Location Value " + strDescription,"Unable to Get Location Value");
		}
		return size;
	}
	
	/***
	 * Name of Function :- fnSubmit
	 * Class Name :- ActionEngine 
	 */
	public boolean fnSubmit(WebElement elem,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(elem))
			{
				elem.submit();
				Reporter.pass("Submit " + strDescription,"Submit Successfully");
			}
			else
			{
				Reporter.fail("Submit " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Submit " + strDescription,"Unable to Submit");
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnSubmit
	 * Class Name :- ActionEngine 
	 */
	public boolean fnSubmit(By loc,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(loc))
			{
				driver.findElement(loc).submit();
				Reporter.pass("Submit " + strDescription,"Submit Successfully");
			}
			else
			{
				Reporter.fail("Submit " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Submit " + strDescription,"Unable to Submit");
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnIsElementDisplayed
	 * Class Name :- ActionEngine 
	 */
	public boolean fnIsElementDisplayed(WebElement elem,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(elem))
			{
				blnStatus=elem.isDisplayed();
				Reporter.pass("Is Displayed " + strDescription,"Displayed Successfully");
			}
			else
			{
				Reporter.fail("Is Displayed " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Displayed " + strDescription,"Unable to Displayed");
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnIsElementDisplayed
	 * Class Name :- ActionEngine 
	 */
	public boolean fnIsElementDisplayed(By loc,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(loc))
			{
				blnStatus=driver.findElement(loc).isDisplayed();
				Reporter.pass("Is Displayed " + strDescription,"Displayed Successfully");
			}
			else
			{
				Reporter.fail("Is Displayed " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Is Displayed " + strDescription,"Unable to Displayed");
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnVerifyIsDisplayed
	 * Class Name :- ActionEngine 
	 */
	public boolean fnVerifyIsDisplayed(WebElement elem,String strDescription) {
		boolean blnStatus=true;
		try
		{
			blnStatus=fnIsElementPresent(elem);
			if(blnStatus)
			{
				Reporter.pass("Is Displayed " + strDescription,"Element Displayed Successfully");
			}
			else
			{
				Reporter.fail("Is Displayed " + strDescription,"Element not Displayed.");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnVerifyIsDisplayed
	 * Class Name :- ActionEngine 
	 */
	public boolean fnVerifyIsDisplayed(By loc,String strDescription) {
		boolean blnStatus=true;
		try
		{
			blnStatus=fnIsElementPresent(loc);
			if(blnStatus)
			{
				Reporter.pass("Is Displayed " + strDescription,"Element Displayed Successfully");
			}
			else
			{
				Reporter.fail("Is Displayed " + strDescription,"Element not Displayed.");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnVerifyIsEnabled
	 * Class Name :- ActionEngine 
	 */
	public boolean fnVerifyIsEnabled(WebElement elem,String strDescription) {
		boolean blnStatus=true;
		try
		{
			blnStatus=fnIsEnabled(elem);
			if(blnStatus)
			{
				Reporter.pass("Is Enabled " + strDescription,"Element Enabled Successfully");
			}
			else
			{
				Reporter.fail("Is Enabled " + strDescription,"Element not Enabled.");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnVerifyIsEnabled
	 * Class Name :- ActionEngine 
	*/
	public boolean fnVerifyIsEnabled(By loc,String strDescription) {
		boolean blnStatus=true;
		try
		{
			blnStatus=fnIsEnabled(loc);
			if(blnStatus)
			{
				Reporter.pass("Is Enabled " + strDescription,"Element Enabled Successfully");
			}
			else
			{
				Reporter.fail("Is Enabled " + strDescription,"Element not Enabled.");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnIsElementSelected
	 * Class Name :- ActionEngine 
	 */
	public boolean fnIsElementSelected(WebElement elem,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(elem))
			{
				blnStatus=fnIsSelected(elem);
				if(blnStatus)
					Reporter.pass("Is Selected " + strDescription,"Selected Successfully");
				else
					Reporter.fail("Is Selected " + strDescription,"Element not Selected");
			}
			else
			{
				Reporter.fail("Is Selected " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Is Selected " + strDescription,"Unable to find Is Selected");
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnIsElementSelected
	 * Class Name :- ActionEngine 
	 */
	public boolean fnIsElementSelected(By loc,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(loc))
			{
				blnStatus=fnIsSelected(loc);
				if(blnStatus)
					Reporter.pass("Is Selected " + strDescription,"Selected Successfully");
				else
					Reporter.fail("Is Selected " + strDescription,"Element not Selected");
			}
			else
			{
				Reporter.fail("Is Selected " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Is Selected " + strDescription,"Unable to find Is Selected");
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnIsMultiple
	 * Class Name :- ActionEngine 
	  */
	public boolean fnIsMultiple(Select objSelect) {
		boolean blnStatus=true;
		try
		{
			blnStatus=objSelect.isMultiple();
		}
		catch(Exception e)
		{
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnVerifySelectOption
	 * Class Name :- ActionEngine 
	  */
	public Select fnVerifySelectOption(By loc) {
		Select objSelect=null;
		try
		{
			objSelect=new Select(driver.findElement(loc));
		}
		catch(Exception e)
		{
		}
		return objSelect;
	}
	
	/***
	 * Name of Function :- fnVerifySelectOption
	 * Class Name :- ActionEngine 
	 */
	public Select fnVerifySelectOption(WebElement elem) {
		Select objSelect=null;
		try
		{
			objSelect=new Select(elem);
		}
		catch(Exception e)
		{
		}
		return objSelect;
	}
	
	/***
	 * Name of Function :- fnGetAllOptions
	 * Class Name :- ActionEngine 
	 */
	public List<WebElement> fnGetAllOptions(Select objSelect) {
		List<WebElement> objElement=null;
		try
		{
			objElement=objSelect.getOptions();
		}
		catch(Exception e)
		{

		}
		return objElement;
	}
	
	/***
	 * Name of Function :- fnGetSelectedOption
	 * Class Name :- ActionEngine 
	  */
	public String fnGetSelectedOption(Select objSelect) {
		String strText="";
		try
		{
			strText=objSelect.getAllSelectedOptions().get(0).getText();
		}
		catch(Exception e)
		{
		
		}
		return strText;
	}
	
	/***
	 * Name of Function :- fnGetAllSelectedOption
	 * Class Name :- ActionEngine 
	  */
	public List<String> fnGetAllSelectedOption(Select objSelect) {
		List<String> objText=new ArrayList<String>();
		try
		{
			for (WebElement elem : objSelect.getAllSelectedOptions()) {
				objText.add(elem.getText());
			}		
		}
		catch(Exception e)
		{
		
		}
		return objText;
	}
	
	
	/***
	 * Name of Function :- fnGetAllOptionsAsText
	 * Class Name :- ActionEngine 
	 */
	public List<String> fnGetAllOptionsAsText(Select objSelect) {
		List<String> objElement=new ArrayList<String>();
		try
		{
			for (WebElement elem : objSelect.getOptions()) {
				objElement.add(elem.getText());
			}
		}
		catch(Exception e)
		{
		
		}
		return objElement;
	}
	
	/***
	 * Name of Function :- fnGetOptionCount
	 * Class Name :- ActionEngine 
	*/
	public int fnGetOptionCount(Select objSelect) {
		int  intCount=0;
		try
		{
			intCount=objSelect.getOptions().size();
		}
		catch(Exception e)
		{
			
		}
		return intCount;
	}
	
	/***
	 * Name of Function :- fnSelectByVisibleText
	 * Class Name :- ActionEngine 
	 */
	public boolean fnSelectByVisibleText(By loc,String strText,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(loc))
			{
				Select objSelect=fnVerifySelectOption(loc);
				if(objSelect!=null)
				{
					objSelect.selectByVisibleText(strText);
					Reporter.pass("Select From Dropdown " + strDescription,strText+" selected successfully");
				}
				else
					Reporter.fail("Select From Dropdown  " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("Select From Dropdown  " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Select From Dropdown " + strDescription,strText+" not selected.");
			
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnSelectByVisibleText
	 * Class Name :- ActionEngine 
	*/
	public boolean fnSelectByVisibleText(WebElement elem,String strText,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(elem))
			{
				Select objSelect=fnVerifySelectOption(elem);
				if(objSelect!=null)
				{
					objSelect.selectByVisibleText(strText);
					Reporter.pass("Select From Dropdown " + strDescription,strText+" selected successfully");
				}
				else
					Reporter.fail("Select From Dropdown  " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("Select From Dropdown  " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Select From Dropdown " + strDescription,strText+" not selected.");
			
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnSelectByValue
	 * Class Name :- ActionEngine 
	 */
	public boolean fnSelectByValue(By loc,String strText,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(loc))
			{
				Select objSelect=fnVerifySelectOption(loc);
				if(objSelect!=null)
				{
					objSelect.selectByVisibleText(strText);
					Reporter.pass("Select From Dropdown " + strDescription,strText+" selected successfully");
				}
				else
					Reporter.fail("Select From Dropdown  " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("Select From Dropdown  " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Select From Dropdown " + strDescription,strText+" not selected.");
		
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnSelectByValue
	 * Class Name :- ActionEngine 
	*/
	public boolean fnSelectByValue(WebElement elem,String strText,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(elem))
			{
				Select objSelect=fnVerifySelectOption(elem);
				if(objSelect!=null)
				{
					objSelect.selectByVisibleText(strText);
					Reporter.pass("Select From Dropdown " + strDescription,strText+" selected successfully");
				}
				else
					Reporter.fail("Select From Dropdown  " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("Select From Dropdown  " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Select From Dropdown " + strDescription,strText+" not selected.");
		
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnSelectByValue
	 * Class Name :- ActionEngine 
	*/
	public boolean fnSelectByIndex(By loc,int intIndex,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(loc))
			{
				Select objSelect=fnVerifySelectOption(loc);
				if(objSelect!=null)
				{
					objSelect.selectByIndex(intIndex);
					Reporter.pass("Select From Dropdown " + strDescription,intIndex+" selected successfully");
				}
				else
					Reporter.fail("Select From Dropdown  " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("Select From Dropdown  " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Select From Dropdown " + strDescription,intIndex+" not selected.");
		
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnSelectByValue
	 * Class Name :- ActionEngine 
	  */
	public boolean fnSelectByIndex(WebElement elem,int intIndex,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(elem))
			{
				Select objSelect=fnVerifySelectOption(elem);
				if(objSelect!=null)
				{
					objSelect.selectByIndex(intIndex);
					Reporter.pass("Select From Dropdown " + strDescription,intIndex+" selected successfully");
				}
				else
					Reporter.fail("Select From Dropdown  " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("Select From Dropdown  " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Select From Dropdown " + strDescription,intIndex+" not selected.");
		
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnVerifyIsMultiple
	 * Class Name :- ActionEngine 
	 */
	public boolean fnVerifyIsMultiple(By loc,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(loc))
			{
				Select objSelect=fnVerifySelectOption(loc);
				if(objSelect!=null)
				{
					blnStatus=fnIsMultiple(objSelect);
					if(blnStatus)
						Reporter.pass("MultiSelect From Dropdown " + strDescription,"Dropdown is Multiselect");
					else
						Reporter.fail("MultiSelect From Dropdown " + strDescription,"Dropdown is not Multiselect");
				}
				else
					Reporter.fail("MultiSelect From Dropdown  " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("MultiSelect From Dropdown  " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("MultiSelect From Dropdown " + strDescription,"Dropdown is not Multiselect");
		
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnVerifyIsMultiple
	 * Class Name :- ActionEngine 
	*/
	public boolean fnVerifyIsMultiple(WebElement elem,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(elem))
			{
				Select objSelect=fnVerifySelectOption(elem);
				if(objSelect!=null)
				{
					blnStatus=fnIsMultiple(objSelect);
					if(blnStatus)
						Reporter.pass("MultiSelect From Dropdown " + strDescription,"Dropdown is Multiselect");
					else
						Reporter.fail("MultiSelect From Dropdown " + strDescription,"Dropdown is not Multiselect");
				}
				else
					Reporter.fail("MultiSelect From Dropdown  " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("MultiSelect From Dropdown  " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("MultiSelect From Dropdown " + strDescription,"Dropdown is not Multiselect");
		
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnDeSelectAll
	 * Class Name :- ActionEngine 
	  */
	public boolean fnDeSelectAll(By loc,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(loc))
			{
				Select objSelect=fnVerifySelectOption(loc);
				if(objSelect!=null)
				{
					blnStatus=fnIsMultiple(objSelect);
					if(blnStatus)
					{
						objSelect.deselectAll();
						Reporter.pass("De-Select All From Dropdown " + strDescription,"De-Select All Dropdown");
					}
					else
						Reporter.fail("De-Select All From Dropdown  " + strDescription,"Dropdown is not Multiselect");
				}
				else
					Reporter.fail("De-Select All From Dropdown   " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("De-Select All From Dropdown   " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("De-Select All From Dropdown  " + strDescription,"Dropdown is not Multiselect");
	
		}
		return blnStatus;
	}
	/***
	 * Name of Function :- fnDeSelectAll
	 * Class Name :- ActionEngine 
	 */
	public boolean fnDeSelectAll(WebElement elem,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(elem))
			{
				Select objSelect=fnVerifySelectOption(elem);
				if(objSelect!=null)
				{
					blnStatus=fnIsMultiple(objSelect);
					if(blnStatus)
					{
						objSelect.deselectAll();
						Reporter.pass("De-Select All From Dropdown " + strDescription,"De-Select All Dropdown");
					}
					else
						Reporter.fail("De-Select All From Dropdown  " + strDescription,"Dropdown is not Multiselect");
				}
				else
					Reporter.fail("De-Select All From Dropdown   " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("De-Select All From Dropdown   " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("De-Select All From Dropdown  " + strDescription,"Dropdown is not Multiselect");
	
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnDeSelectByVisibleText
	 * Class Name :- ActionEngine 
	*/
	public boolean fnDeSelectByVisibleText(By loc,String strText,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(loc))
			{
				Select objSelect=fnVerifySelectOption(loc);
				if(objSelect!=null)
				{
					blnStatus=fnIsMultiple(objSelect);
					if(blnStatus)
					{
						objSelect.deselectByVisibleText(strText);
						Reporter.pass("De-Select By Visible Text From Dropdown  " + strDescription,"De-Select By Visible Text from Dropdown : " + strText);
					}
					else
						Reporter.fail("De-Select By Visible Text From Dropdown   " + strDescription,"Dropdown is not Multiselect");
				}
				else
					Reporter.fail("De-Select By Visible Text From Dropdown " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("De-Select By Visible Text From Dropdown " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("De-Select By Visible Text From Dropdown " + strDescription,"De-Select By Visible Text from Dropdown : " + strText);
	
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnDeSelectByVisibleText
	 * Class Name :- ActionEngine 
	 */
	public boolean fnDeSelectByVisibleText(WebElement elem,String strText,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(elem))
			{
				Select objSelect=fnVerifySelectOption(elem);
				if(objSelect!=null)
				{
					blnStatus=fnIsMultiple(objSelect);
					if(blnStatus)
					{
						objSelect.deselectByVisibleText(strText);
						Reporter.pass("De-Select By Visible Text From Dropdown  " + strDescription,"De-Select By Visible Text from Dropdown : " + strText);
					}
					else
						Reporter.fail("De-Select By Visible Text From Dropdown   " + strDescription,"Dropdown is not Multiselect");
				}
				else
					Reporter.fail("De-Select By Visible Text From Dropdown " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("De-Select By Visible Text From Dropdown " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("De-Select By Visible Text From Dropdown " + strDescription,"De-Select By Visible Text from Dropdown : " + strText);
	
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnDeSelectByValue
	 * Class Name :- ActionEngine 
	 */
	public boolean fnDeSelectByValue(By loc,String strText,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(loc))
			{
				Select objSelect=fnVerifySelectOption(loc);
				if(objSelect!=null)
				{
					blnStatus=fnIsMultiple(objSelect);
					if(blnStatus)
					{
						objSelect.deselectByValue(strText);
						Reporter.pass("De-Select By Value From Dropdown  " + strDescription,"De-Select By Value from Dropdown : " + strText);
					}
					else
						Reporter.fail("De-Select By Value From Dropdown   " + strDescription,"Dropdown is not Multiselect");
				}
				else
					Reporter.fail("De-Select By Value From Dropdown " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("De-Select By Value From Dropdown " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("De-Select By Value From Dropdown " + strDescription,"De-Select By Value from Dropdown : " + strText);
			
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnDeSelectByValue
	 * Class Name :- ActionEngine 
	 */
	public boolean fnDeSelectByValue(WebElement elem,String strText,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(elem))
			{
				Select objSelect=fnVerifySelectOption(elem);
				if(objSelect!=null)
				{
					blnStatus=fnIsMultiple(objSelect);
					if(blnStatus)
					{
						objSelect.deselectByValue(strText);
						Reporter.pass("De-Select By Value From Dropdown  " + strDescription,"De-Select By Value from Dropdown : " + strText);
					}
					else
						Reporter.fail("De-Select By Value From Dropdown   " + strDescription,"Dropdown is not Multiselect");
				}
				else
					Reporter.fail("De-Select By Value From Dropdown " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("De-Select By Value From Dropdown " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("De-Select By Value From Dropdown " + strDescription,"De-Select By Value from Dropdown : " + strText);
	
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnDeSelectByIndex
	 * Class Name :- ActionEngine 
	 */
	public boolean fnDeSelectByIndex(By loc,int intIndex,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(loc))
			{
				Select objSelect=fnVerifySelectOption(loc);
				if(objSelect!=null)
				{
					blnStatus=fnIsMultiple(objSelect);
					if(blnStatus)
					{
						objSelect.deselectByIndex(intIndex);
						Reporter.pass("De-Select By Index From Dropdown  " + strDescription,"De-Select By Index from Dropdown : " + intIndex);
					}
					else
						Reporter.fail("De-Select By Index From Dropdown   " + strDescription,"Dropdown is not Multiselect");
				}
				else
					Reporter.fail("De-Select By Index From Dropdown " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("De-Select By Index From Dropdown " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("De-Select By Index From Dropdown " + strDescription,"De-Select By Value from Dropdown : " + intIndex);

		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnDeSelectByIndex
	 * Class Name :- ActionEngine 
	 */
	public boolean fnDeSelectByIndex(WebElement elem,int intIndex,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(elem))
			{
				Select objSelect=fnVerifySelectOption(elem);
				if(objSelect!=null)
				{
					blnStatus=fnIsMultiple(objSelect);
					if(blnStatus)
					{
						objSelect.deselectByIndex(intIndex);
						Reporter.pass("De-Select By Index From Dropdown  " + strDescription,"De-Select By Index from Dropdown : " + intIndex);
					}
					else
						Reporter.fail("De-Select By Index From Dropdown   " + strDescription,"Dropdown is not Multiselect");
				}
				else
					Reporter.fail("De-Select By Index From Dropdown " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("De-Select By Index From Dropdown " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("De-Select By Index From Dropdown " + strDescription,"De-Select By Index from Dropdown : " + intIndex);
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnPrintAllOptions
	 * Class Name :- ActionEngine 
	*/
	public boolean fnPrintAllOptions(By loc,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(loc))
			{
				Select objSelect=fnVerifySelectOption(loc);
				if(objSelect!=null)
				{
					if(fnGetOptionCount(objSelect)>0)
					{
						for (String strText : fnGetAllOptionsAsText(objSelect)) {
							Reporter.pass("Select Option Text " + strDescription,"Element Option : "+ strText);
						}
					}
					else
						Reporter.fail("Select Option Text " + strDescription,"Element Option : No Option Found");
				}
				else
					Reporter.fail("Select Option Text " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("Select Option Text " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Select Option Text " + strDescription,"Element Option : No Option Found");
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnPrintAllOptions
	 * Class Name :- ActionEngine 
	*/
	public boolean fnPrintAllOptions(WebElement elem,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(elem))
			{
				Select objSelect=fnVerifySelectOption(elem);
				if(objSelect!=null)
				{
					if(fnGetOptionCount(objSelect)>0)
					{
						for (String strText : fnGetAllOptionsAsText(objSelect)) {
							Reporter.pass("Select Option Text " + strDescription,"Element Option : "+ strText);
						}
					}
					else
						Reporter.fail("Select Option Text " + strDescription,"Element Option : No Option Found");
				}
				else
					Reporter.fail("Select Option Text " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("Select Option Text " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Select Option Text " + strDescription,"Element Option : No Option Found");
		}
		return blnStatus;
	}
	
	
	
	/***
	 * Name of Function :- fnVerifySelectOptionCount
	 * Class Name :- ActionEngine 
	*/
	public boolean fnVerifySelectOptionCount(WebElement elem,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(elem))
			{
				Select objSelect=fnVerifySelectOption(elem);
				if(objSelect!=null)
				{
					Reporter.pass("Select Option Count " + strDescription,"Element Option Count : "+ fnGetOptionCount(objSelect));
				}
				else
					Reporter.fail("Select Option Count " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("Select Option Count " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Select Option Count " + strDescription,"Element Option : No Option Found");
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnVerifySelectOptionCount
	 * Class Name :- ActionEngine 
	 */
	public boolean fnVerifySelectOptionCount(By loc,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(loc))
			{
				Select objSelect=fnVerifySelectOption(loc);
				if(objSelect!=null)
				{
					Reporter.pass("Select Option Count " + strDescription,"Element Option Count : "+ fnGetOptionCount(objSelect));
				}
				else
					Reporter.fail("Select Option Count " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("Select Option Count " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Select Option Count " + strDescription,"Element Option : No Option Found");
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnVerifySelecedOption
	 * Class Name :- ActionEngine 
	*/
	public boolean fnVerifySelecedOption(By loc,String strText,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(loc))
			{
				Select objSelect=fnVerifySelectOption(loc);
				if(objSelect!=null)
				{
					if(fnGetSelectedOption(objSelect).equalsIgnoreCase(strText.toLowerCase()))
						Reporter.pass("Selected Option " + strDescription,strText + " is Selected");
					else 
						Reporter.fail("Selected Option " + strDescription,strText + " is not Selected");
				}
				else
					Reporter.fail("Selected Option " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("Selected Option " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Selected Option " + strDescription,strText + " is not Selected");
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnVerifySelecedOption
	 * Class Name :- ActionEngine 
	*/
	public boolean fnVerifySelecedOption(WebElement elem,String strText,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(elem))
			{
				Select objSelect=fnVerifySelectOption(elem);
				if(objSelect!=null)
				{
					if(fnGetSelectedOption(objSelect).equalsIgnoreCase(strText.toLowerCase()))
						Reporter.pass("Selected Option " + strDescription,strText + " is Selected");
					else 
						Reporter.fail("Selected Option " + strDescription,strText + " is not Selected");
				}
				else
					Reporter.fail("Selected Option " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("Selected Option " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("Selected Option " + strDescription,strText + " is not Selected");
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnPrintAllSelectedOptions
	 * Class Name :- ActionEngine 
	 */
	public boolean fnPrintAllSelectedOptions(By loc,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(loc))
			{
				Select objSelect=fnVerifySelectOption(loc);
				if(objSelect!=null)
				{
					if(fnGetOptionCount(objSelect)>0)
					{
						for (String strText : fnGetAllSelectedOption(objSelect)) {
							Reporter.pass("All Selected Option Text " + strDescription,"Element Option : "+ strText);
						}
					}
					else
						Reporter.fail("All Selected Option Text " + strDescription,"Element Option : No Option Found");
				}
				else
					Reporter.fail("All Selected Option Text " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("All Selected Option Text " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("All Selected Option Text " + strDescription,"Element Option : No Option Found");
		}
		return blnStatus;
	}
	
	/***
	 * Name of Function :- fnPrintAllSelectedOptions
	 * Class Name :- ActionEngine 
	 */
	public boolean fnPrintAllSelectedOptions(WebElement elem,String strDescription) {
		boolean blnStatus=true;
		try
		{
			if(fnIsElementPresent(elem))
			{
				Select objSelect=fnVerifySelectOption(elem);
				if(objSelect!=null)
				{
					if(fnGetOptionCount(objSelect)>0)
					{
						for (String strText : fnGetAllSelectedOption(objSelect)) {
							Reporter.pass("All Selected Option Text " + strDescription,"Element Option : "+ strText);
						}
					}
					else
						Reporter.fail("All Selected Option Text " + strDescription,"Element Option : No Option Found");
				}
				else
					Reporter.fail("All Selected Option Text " + strDescription,"Element is not Select Option");
			}
			else
			{
				Reporter.fail("All Selected Option Text " + strDescription,"Unable to find Element");
			}
		}
		catch(Exception e)
		{
			blnStatus=false;
			Reporter.fail("All Selected Option Text " + strDescription,"Element Option : No Option Found");
		}
		return blnStatus;
	}
	
	public void fnWaitForElement(By loc)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
	}
}
