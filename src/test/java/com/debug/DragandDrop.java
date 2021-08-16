package com.debug;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");
		Thread.sleep(10000);
		WebElement elem=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement elemFinal=driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions actions=new Actions(driver);
		actions.clickAndHold(elem).dragAndDrop(elem, elemFinal).build().perform();
		

	}

}
