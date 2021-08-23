package com.debug;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CameraAccess {

	public static void main(String[] args) throws InterruptedException {
		//Configure ChromeOptions to pass fake media stream
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("use-fake-device-for-media-stream");
	    options.addArguments("use-fake-ui-for-media-stream");

	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability(ChromeOptions.CAPABILITY, options);
	    WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver(caps);
	    //WebCam Test
	    driver.get("https://webcamtests.com/check");
	    Thread.sleep(5000);
	    driver.findElement(By.id("webcam-launcher")).click();
	    Thread.sleep(5000);

	    //Mic Test
	    driver.get("https://www.vidyard.com/mic-test/");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//a[@id='start-test']")).click();
	    Thread.sleep(5000);

	    driver.quit();

	}

}
