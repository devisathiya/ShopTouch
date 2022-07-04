package com.tbs.shoptouch.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Hompageobject{

	@FindBy(xpath="//div[contains(@class, 'zeroPadding ng-star-inserted')]/button")
	public static List<WebElement> btn;
	
	@FindBy(xpath="//app-dashboard/div[1]/div[1]/app-topbar/div/div[2]/div/img[contains(@class,'p-element topbarImg')]")
	public static List<WebElement> headerimage;
	
	@FindBy(xpath="//app-dashboard/div[1]/div[1]/app-topbar/div/div[2]/div[1]/img[contains(@class,'p-element topbarImg')]")
	public static WebElement itemicon;
	

	@FindBy(xpath="//*[@id='billingTable']")
	public static WebElement billingTable;
	

	
	
	
	
	

	
	
}
