package com.tbs.shoptouch.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Barcode_objects {

	@FindBy(xpath="//div[@class='actionSection']/div[1]")
	public static WebElement barcodeicon;
	
	@FindBy(xpath="//div[@class='actionSection']/div[1]/div[1]/input")
	public static WebElement barcodetextlabel;

	@FindBy(xpath="//div[@class='actionSection']/div[1]/div[2]")
	public static WebElement barcodesymbolclick;
	
	@FindBy(xpath="//div[@class='returnInvoiceEntry']")
	public static WebElement replacementiconinheader;
	
	@FindBy(xpath="//div[@class='headerContainer']/div[2]")
	public static WebElement replacementheadername;
	
	@FindBy(xpath="//div[contains(@class, 'ng-trigger ng-trigger-animation')]/div[1]/span")
	public static WebElement returnreplacementpopup;
	
	@FindBy(xpath="//div[contains(@class, 'ng-trigger ng-trigger-animation')]/div[1]/div/button")
	public static WebElement returnreplacementpopupcloseicon;
	
	@FindBy(xpath="//div[contains(@class, 'ng-trigger ng-trigger-animation')]/div[2]/app-return-invoice/div")
	public static WebElement replcamentdetails;
	
}
