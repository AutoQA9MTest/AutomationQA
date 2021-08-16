package com.debug;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchrameInsideFrame {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Frames.html");
		//Switch Frame by XPath
		driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']")).click();
		WebElement elem=driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(elem);
		WebElement elemInside=driver.findElement(By.xpath("//iframe[normalize-space()='<p>Your browser does not support iframes.</p>']"));
		driver.switchTo().frame(elemInside);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Automation");
		Thread.sleep(10000);
		//driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//a[normalize-space()='WebTable']")).click();
		Thread.sleep(10000);
		driver.quit();

	}

}
