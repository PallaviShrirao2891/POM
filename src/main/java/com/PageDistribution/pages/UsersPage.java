package com.PageDistribution.pages;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.PageDistribution.objectRepository.UsersPageObjectRepository;
import com.utility.CommonUtils;

public class UsersPage extends UsersPageObjectRepository{
	public  WebDriver driver;
	public UsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public ArrayList<String> emailEndsWith() throws Exception {
		String jxlpath=System.getProperty("user.dir")+"/d.xls";
		ArrayList<String> expMenusList = new ArrayList<String>();
		expMenusList.addAll(CommonUtils.readDataOfCol(jxlpath, "Sheet1", 2));
		return expMenusList;
	}
	public ArrayList<String> checkColumnNames() throws Exception {
		String jxlpath=System.getProperty("user.dir")+"/d.xls";
		ArrayList<String> expMenusList = new ArrayList<String>();
		expMenusList.addAll(CommonUtils.readDataOfRow(jxlpath, "Sheet1", 0));
		return expMenusList;
	}
	public ArrayList<String> checkColumn() throws Exception{
		String jxlpath=System.getProperty("user.dir")+"/d.xls";
		ArrayList<String> expMenusList = new ArrayList<String>();
		expMenusList.addAll(CommonUtils.readDataOfCol(jxlpath, "Sheet1", 2));
		return expMenusList;
	}
}
