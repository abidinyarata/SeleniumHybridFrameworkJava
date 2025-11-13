package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.text.RandomStringGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties configProp;
	
	@BeforeClass(groups= {"Master", "Sanity", "Regression"})
	@Parameters({"os", "browser"})
	public void setup(String os, String browser) throws IOException
	{
		//loading properties file
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		configProp = new Properties();
		configProp.load(file);
		
		//loading log4j file
		logger = LogManager.getLogger(this.getClass());
		
		//launching browser based on condition
		switch (browser.toLowerCase()) {
		case "chrome": 
			driver = new ChromeDriver();
			break;
		case "edge": 
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("No matching browser....");
			return;
		}	
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(configProp.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Master", "Sanity", "Regression"})
	public void tearDown()
	{
		driver.close();
	}
	
	private String randomGenerator(int length, char minCodePoint, char maxCodePoint)
	{
		RandomStringGenerator generator = new RandomStringGenerator.Builder()
				.withinRange(minCodePoint, maxCodePoint).get();
		
		return generator.generate(length);
	}
	
	public String randomString(int length)
	{		
		return randomGenerator(length, 'a', 'z');
	}
	
	public String randomNumber(int length)
	{
		return randomGenerator(length, '0', '9');
	}
	
	public String randomAlphaNumeric()
	{
		return randomString(3) + randomNumber(3);
	}
	
	public String capitalize(String text)
	{
		return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
	}
	
	public String captureScreen(String testName) throws IOException 
	{
		String currentDatetimeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + testName + "_" + currentDatetimeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;
	}
}