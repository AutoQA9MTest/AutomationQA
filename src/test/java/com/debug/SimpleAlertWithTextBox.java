package com.debug;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleAlertWithTextBox {

	public static void main(String[] args) throws InterruptedException {
		//SimpleAlertWithTextBox
		//Browser-Invoking-Chrome
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Alerts.html");
		By loc=By.xpath("//a[normalize-space()='Alert with Textbox']");
		driver.findElement(loc).click();
		Thread.sleep(5000);
		By locbutton=By.xpath("//button[normalize-space()='click the button to demonstrate the prompt box']");
		driver.findElement(locbutton).click();
		Thread.sleep(10000);
		Alert objAlert=driver.switchTo().alert();
		objAlert.sendKeys("Pankaj");
		Thread.sleep(10000);
		objAlert.accept();
		Thread.sleep(5000);
		By locmessage=By.xpath("//div[@id='Textbox']//p");
		String strMessage=driver.findElement(locmessage).getText();
		System.out.println(strMessage);
		driver.quit();
		
	}

}
