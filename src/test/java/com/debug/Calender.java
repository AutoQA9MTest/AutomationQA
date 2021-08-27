package com.debug;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/datepicker/#date%E2%88%92range");
		driver.switchTo().frame(0);
		 //identify element
	      WebElement e = driver.findElement(By.id("datepicker"));
	      e.click();
	      Thread.sleep(5000);
	      //identify elements with td tag in list
	      List<WebElement> d =driver.findElements(By.xpath("//table/tbody/tr/td"));
	      //iterate list
	      for (int i = 0; i<d.size(); i++) {
	         //check expected data
	         String s = d.get(i).getText();
	         if (s.equals("2")) {
	            d.get(i).click();
	            break;
	         }
	      }
	      //get data selected
	      String m = e.getAttribute("value");
	      System.out.print("Date selected in calendar is: "+ m);
	}

}
