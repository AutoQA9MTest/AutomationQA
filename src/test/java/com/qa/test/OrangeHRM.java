package com.qa.test;

import org.testng.annotations.Test;

import com.qa.reports.Reporter;
import com.qa.utilities.TestConfig;
import com.qa.workflow.HRMCommon;

public class OrangeHRM extends HRMCommon{
	
	@Test
	public void fnOrangeHRM()
	{
		Reporter.info("ORangeHRM", "Web Application for Test");
		fnGetURL(TestConfig.strURL, "Orange HRM");
		HRMCommon.hrmlogin.fnOrangeHRMLogin();
		HRMCommon.db.fnVerifyDashboard();
		
		
	}

}
