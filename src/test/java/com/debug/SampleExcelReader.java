package com.debug;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.utilities.ExcelReader;
import com.qa.utilities.FileUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleExcelReader {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		for(int i=1;i<=5;i++)
		{
				UserInput objData=UserInput.fnGetUserDetails(i);
				fnEnterUserData(objData);
				WebDriverManager.chromedriver().setup();
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("http://demo.automationtesting.in/Register.html");
				driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(objData.FirstName);
				driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(objData.LastName);
				Thread.sleep(10000);
				driver.quit();
		}
		
		
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
