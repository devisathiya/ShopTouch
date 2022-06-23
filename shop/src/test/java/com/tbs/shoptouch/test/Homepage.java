package com.tbs.shoptouch.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tbs.shoptouch.page.Hompageobject;
import com.tbs.shoptouch.utilities.Baseclass;

public class Homepage extends Baseclass{

	@Test
	public void btncheck() throws IOException {
		PageFactory.initElements(driver, Hompageobject.class);
		List<String> userbtnlist = Stream.of("Take Out","Reprint","Hold","Release").collect(Collectors.toList());	
		List<String> uibtnlist = new ArrayList<String>();
		 
		for(WebElement a : Hompageobject.btn){        
			uibtnlist.add(a.getText()) ; 
		}   
		  System.out.println(uibtnlist);
		  Assert.assertEquals(userbtnlist,uibtnlist, "Given User buttons  not matched with UI button, UI Failed");
		  System.out.println(userbtnlist.containsAll(uibtnlist));
		}
	
	@Test
	public void imagecountcheck() {
		
		PageFactory.initElements(driver, Hompageobject.class);
		int imagecount= Hompageobject.headerimage.size();
				
		if(imagecount == 3) {
			System.out.println("Item List, Customer creation and selection is displayed");
		} else {
			System.out.println("Image icons are not available, either no or greater than or less than");
		}
	}
		
}
