package com.tbs.shoptouch.utilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class Utilities {
	public static WebDriver driver;
	public static Properties prop;
	public static JdbcTemplate jdbcTemplate; 
	
	public void setProperties() {
		prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream stream = loader.getResourceAsStream("config.properties");
		try {
			prop.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		databaseConnection();
	}

	public  static void getScreenshot(String FileName) {
		//Create folder if not present in framework
		try {
			File file = new File("Screenshots");
			if (!file.exists()) {
				System.out.println("File created " + file);
				file.mkdir();
			}  
		//Take the screenshot
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File DestFile = new File("./"+file +"/"+ FileName+"_"+ getTimeStamp()  +".png");
			try {
				FileUtils.copyFile(srcFile, DestFile);
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("An exception occured while taking screenshot " + e.getCause());
		}
  	}
	
	public static String getTimeStamp() {
		String timestamp = new SimpleDateFormat("ddmmyyyy_HHmmss").format(Calendar.getInstance().getTime());
		return timestamp;
	}
	
	public void databaseConnection() {
		try {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			dataSource.setUrl(prop.getProperty("dburl"));
			dataSource.setUsername(prop.getProperty("dbusername"));
			dataSource.setPassword(prop.getProperty("dbpassword"));
			jdbcTemplate = new JdbcTemplate(dataSource);

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}

	}
	
	public static void closePrintPreview() {
        String jsCancel = "return document.querySelector('print-preview-app')" +
                ".shadowRoot.querySelector('#sidebar')" +
                ".shadowRoot.querySelector('print-preview-button-strip')" +
                ".shadowRoot.querySelector('cr-button.cancel-button')";
        WebDriverWait wait = new WebDriverWait(driver, 5);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement cancelButton;

        wait.until(driver -> driver.getWindowHandles().size() > 1);
        driver.switchTo().window(driver.getWindowHandles().toArray(new String[0])[1]);

        while (driver.getWindowHandles().size() > 1) {
            driver.switchTo().window(driver.getWindowHandles().toArray(new String[0])[1]);
            cancelButton = (WebElement) jse.executeScript(jsCancel);
            cancelButton.click();
        }

        driver.switchTo().window(driver.getWindowHandles().toArray(new String[0])[0]);
    }
	
}	
