package com.PageDistribution.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.PageDistribution.objectRepository.UsefulLinksPageObjectRepository;

public class UsefulLinksPage extends UsefulLinksPageObjectRepository{
	public WebDriver driver=null;
	public UsefulLinksPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean goBtn1Click(){
		goButton1.click();
		String title=driver.getTitle();
		System.out.println(title);
		if(title.equals("JavaByKiran | Useful Links")) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean goBtn2Click() {
		goButton1.click();
		String title=driver.getTitle();
		System.out.println(title);
		if(title.equals("JavaByKiran | Useful Links")) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean goBtn3Click() {
		goButton1.click();
		String title=driver.getTitle();
		if(title.equals("JavaByKiran | Useful Links")) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean goBtn4Click() {
		goButton1.click();
		String title=driver.getTitle();
		if(title.equals("JavaByKiran | Useful Links")) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean goBtn5Click() {
		goButton1.click();
		String title=driver.getTitle();
		if(title.equals("JavaByKiran | Useful Links")) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean goBtn6Click() {
		goButton1.click();
		String title=driver.getTitle();
		if(title.equals("JavaByKiran | Useful Links")) {
			return true;
		}
		else {
			return false;
		}
	}
	}