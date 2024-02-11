package abhay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPageObject {

	public WebDriver driver;
	
	public  ForgotPasswordPageObject(WebDriver driver) 
	{
		super();
		this.driver=driver;	
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(linkText="Forgot your password?")
	WebElement fyp;
	
	@FindBy (xpath="//input[@placeholder='Name']")
	WebElement name;
	
	@FindBy (xpath="//input[@placeholder='Email']")
	WebElement email;
	
	@FindBy (xpath="//input[@placeholder='Phone Number']")
	WebElement pNumber;
	
	@FindBy (css=".reset-pwd-btn")
	WebElement resetbutton;
	
	
	public void resetLogin(String Name,String Email, CharSequence[] number) throws InterruptedException
	{
		Thread.sleep(3000);
		fyp.click();
		Thread.sleep(3000);
		name.sendKeys(Name);
		email.sendKeys(Email);
		pNumber.sendKeys(number);
		Thread.sleep(4000);
		resetbutton.click();
	}

}
