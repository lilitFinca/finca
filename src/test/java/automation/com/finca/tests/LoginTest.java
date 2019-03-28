package automation.com.finca.tests;
import java.io.IOException;
import java.net.MalformedURLException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import automation.com.finca.ExcelUtils;
import automation.com.finca.po.BasePO;
import automation.com.finca.po.LoginPO;
import junit.framework.Assert;


public class LoginTest {

	RemoteWebDriver driver = null;
	LoginPO loginPage = null;
	BasePO basePage= null;

	@BeforeClass
	public void setUP() throws MalformedURLException {

		loginPage = new LoginPO();
		basePage = new BasePO();
		driver = loginPage.getDriver();
	}

	@Test(dataProvider = "getData")
	public void login(String username, String password) {
		loginPage.getEnterButton().click();
		//loginPage.login(username, password);
		//Assert.assertTrue(basePage.getMenuItem().isDisplayed());
		
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		ExcelUtils utils = new ExcelUtils();
		return utils.getData("finca");
	}

}