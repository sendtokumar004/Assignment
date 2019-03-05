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

public class Login {
	WebDriver driver = null;
	//h2[contains(text(),'OnePlus 6T')]
	ExtentTest test;
	public Login(WebDriver driver ,ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.test = test;
	}
	
	//input[@id='add-to-cart-button']
	
	/*@FindBy(id = "add-to-cart-button")
	 WebElement addtocart;
	public void clickonaddtocart() {
		
	addtocart.click();	
	test.log(LogStatus.INFO, "Clicked on Add to Cart button");
	
	}
	
	@FindBy(xpath="//h1[@class='a-size-medium a-text-bold']")
	WebElement Addedtocart;
	
	@FindBy(xpath="//a[@id='hlb-view-cart-announce']")
	WebElement cart;
	
	public void clickoncart() {
		
		cart.click();
		test.log(LogStatus.INFO, "Clicked on Cart button");
		
	}
	*/
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	public void clickonusername() {
		
		email.click();	
		test.log(LogStatus.INFO, "Clicked on username");
		email.sendKeys("kumarlokesh179@gmail.com");
		test.log(LogStatus.INFO, "  Enter email +");
		test.log(LogStatus.PASS, " Username enterned sucessfully +");
		
		}
	
	@FindBy(xpath="//input[@id='pass']")
	WebElement pass;
	
public void clickonpassword() {
		
		pass.click();	
		test.log(LogStatus.INFO, "Clicked on Password");
		pass.sendKeys("Automation@123");
		test.log(LogStatus.INFO, "  Enter Password +");
		test.log(LogStatus.PASS, " Password Entered sucessfully +");
		}
	
	
	@FindBy(xpath="//label[@class='uiButton uiButtonConfirm']")
	WebElement log_in;
	
public void clickonlogin() {
		
		
		String textlogin=log_in.getText();
		
		test.log(LogStatus.INFO, "Text of Login Button " +textlogin);
		
		
		log_in.click();	
		test.log(LogStatus.PASS, " Login Button clicked +");
	
	}

}
	



