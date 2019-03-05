package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SearchFriends {

	WebDriver driver = null;
	//h2[contains(text(),'OnePlus 6T')]
	ExtentTest test;
	public SearchFriends(WebDriver driver ,ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.test = test;
	}
	
	@FindBy(xpath="//h2[contains(text(),'search')]")
	List<WebElement> search;
	
	
	@FindBy(xpath="//div[contains(@class,'a-fixed-left-grid')]//span[contains(@class,'text-bold')]")
	WebElement send_request;
	
	
	
public void clickonsendrequest() {
		
	send_request.click();	
		test.log(LogStatus.INFO, "Clicked on search");
		send_request.sendKeys("lokesh");
		//test.log(LogStatus.INFO, "  ");
		test.log(LogStatus.PASS, " Friend request sucessfully send +");
		}
//Verify title of page conatins one plus 6T or not 	
	
}
