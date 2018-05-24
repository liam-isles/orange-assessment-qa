package com.qa.Assessment;

import java.util.UUID;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployeePage {
	
	@FindBy(xpath="//*[@id=\"firstName\"]") private WebElement firstName;
	@FindBy(xpath="//*[@id=\"lastName\"]") private WebElement lastName;
	@FindBy(xpath="//*[@id=\"chkLogin\"]") private WebElement createLoginDetailsBox;
	@FindBy(xpath="//*[@id=\"user_name\"]") private WebElement userName;
	@FindBy(xpath="//*[@id=\"user_password\"]") private WebElement password;
	@FindBy(xpath="//*[@id=\"re_password\"]") private WebElement confirmPass;
	@FindBy(xpath="//*[@id=\"btnSave\"]") private WebElement submitButton;
	
	public void EmployeeDetails( ) {
		firstName.sendKeys("Liam");
		lastName.sendKeys("Isles");	
	}
	
	public void LoginDetailsChoice() {
		createLoginDetailsBox.click();
	}
	
	public void LoginDetails() {
		String loginUsername = UUID.randomUUID().toString();
		userName.sendKeys(loginUsername);
		password.sendKeys("Potatoes4lyf");
		confirmPass.sendKeys("Potatoes4lyf");
	}
	
	public void submitUser() {
		submitButton.click();
	}
}
