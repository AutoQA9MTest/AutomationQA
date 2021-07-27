package com.debug;

import java.io.IOException;

import com.qa.utilities.ExcelReader;
import com.qa.utilities.FileUtilities;

public class SampleExcelReader {

	public static void main(String[] args) throws IOException {
		/*String strSheetPath=FileUtilities.fnGetCurrentUserDir()+"/TestData/TestSampleData.xlsx";
		String UserName=ExcelReader.fn_GetCellData(strSheetPath, "UserDetails", 1, "UserName");
		String Password=ExcelReader.fn_GetCellData(strSheetPath, "UserDetails", 1, "Password");
		String FirstName=ExcelReader.fn_GetCellData(strSheetPath, "UserDetails", 1, "FirstName");
		String LastName=ExcelReader.fn_GetCellData(strSheetPath, "UserDetails", 1, "LastName");
		String Mobile=ExcelReader.fn_GetCellData(strSheetPath, "UserDetails", 1, "Mobile");
		String State=ExcelReader.fn_GetCellData(strSheetPath, "UserDetails", 1, "State");
		System.out.println(State);*/
		UserInput objData=UserInput.fnGetUserDetails(1);
		fnEnterUserData(objData);

		
	}
	
	public static void fnEnterUserData(UserInput arrData)
	{
		System.out.println("User Entry Details");
		System.out.println(arrData.UserName);
		System.out.println(arrData.Password);
		System.out.println(arrData.FirstName);
		System.out.println(arrData.LastName);
		System.out.println(arrData.Mobile);
		System.out.println(arrData.State);

	}


}
