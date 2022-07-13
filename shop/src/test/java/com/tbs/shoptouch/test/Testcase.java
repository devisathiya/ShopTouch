package com.tbs.shoptouch.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tbs.shoptouch.utilities.Baseclass;
import com.tbs.shoptouch.utilities.Excelutil;



public class Testcase extends Baseclass{

//	@Test
//	public void screenshottc() throws IOException {
//		
//		Utilities.getScreenshot("Login");
//		testName =extent.createTest("Test");
//		
//
//	}
	
//	@DataProvider
//	public Object[][] getLogindata() throws InvalidFormatException, IOException {
//		Object dataset[][]=Excelutil.getTestdata("Login");
//		//return new Object[][] {{"SAT1","123"},{"SAN1","123"}};
//		return dataset;
//	}
//	
//	@Test(dataProvider="getLogindata")
//	public void logintest(String username,String password) throws InvalidFormatException, IOException {
//		WebElement userid=driver.findElement(By.xpath("//*[@id='userName']"));
//		WebElement pwd=driver.findElement(By.xpath("//*[@id = 'password']"));
//		WebElement login= driver.findElement(By.xpath("//*[@id = 'submit']"));
//		
//		userid.sendKeys(username);
//		System.out.println(username);
//		pwd.sendKeys(password);
//		System.out.println(username);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		login.click();
//		
//	}
//	
}
