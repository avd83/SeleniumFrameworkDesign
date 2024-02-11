package abhay;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Utility.ReadXlsData;

public class ForgotPasswordTest extends BaseTest {
	
	@Test(dataProviderClass = ReadXlsData.class,dataProvider="readdata")
	public void resetPassword(String Name , String Email, CharSequence[] PhoneNumber) throws InterruptedException
	{
		/*		
		driver.findElement(By.linkText(loc.getProperty("forgot_password_link"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(loc.getProperty("Name_field"))).sendKeys(Name);
		driver.findElement(By.xpath(loc.getProperty("Email_field"))).sendKeys(Email);
		driver.findElement(By.xpath(loc.getProperty("PhoeNumbar_field"))).sendKeys(PhoneNumber);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(loc.getProperty("reset_button"))).click();
		Thread.sleep(3000);
		*/
		
		//Thread.sleep(3000);
		//driver.findElement(By.linkText("Forgot your password?")).click();
		
		ForgotPasswordPageObject fp = new ForgotPasswordPageObject(driver);
	
		fp.resetLogin(Name, Email, PhoneNumber);
				
		String message = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
		System.out.println(message);
		Thread.sleep(3000);
		Assert.assertEquals(message,"Please use temporary password 'rahulshettyacademy' to Login.");
		
	}

}
