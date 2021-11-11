package com.PageDistribution.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DownloadsPageObjectRepository {
@FindBy(xpath="//tr[2]/td[8]")
public WebElement officialWebsiteBtn1;
@FindBy(xpath="//tr[3]/td[8]")
public WebElement officialWebsiteBtn2;
@FindBy(xpath="//tr[4]/td[8]")
public WebElement officialWebsiteBtn3;
@FindBy(xpath="//tr[5]/td[8]")
public WebElement officialWebsiteBtn4;
@FindBy(xpath="//tr[6]/td[8]")
public WebElement officialWebsiteBtn5;
@FindBy(xpath="//tr[7]/td[8]")
public WebElement officialWebsiteBtn6;
@FindBy(xpath="//tr[8]/td[8]")
public WebElement officialWebsiteBtn7;
}
