package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Regression", "Master"})
	public void verifyAccountRegistration()
	{
		logger.info("*****	Starting TC_001_AccountRegistrationTest	*****");
		logger.debug("This is a debug log message");
		
		try {
			HomePage homePage = new HomePage(driver);
			
			homePage.clickMyAccount();
			logger.info("Clicked on MyAccount Link...");
			
			homePage.clickRegister();
			logger.info("Clicked on Register Link...");
			
			AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
			
			logger.info("Providing customer details...");
			registrationPage.setFirstname(capitalize(randomString(6)));
			registrationPage.setLastname(capitalize(randomString(6)));
			registrationPage.setEmail(randomString(10) + "@gmail.com");
			registrationPage.setTelephone(randomNumber(10));
			
			String password = randomAlphaNumeric();
			
			registrationPage.setPassword(password);
			registrationPage.setConfirmPassword(password);
			
			registrationPage.setPrivacyPolicy();
			registrationPage.clickContinue();
			
			logger.info("Validating expected message...");
			String configMessage = registrationPage.getConfirmationMessage();
			Assert.assertEquals(configMessage, "Your Account Has Been Created!");
			
			logger.info("Test passeed");
		} 
		catch (Exception e) {
			logger.error("Test failed : " + e.getMessage());
			Assert.fail("Test failed : " + e.getMessage());
		}
		finally {
			logger.info("*****	Finished TC_001_AccountRegistrationTest	*****");
		}
	}
}