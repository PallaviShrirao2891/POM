package com.PageDistribution.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.PageDistribution.objectRepository.DashboardPageObjectRepository;

public class DasboardPage extends DashboardPageObjectRepository {

	public WebDriver driver = null;
	public DasboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public UsersPage nevigateUserPage(WebDriver driver) {
		userLink.click();
		return new UsersPage(driver);
	}
	public OperatorsPage nevigateOperatorsPage(WebDriver driver) {
		operators.click();
		return new OperatorsPage(driver);
	}
	public UsefulLinksPage nevigateUsefulLinksPage(WebDriver driver) {
		usefulLinks.click();
		return new UsefulLinksPage(driver);
	}
	public DownloadsPage nevigateDownloadsPage(WebDriver driver) {
		downloads.click();
		return new DownloadsPage(driver);
	}
	public LoginPage nevigateLogoutPage(WebDriver driver) {
		logoutLink.click();
		return new LoginPage(driver);
	}
}
