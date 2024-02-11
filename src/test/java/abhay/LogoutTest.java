package abhay;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Base.BaseTest;

public class LogoutTest extends BaseTest {

	@Test
	public void logOut() throws InterruptedException
	{
			
		driver.findElement(By.id("inputUsername")).sendKeys("pad@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		
		Thread.sleep(3000);
		//String loginMessage = driver.findElement(By.xpath("//div[@class='login-container']")).getText();
		//System.out.println(loginMessage);
		//Thread.sleep(3000);
		//Assert.assertEquals(loginMessage,"Hello pad@gmail.com,\r\n"	+ "Welcome to Rahul Shetty Academy\r\n"+ "You are successfully logged in.\r\n");
		driver.findElement(By.cssSelector(".logout-btn")).click();
		Thread.sleep(3000);
						
	}
}
