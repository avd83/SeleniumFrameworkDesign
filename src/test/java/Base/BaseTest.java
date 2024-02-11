package Base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public  WebDriver driver;
	public  Properties prop = new Properties() ;
	public  Properties loc = new Properties() ;
	public  FileReader fr;
	public  FileReader fr1;
	
	@BeforeTest
	public void setUp() throws IOException, InterruptedException {
		
		if(driver==null)
		{
		FileReader fr= new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\Configfiles\\config.properties");
		prop.load(fr);
		//FileReader fr1= new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\Configfiles\\Locators.properties");
		//loc.load(fr1);
		}
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		} 
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("testurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		}
	
	public String getScreenShort(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") +"//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") +"//reports//" + testCaseName + ".png";
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		System.out.println("Tear Down");
		
	}
	

}
