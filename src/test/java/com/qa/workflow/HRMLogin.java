package com.qa.workflow;

import org.openqa.selenium.By;

import com.qa.accelarator.ActionEngine;
import com.qa.reports.Reporter;
import com.qa.utilities.TestConfig;

public class HRMLogin extends ActionEngine{
	//Locators
	By txtUserName=By.xpath("//input[@id='txtUsername']");
	By txtPassword=By.xpath("//input[@id='txtPassword']");
	By btnLogin=By.xpath("//input[@id='btnLogin']");
	
	public void fnOrangeHRMLogin()
	{
		Reporter.info("ORangeHRM", "Orange HRM Login");
		fnType(txtUserName, TestConfig.strUserID, "UserName");
		fnType(txtPassword, TestConfig.strPassword, "Password");
		fnClick(btnLogin, "Login");
		String strTitle=fnGetTitle("Current Orange HRM");
		System.out.println(strTitle);
		if(strTitle.equals("OrangeHRM"))
		{
			Reporter.pass("Orange HRM Login", "Login Successfully");
		}
		else
		{
			Reporter.fail("Orange HRM Login", "Login problem please check user cred");
		}
	}

}
