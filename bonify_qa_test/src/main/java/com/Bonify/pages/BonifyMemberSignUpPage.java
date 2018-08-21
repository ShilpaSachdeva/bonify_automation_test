package com.Bonify.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BonifyMemberSignUpPage extends BasicOperations {

	public BonifyMemberSignUpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	// Using page factory FindBy method to find all the elements in this page
	
	@FindBy(name = "email")
	private WebElement emailAddress;

	@FindBy(name = "password")
	private WebElement password;
	
	
	@FindBy(className = "btn-flat-cta-alert")
	private WebElement register;
	
	@FindBy(className = "btn-flat-cta-default")
	private WebElement registration;
	
	@FindBy(xpath = "//*[@id='step-{{$index}}']/div/div/form/div[1]/div/div[2]/span")
	private WebElement emailError;
	
	@FindBy(xpath = "//*[@id='step-{{$index}}']/div/div/form/div[2]/div/div[2]/span")
	private WebElement passwordError;

	// Defining all the user actions (Methods) that can be performed in this
	// page
	public void setEmail(String strEmail) throws Exception {
		textboxControl.setText(emailAddress, strEmail);
	}
	
	public boolean verifyEmailVisible() throws Exception {
		return emailAddress.isDisplayed();
	}

	public void setPassword(String strPassword) throws Exception{
		textboxControl.setText(password, strPassword);
   	 }
	
	public void clearEmail() throws Exception {
		//textboxControl.clickText(emailAddress);
		textboxControl.clearText(emailAddress);
		textboxControl.clickText(emailAddress);
	}

	public void clearPassword() throws Exception{
		textboxControl.clickText(password);
		textboxControl.clearText(password);
   	 }

	
	public void clickRegister() throws Exception {
		elementControl.click(register);
	}
	
	public void clickLogin() throws Exception {
		elementControl.click(registration);
	}


	public String getEmailError() throws Exception {		
		return  elementControl.getText(emailError);		
	}
	
	public String getPasswordError() throws Exception {	
		return  elementControl.getText(passwordError);		
	}

}
