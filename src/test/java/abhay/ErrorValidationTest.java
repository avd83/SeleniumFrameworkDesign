package abhay;

import org.testng.Assert;
import org.testng.annotations.Test;
import Base.BaseTest;
import Utility.ReadXlsData;
import Utility.Retry;

public class ErrorValidationTest extends BaseTest {
	
		@Test(dataProviderClass = ReadXlsData.class,dataProvider="readdata",
				groups={"ErrorHandling"},retryAnalyzer= Retry.class)
		public void loginErrorValidation(String name,String password) throws InterruptedException 
	{
			
			LoginOutPageObject lp = new LoginOutPageObject(driver);
			lp.Login1(name,password);
			Assert.assertEquals(lp.getErrorMessage()," Incorrect username or password");
	}
		
}


