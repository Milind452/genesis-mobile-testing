package GmailAutomation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SendMail {
	static AppiumDriver<MobileElement> driver = null;

	@Test(priority = 0)
	public void init() throws InterruptedException {
		// Set the Desired Capabilities

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("deviceName", "My Phone");

//		caps.setCapability("udid", "5c9d5660"); // Give Device ID of your mobile phone
		caps.setCapability("udid", "10.42.0.86:5555"); //Give wireless Device ID of your mobile phone

		caps.setCapability("platformName", "Android");

		caps.setCapability("platformVersion", "10.0");

		caps.setCapability("appPackage", "com.google.android.gm");
		
		caps.setCapability("appActivity", "com.google.android.gm.ConversationListActivityGmail");
		
		caps.setCapability("noReset", "true");

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}		
	}
	
//	@Test(dependsOnMethods = "init")
//	public void enterGmail() {
//		driver.findElement(By.id("com.google.android.gm:id/welcome_tour_got_it")).click();
//		driver.findElement(By.id("com.google.android.gm:id/action_done")).click();
//	}
	
	@Test(dependsOnMethods = "init")
	public void composeMail() {
		driver.findElement(By.id("com.google.android.gm:id/attachment")).click();
		
	}
}

