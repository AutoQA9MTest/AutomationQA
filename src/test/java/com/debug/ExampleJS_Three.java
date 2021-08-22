package com.debug;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExampleJS_Three {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Windows.html");
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		WebElement elem=driver.findElement(By.xpath("//*[@id='Tabbed']/a/button"));
		//Perform Click on LOGIN button using JavascriptExecutor		
        js.executeScript("arguments[0].click();", elem);
        Thread.sleep(5000);
        driver.quit();
	}

}
