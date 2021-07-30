package com.debug;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleAlert {

	public static void main(String[] args) throws InterruptedException {
		//Sample Click on OK Alert
				//Browser-Invoking-Chrome
				WebDriverManager.chromedriver().setup();
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("http://demo.automationtesting.in/Alerts.html");
				By loc=By.xpath("//button[contains(text(),'click the button to display an')]");
				driver.findElement(loc).click();
				Thread.sleep(10000);
				Alert objAlert=driver.switchTo().alert();
				//To Get Text on the Alert
				String strText=objAlert.getText();
				System.out.println(strText);
				objAlert.accept();
				Thread.sleep(5000);
				driver.quit();

	}

}
