package NewTest;

import static org.testng.Assert.assertEquals;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tools.ant.taskdefs.WaitFor.Unit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import PageObject.poEditProfile;
import PageObject.poHomepage;
import PageObject.poLogin;
import source.base;

public class EditProfile extends base {
	
	WebDriver driver;
	public static Logger  log = LogManager.getLogger(Log4JLogger.class.getName());
	
	@Test
	public void accessEditProfile()
	{
		
		try {
			
		log.info("Opening browser for EditProfile");
			driver = Openbrowser();
			driver.manage().window().maximize();
			
			poHomepage poh = new poHomepage(driver);		
			
			log.info("handling parent window");
			//checking windows before new popup. parent window
			Set<String> beforelogpop = driver.getWindowHandles();
			
			log.info("handling child window");
			// click login to invoke popup
			poh.login().click();
			
			Set<String> afterlogpop = driver.getWindowHandles();
			
			log.info("removing parent window");
			afterlogpop.removeAll(beforelogpop);
			
			log.info("logging in");
			if (afterlogpop.size() ==1)
			{
				String sLogWindow = afterlogpop.toArray()[0].toString();
				//System.out.println("window name" + sLogWindow);
				driver.switchTo().window(sLogWindow);
				poLogin pol =new poLogin(driver);
				pol.email().sendKeys("gmail@gmail.com");
				pol.password().sendKeys("gmail123");
				pol.loginbtn().click();	
				driver.manage().window().maximize();
				
				poEditProfile poef = new poEditProfile(driver);				
				log.info("Click on profile icon");
				poef.imageclick().click();
				
				log.info("Click on profile link");
				poef.profileLinkclick().click();
			
				if(!poef.NotifyOnCommentClick().isSelected())
				{
					log.info("Check the checkbox");				
					poef.NotifyOnCommentClick().click();
					log.info("Check the checkbox DONE");
				}
				
				/*driver.findElement(By.cssSelector("#edit-user-submit")).click();
				String message = driver.findElement(By.id("form-success")).getText();*/
				
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
				//driver.wait(10);
				driver.findElement(By.cssSelector("#edit-user-submit")).click();
				//poef.ProfileChangeSubmitClick().click();
				String message = poef.UpdateMessage().getText();
				System.out.println(message);
				log.debug("Varifying the profile update message");
				assertEquals(message, "Your profile has been updated.");
				
				log.debug("Verified the profile update message Successfully");
			
			}					
			
		}catch(Exception e ) {
			log.error(e);			
			log.debug("Test Case EditProfile Failed");
		}finally {	
			log.info("Test Case EditProfile completed");
		}
		
	}
}
