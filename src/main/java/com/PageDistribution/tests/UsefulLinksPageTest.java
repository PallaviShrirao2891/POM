package com.PageDistribution.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PageDistribution.pages.UsefulLinksPage;
import com.TestBases.TestBase;

public class UsefulLinksPageTest extends TestBase{
	 UsefulLinksPage ulp=null;
	@BeforeMethod
	public void setUp() {
		driver=intialization();
		ulp = loadLoginPage().verifyValidLogin().nevigateUsefulLinksPage(driver);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test(priority = 1)
	public void goBtn1Click() {
	Assert.assertTrue(ulp.goBtn1Click());
	}
	@Test(priority = 2)
	public void goBtn2Click() {
	Assert.assertTrue(ulp.goBtn2Click());
	}
	@Test(priority = 3)
	public void goBtn3Click() {
	Assert.assertTrue(ulp.goBtn3Click());
	}
	@Test(priority = 4)
	public void goBtn4Click() {
	Assert.assertTrue(ulp.goBtn4Click());
	}
	@Test(priority = 5)
	public void goBtn5Click() {
	Assert.assertTrue(ulp.goBtn5Click());
	}
	@Test(priority = 6)
	public void goBtn6Click() {
	Assert.assertTrue(ulp.goBtn5Click());
	}
	
}
