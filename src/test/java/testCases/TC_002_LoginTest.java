package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	@Test(groups= {"Sanity", "Master"})
	public void verifyLogin()
	{
		logger.info("*****	TC_002_LoginTest	*****");
		logger.debug("Capturing application debug logs");
		
		try {
			HomePage homePage = new HomePage(driver);
			homePage.clickMyAccount();
			logger.info("Clicked on My Account link on the Home Page");
			homePage.clickLogin();
			
			LoginPage loginPage = new LoginPage(driver);
			logger.info("Providing login details");
			loginPage.setEmail(configProp.getProperty("email"));
			loginPage.setPassword(configProp.getProperty("password"));
			loginPage.clickLogin();
			logger.info("Clicked on Login button");
			
			MyAccountPage myAccountPage = new MyAccountPage(driver);
			boolean targetPage = myAccountPage.isMyAccountPageExists();
			
			Assert.assertEquals(targetPage, true, "Login failed");
			logger.info("Login successful");
		}
		catch (Exception e) {
			Assert.fail();
		}
		finally {
			logger.info("Finished TC_002_LoginTest");
		}
	}
}