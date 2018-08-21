package com.Bonify.testcases;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataProvider;

public class BonifyMemberLoginLogoutSignUpTest extends BaseScenarios {
	
	//Already Registered User credentials for Login
	private String userName = "username646@gmail.com";
	private String password = "Password@646";

	@Test(priority = 0)
	public void verifyLoginPage() throws Exception {
		try {
			logger = report.createTest("Test case Id :: 1 :: Verify Login page");
			logger.info("Click on Login");
			homepage.clickLoginLink();

			if (driver.getCurrentUrl().contains(configProperty.getProperty("loginUrl"))) {
				logger.pass("Login Page is opened succesfully");

			} else {
				logger.fail("Login Page is not opened succesfully");
			}

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();

		}

	}

	@Test(priority = 1)
	public void verifySuccessfulLogin() throws Exception {

		try {
			logger = report.createTest("Test case Id :: 2 :: Verify Successful Login");
			memberSignuppage.clearEmail();
			memberSignuppage.clearPassword();

			logger.info("Enter Valid Username");

			memberSignuppage.setEmail(userName);
			logger.info("Enter Valid Password");

			memberSignuppage.setPassword(password);

			memberSignuppage.clickLogin();

			if (memberHomePage.getmessageText().contains(userName)) {
				logger.pass("Username: " + userName + " is successfully logged in");

			} else {
				logger.fail("Username: " + userName + " is NOT successfully logged in");
			}

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();

		}

	}

	@Test(priority = 2)
	public void verifySuccessfulLogout() throws Exception {

		try {
			logger = report.createTest("Test case Id :: 3 :: Verify Successful Logout");

			logger.info("Click on Logout");
			memberHomePage.clickDropdownLabel();
			Thread.sleep(1000);
			memberHomePage.clickLogout();

			if (memberSignuppage.verifyEmailVisible()) {
				logger.pass("Username: " + userName + " is successfully logged out");

			} else {
				logger.fail("Username: " + userName + " is NOT successfully logged out");
			}

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();

		}

	}


	@Test(priority = 3)
	public void verifyRegistrationPage() throws Exception {
		try {
			logger = report.createTest("Test case Id :: 4 :: Verify Registration page");
			logger.info("Open Registration URL");
			driver.navigate().to("https://www.bonify.de/");
			logger.info("Click on New At Bonify");
			homepage.clickRegistrationLink();
			logger.info("Switch to Registration window");
			homepage.workOnRegistartionWindow();

			if (driver.getCurrentUrl().contains(configProperty.getProperty("registrationUrl"))) {
				logger.pass("Registration Page window is opened succesfully");

			} else {
				logger.fail("Registration Page window is not opened succesfully");
			}

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();

		}

	}

	@Test(priority = 4)
	public void verifyBlankEmailId() throws Exception {
		try {
			logger = report.createTest("Test case Id :: 5 :: Verify Blank Email Error");
			memberSignuppage.clearEmail();
			memberSignuppage.clearPassword();

			logger.info("Enter Blank Username");

			memberSignuppage.setEmail("");
			logger.info("Enter Random Password");

			memberSignuppage.setPassword("Random");

			if (memberSignuppage.getEmailError().equalsIgnoreCase("Trage bitte Deine Email-Adresse ein")) {
				logger.pass("Error message appears on entering blank Email Id");

			} else {
				logger.fail("Error message doesn't appears on entering blank Email Id");
			}

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();

		}

	}

	@Test(priority = 5)
	public void verifyBlankPassword() throws Exception {
		try {
			logger = report.createTest("Test case Id :: 6 :: Verify Blank Password Error");
			memberSignuppage.clearEmail();
			memberSignuppage.clearPassword();
			logger.info("Enter Random Username");
			memberSignuppage.setEmail("random@gmail.com");
			logger.info("Enter Blank Password");
			memberSignuppage.setPassword("");

			if (memberSignuppage.getPasswordError().equalsIgnoreCase("Trage bitte ein Passwort ein")) {
				logger.pass("Error message appears on entering blank password");

			} else {
				logger.fail("Error message doesn't appears on entering blank Password");
			}

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();

		}

	}

