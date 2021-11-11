package com.PageDistribution.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjectRepository {
	@FindBy(id="email")
	public WebElement email;
	@FindBy(id="password")
	public WebElement pass;
	@FindBy(xpath="//button")
	public WebElement button;
	@FindBy(xpath=("//img"))
	public WebElement logo;
	@FindBy(xpath="//a[text()='Register a new membership']")
	public WebElement registerBtn;
	
}
