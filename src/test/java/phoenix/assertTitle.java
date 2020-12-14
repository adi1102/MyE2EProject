package phoenix;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.LandingPage;
import resources.base;

public class assertTitle extends base {
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeMethod
	public void initialize() throws IOException{
		
		driver = initializeDriver();
		log.info("Initializing the Driver");
		driver.get(prop.getProperty("URL"));
		log.info("Got URL from Property");
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.close();
	}
	@Test
	public void basePageNavigation() throws IOException{
		
		// two ways of accessing functions -> 
		//inheritance and creating object
		LandingPage landingpage = new LandingPage(driver);
		Assert.assertEquals(landingpage.getTitle().getText(),"Fesatured Courses");
		log.info("Featured Courses is present");
		Assert.assertTrue(landingpage.getHome().isDisplayed());
		log.info("Home is present");
		
		
	}
	
	
	}

