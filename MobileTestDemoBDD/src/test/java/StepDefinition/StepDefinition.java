package StepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

@RunWith(Cucumber.class)
public class StepDefinition {

	static AndroidDriver<AndroidElement> driver = null;
	
    @Given("^I launch the app$")
    public void ilaunch_the_app() throws Throwable {
        
        DesiredCapabilities caps = new DesiredCapabilities();
        
        // Set your access credentials
        caps.setCapability("browserstack.user", "milindmohapatra1");
        caps.setCapability("browserstack.key", "Z5VGdQxZ8Gyvk61pmwyz");
        
        // Set URL of the application under test
        caps.setCapability("app", "bs://97b48fb8a5c8c4d1941d6f3f5b713f0d94a60b63");
        
        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");
          
        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "Java Android");
        caps.setCapability("name", "first_test");
          
        
        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above

		try {
			driver = new AndroidDriver<AndroidElement>(
		              new URL("http://hub.browserstack.com/wd/hub"), caps);		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
    }

    @When("^I click on OK$")
    public void i_click_on_ok() throws Throwable {
    	driver.findElement(By.id("android:id/button1")).click();
    }

    @Then("^App should start$")
    public void app_should_start() throws Throwable {
    	String expected = "Your selection: ";
    	String actual = driver.findElement(By.id("com.somewow.radiobutton:id/text_view_selected")).getText();
    	Assert.assertEquals(actual, expected);
    }
    
    @When("^I click on One radio button$")
    public void i_click_on_one_radio_button() throws Throwable {
        driver.findElement(By.id("com.somewow.radiobutton:id/radio_one")).click();
    }

    @When("^I click on Two radio button$")
    public void i_click_on_two_radio_button() throws Throwable {
    	driver.findElement(By.id("com.somewow.radiobutton:id/radio_two")).click();
    }

    @When("^I click on Three radio button$")
    public void i_click_on_three_radio_button() throws Throwable {
    	driver.findElement(By.id("com.somewow.radiobutton:id/radio_three")).click();
    }

    @Then("^That One radio button is selected$")
    public void that_one_radio_button_is_selected() throws Throwable {
    	Assert.assertTrue(driver.findElement(By.id("com.somewow.radiobutton:id/radio_one")).isEnabled());
    }

    @Then("^That Two radio button is selected$")
    public void that_two_radio_button_is_selected() throws Throwable {
    	Assert.assertTrue(driver.findElement(By.id("com.somewow.radiobutton:id/radio_two")).isEnabled());    }

    @Then("^That Three radio button is selected$")
    public void that_three_radio_button_is_selected() throws Throwable {
    	Assert.assertTrue(driver.findElement(By.id("com.somewow.radiobutton:id/radio_three")).isEnabled());    }

    @And("^I click on apply button1$")
    public void i_click_on_apply_button1() throws Throwable {
    	driver.findElement(By.id("com.somewow.radiobutton:id/button_apply")).click();
    }

    @And("^Your choice: 0 is displayed$")
    public void your_choice_0_is_displayed() throws Throwable {
    	String expected = "Your choice: 0";
    	String actual = driver.findElement(By.id("com.somewow.radiobutton:id/text_view_selected")).getText();
    	Assert.assertEquals(actual, expected);
    }

    @And("^I click on apply button2$")
    public void i_click_on_apply_button2() throws Throwable {
    	driver.findElement(By.id("com.somewow.radiobutton:id/button_apply")).click();
    }

    @And("^Your choice: 124 is displayed$")
    public void your_choice_124_is_displayed() throws Throwable {
    	String expected = "Your choice: 88";
    	String actual = driver.findElement(By.id("com.somewow.radiobutton:id/text_view_selected")).getText();
    	Assert.assertEquals(actual, expected);
    }

    @And("^I click on apply button3$")
    public void i_click_on_apply_button3() throws Throwable {
    	driver.findElement(By.id("com.somewow.radiobutton:id/button_apply")).click();
    }

    @And("^Your choice: 224 is displayed$")
    public void your_choice_224_is_displayed() throws Throwable {
    	String expected = "Your choice: 176";
    	String actual = driver.findElement(By.id("com.somewow.radiobutton:id/text_view_selected")).getText();
    	Assert.assertEquals(actual, expected);
    }

}