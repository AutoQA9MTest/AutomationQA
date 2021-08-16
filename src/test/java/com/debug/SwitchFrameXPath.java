package com.debug;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchFrameXPath {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Frames.html");
		//Switch Frame by XPath
		WebElement elem=driver.findElement(By.xpath("//iframe[@id='singleframe']"));
		driver.switchTo().frame(elem);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Automation");
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[normalize-space()='WebTable']")).click();
		Thread.sleep(10000);
		driver.quit();

	}

}
