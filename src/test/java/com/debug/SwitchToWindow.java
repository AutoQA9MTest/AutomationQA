package com.debug;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToWindow {

	public static void main(String[] args) throws InterruptedException {
		//Sample Click on OK Alert
		//Browser-Invoking-Chrome
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Windows.html");
		String mainWindowHandle = driver.getWindowHandle();
		System.out.println("Window handle Bas==> "+mainWindowHandle);
		By loc=By.xpath("//div[@id='Tabbed']//a");
		driver.findElement(loc).click();
		Thread.sleep(5000);
		String title1=driver.getTitle();
		System.out.println(title1);
		 //Get handles of the windows 
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            System.out.println("child window ==> "+ChildWindow);
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
            }
        }
        String title2=driver.getTitle();
		System.out.println(title2);
		driver.close();
		driver.switchTo().window(mainWindowHandle);
		String title3=driver.getTitle();
		System.out.println(title3);
		
    }
}
