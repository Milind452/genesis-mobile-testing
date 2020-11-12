package Demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LoginRegistration {

	static AppiumDriver<MobileElement> driver = null;

	@Test(priority = 0)
	public void init() {
		// Set the Desired Capabilities

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("deviceName", "My Phone");

		caps.setCapability("udid", "5c9d5660"); // Give Device ID of your mobile phone

		caps.setCapability("platformName", "Android");

		caps.setCapability("platformVersion", "10.0");

		caps.setCapability("app", "/home/milind/Downloads/Login Registration Example_v3.0_apkpure.com.apk");

		caps.setCapability("noReset", "true");

		// Instantiate Appium Driver

		try {

			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

		} catch (MalformedURLException e) {

			System.out.println(e.getMessage());

		}
	}
	
	@Test(dependsOnMethods = "init", priority = 1)
	public void register() throws InterruptedException {
		driver.navigate().back();
		driver.findElement(By.id("com.appsgallery.sagar.loginregistrationexample:id/register")).click();
		driver.findElement(By.id("com.appsgallery.sagar.loginregistrationexample:id/editTextUserName")).sendKeys("Milind4526");
		driver.findElement(By.id("com.appsgallery.sagar.loginregistrationexample:id/editTextPassword")).sendKeys("milind11");
		driver.findElement(By.id("com.appsgallery.sagar.loginregistrationexample:id/editTextConfirmPassword")).sendKeys("milind11");
		driver.findElement(By.id("com.appsgallery.sagar.loginregistrationexample:id/buttonCreateAccount")).click();
		driver.navigate().back();
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = "register", priority = 2)
	public void login() throws InterruptedException {
		driver.navigate().back();
		driver.findElement(By.id("com.appsgallery.sagar.loginregistrationexample:id/editLogin")).sendKeys("Milind4526");
		driver.findElement(By.id("com.appsgallery.sagar.loginregistrationexample:id/editPasswordLogin")).sendKeys("milind11");
		driver.findElement(By.id("com.appsgallery.sagar.loginregistrationexample:id/login")).click();
		driver.findElement(By.id("com.appsgallery.sagar.loginregistrationexample:id/login")).click();
	}
}

