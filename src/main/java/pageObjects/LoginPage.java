package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class LoginPage {
	
	public WebDriver driver;
	
	By username = By.xpath("//*[@id='user_email']");
	By password = By.xpath("//*[@id='user_password']");
	By login = By.xpath("//*[@id='new_user']/div[3]/input");
			
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement putUsername() {
		return driver.findElement(username);
	}
	
	public WebElement putPassword() {
		return driver.findElement(password);
	}
	
	public WebElement putLogin() {
		return driver.findElement(login);
	}

}
