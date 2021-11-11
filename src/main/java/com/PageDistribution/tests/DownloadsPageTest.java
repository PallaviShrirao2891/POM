package com.PageDistribution.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PageDistribution.pages.DownloadsPage;
import com.TestBases.TestBase;

public class DownloadsPageTest extends TestBase{
	DownloadsPage dlp=null;
	@BeforeMethod
	public void setUp() {
		driver = intialization();
		dlp = loadLoginPage().verifyValidLogin().nevigateDownloadsPage(driver);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void verifyTitle() {
		String title=dlp.validateLoginPageTitle();
		Assert.assertEquals(title, "JavaByKiran | Downloads");
	}
}
