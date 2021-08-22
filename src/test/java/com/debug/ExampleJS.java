package com.debug;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExampleJS {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Register.html");
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		//Fetching the Domain Name of the site. 
		String DomainName = js.executeScript("return document.domain;").toString();			
        System.out.println("Domain name of the site = "+DomainName);	
        //Fetching the URL of the site.	
        String url = js.executeScript("return document.URL;").toString();			
        System.out.println("URL of the site = "+url);	
        //Method document.title fetch the Title name of the site.	
        String TitleName = js.executeScript("return document.title;").toString();			
        System.out.println("Title of the page = "+TitleName);	
        Thread.sleep(5000);
        //Navigate to new Page i.e to generate access page. (launch new url)		
        js.executeScript("window.location = 'https://www.google.com/'");	
        Thread.sleep(5000);
        driver.quit();
	}

}
