package com.debug;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchFrameIndex {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Frames.html");
		//Switch Frame by index
		//driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Automation");
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[normalize-space()='WebTable']")).click();
		Thread.sleep(10000);
		driver.quit();

	}

}