	@Test(priority = 6)
	public void verifyBlankEmailPassword() throws Exception {
		try {
			logger = report.createTest("Test case Id :: 7 :: Verify Blank Email and Password Error");

			logger.info("Enter Blank Username");
			memberSignuppage.clearEmail();
			logger.info("Enter Blank Password");
			memberSignuppage.clearPassword();

			if ((memberSignuppage.getPasswordError().equalsIgnoreCase("Trage bitte ein Passwort ein"))
					&& (memberSignuppage.getEmailError().equalsIgnoreCase("Trage bitte Deine Email-Adresse ein"))) {
				logger.pass("Error message appears on entering blank Email and Password");

			} else {
				logger.fail("Error message doesn't appears on entering blank Email and Password");
			}

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();

		}

	}

	@Test(priority = 7)
	public void verifyInvalidEmail() throws Exception {
		try {
			logger = report.createTest("Test case Id :: 8 :: Verify Invalid Email  Error");
			memberSignuppage.clearEmail();
			memberSignuppage.clearPassword();
			logger.info("Enter Invalid Email Id");
			memberSignuppage.setEmail("Random");

			if (memberSignuppage.getEmailError().equalsIgnoreCase("Bitte nutze eine gültige Email-Adresse")) {
				logger.pass("Error message appears on entering Invalid Email Id");

			} else {
				logger.fail("Error message doesn't appears on entering Invalid Email Id");
			}

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();

		}

	}

	@Test(priority = 8)
	public void verifyInvalidPassword() throws Exception {
		try {
			logger = report.createTest("Test case Id :: 9 :: Verify Invalid Password Error");
			memberSignuppage.clearEmail();
			memberSignuppage.clearPassword();
			logger.info("Enter invalid Password");
			memberSignuppage.setPassword("random");

			if (memberSignuppage.getPasswordError().equalsIgnoreCase("Bitte nutze mindestens 8 Zeichen")) {
				logger.pass("Error message appears on entering Invalid password");

			} else {
				logger.fail("Error message doesn't appears on entering Invalid password");
			}

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();

		}

	}

	@Test(priority = 9)
	public void verifyUserRegistrationStepOne() throws Exception {
		try {
			logger = report.createTest("Test case Id :: 10 :: Verify successful User Registration Step 1");
			String emailId;
			String password;
			logger.info("Genarte random EmailId");
			Random randomGenerator = new Random();  
			int randomInt = randomGenerator.nextInt(1000); 
			emailId= "username"+ randomInt +"@gmail.com";
			password= "Password@ "+randomInt;

			logger.info("Enter Random valid Email Id :" + emailId);
			memberSignuppage.clearEmail();
			memberSignuppage.setEmail(emailId);
			logger.info("Enter Random valid password :" + password);
			memberSignuppage.clearPassword();
			memberSignuppage.setPassword(password);
			logger.info("Click on Register");
			memberSignuppage.clickRegister();
			
			

		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();

		}

	}

	
	@Test(priority = 10, dataProvider = "getData", dataProviderClass=TestDataProvider.class, enabled = true)
	public void verifyUserRegistrationStepTwo(String strFirstName, String strLastName, String strDob, String strRoad, String strNum, String strPostalCode, String strCity ) throws Exception {
		try {
			logger = report.createTest("Test case Id :: 11 :: Verify successful User Registration Step 2");
			
			logger.info("Entering personal information");
			memberpersonalInfoPage.setsalutation();
			memberpersonalInfoPage.setFirstName(strFirstName);
			memberpersonalInfoPage.setLastName(strLastName);
			memberpersonalInfoPage.setDateOfBirth(strDob);
			memberpersonalInfoPage.setStreet(strRoad);
			memberpersonalInfoPage.setHouseNumber(strNum);
			memberpersonalInfoPage.setCity(strCity);
			memberpersonalInfoPage.setZipCode(strPostalCode);
			logger.info("Click on Continue button");
			memberpersonalInfoPage.clickContinue();
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail();

		}

	}

	
}
