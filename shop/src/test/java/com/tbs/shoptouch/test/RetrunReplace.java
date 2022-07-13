package com.tbs.shoptouch.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tbs.shoptouch.page.Returnobjects;
import com.tbs.shoptouch.utilities.Baseclass;

public class RetrunReplace extends Baseclass{
	public String totaluivalue ;
@Test
	public void returnui() {
	
	PageFactory.initElements(driver, Returnobjects.class);
	
	if (Returnobjects.returninvoicebtn.isEnabled()) {
		Returnobjects.returninvoicebtn.click();
	
		if (Returnobjects.saleinvoicepopup.isDisplayed()) {
		
			totaluivalue=Returnobjects.total.getText();
			Returnobjects.closeicon.click();
		
		}else
			{
			System.out.println("There is no return popup for the given barcode");
			}
	}else {
		System.out.println("Barcode does not exist");
	}
	Returnobjects.checkout.click();
	Returnobjects.replacement.click();
	
	Returnobjects.checkoutokbtn.click();
	
	}
}
	
