package abhay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOutPageObject  {
	
	public WebDriver driver;
	
	public  LoginOutPageObject(WebDriver driver)
	{
		super();
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="inputUsername")
	WebElement username;
	
	@FindBy (css="input[placeholder='Password']")
	WebElement passwordEle;
	
	@FindBy (xpath="//button[@class='submit signInBtn']")
	WebElement signin;
	
	@FindBy (css=".logout-btn")
	WebElement signout;
	
	@FindBy (css=".error")
	WebElement errormessage;
	
	public void Login1(String name, String pass) 
	{
		username.sendKeys(name);
		passwordEle.sendKeys(pass);
		signin.click();
	}
	
	public String getErrorMessage() throws InterruptedException
	{
		Thread.sleep(4000);
		return errormessage.getText();
	}
	
	public void Logout()
	{
		signout.click();
	}

}
