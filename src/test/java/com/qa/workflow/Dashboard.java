package com.qa.workflow;

import org.openqa.selenium.By;

import com.qa.accelarator.ActionEngine;
import com.qa.reports.Reporter;

public class Dashboard extends ActionEngine {
	
	By lblDashboard=By.xpath("//h1[normalize-space()='Dashboard']");
	
	public void fnVerifyDashboard()
	{
		Reporter.info("ORangeHRM", "Orange HRM Dashboard Page");
		String strText=fnGetText(lblDashboard, "Label Dashboard");
		if(strText.equals("Dashboard"))
		{
			Reporter.pass("Orange HRM Dashboard", "Dashboard Page Displayed Successfully");
		}
		else
		{
			Reporter.fail("Orange HRM Dashboard", "Dashboard Page not Displayed");
		}
				
	}

}
