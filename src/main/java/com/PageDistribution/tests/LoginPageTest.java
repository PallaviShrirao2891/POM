package com.PageDistribution.tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PageDistribution.pages.DasboardPage;
import com.PageDistribution.pages.LoginPage;
import com.PageDistribution.pages.RegistrationPage;
import com.TestBases.TestBase;
import com.utility.DataProviderUtils;

public class LoginPageTest extends TestBase {
	LoginPage lp;
	RegistrationPage rp;
	DasboardPage dp;
	String sheetName="registration";
	@BeforeMethod
	public void setUp() {
		driver =intialization();
		lp = new LoginPage(driver);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test(priority = 1)
	public void checkCrediantialsPassword() {
		Assert.assertTrue(lp.checkCrediantialsPassword());
	}
	@Test(priority = 2)
	public void verifyTitle() {
		String title=lp.validateLoginPageTitle();
		Assert.assertEquals(title, "JavaByKiran | Log in");
	}
	@Test(priority = 3)
	public void verifyImage() {
		boolean i=lp.validateImage();
		Assert.assertTrue(i);
	}
	
	@Test(priority = 4)
	public void checkValidCredentials() {
		dp = lp.verifyValidLogin();
	}
	@DataProvider
	public Object[][] getRegistrationPageData() {
		Object data[][]=DataProviderUtils.getTestData(sheetName);
		return data;
	}
	@Test(dataProvider="getRegistrationPageData")
	public void registrationPage(String Name,String	Mobile,String Email,String password) {
		//lp.clickOnRegistrationLink();
		lp.clickOnRegistrationLink().registrationForm(Name, Mobile, Email, password);
	}
}
