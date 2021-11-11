package com.PageDistribution.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.PageDistribution.objectRepository.OperatorsPageObjectRepository;
import com.utility.CommonUtils;

public class OperatorsPage extends OperatorsPageObjectRepository {
	public WebDriver driver;

	public OperatorsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public ArrayList<String> verifyTableHeaderCount() throws Exception {
		String jxlpath = System.getProperty("user.dir") + "/OperatorsTable.xls";
		ArrayList<String> expMenusList = new ArrayList<String>();
		expMenusList.addAll(CommonUtils.readDataOfRow(jxlpath, "Sheet1", 0));
		return expMenusList;
	}

	public ArrayList<String> verifyTechnicalJob() throws Exception {
		String jxlpath = System.getProperty("user.dir") + "/OperatorsTable.xls";
		ArrayList<String> expMenusList = new ArrayList<String>();
		ArrayList<String> expMenusList1 = CommonUtils.readDataOfCol(jxlpath, "Sheet1", 2);
		String val;
		for (int i = 0; i < expMenusList1.size(); i++) {
			val = expMenusList1.get(i);
			if (val.contains("Technical"))
				expMenusList.add(val);
		}
		return expMenusList;
	}
	
	public ArrayList<String> verifyWhatsAppUser() throws Exception {
		String jxlpath = System.getProperty("user.dir") + "/OperatorsTable.xls";
		ArrayList<String> expMenusList = new ArrayList<String>();
		ArrayList<String> expMenusList1 = CommonUtils.readDataOfCol(jxlpath, "Sheet1", 3);
		ArrayList<String> expMenusList2 = CommonUtils.readDataOfCol(jxlpath, "Sheet1", 1);
			if (expMenusList1.get(0).contains("Whats App"))
				expMenusList.addAll(expMenusList2);
		return expMenusList;
	}
}
