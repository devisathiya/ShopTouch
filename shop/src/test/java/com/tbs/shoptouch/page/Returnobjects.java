package com.tbs.shoptouch.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Returnobjects {

	
	@FindBy(xpath="//div[@class='returnInvoiceEntry']/img")
	public static WebElement returninvoicebtn;
	
	@FindBy(xpath="//div[contains(@class,'saleInvoice p-dialog p-dynamic-dialog')]")
	public static WebElement saleinvoicepopup;
	
	@FindBy(xpath="//div[@class='total']/span")
	public static WebElement total;
		
	@FindBy(xpath="//span[contains(@class,'p-dialog-header-close-icon')]")
	public static WebElement closeicon;
		
	@FindBy(xpath="//app-dashboard/div[1]/div[2]/div/app-bill-management/div/div[2]/app-billing-payment/div/div[2]/button[2]")
	public static WebElement checkout;
	
	@FindBy(xpath="//div/button[@class='common_button Replacement']/img")
	public static WebElement replacement;
	
	@FindBy(xpath="//div/button[@class='common_button ok']")
	public static WebElement checkoutokbtn;
	
		
	
}
