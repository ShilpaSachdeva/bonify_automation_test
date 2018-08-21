package com.Bonify.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BonifyHomePage extends BasicOperations {

	public BonifyHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}
	// Using page factory FindBy method to find all the elements in this page
	@FindBy(className = "ush_btn_1")
	private WebElement registrationLink;
	
	@FindBy(className = "ush_btn_2")
	private WebElement loginLink;

	// Defining all the user actions (Methods) that can be performed in this page
	public void clickRegistrationLink() throws Exception {
			elementControl.click(registrationLink);

	}
	public void clickLoginLink() throws Exception {
		elementControl.click(loginLink);

}
	
	public void workOnRegistartionWindow() throws Exception{
		windowControl.switchToChildWindow();
	}
	
	

}
