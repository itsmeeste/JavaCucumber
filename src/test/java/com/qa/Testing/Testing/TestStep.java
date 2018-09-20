package com.qa.Testing.Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestStep 
{
	WebDriver driver;
	
	
	@Before
	public void startUp()
	{
		System.setProperty("webdriver.chrome.driver",Constants.CHROMEDRIVER);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		ReportUtil.startReport();
		
	}
	
	@Given("^That I created a User using username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void that_I_created_a_User_using_username_and_password(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(Constants.URL);
		ReportUtil.createTest("SomeTest");
		ReportUtil.logTestWithScreenShot(LogStatus.INFO, "someText", driver);
		ReportUtil.EndTest();
	}

	@When("^I log into the page using username \"([^\"]*)\" and passwprd \"([^\"]*)\"$")
	public void i_log_into_the_page_using_username_and_passwprd(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I am successfully logged in$")
	public void i_am_successfully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	@After
	public void tearDown()
	{
		driver.close();
		driver.quit();
		ReportUtil.EndReport();
	}

}
