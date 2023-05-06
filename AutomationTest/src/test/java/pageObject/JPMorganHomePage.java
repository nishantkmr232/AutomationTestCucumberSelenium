package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JPMorganHomePage {

	WebDriver driver;
	
	By logoText =By.xpath("//div[contains(@class,'logo-desktop')]//a/img[@class=\"first-logo\"]");

	public JPMorganHomePage(WebDriver driver){
		
		this.driver=driver;
	}
	
	public Boolean verifyLogo(){
		Boolean res=driver.findElement(logoText).isDisplayed();
		return res;
	}
}
