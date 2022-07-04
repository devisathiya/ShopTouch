package com.tbs.shoptouch.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tbs.shoptouch.page.Hold_Release_objects;
import com.tbs.shoptouch.utilities.Baseclass;

public class Holdtestcases extends Baseclass {
 public static int holdnum;
 
	@Test
	public static void hold() {
		
		testName=extent.createTest("Hold Testcases");
		PageFactory.initElements(driver, Hold_Release_objects.class);
		if(Hold_Release_objects.holdicon.isEnabled()) {
			testName.log(Status.PASS, "Hold Icon present in Home Page");
		}
		else {
			testName.log(Status.FAIL, "Hold Icon Not present in Home Page");
			}

		
		if(Hold_Release_objects.billingtable.getText().isEmpty()) {
			Hold_Release_objects.holdicon.click();	
			if(Hold_Release_objects.holdclickwithnodata.isDisplayed()) {
				System.out.println(Hold_Release_objects.holdclickwithnodata.getText());
				testName.log(Status.PASS, "Negative(Click on Hold option when no data in Billing Table) case of Hold working fine");
			}}
			else {
				Hold_Release_objects.holdicon.click();
				if(Hold_Release_objects.holdconfirmationpopup.isDisplayed()) {
					String num=Hold_Release_objects.holdinvoicenum.getText();
					holdnum=Integer.parseInt(num);
					System.out.println(holdnum);
				if(prop.getProperty("Holdconfirmbtn").equalsIgnoreCase("yes")) {
					Hold_Release_objects.yesbtn.click();
					closePrintPreview();
					if(Hold_Release_objects.billingtable.getText().isEmpty()) {
						testName.log(Status.PASS, "Selected invoice is Held");	
					}
					else {
						testName.log(Status.FAIL, "Selected invoice is not Held. Having issue in this process");
					}
					
				}
				else {
					Hold_Release_objects.nobtn.click();
					if(!Hold_Release_objects.billingtable.getText().isEmpty()) {
						testName.log(Status.PASS, "Hold cancel process working fine");
					}
					else
					{
						testName.log(Status.FAIL, "Selected invoice is Held. Having issue in this process");
					}
				}
					
				}
			}
			
		}
	}
	
	
	
	

