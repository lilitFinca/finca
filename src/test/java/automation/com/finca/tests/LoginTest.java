package automation.com.finca.tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automation.com.finca.Base;
import automation.com.finca.ExcelUtils;
import automation.com.finca.po.LoginPO;
import io.appium.java_client.android.AndroidDriver;

public class LoginTest {

	RemoteWebDriver driver = null;
	LoginPO loginPage = null;

	@BeforeClass
	public void setUP() throws MalformedURLException {

		loginPage = new LoginPO();
		driver = loginPage.getDriver();
	}

	@Test(dataProvider = "getData")
	public void login(String username, String password) {
		loginPage.getEnterButton().click();
		loginPage.getLoginInput().sendKeys(username);
		loginPage.getpasswordInput().sendKeys(password);
		driver.navigate().back();
		loginPage.getLoginButton().click();
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		ExcelUtils utils = new ExcelUtils();
		return utils.getData();
	}

}