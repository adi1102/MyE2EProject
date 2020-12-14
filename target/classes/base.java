package resources;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	private org.openqa.selenium.OutputType<File> OutputType;

	public WebDriver initializeDriver() throws IOException{
		
		prop = new Properties ();
		FileInputStream fis = new FileInputStream("C:\\Framework\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "C:\\Programming Softwares\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.gecko.driver", "C:\\Applications\\chromedriver_win32\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browsername == "IE"){
			
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenShotPath(String testcaseName, WebDriver driver) throws IOException{
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\abc.png"; 
		FileUtils.copyFile(source,new File(destinationFile));
		
		}
	}
