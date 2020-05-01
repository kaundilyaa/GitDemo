package Academy;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("loginurl"));
	}
	
	@Test (dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException {
		//LandingPage lp = new LandingPage(driver);
		//lp.getLogin().click();
		
		LoginPage l = new LoginPage(driver);
		l.putLogin().sendKeys(username);
		l.putPassword().sendKeys(password);
		System.out.println(text);
		l.putLogin().click();
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}
	
	@DataProvider
	public Object[][] getData() {
		//rows stands for how many different data, for username and password 2 size
		//columns stands for how many values for each test
		Object[][] data = new Object[2][3];
		//oth row
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted User";
		
		//1st row
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "456789";
		data[1][2] = "Non Restricted User";
		
		return data;
	}
	


}
