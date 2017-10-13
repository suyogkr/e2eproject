package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class poEditProfile {
	
	WebDriver driver;
	
	public poEditProfile(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	By image = By.cssSelector(".gravatar");
	By profilelink = By.linkText("Edit Profile");
	//By NotifyOnComment = By.name("preference_attributes[comment_on_participating_thread]");
	By NotifyOnComment = By.xpath(".//*[@id='profile-form']/div[8]/div/div[2]/label/input[2]");
	//By ProfileChangeSubmit = By.id("edit-user-submit");
	By ProfileChangeSubmit = By.cssSelector("#edit-user-submit");
	By UpdateMessage = By.id("form-success");
	
	
	public WebElement imageclick()
	{
		return driver.findElement(image);		
	}
	
	public WebElement profileLinkclick()
	{
		return driver.findElement(profilelink);		
	}
	
	public WebElement NotifyOnCommentClick()
	{
		return driver.findElement(NotifyOnComment);
	}
	
	/*public WebElement NotifyOnCommentCheck()
	{
		return (WebElement) driver.findElements(NotifyOnComment);
	}*/
	
	public WebElement ProfileChangeSubmitClick()
	{
		return driver.findElement(ProfileChangeSubmit);
	}
	
	public WebElement UpdateMessage()
	{
		return driver.findElement(UpdateMessage);
	}
	
	
}
