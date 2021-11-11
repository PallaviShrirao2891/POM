package com.TestBases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.log4testng.Logger;

import com.PageDistribution.pages.LoginPage;

public class BaseClass {
public static WebDriver driver=null;
FileInputStream fis=null;
public static Logger log=Logger.getLogger(BaseClass.class);

public String readProperty(String key) {
	log.info("Reading a Property From Property File");
	Properties prop=new Properties();
	try {
		fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
		prop.load(fis);
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}
	log.info("value found in the property file for the "+key);
	return prop.getProperty(key);
}
public void launchApplication() {
	log.info("Launching an Application..");
	driver.get(readProperty("url"));
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
public WebDriver initialization() {
	log.info("Initializing a browser "+readProperty("browser"));
	if(readProperty("browser").equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		launchApplication();
		log.info("Chrome Browser initialized...");
		return driver;
	}else {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
		log.info("Firefox Browser initialized...");
		return driver;
	}
}
public LoginPage loadLoginPage() {
	LoginPage lp= new LoginPage(driver);
	return lp;
}
public String getScreenshot() {
	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
	File destination = new File(path);
	try {
		FileUtils.copyFile(srcFile, destination);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return path;
}
}
