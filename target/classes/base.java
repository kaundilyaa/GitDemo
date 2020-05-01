package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class base {

	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\nikhil\\E2EProject\\src\\main\\java\\resources\\global.properties");

		prop.load(fis);
		String browswerName = prop.getProperty("browser");

		if (browswerName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\nikhil\\Desktop\\Automation\\software\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browswerName == "firefox") {

			// firefox code

		} else if (browswerName == "internetexplorer") {
			// ie code
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
	
	public void getScreenShot(String result) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src, new File("C://test//screenshot.png"));
		Files.copy(src, new File("C://test//"+result+"_screenshot.png"));
	}

}
