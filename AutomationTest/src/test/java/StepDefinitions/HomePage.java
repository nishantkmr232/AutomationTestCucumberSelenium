package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.GooglePage;
import pageObject.JPMorganHomePage;

public class HomePage {

	WebDriver driver=null;
	
	GooglePage gp;
	JPMorganHomePage jp;
	
	@Given("Web Browser is open")
	public void web_browser_is_open() {
		System.setProperty("webdriver.chrome.driver", "D:/eclipse-workspace/AutomationTest/src/test/resources/Drivers/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(chromeOptions);
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		System.out.println("Chrome driver launched successfully");
	}

	@And("User is on google search page")
	public void user_is_on_google_search_page() {
		driver.get("https://www.google.com/");
		System.out.println("User has been navigated to Google search page");  
	}

	@When("^User enters a search text as (.*)$")
	public void user_enters_a_search_text_as_j_p_morgan(String searchText) {
		gp=new GooglePage(driver);
		gp.enterSearchText(searchText);
		System.out.println("User has entered a search text as:"+searchText);
	}
	
	@And("User hits enter after entering search Text")
	public void user_hits_enter_after_entering_search_text() {
		gp.pressEnter();
		System.out.println("Enter button has been pressed successfully");
	}

	@Then("User is navigated to results page")
	public void user_is_navigated_to_result_page() {
		driver.getPageSource().contains("J.P. Morgan | Official Website");
		System.out.println("User has been navigated to result page successfully");
	}

	@And("User click on first link displayed from results")
	public void user_click_on_first_link_displayed_from_results() {
		gp.clickOnFirstResultLink();
		System.out.println("User has clicked on 1st link from results");
	}

	@Then("User navigated to J.P Morgan Home Page and J.P morgan Logo is displayed")
	public void user_navigated_to_j_p_morgan_home_page_and_j_p_morgan_logo_is_displayed() {
		jp=new JPMorganHomePage(driver);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		Boolean result=jp.verifyLogo();
		if(result==true) {
			System.out.println("User has been navigated to J.P Morgan home page and logo is displaying successfully");
		}
		else{
			System.out.println("Logo is not present on home page");
		}
		
		driver.close();
	}

}
