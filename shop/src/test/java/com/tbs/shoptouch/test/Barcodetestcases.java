package com.tbs.shoptouch.test;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.testng.annotations.Test;

import com.tbs.shoptouch.page.Barcode_objects;
import com.tbs.shoptouch.utilities.Baseclass;

public class Barcodetestcases extends Baseclass{
	public static String value;
	
	@Test
	public void barcodescan() {
	
	System.out.println(prop.getProperty("Barcodetype"));
	
	switch(prop.getProperty("Barcodetype")) {
	case "sales":
	 value=prop.getProperty("Barcodetoscan");
	 barcode();
	 
	case "utilizereplace":
		value=prop.getProperty("utilizereplacement");
		 barcode();
	if(Barcode_objects.replacementheadername.getText().equalsIgnoreCase("Replacement")) {
		System.out.println("Header Name(Replacement) is updated as per Barcode scan");
		Barcode_objects.replacementiconinheader.click();
		if(Barcode_objects.returnreplacementpopup.isEnabled()) {
			utilizereturnpopup();
			ItemMenuClassFamily.menus();
			System.out.println("Items added to billing table");
		}
		
		
}
	else {
		System.out.println("Header Name(Replacement) is not updated as per Barcode scan");
	}
		 
		 
		 
	}
		
}
	
public void barcode() {
		PageFactory.initElements(driver, Barcode_objects.class);
		if(Barcode_objects.barcodeicon.isEnabled()) {
		System.out.println("Barcode scan option is present in Home Page");
		Barcode_objects.barcodetextlabel.sendKeys(value);
		
		  
		  
			/*String x = prop.getProperty("Barcodetoscan");
			 * System.out.println(x.substring(5,10)); String Invoicenum =x.substring(5,10);
			 * Integer Invoice =Integer.parseInt(x.substring(5,10));
			 * System.out.println(Invoicenum); Integer returndays=jdbcTemplate.
			 * queryForObject("select Config_Value from POS_STATION_CONFIG where Config_Id=25 and config_name='Return No. Of Days'"
			 * , Integer.class); System.out.println(returndays);
			 * 
			 * String invoicedate=jdbcTemplate.
			 * queryForObject("select INV_DATE from POS_INVOICES where INVOICE_ID='46'"
			 * ,String.class);
			 */
		
		
		Barcode_objects.barcodesymbolclick.click();
				
		}	
		
	}


public void utilizereturnpopup() {
	
	if(Barcode_objects.returnreplacementpopup.getText().equalsIgnoreCase("Return Replacement")) {
		System.out.println("Return Replacement popup was open");
		System.out.println(Barcode_objects.replcamentdetails.getText());
		Barcode_objects.returnreplacementpopupcloseicon.click();
		
	}
	
}
	
	
}
