package com.PageDistribution.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsefulLinksPageObjectRepository {
@FindBy(xpath="//tr[2]/td[3]")
public WebElement goButton1;
@FindBy(xpath="//tr[3]/td[3]")
public WebElement goButton2;
@FindBy(xpath="//tr[4]/td[3]")
public WebElement goButton3;
@FindBy(xpath="//tr[5]/td[3]")
public WebElement goButton4;
@FindBy(xpath="//tr[6]/td[3]")
public WebElement goButton5;
@FindBy(xpath="//tr[7]/td[3]")
public WebElement goButton6;

}
