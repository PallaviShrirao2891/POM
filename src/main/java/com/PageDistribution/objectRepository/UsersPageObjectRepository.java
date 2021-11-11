package com.PageDistribution.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPageObjectRepository {
@FindBy(xpath=("//button[text()='Add User']"))
public WebElement addUserButton;
@FindBy(xpath=("//tr[2]//td[8]"))
public WebElement deleteButton1;
@FindBy(xpath=("//tr[3]//td[8]"))
public WebElement deleteButton2;
@FindBy(xpath=("//tr[4]//td[8]"))
public WebElement deleteButton3;
@FindBy(xpath=("//tr[5]//td[8]"))
public WebElement deleteButton4;

}
