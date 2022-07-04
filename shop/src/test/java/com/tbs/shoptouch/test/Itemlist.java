package com.tbs.shoptouch.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tbs.shoptouch.page.Hompageobject;
import com.tbs.shoptouch.utilities.Baseclass;

public class Itemlist extends Baseclass{

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void Itemui(){
		PageFactory.initElements(driver, Hompageobject.class);
		String ToolTipText = Hompageobject.itemicon.getAttribute("id");
		System.out.println(ToolTipText);
//		if(ToolTipText == "Item List") {
//			Hompageobject.itemicon.click();
//		}else {
//			System.out.println("Item List is not available");
//		}
		Hompageobject.itemicon.click();
		
		List<WebElement> allpages=driver.findElements(By.xpath("//*[@id='pr_id_12']/p-paginator/div/span/button"));
	    System.out.println("Total page : "+allpages.size());

	    if(allpages.size()>0)
	    {
	        System.out.println("pagination exist");

	        //click on pagination link

	        for(int i=0;i<=allpages.size();i++)
	        {
	            allpages=driver.findElements(By.xpath("//*[@id='pr_id_12']/p-paginator/div/span/button"));
	            if(allpages.contains(prop.getProperty("Itemname")))
	            {
	                System.out.println("record exists");

	                break;
	            }

	            else
	            {
	                System.out.println("No item is available");
	                allpages.get(i).click();
	            }
	          }               
	      }

	  }

}
