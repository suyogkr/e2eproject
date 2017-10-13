package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class poLogin {
	WebDriver driver; 
	
	public poLogin(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//By email = By.id("user_email");
	By email = By.xpath("//*[@id='user_email']");
	By password = By.id("user_password");
	By loginbtn = By.name("commit");
	
	public WebElement email()
	{
		return driver.findElement(email);		
	}
	public WebElement password()
	{
		return driver.findElement(password);		
	}
	public WebElement loginbtn()
	{
		return driver.findElement(loginbtn);
	}
	
	
	
}
