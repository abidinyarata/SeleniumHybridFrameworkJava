package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verifyLoginDDT(String email, String password, String exp)
	{
		logger.info("*****	TC_002_LoginTest	*****");
		
		try {
			HomePage homePage = new HomePage(driver);
			homePage.clickMyAccount();
			homePage.clickLogin();
			
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmail(email);
			loginPage.setPassword(password);
			loginPage.clickLogin();
			
			MyAccountPage myAccountPage = new MyAccountPage(driver);
			boolean targetPage = myAccountPage.isMyAccountPageExists();
			
			if (exp.equalsIgnoreCase("Valid"))
				if (targetPage) {
					myAccountPage.clickLogout();
					Assert.assertTrue(true);
				}
				else
					Assert.assertTrue(false);
			
			if (exp.equalsIgnoreCase("Invalid"))
				if (targetPage) {
					myAccountPage.clickLogout();
					Assert.assertTrue(false);
				}
				else
					Assert.assertTrue(true);
		}
		catch (Exception e) {
			Assert.fail("An exception occured : " + e.getMessage());
		}
	}
}