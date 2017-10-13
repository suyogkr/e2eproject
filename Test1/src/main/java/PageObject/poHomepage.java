package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class poHomepage {
	
	WebDriver driver;
	
	public poHomepage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By login = By.cssSelector(".btn.btn-primary");
	
	
	public WebElement login()
	{
		return driver.findElement(login);
	}
	
	
}