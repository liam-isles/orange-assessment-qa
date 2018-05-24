package com.qa.Assessment;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(xpath = "//*[@id=\"txtUsername\"]") private WebElement nameInput;
	
	@FindBy(xpath="//*[@id=\"txtPassword\"]") private WebElement passInput;
	
	@FindBy(xpath="//*[@id=\"btnLogin\"]") private WebElement loginButton;
	
	public void loginMethod() {
		nameInput.sendKeys("Admin");
		passInput.sendKeys("admin");
		loginButton.click();
//		driver.get("http://opensource.demo.orangehrmlive.com/index.php/auth/login");
//		driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys("Admin");
//		driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys("admin");
//		driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
	}
}
