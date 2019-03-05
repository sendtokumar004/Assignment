package com.facebook.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

//import pages.Feedpost;
import pages.Login;
import pages.Feedpost;
import pages.SearchFriends;

public class Testcases {

	private WebDriver driver;
	private String baseUrl;
	ExtentReports report;
	com.relevantcodes.extentreports.ExtentTest test;

	@BeforeClass
	public void beforeClass() {

		baseUrl = "http://www.facebook.com/";
		report = new ExtentReports(System.getProperty("user.dir") + "/test-output/STMExtentReport.html", true);
		test = report.startTest("Facebook Automation Suite ");

		report.addSystemInfo("User Name", "Lokesh Kumar");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		test.log(LogStatus.INFO, "Browser Started...");

		// Maximize the browser's window
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser Maximized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Web application opened");
	}

	@Test(priority = 1)
	public void homepage() throws Exception {
		// pages.Login hp = new pages.Login(driver, test);
		String title = driver.getTitle();
		// String Expected_title = "Facebook – log in or sign up";
		System.out.println("" + title);
		test.log(LogStatus.PASS, "" + title);

	}

	@Test(priority = 2)
	public void Login() throws Exception {

		pages.Login hp = new pages.Login(driver, test);

		try {

			Thread.sleep(10000);

			String actual = driver.getTitle();
			test.log(LogStatus.PASS, "" + actual);
			String expected = "Facebook – log in or sign up";
			Assert.assertEquals(actual, expected);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());

		}
		// Assert.assertEquals(actual, expected);
		test.log(LogStatus.PASS, "Opened Facebook Sign in Page ");
	}

	@Test(priority = 3)
	public void username() throws Exception {
		Login hp = new Login(driver, test);

		try {

			hp.clickonusername();

		}

		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());

		}
		// test.log(LogStatus.PASS, "username Entered Sucessfully");

		// hp.continue1.click();
		// test.log(LogStatus.PASS, "Clicked on Continue");
	}

	@Test(priority = 4)

	public void password_login() throws Exception {

		Login hp = new Login(driver, test);

		try {
			hp.clickonpassword();
			hp.clickonlogin();

		}

		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());

		}

		/*
		 * Thread.sleep(5000); String actual_title1=driver.getTitle(); String
		 * Expected_title1="Facebook"; Assert.assertEquals(actual_title1,
		 * Expected_title1);
		 */
		test.log(LogStatus.PASS, "Login and Password testcase successfully Passed");

	}

	@Test(priority = 5)

	public void Feedpost() throws Exception {

		Feedpost hp = new Feedpost(driver, test);

		Thread.sleep(5000);
		/*
		 * String actual_title1=driver.getTitle(); String Expected_title1="Facebook";
		 * Assert.assertEquals(actual_title1, Expected_title1);
		 */
		test.log(LogStatus.PASS, "Successfully logged In ");
		try {
			hp.clickonfeed();

		}

		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());

		}

		// Thread.sleep(10000);
		hp.share();
		test.log(LogStatus.PASS, "Feed Posted Successfully");
		hp.share();

	}

	@Test(priority = 6)

	public void sendrequest() throws Exception {

		SearchFriends lp = new SearchFriends(driver, test);

		Thread.sleep(5000);
		/*
		 * String actual_title1=driver.getTitle(); String Expected_title1="Facebook";
		 * Assert.assertEquals(actual_title1, Expected_title1);
		 */
		test.log(LogStatus.PASS, "Search for a friend ");
		try {
			lp.clickonsendrequest();
		}

		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());

		}

		// Thread.sleep(10000);

		test.log(LogStatus.PASS, "Friend request successfully send ");

	}

	@AfterMethod
	public void tearDown(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			String path = Screenshots.takeScreenshot(driver, testResult.getName());
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "Verify Welcome Text Failed", imagePath);
		}

	}

	@AfterClass

	public void last() throws IOException {

		driver.quit();
		report.endTest(test);
		report.flush();

	}

}
