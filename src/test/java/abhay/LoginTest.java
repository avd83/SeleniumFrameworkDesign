package abhay;

import org.testng.annotations.Test;

import Base.BaseTest;
import Utility.ReadXlsData;

public class LoginTest extends BaseTest {

	@Test(dataProviderClass = ReadXlsData.class,dataProvider="readdata")
	public void Login(String username,String password) throws InterruptedException{
					
		LoginOutPageObject t = new LoginOutPageObject(driver);
		t.Login1(username, password);
		Thread.sleep(4000);
		t.Logout();
		
		/*
		driver.findElement(By.id(loc.getProperty("userName_field"))).sendKeys(username);
		driver.findElement(By.cssSelector(loc.getProperty("password_field"))).sendKeys(password);
		driver.findElement(By.xpath(loc.getProperty("signin_button"))).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector(loc.getProperty("signout_button"))).click();
		*/
	}

}
