package com.PageDistribution.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPageObjectRepository {
	@FindBy(xpath = "//span[text()='Users']")
	public WebElement userLink;
	
	@FindBy(xpath = "//span[text()='Operators']")
	public WebElement operators;
	
	@FindBy(xpath = "//span[text()='     Useful Links']")
	public WebElement usefulLinks;
	
	@FindBy(xpath = "//span[text()='Downloads']")
	public WebElement downloads;
	
	@FindBy(linkText = "LOGOUT")
	public WebElement logoutLink;
	
	@FindBy(xpath="//h3")
	public List<WebElement> courses;
	
	@FindBy(xpath="//p//following::h3")
	public List<WebElement> details;
	
	@FindBy(xpath="//a[text()='More info ']")
	public List<WebElement> moreInfoLinks;
	
	@FindBy(xpath="//ul[@class='sidebar-menu']//child::li//span")
	public List<WebElement> sidebar_menu;
}
