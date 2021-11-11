package com.PageDistribution.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPageObjectRepository {
	@FindBy(xpath="//input[@id='name']")
	public WebElement name;
	@FindBy(xpath="//input[@id='mobile']")
	public WebElement mobile;
	@FindBy(xpath="//input[@id='email']")
	public WebElement email;
	@FindBy(xpath="//input[@id='password']")
	public WebElement pass;
	@FindBy(xpath="//button")
	public WebElement btn;
	
}
