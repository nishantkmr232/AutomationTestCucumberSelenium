package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GooglePage {

	WebDriver driver;

	By searchTextBox =By.name("q");
	By resultsLink = By.xpath("(//h3[text()=\"J.P. Morgan | Official Website\"]/parent::a)[1]");
    
	public GooglePage(WebDriver driver){
		
		this.driver=driver;
	}
	
	public void enterSearchText(String searchText){
		driver.findElement(searchTextBox).sendKeys(searchText);
	}

	public void pressEnter() {
		driver.findElement(searchTextBox).sendKeys(Keys.ENTER);
	}
	
	public void clickOnFirstResultLink() {
		driver.findElement(resultsLink).click();
	}
}
