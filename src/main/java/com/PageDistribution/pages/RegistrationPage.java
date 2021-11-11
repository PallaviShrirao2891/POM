package com.PageDistribution.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.PageDistribution.objectRepository.RegistrationPageObjectRepository;

public class RegistrationPage extends RegistrationPageObjectRepository {
	public WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void registrationForm(String Name, String Mobile, String Email, String password) {
		name.clear();
		mobile.clear();
		email.clear();
		pass.clear();
		name.sendKeys(Name);
		mobile.sendKeys(Mobile);
		email.sendKeys(Email);
		pass.sendKeys(password);
		btn.click();
		driver.switchTo().alert().accept();
	}
}
