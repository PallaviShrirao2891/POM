package com.PageDistribution.tests;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PageDistribution.pages.OperatorsPage;
import com.TestBases.TestBase;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class OperatorsPageTest extends TestBase {
	OperatorsPage op = null;

	@BeforeMethod
	public void setUp() {
		driver = intialization();
		op = loadLoginPage().verifyValidLogin().nevigateOperatorsPage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void checkTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "JavaByKiran | Operators");
	}

	@Test(priority = 2)
	public void verifyTableHeaderCount() throws Exception {
		List<WebElement> courses = driver.findElements(By.xpath("//th"));
		ArrayList<String> actualCoursesList = new ArrayList<String>();
		for (WebElement course : courses) {
			String courseName = course.getText();
			actualCoursesList.add(courseName);
		}
		Assert.assertEquals(actualCoursesList, op.verifyTableHeaderCount());
	}

	@Test(priority = 3)
	public void verifyTechnicalJob() throws Exception {
		List<WebElement> courses = driver.findElements(By.xpath("//table/tbody/tr[position()>=2 and position()<=6]/td[3]"));
		ArrayList<String> actualCoursesList = new ArrayList<String>();
		for (WebElement course : courses) {
			String courseName = course.getText();
			if (courseName.contains("Technical"))
				actualCoursesList.add(courseName);

		}
		Assert.assertEquals(actualCoursesList.size(), op.verifyTechnicalJob().size());
	}

	@Test(priority = 4)
	public void verifyWhatsAppUser() throws Exception {
		WebElement way = driver.findElement(By.xpath("//table/tbody/tr/td[4]/span[1]"));
		List<WebElement> faculties = way.findElements(By.xpath("//table/tbody/tr/td[4]/span[1]//preceding::td[2]"));
		ArrayList<String> actualfacultiesList = new ArrayList<String>();
		for (WebElement faculty : faculties) {
			String courseName = faculty.getText();
			actualfacultiesList.add(courseName);
		}
		Assert.assertEquals(actualfacultiesList, op.verifyWhatsAppUser());
	}

	@Test(priority = 5)
	public void verifyTiming() throws Exception {
		List<WebElement> times = driver
				.findElements(By.xpath("//table/tbody/tr[position()>=2 and position()<=6]/td[6]"));
		ArrayList<String> actualWaysList = new ArrayList<String>();
		for (WebElement time : times) {
			String timeRange = time.getText();
			if (timeRange.contains("07:00 AM") || timeRange.contains("10:00 PM "))
				actualWaysList.add(timeRange);
		}

		FileInputStream fis = new FileInputStream("OperatorsTable.xls");
		Workbook w = Workbook.getWorkbook(fis);
		Sheet s = w.getSheet(0);
		int rows = s.getRows();
		//int column = s.getColumns();
		ArrayList<String> expWaysList = new ArrayList<String>();
		String val;
		for (int i = 1; i < rows; i++) {
			Cell c = s.getCell(5, i);// col,rows
			val = c.getContents();
			if (val.contains("07:00 AM") || val.contains("10:00 PM "))
				expWaysList.add(val);
		}

		System.out.println(actualWaysList);
		System.out.println(expWaysList);
		System.out.println(actualWaysList.size());
		System.out.println(expWaysList.size());
		Assert.assertEquals(actualWaysList.size(), expWaysList.size());
	}

	@Test(priority = 6)
	public void facultyNeelamTiming() throws Exception {
		WebElement name = driver.findElement(By.xpath("//table/tbody/tr/td[text()='Neelam']"));
		String t = name.findElement(By.xpath("//table/tbody/tr/td[text()='Neelam']//following::tr/td[6]")).getText();
		System.out.println(t);
		FileInputStream fis = new FileInputStream("OperatorsTable.xls");
		Workbook w = Workbook.getWorkbook(fis);
		Sheet s = w.getSheet(0);
	//	int rows = s.getRows();
		//int column = s.getColumns();
		String t1;
		Cell c = s.getCell(5, 2);// col,rows
		t1 = c.getContents();
		System.out.println(t1);
		Assert.assertEquals(t, t1);
	}

	@Test(priority = 7)
	public void facultyAvailable() throws Exception {
		WebElement time = driver.findElement(By.xpath("//table/tbody/tr/td[text()='07:00 AM to 10:00 PM ']"));
		ArrayList<String> actualContacNumber = new ArrayList<String>();
		String contactNo = time
				.findElement(By.xpath("//table/tbody/tr/td[text()='07:00 AM to 10:00 PM ']//preceding::td[1]"))
				.getText();
		actualContacNumber.add(contactNo);
		FileInputStream fis = new FileInputStream("OperatorsTable.xls");
		Workbook w = Workbook.getWorkbook(fis);
		Sheet s = w.getSheet(0);
		int rows = s.getRows();
		//int column = s.getColumns();
		ArrayList<String> expfacultiesContact = new ArrayList<String>();
		String val;
		for (int i = 1; i < rows; i++) {
			Cell c = s.getCell(5, i);// col,rows
			val = c.getContents();
			if (val.contains("07:00 AM to 10:00 PM ")) {
				c = s.getCell(4, i);
				val = c.getContents();
				expfacultiesContact.add(val);
			}
		}
		Assert.assertEquals(actualContacNumber, expfacultiesContact);
	}

	@Test(priority = 8)
	public void facultyAvailableMon_Sat() throws Exception {
		WebElement time = driver.findElement(By.xpath("//table/tbody/tr/td/b[text()='Monday-Saturday']"));
		List<WebElement> faculties = time
				.findElements(By.xpath("//table/tbody/tr/td/b[text()='Monday-Saturday']//preceding::td[4]"));
		ArrayList<String> actualfacultiesList = new ArrayList<String>();
		for (WebElement faculty : faculties) {
			String courseName = faculty.getText();
			actualfacultiesList.add(courseName);
		}
		FileInputStream fis = new FileInputStream("OperatorsTable.xls");
		Workbook w = Workbook.getWorkbook(fis);
		Sheet s = w.getSheet(0);
		int rows = s.getRows();
	//	int column = s.getColumns();
		ArrayList<String> expfacultiesList = new ArrayList<String>();
		String val;
		for (int i = 1; i < rows; i++) {
			Cell c = s.getCell(5, i);// col,rows
			val = c.getContents();
			if (val.contains("Monday-Saturday")) {
				c = s.getCell(1, i);
				val = c.getContents();
				expfacultiesList.add(val);
			}
		}
		System.out.println(actualfacultiesList);
		System.out.println(expfacultiesList);
		Assert.assertEquals(actualfacultiesList, expfacultiesList);
	}

	@Test(priority = 9)
	public void facultyNeelamFor() throws Exception {
		WebElement name = driver.findElement(By.xpath("//table/tbody/tr/td[text()='Neelam']"));
		String t = name.findElement(By.xpath("//table/tbody/tr/td[text()='Neelam']//following::td[1]")).getText();
		System.out.println(t);
		FileInputStream fis = new FileInputStream("OperatorsTable.xls");
		Workbook w = Workbook.getWorkbook(fis);
		Sheet s = w.getSheet(0);
	//	int rows = s.getRows();
	//	int column = s.getColumns();
		String t1;
		Cell c = s.getCell(2, 2);// col,rows
		t1 = c.getContents();
		System.out.println(t1);
		Assert.assertEquals(t, t1);
	}
}
