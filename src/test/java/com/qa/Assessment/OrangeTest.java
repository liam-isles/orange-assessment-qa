package com.qa.Assessment;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertEquals;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import org.openqa.selenium.WebElement;

public class OrangeTest {
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	Actions action;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		report = new ExtentReports(
				"C:\\Users\\Admin\\eclipse-workspace\\Assessment\\src\\test\\java\\com\\qa\\Assessment\\test.html");
		test = report.startTest("Assessment test document");
	}

	@Given("^the Add Employee Tab$")
	public void the_Add_Employee_Tab() throws InterruptedException {
		LoginPage page = PageFactory.initElements(driver, LoginPage.class);
		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		driver.get("http://opensource.demo.orangehrmlive.com/index.php/auth/login");
		page.loginMethod();
		dashboard.AddEmployee();
		test.log(LogStatus.INFO, "test has successfully logged in and navigated to employee tab.");
	}

	@When("^I fill out the Employee Details correctly$")
	public void i_fill_out_the_Employee_Details_correctly() {
		AddEmployeePage adduser = PageFactory.initElements(driver, AddEmployeePage.class);
		adduser.EmployeeDetails();
		test.log(LogStatus.INFO, "added employee details.");
	}

	@When("^I choose to create Login Details$")
	public void i_choose_to_create_Login_Details() {
		AddEmployeePage adduser = PageFactory.initElements(driver, AddEmployeePage.class);
		adduser.LoginDetailsChoice();
		test.log(LogStatus.INFO, "chose to add login details too");
	}

	@When("^I fill out the Login Details correctly$")
	public void i_fill_out_the_Login_Details_correctly() {
		AddEmployeePage adduser = PageFactory.initElements(driver, AddEmployeePage.class);
		adduser.LoginDetails();
	}

	@When("^I click the Save button$")
	public void i_click_the_Save_button() {
		AddEmployeePage adduser = PageFactory.initElements(driver, AddEmployeePage.class);
		adduser.submitUser();
		test.log(LogStatus.INFO, "Fully submitted information");
	}

	@Then("^I can see information about the user$")
	public void i_can_see_information_about_the_user() throws InterruptedException {
		assertEquals("Personal Details", driver.findElement(By.xpath("//*[@id=\"pdMainContainer\"]/div[1]/h1")).getText());
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Mission complete!");
	}

	@After
	public void teardown() {
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}
