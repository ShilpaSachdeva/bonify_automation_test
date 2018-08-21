package com.Bonify.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BonifyMemberHomePage extends BasicOperations {

	public BonifyMemberHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	// Using page factory FindBy method to find all the elements in this page
	@FindBy(className = "message")
	private WebElement welcomeMessage;

	@FindBy(xpath = "//*[@id='main-header']/div[1]/div/div[2]/button/div")
	private WebElement dropdownLabel;

	@FindBy(xpath = "//*[@id='main-body']/ul[1]/li[4]/button")
	private WebElement logout;


	// Defining all the user actions (Methods) that can be performed in this
	// page
	public String getmessageText() throws Exception {
		return elementControl.getText(welcomeMessage);

	}

	public void clickDropdownLabel() throws Exception {
		elementControl.click(dropdownLabel);

	}

	public void clickLogout() throws Exception {
		elementControl.click(logout);
	}

}
