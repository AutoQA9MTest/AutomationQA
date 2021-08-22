package com.debug;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExampleJS_Four {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Register.html");
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		WebElement elem=driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]"));
		//Perform Type using JavascriptExecutor		
        js.executeScript("arguments[0].value='Automation'", elem);  
        Thread.sleep(5000);
        //Get the value using JavaScript Executer
        String text = (String) js.executeScript("return arguments[0].value", elem);  
        System.out.println(text);  
        Thread.sleep(5000);
        driver.quit();
        
	}

}
