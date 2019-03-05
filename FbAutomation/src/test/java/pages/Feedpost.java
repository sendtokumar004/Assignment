package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Feedpost {

	ExtentTest test;
	WebDriver driver = null;

	public Feedpost(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.test = test;
	}

	
	
	
	@FindBy(xpath="//textarea[@id='js_wy']")
	WebElement feed_post;
	
	
	//button[@value='1']//span[contains(text(),'Share')]
	
	@FindBy(xpath="//button[@value='1']//span[contains(text(),'Share')]")
	WebElement share;
	
	
	
	public void clickonfeed() {
		
		feed_post.click();	
		test.log(LogStatus.INFO, "Write Something here");
		feed_post.sendKeys("Feed post Testing");
		test.log(LogStatus.INFO, "  feed posted +");
		test.log(LogStatus.PASS, " Create post Locator found");
		
		
		}
	
	public void share() {
		share.click();
		
		
		test.log(LogStatus.PASS, " Feed posted ..Yipeee");
	}
	}
	
	

