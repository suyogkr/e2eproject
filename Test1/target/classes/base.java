package source;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public WebDriver Openbrowser() throws IOException, FileNotFoundException
	{
		
		prop = new Properties(); 
		FileInputStream fis = new FileInputStream(new File("G:\\Test\\Test1\\src\\main\\java\\source\\property.properties"));
		prop.load(fis);
	
		if(prop.getProperty("browser").equals("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");			
			System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.get(prop.getProperty("Url"));
			
		}
		else if (prop.getProperty("browser").equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "G:\\geckodriver.exe");		
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("url"));	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return driver;

	}
}