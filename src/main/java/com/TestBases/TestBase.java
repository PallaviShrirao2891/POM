package com.TestBases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.PageDistribution.pages.LoginPage;
import com.utility.PropertiesUtils;
import com.utility.WaitUtility;
import com.utility.WebEventListener;

public class TestBase {
	public static PropertiesUtils pu = null;
	public WaitUtility wu = null;
	public static WebDriver driver;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Logger log = Logger.getLogger(TestBase.class);

	public WebDriver intialization() {
		log.info("Launching an Application..");
		pu = new PropertiesUtils();
		wu = new WaitUtility();
		if (pu.readproperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", pu.readproperty("chromeDriverFilePath"));
			driver = new ChromeDriver();
			log.info("Chrome Browser initialized...");
			driver.get(pu.readproperty("url"));
			driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(pu.readproperty("pageload")), TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(pu.readproperty("pageload")), TimeUnit.SECONDS);
			//return driver;
		} else {
			System.setProperty("webdriver.gecko.driver", pu.readproperty("geckoDriverFilePath"));
			driver = new FirefoxDriver();
			log.info("Firefox Browser initialized...");
			driver.get(pu.readproperty("url"));
			driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(pu.readproperty("pageload")), TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(pu.readproperty("pageload")), TimeUnit.SECONDS);
			//return driver;
		}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		return driver;
	}

	public LoginPage loadLoginPage() {
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
	public String getScreenshot() {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
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
