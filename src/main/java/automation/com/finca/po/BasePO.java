package automation.com.finca.po;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.com.finca.Base;

public class BasePO {
	private RemoteWebDriver driver=null;
	
	public BasePO() throws MalformedURLException {
		Base base = new Base();
		driver=base.initDriver();
		PageFactory.initElements(this.driver, this);
	
	}
	
	@FindBy(xpath="//*[@resource-id='com.xtech.dev.fincaandroid:id/open_drawer']")
	private WebElement menuItem;
	
	public WebElement getMenuItem() {
		return menuItem;
	}

}
