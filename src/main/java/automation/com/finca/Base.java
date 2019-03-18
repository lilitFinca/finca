package automation.com.finca;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {
	RemoteWebDriver driver = null;

	public DesiredCapabilities getCapability() throws MalformedURLException {
		File f = new File(Constants.FILE_PATH);
		System.out.println("filepath:+"+f);
		File fs = new File(f, Constants.APK_NAME);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "appium");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		System.out.println(cap);
		return cap;

	}
	
	
	public RemoteWebDriver initDriver() throws MalformedURLException{
		DesiredCapabilities cap = getCapability();
	    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	    driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.SECONDS);
	    return driver;
	} 
}
