package com.tbs.shoptouch.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ItemMenuClassFamilyPage {

		@FindBy(xpath="//div[@class='itemClass']/button")
		public static List<WebElement> Menulist;
		
		@FindBy(xpath="//div[@class='col-12 itemContent ng-star-inserted']/div")
		public static List<WebElement> submenu1;
		
		@FindBy(xpath="//div[@id='ItemCard']/div/div")
		public static List<WebElement> itemsinmenulist;
		
		@FindBy(xpath="//ul[@class='ngx-pagination responsive ng-star-inserted']//li[@class='ng-star-inserted' or @class='current ng-star-inserted']")
		public static List<WebElement> Pagination;
		
		@FindBy(xpath="//div[@class='itemClass']/button")
		public static List<WebElement> Itemclass1;
		
		@FindBy(xpath="//div[@class='col-12 itemContent ng-star-inserted']/div/div")
		public static List<WebElement> Itemfamily;

		@FindBy(xpath="//div[@class='itemImg back_button']")
		public static WebElement itemsbackbtn;
		
		@FindBy(xpath="//div[@class='itemCardContent ng-star-inserted']")
		public static List<WebElement> Items;
		
		
				//div[@class='ng-trigger ng-trigger-animation ng-tns-c37-10 itemList p-dialog p-dynamic-dialog p-component ng-star-inserted']
		
		@FindBy(xpath="/html/body/p-dynamicdialog/div/div/div[1]")
		public static WebElement linkitempopupheader;
		
		@FindBy(xpath="//div[@class='ng-trigger ng-trigger-animation ng-tns-c36-10 itemList p-dialog p-dynamic-dialog p-component ng-star-inserted']/div/div/button")
		public static WebElement linkitempopupheadermenuclose;
		
		@FindBy(xpath="//div[@class='link-item']/span[@class='sub-label']")
		public static WebElement linkitemsublabel;
		
		@FindBy(xpath="//div[@class='p-selectbutton p-buttonset p-component']/div")
		public static List<WebElement> linkitemstablabelname;
		
		@FindBy(xpath="//div[@class='p-listbox-list-wrapper']/ul/li")
		public static List<WebElement> notesdetails;
		
		@FindBy(xpath="//div[@class='p-listbox-list-wrapper']/ul/li")
		public static List<WebElement> chargeabledetails;
		
		@FindBy(xpath="//div/button[@class='p-element p-button-raised defaultBtn primaryBtnColor btnMargin p-button p-component']")
		public static WebElement notesaddbutton;
		
		@FindBy(xpath="//table[@id='pr_id_2-table']/tbody/tr/td")
		public static List<WebElement> itemaddcheckinbilltable;
		
		@FindBy(xpath="//img[@class='p-element topbarImg")
		public static WebElement itemicon;
		
		
		@FindBy(xpath="/html/body/p-dynamicdialog/div/div")
		public static WebElement itempopup;
		
		@FindBy(xpath="//span[@class='p-dialog-title ng-tns-c35-3']")
		public static WebElement itemheader;
		
		@FindBy(xpath="//table[@id='pr_id_3-table']/thead/tr/th")
		public static List<WebElement> itemtableheader;
		
	//Strategy Price popup Objects
		@FindBy(xpath="//div[contains(@class,'ng-trigger ng-trigger-animation ng-tns')]")
		public static WebElement strategypopup;
		
		@FindBy(xpath="//div[contains(@class,'ng-trigger ng-trigger-animation ng-tns')]/div[2]/app-strategy-price/div/h3")
		public static WebElement itemnamecheck;
		
		@FindBy(xpath="//div[contains(@class,'strategy_Level ng-star-inserted')]/p-radiobutton/div")
		public static WebElement readiobtn;
		
		@FindBy(xpath="//div[contains(@class,'footer strategy')]/button[2]")
		public static WebElement okbtn;
		
		
		//div[contains(@class,'ng-trigger ng-trigger-animation ng-tns')]/div[2]/app-strategy-price/div/div/div
		//driver.findElement(By.xpath("//td[normalize-space(text())='"+newUser+"']/a")).click();
		
		
		
}