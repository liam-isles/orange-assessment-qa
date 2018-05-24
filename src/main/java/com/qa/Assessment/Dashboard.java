package com.qa.Assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard {
	@FindBy(xpath="//*[@id=\"menu_pim_viewPimModule\"]/b") private WebElement pimTab;
	@FindBy(xpath="//*[@id=\"menu_pim_addEmployee\"]") private WebElement addEmployeeButton;
	
	public void AddEmployee() throws InterruptedException {
		pimTab.click();
		addEmployeeButton.click();
	}
}
