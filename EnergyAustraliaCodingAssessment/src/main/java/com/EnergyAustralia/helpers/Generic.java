package com.EnergyAustralia.helpers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;

public class Generic {

	 public static AndroidDriver<AndroidElement> driver =null;

	@BeforeClass
	public void setUp() throws MalformedURLException {
    
		// Setting the necessary properties to open App in Emulator Virtual Device
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "pixel_xl");
		capabilities.setCapability("appPackage", "com.energyaustralia.codingtestsample");
		capabilities.setCapability("appActivity", ".MainActivity");
		capabilities.setCapability("appium:ensureWebviewsHavePages", true);
		capabilities.setCapability("appium:nativeWebScreenshot", true);
		capabilities.setCapability("appium:newCommandTimeout", 3600);
		capabilities.setCapability("appium:connectHardwareKeyboard", true);

		// Appium Server URL
		URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

		//Initializing the android driver
		driver = new AndroidDriver<AndroidElement>(remoteUrl, capabilities);

		//Implicit timeout
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterClass
	public void tearDown() {
		//Closing the driver
		driver.quit();
	}

}
