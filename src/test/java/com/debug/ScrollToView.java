package com.debug;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollToView {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Register.html");
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		 //To generate Alert window using JavascriptExecutor. Display the alert message 	
		WebElement elem=driver.findElement(By.xpath("//button[normalize-space()='Refresh']"));
        js.executeScript("arguments[0].scrollIntoView(true);",elem);  
        Thread.sleep(5000);
        driver.quit();
	}

	
}
