package com.PageDistribution.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.PageDistribution.objectRepository.DownloadsPageObjectRepository;

public class DownloadsPage extends DownloadsPageObjectRepository{

		WebDriver driver=null;
		public DownloadsPage(WebDriver driver) {
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
		
		public String validateLoginPageTitle() {
			return driver.getTitle();
		}		
}
