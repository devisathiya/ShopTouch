package com.tbs.shoptouch.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tbs.shoptouch.page.Hold_Release_objects;
import com.tbs.shoptouch.utilities.Baseclass;

public class Releasetestcases extends Baseclass {

	@Test
	public void releaseui() {
		testName=extent.createTest("Release Testcases");
		PageFactory.initElements(driver, Hold_Release_objects.class);
		if(Hold_Release_objects.releaseicon.isEnabled()) {
			testName.log(Status.PASS, "Release Icon present in Home Page");
		}
		else {
			testName.log(Status.FAIL, "Release Icon Not present in Home Page");
			}

	}
	@Test(dependsOnMethods="releaseui")
	public void releasefunc() {
		PageFactory.initElements(driver, Hold_Release_objects.class);
		Hold_Release_objects.releaseicon.click();
		if(Hold_Release_objects.invoicepopup.isDisplayed()) {
			System.out.println("List of Held invoice popup present");
			for(WebElement invoices:Hold_Release_objects.invoicenofind ) {
				
			if(invoices.getText().equalsIgnoreCase(prop.getProperty("invoicenumtorelease"))) {
			
				Hold_Release_objects.invoiceboxclick.click();
				System.out.println("Invoice is selected");
				if(prop.getProperty("releaseconfirmation").equalsIgnoreCase("Clear Hold")) {
					Hold_Release_objects.releaseclearbtn.click();
					if(Hold_Release_objects.clearconfirmation.isDisplayed()) {
						System.out.println("Invoice Clear confirmation pop up is present");
						
						if(prop.getProperty("releaseclearoptn").equalsIgnoreCase("yes")) {
							
							Hold_Release_objects.clearyesbtn.click();
							testName.log(Status.PASS, "Given invoice is cleared from Hold");
						}
						else {
							Hold_Release_objects.clearnobtn.click();
							Hold_Release_objects.releasecloseicon.click();
							testName.log(Status.PASS, "Given invoice is not cleared from Hold and closed the release popup");
						}
						
					}
					
					
					}
				else {
					Hold_Release_objects.releaseokbtn.click();
					if(!Hold_Release_objects.billingtable.getText().isEmpty()) {
						System.out.println("selected invoice is released from hold and present in billing screen");
						testName.log(Status.PASS, "selected invoice is released from hold and present in billing screen");
					}
					
				}
				
			break;}
		}
		}
	}
}
