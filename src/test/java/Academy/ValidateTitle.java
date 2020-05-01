package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateTitle extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initiated");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
		
	}
	
	@Test 
	public void basePageNavigation() throws IOException {
		LandingPage lp = new LandingPage(driver);
		
		//compare the text from the broswer with actual text - failed then error
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES123");
		log.info("Successfully validated the text message");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}

}
