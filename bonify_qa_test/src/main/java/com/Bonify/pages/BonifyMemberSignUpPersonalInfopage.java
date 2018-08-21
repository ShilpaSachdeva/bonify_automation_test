package com.Bonify.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BonifyMemberSignUpPersonalInfopage extends BasicOperations {

	public BonifyMemberSignUpPersonalInfopage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	// Using page factory FindBy method to find all the elements in this page
	
	@FindBy(id = "gender-male")
	private WebElement salutation;

	@FindBy(name = "firstName")
	private WebElement firstName;
	
	@FindBy(name = "lastName")
	private WebElement lastName;
	
	@FindBy(name = "dateOfBirth")
	private WebElement dateOfBirth;
	
	@FindBy(name = "street")
	private WebElement street;
	
	@FindBy(name = "houseNumber")
	private WebElement houseNumber;
	
	@FindBy(name = "zipCode")
	private WebElement zipCode;
	
	@FindBy(name = "city")
	private WebElement city;
	
	
	@FindBy(className = "btn")
	private WebElement continueBtn;
	
		// Defining all the user actions (Methods) that can be performed in this
	// page
	public void setsalutation() throws Exception {
		elementControl.click(salutation);
		}

	public void setFirstName(String strFirstName) throws Exception{
		textboxControl.setText(firstName, strFirstName);
   	 }
	
	public void setLastName(String strLastName) throws Exception{
		textboxControl.setText(lastName, strLastName);
   	 }
	public void setDateOfBirth(String strDateOfBirth) throws Exception{
		textboxControl.setText(dateOfBirth, strDateOfBirth);
   	 }
	public void setStreet(String strStreet) throws Exception{
		textboxControl.setText(street, strStreet);
   	 }
	public void setHouseNumber(String strHouseNumber) throws Exception{
		textboxControl.setText(houseNumber, strHouseNumber);
   	 }
	public void setZipCode(String strZipCode) throws Exception{
		textboxControl.setText(zipCode, strZipCode);
   	 }
	public void setCity(String strCity) throws Exception{
		textboxControl.setText(city, strCity);
   	 }	
	
	public void clickContinue() throws Exception {
		elementControl.click(continueBtn);
	}

	
}
