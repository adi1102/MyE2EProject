package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By signin = By.cssSelector("a[href*='sign_in']");
	By title  = By.xpath("/html/body/app-root/div/app-home/div/section[2]/div[1]/div[1]/div[1]/h2");
	By homelink = By.linkText("Home");	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getLogin(){
		
		return driver.findElement(signin);
	}
	public WebElement getTitle(){
		
		return driver.findElement(title);
	}
	public WebElement getHome(){
		
		return driver.findElement(homelink);
	}
}
