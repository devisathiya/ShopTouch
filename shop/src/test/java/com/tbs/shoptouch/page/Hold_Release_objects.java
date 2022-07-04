package com.tbs.shoptouch.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Hold_Release_objects {

	//Hold objects
	@FindBy(xpath = "//div[contains(@class, 'zeroPadding ng-star-inserted')]/button[3]")
	public static WebElement holdicon;
	
	@FindBy(xpath = "//div[contains(@class, ' p-dialog p-component p-dialog-draggable p-dialog-resizable ng-star-inserted')]")
	public static WebElement holdclickwithnodata;

	@FindBy(xpath = "//div[contains(@class, 'tableMain ltrUI')]/p-table/div/div/table/tbody")
	public static WebElement billingtable;
	
	
	@FindBy(xpath = "//div[contains(@class, 'hold p-dialog p-dynamic-dialog p-component ng-star-inserted')]")
	public static WebElement holdconfirmationpopup;
	
	@FindBy(xpath = "//div[contains(@class,'p-dialog-content ng')]/app-confirmation-popup/p")
	public static WebElement holdinvoicenum;
	
	@FindBy(xpath = "//div[contains(@class, 'p-dialog-content ng-tns')]/app-confirmation-popup/div/button[2]")
	public static WebElement yesbtn;
	
	@FindBy(xpath = "//div[contains(@class, 'p-dialog-content ng-tns')]/app-confirmation-popup/div/button[1]")
	public static WebElement nobtn;
	
	
	
	//Release Objects
	
	@FindBy(xpath = "//div[contains(@class, 'zeroPadding ng-star-inserted')]/button[4]")
	public static WebElement releaseicon;
	
	@FindBy(xpath = "//div[contains(@class, 'releasePopup p-dialog p-dynamic-dialog p-component ng-star-inserted')]")
	public static WebElement invoicepopup;
	
	@FindBy(xpath = "//div[contains(@class, 'p-datatable-wrapper')]/table[contains(@class, 'p-datatable-table ng-star-inserted')]/tbody/tr/td[3]")
	public static List<WebElement> invoicenofind;
	
	@FindBy(xpath = "//div[contains(@class, 'p-datatable-wrapper')]/table[contains(@class, 'p-datatable-table ng-star-inserted')]/tbody/tr/td[1]")
	public static WebElement invoiceboxclick;
	
	@FindBy(xpath = "//div[contains(@class, 'Invoice_Buttons ng-star-inserted')]/button[1]")
	public static WebElement releaseokbtn;
	
	@FindBy(xpath = "//div[contains(@class, 'Invoice_Buttons ng-star-inserted')]/button[2]")
	public static WebElement releaseclearbtn;
	
	@FindBy(xpath = "//div[contains(@class, 'session clearHoldInvoice p-dialog')]")
	public static WebElement clearconfirmation;
	
	@FindBy(xpath = "//div[contains(@class, 'p-dialog-footer')]/button[1]")
	public static WebElement clearnobtn;
	
	@FindBy(xpath = "//div[contains(@class, 'p-dialog-footer')]/button[2]")
	public static WebElement clearyesbtn;
	
	@FindBy(xpath = "//div[contains(@class,'p-dialog-header-icons ng-tns')]/button")
	public static WebElement releasecloseicon;
	
}
