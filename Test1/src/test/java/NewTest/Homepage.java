package NewTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import PageObject.poHomepage;
import PageObject.poLogin;
import source.base;

public class Homepage extends base 
{
	
	WebDriver driver;
	public static Logger log=LogManager.getLogger(Log4JLogger.class.getName());

	@Test
	public void accessHomepage() throws FileNotFoundException, IOException
	{
		try
		{
			log.info("Opening browser for Homepage");
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
				System.out.println("window name" + sLogWindow);
				driver.switchTo().window(sLogWindow);
				poLogin pol =new poLogin(driver);
				pol.email().sendKeys("gmail@gmail.com");
				pol.password().sendKeys("gmail123");
				pol.loginbtn().click();				
			}
			
			log.debug("Login successfull");
			driver.quit();
		}catch(Exception e)
			{
				log.error(e);
				log.info("Test Case Failed");
			}finally 
			{
				log.info("Test Case Homepage completed");
				//driver.quit();
			} 


	}
}
