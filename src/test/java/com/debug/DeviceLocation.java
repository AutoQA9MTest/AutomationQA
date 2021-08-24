package com.debug;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeviceLocation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// INIT CHROME OPTIONS
	    ChromeOptions options = new ChromeOptions();
	    Map < String, Object > prefs = new HashMap < String, Object > ();
	    Map < String, Object > profile = new HashMap < String, Object > ();
	    Map < String, Object > contentSettings = new HashMap < String, Object > ();

	    // SET CHROME OPTIONS
	    // 0 - Default, 1 - Allow, 2 - Block
	    contentSettings.put("geolocation", 1);
	    profile.put("managed_default_content_settings", contentSettings);
	    prefs.put("profile", profile);
	    options.setExperimentalOption("prefs", prefs);
	    DesiredCapabilities caps = new DesiredCapabilities();
	    // SET CAPABILITY
	    caps.setCapability(ChromeOptions.CAPABILITY, options);
	    WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver(caps);
	    driver.get("https://the-internet.herokuapp.com/geolocation");
	    driver.findElement(By.xpath("//*[@id='content']/div/button")).click();
	    Thread.sleep(10000);
	    driver.quit();
	}

}
