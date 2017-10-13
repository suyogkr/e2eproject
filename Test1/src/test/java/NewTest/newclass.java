package NewTest;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObject.poHomepage;
import PageObject.poLogin;
import source.base;

public class newclass extends base {
	
	WebDriver driver;
	public static Logger log = LogManager.getLogger(Log4JLogger.class.getName());
	
	poHomepage poh1 = new poHomepage(driver);
	poLogin pol1 = new poLogin(driver);
	
	
	
	
}
