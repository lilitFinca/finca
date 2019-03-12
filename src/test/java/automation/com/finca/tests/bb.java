package automation.com.finca.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automation.com.finca.Base;
import automation.com.finca.ExcelUtils;
import automation.com.finca.po.BaseTest;


public class bb  extends BaseTest{
	
	@Test
	 (dataProvider="getData")
	public void test(String username, String password) throws MalformedURLException, FileNotFoundException {
		
} 
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException{
		ExcelUtils utils = new ExcelUtils();
		return utils.getData();
	}
	
}