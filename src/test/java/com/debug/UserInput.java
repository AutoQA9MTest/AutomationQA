package com.debug;

import java.io.IOException;

import com.qa.utilities.ExcelReader;
import com.qa.utilities.FileUtilities;

public class UserInput {
	public String UserName;
	public String Password;
	public String FirstName;
	public String LastName;
	public String Mobile;
	public String State;
	
	public static UserInput fnGetUserDetails(int intRow) throws IOException
	{
		String strSheetPath=FileUtilities.fnGetCurrentUserDir()+"/TestData/TestSampleData.xlsx";
		UserInput objUserData=new UserInput();
		objUserData.UserName=ExcelReader.fn_GetCellData(strSheetPath, "UserDetails", intRow, "UserName");
		objUserData.Password=ExcelReader.fn_GetCellData(strSheetPath, "UserDetails", intRow, "Password");
		objUserData.FirstName=ExcelReader.fn_GetCellData(strSheetPath, "UserDetails", intRow, "FirstName");
		objUserData.LastName=ExcelReader.fn_GetCellData(strSheetPath, "UserDetails", intRow, "LastName");
		objUserData.Mobile=ExcelReader.fn_GetCellData(strSheetPath, "UserDetails", intRow, "Mobile");
		objUserData.State=ExcelReader.fn_GetCellData(strSheetPath, "UserDetails", intRow, "State");
		return objUserData;
	}


}
