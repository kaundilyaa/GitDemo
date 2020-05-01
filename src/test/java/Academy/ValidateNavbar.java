package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateNavbar extends base{
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@Test 
	public void basePageNavigation() throws IOException {
		
		LandingPage lp = new LandingPage(driver);
		
		//compare the text from the broswer with actual text - failed then error
		
		Assert.assertTrue(lp.getNavbar().isDisplayed());		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}

}
