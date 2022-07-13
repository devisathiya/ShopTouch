package com.tbs.shoptouch.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tbs.shoptouch.page.ItemMenuClassFamilyPage;
import com.tbs.shoptouch.utilities.Baseclass;


public class ItemMenuClassFamily extends Baseclass{

	public static String menuitem ;
	public static String classitem;
	public static String familyitem;
	
	public static String notes;
	public static String chargable ;
	public static String submenu;
	public static String itemsinmenu;
	@Test
	//(priority=0)
	public static void menus() {
		menuitem =prop.getProperty("menuitem");
		classitem = prop.getProperty("classitem");
		familyitem = prop.getProperty("familyitem");
		notes = prop.getProperty("notes");
		chargable = prop.getProperty("chargable");
		submenu=prop.getProperty("submenu");
		itemsinmenu=prop.getProperty("itemsinmenu");
		
		PageFactory.initElements(driver, ItemMenuClassFamilyPage.class);
		testName=extent.createTest("Item Menu/Class/Family Testcases");
		String menuitemDBvalue=jdbcTemplate.queryForObject("select Config_Value from POS_STATION_CONFIG where config_id=59 and Config_Name='Using POS Menu'", String.class);
		System.out.println("The POSmenu config value in DB= " +menuitemDBvalue);
		testName.log(Status.INFO, "The POSmenu config value in DB= " +menuitemDBvalue);
		if(menuitemDBvalue.equalsIgnoreCase("T")) {
			
			for(WebElement list:ItemMenuClassFamilyPage.Menulist) {
				System.out.println("The POS menu lists are: " + list.getText());
				testName.log(Status.INFO,"The POS menu lists are Present" + list.getText());
				List<String> myList = new ArrayList<String>(Arrays.asList(menuitem.split(",")));
				for(String menuitem1:myList) {
				if(menuitem1.equalsIgnoreCase(list.getText())) {
					list.click();
					System.out.println(list.getText()+ " Menu option is selected from menu list");
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					for(WebElement submenulist: ItemMenuClassFamilyPage.submenu1) {
						List<String> mysubmenu = new ArrayList<String>(Arrays.asList(submenu.split(",")));
						for(String submenu:mysubmenu) {
					if(submenulist.getText().equalsIgnoreCase(submenu))	{
						submenulist.click();
						for(WebElement itemsmenu1 : ItemMenuClassFamilyPage.itemsinmenulist) {
							List<String> myListmenuitem = new ArrayList<String>(Arrays.asList(itemsinmenu.split(",")));
							for(String itemsmenu : myListmenuitem) {
							if(itemsmenu.equalsIgnoreCase(itemsmenu1.getText())) {
								itemsmenu1.click();
								/*
								 * if(ItemMenuClassFamilyPage.linkitempopupheadermenuclose.isDisplayed()) {
								 * ItemMenuClassFamilyPage.linkitempopupheadermenuclose.click(); }
								 */
								System.out.println(itemsmenu1.getText()+ " Items under Menu option is selected from menu list");
								testName.log(Status.INFO, itemsmenu1.getText()+ " Items underoption is selected from menu list");
								
											}									
										}
									}
					}
							}
						}
					}	
					}
			}
		}

		else {
			testName=extent.createTest("Item class, Family Cards Testcases");
		
			if(ItemMenuClassFamilyPage.Pagination.size()>0) {
				System.out.println("Size of the pagination :" + ItemMenuClassFamilyPage.Pagination.size()); 

				for(WebElement pagesize:ItemMenuClassFamilyPage.Pagination) {
					WebDriverWait wait=new WebDriverWait(driver, 50);
					wait.until(ExpectedConditions.elementToBeClickable(pagesize)).click();
					for (WebElement option : ItemMenuClassFamilyPage.Itemclass1) {
						System.out.println("Text :" + option.getText()); 
						List<String> itemclass = new ArrayList<String>(Arrays.asList(classitem.split(",")));
						for(String classitem :itemclass) {
						if(option.getText().equalsIgnoreCase(classitem)) {
							option.click();
							System.out.println(classitem + " Item Class Option is clicked");
							driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
							int familyloop=0;
						
							try {
							
								List<String> itemfamily = new ArrayList<String>(Arrays.asList(familyitem.split(",")));
								for(String familyitem1:itemfamily){
									for (WebElement family : ItemMenuClassFamilyPage.Itemfamily) {
								if(familyitem1.equalsIgnoreCase(family.getText())) {	
									family.click();
									System.out.println(familyitem + " Item Family is selected");
									for(WebElement itemlist : ItemMenuClassFamilyPage.Items) {
										System.out.println(" Items lists under the selected item family " + itemlist.getText() );
										List<String> itemlist1 = new ArrayList<String>(Arrays.asList(prop.getProperty("Items").split(",")));
										for(String splititems:itemlist1) {
											//System.out.println(splititems+" Items in config file");
										if(itemlist.getText().equalsIgnoreCase(splititems)) {
											System.out.println( itemlist.getText() + " Item list is clicked under the selected item family");
											
											String strategyconfig =jdbcTemplate.queryForObject("select Config_Value from POS_STATION_CONFIG where Config_Id=24 and Config_Name='Use Strategy Price'",String.class );
											if(strategyconfig.equalsIgnoreCase("T")) {
												itemlist.click();
												if(ItemMenuClassFamilyPage.strategypopup.isDisplayed()) {
													System.out.println("Strategy Price popup is present");
													if(ItemMenuClassFamilyPage.itemnamecheck.getText().equalsIgnoreCase(itemlist.getText())) {
														System.out.println("Strategy Price popup item name is same as Selected item name ");
														ItemMenuClassFamilyPage.readiobtn.click();
														ItemMenuClassFamilyPage.okbtn.click();
													}
													else {
														System.out.println("Strategy Price popup item name is not same as Selected item name ");
													}
													
													
													
													
												}
												
											}
											else {
												itemlist.click();
											}
											
											String a= itemlist.getText();
											//DB check need to do for link items
											driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
											testName.log(Status.PASS, "Given Item selected from item section and its present in Billing Table");
											
										try {
											driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
											if(ItemMenuClassFamilyPage.linkitempopupheader.isDisplayed()) {
												System.out.println(" Selected item have Link Items");
												driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
												if(ItemMenuClassFamilyPage.linkitemsublabel.getText().equalsIgnoreCase(itemlist.getText()))
												{
													System.out.println(" Link item label name in linkitem pop is same as item selected in card. Selected item name is " +ItemMenuClassFamilyPage.linkitemsublabel.getText());
													for(WebElement linkitemtab:ItemMenuClassFamilyPage.linkitemstablabelname)
													{
														switch(linkitemtab.getText()) {
														case "Notes":
															for(WebElement notesdetail:ItemMenuClassFamilyPage.notesdetails) {
																if(notes.contains(notesdetail.getText())) {
																	System.out.println(" Selected Notes details are: " +notesdetail.getText());
																	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
																	notesdetail.click();
																	
																}
															}
															break;
															
														case "Free":
															 linkitemtab.click(); 
															  for(WebElement freeitem:ItemMenuClassFamilyPage.notesdetails) {
															  if(prop.getProperty("freeitems").contains(freeitem.getText())) {
															  System.out.println("Selected Free item details are: " +freeitem.getText());
															  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
															  freeitem.click();
															
															  }
															  
															  }
															  break;
														case "Chargeable Items":
															linkitemtab.click();
															for(WebElement chargeableitem:ItemMenuClassFamilyPage.chargeabledetails) {
																String[] splittotalvalue = chargeableitem.getText().split("\n");
																List<String> myList = new ArrayList<String>(Arrays.asList(chargable.split(",")));
																for(String list:myList) {
																if(list.equalsIgnoreCase(splittotalvalue[0])) {
																	 System.out.println(" chargeable item details: " +splittotalvalue[0]); 
																	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
																	 chargeableitem.click(); 
																}
																	  }
																	  } 
															}
														}
												
													}
												ItemMenuClassFamilyPage.notesaddbutton.click();
												driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
												} }catch(Exception e) {}
											
										
										
										//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
										
										for(WebElement i:ItemMenuClassFamilyPage.itemaddcheckinbilltable) {
											System.out.println("Text: "+i.getText());
											if(i.getText().equalsIgnoreCase(a)) {
												System.out.println(" Selected item is added to billing table");
												testName.log(Status.PASS, "Given Item selected from item section and its present in Billing Table");
												
											}
											}
										
											/*
											 * else { System.out.println(" Selected item does not have Link Items");
											 * 
											 * }
											 */
											
										
											
										
											}
									}
										}ItemMenuClassFamilyPage.itemsbackbtn.click();
									
							}

						}}
							}
							catch(StaleElementReferenceException e) {}
					

					}
							}
		
						}

				}

			}

		}
}

		}