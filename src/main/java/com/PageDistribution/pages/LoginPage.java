package com.PageDistribution.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.PageDistribution.objectRepository.LoginPageObjectRepository;
import com.utility.PropertiesUtils;

public class LoginPage extends LoginPageObjectRepository {
	public WebDriver driver;
public PropertiesUtils pu;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyLogin() {
		email.sendKeys(pu.readproperty("username"));
		pass.sendKeys(pu.readproperty("password"));
		button.click();
		String actTitle = driver.getTitle();
		String expTitle = "JavaByKiran | Dashboard";
		if (actTitle.equals(expTitle)) {
			System.out.println("Title is Matching....");
			return true;
		} else {
			System.out.println("Title is not Matching...");
			return false;
		}
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validateImage() {
		return logo.isDisplayed();
	}
	public DasboardPage verifyValidLogin() {
		email.sendKeys("kiran@gmail.com");
		pass.sendKeys("123456");
		button.click();
		return new DasboardPage(driver);
	}

	public boolean checkCrediantialsPassword() {
		email.clear();
		pass.clear();
		email.sendKeys("pallavi");
		button.click();
		String actCredtentials = driver.findElement(By.id("password_error")).getText();
		System.out.println(actCredtentials);
		String expCredtentials = "Please enter password.";
		if (actCredtentials.equals(expCredtentials)) {
			System.out.println("Password Error message is Matching....");
			return true;
		} else {
			System.out.println("Password Error message is Not Matching....");
			return false;
		}
	}
	public RegistrationPage clickOnRegistrationLink() {
		registerBtn.click();
		return new RegistrationPage(driver);
	}
	
}
