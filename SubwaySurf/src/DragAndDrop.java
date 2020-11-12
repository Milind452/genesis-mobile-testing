import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;

public class DragAndDrop {
	static AppiumDriver<MobileElement> driver = null;

	@BeforeMethod
	@Test()
	public void init() {
		// Set the Desired Capabilities

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("deviceName", "My Phone");

		caps.setCapability("udid", "5c9d5660"); // Give Device ID of your mobile phone

		caps.setCapability("platformName", "Android");

		caps.setCapability("platformVersion", "10.0");

		caps.setCapability("app",
				"/home/milind/Downloads/Drag Drop Multiple domains for awesome brains_v5_apkpure.com.apk");

		caps.setCapability("noReset", "true");

		// Instantiate Appium Driver

		try {

			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

		} catch (MalformedURLException e) {

			System.out.println(e.getMessage());

		}
	}

	@Test()
	public void clickOnFootballThenDrag() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("dragdrop.stufflex.com.dragdrop:id/btn_football")).click();

		Thread.sleep(5000);
		WebElement source = driver.findElement(By.id("dragdrop.stufflex.com.dragdrop:id/chooseB"));
		WebElement target = driver.findElement(By.id("dragdrop.stufflex.com.dragdrop:id/answer"));
		
		TouchAction action = new TouchAction((MobileDriver) driver);
		action.longPress(ElementOption.element(source)).moveTo(ElementOption.element(target)).release().perform();
//		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test()
	public void clickOnLiteratureThenDrag() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("dragdrop.stufflex.com.dragdrop:id/btn_literature")).click();

		Thread.sleep(5000);
		WebElement source = driver.findElement(By.id("dragdrop.stufflex.com.dragdrop:id/chooseA"));
		WebElement target = driver.findElement(By.id("dragdrop.stufflex.com.dragdrop:id/answer"));
		
		TouchAction action = new TouchAction((MobileDriver) driver);
		action.longPress(ElementOption.element(source)).moveTo(ElementOption.element(target)).release().perform();
//		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
//	
//	@Test()
//	public void clickOnMythologyThenDrag() throws InterruptedException {
//		Thread.sleep(5000);
//		driver.findElement(By.id("dragdrop.stufflex.com.dragdrop:id/btn_mythology")).click();
//
//		Thread.sleep(5000);
//		WebElement source = driver.findElement(By.id("dragdrop.stufflex.com.dragdrop:id/chooseA"));
//		WebElement target = driver.findElement(By.id("dragdrop.stufflex.com.dragdrop:id/answer"));
//		
//		TouchAction action = new TouchAction((MobileDriver) driver);
//		action.longPress(ElementOption.element(source)).moveTo(ElementOption.element(target)).release().perform();
//		Thread.sleep(5000);
//	}
//	
//	@Test()
//	public void clickOnWorldCapitalsThenDrag() throws InterruptedException {
//		Thread.sleep(5000);
//		driver.findElement(By.id("dragdrop.stufflex.com.dragdrop:id/btn_world_capitals")).click();
//
//		Thread.sleep(5000);
//		WebElement source = driver.findElement(By.id("dragdrop.stufflex.com.dragdrop:id/chooseB"));
//		WebElement target = driver.findElement(By.id("dragdrop.stufflex.com.dragdrop:id/answer"));
//		
//		TouchAction action = new TouchAction((MobileDriver) driver);
//		action.longPress(ElementOption.element(source)).moveTo(ElementOption.element(target)).release().perform();
//		Thread.sleep(5000);
//	}
}















