package phoenix;

import java.io.IOException;
import java.util.logging.Logger;

import org.testng.annotations.*;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public static Logger log = Logger.getLogger(base.class.getName());
	@BeforeMethod
	public void initialize() throws IOException{
		
		driver = initializeDriver();
		driver.get(prop.getProperty("URL"));		
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password) throws IOException{
		
		// two ways of accessing functions -> 
		//inheritance and creating object
		LandingPage landingpage = new LandingPage(driver);
		landingpage.getLogin().click();
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.getEmail().sendKeys(username);
		loginpage.getPassword().sendKeys(password);
		loginpage.getLoginButton().click();
		
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.close();
		
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		
		data[0][0] = "abc@xyz.com";
		data[0][1] = "abc@xy123";
		
		data[1][0] = "abc@xvz.com";
		data[1][1] = "abc@xv123";
		
		return data;
	}
}
