package com.debug;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPoppup {

	public static void main(String[] args) throws InterruptedException {
		//http://the-internet.herokuapp.com/basic_auth
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Set the username
		String username = "admin";
		//Set the password
		String password = "admin";
		String URL = "https://" +username +":" +password +"@"+ "the-internet.herokuapp.com/basic_auth";
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println("The page title is "+title);
		String text = driver.findElement(By.tagName("p")).getText();
		System.out.println("The test present in page is ==> "+text);
		Thread.sleep(5000);
        driver.quit();
		

	}

}
