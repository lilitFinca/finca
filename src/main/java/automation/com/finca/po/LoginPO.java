package automation.com.finca.po;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.com.finca.Base;

public class LoginPO {
	private RemoteWebDriver driver=null;
	
	public LoginPO() throws MalformedURLException {
		Base base = new Base();
		driver=base.initDriver();
		PageFactory.initElements(this.driver, this);
	
	}
	
	@FindBy(xpath="//*[@class='android.widget.Button']")
	private WebElement enterButton;
	
	@FindBy(xpath="//*[@resource-id='com.xtech.dev.fincaandroid:id/edittext_user_name']")
	private WebElement loginInput;
	
	@FindBy(xpath="//*[@resource-id='com.xtech.dev.fincaandroid:id/edittext_password']")
	private WebElement passwordInput;
	
	@FindBy(xpath="//*[@resource-id='com.xtech.dev.fincaandroid:id/bnt_login']")
	private WebElement loginButton;
	
	public WebElement getEnterButton() {
		return enterButton;		
	}
	
	public WebElement getLoginInput() {
		return loginInput;	
	}
	
	public WebElement getpasswordInput() {
		return passwordInput;	
	}
	
	public WebElement getLoginButton() {
		return loginButton;	
	}
	public RemoteWebDriver getDriver() {
		return driver;
	}
	
	public void login(String email, String password) {
		getLoginInput().sendKeys(email);
		getpasswordInput().sendKeys(password);
		getDriver().navigate().back();
		getLoginButton().click();
	}
	
	

}
