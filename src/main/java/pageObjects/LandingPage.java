package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class LandingPage {
	
	public WebDriver driver;
	
	By signin= By.xpath("//*[@id='homepage']/header/div[1]/div/nav/ul/li[4]/a/span");
	By title= By.cssSelector(".text-center>h2");
	By navbar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getLogin() {
		return driver.findElement(signin);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavbar() {
		return driver.findElement(navbar);
	}

}
