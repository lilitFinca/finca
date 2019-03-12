package automation.com.finca.po;


import java.net.MalformedURLException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.com.finca.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
	RemoteWebDriver driver=null;
	@BeforeTest
	public void setUP() throws MalformedURLException {

		Base base = new Base();
		driver=  base.initDriver();
		
	}
	
	@Test
	public void login() {
		driver.findElement(By.xpath("//*[@class='android.widget.Button']")).click();
		System.out.println("passed");

}
}