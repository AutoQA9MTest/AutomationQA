package com.debug;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExampleJS_Two {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Windows.html");
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		 //To generate Alert window using JavascriptExecutor. Display the alert message 			
        js.executeScript("alert('Automation with Selenium ');");   
        Thread.sleep(5000);
        driver.quit();
	}

}
