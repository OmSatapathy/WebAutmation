package com.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtlity {

	
	static WebDriver driver;
	
	public static void Explictwait() {
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='Find a job in London']")));
	}
	
	public static void readFile() throws IOException {
		
		FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream("src/main/java/com/propertyFiles/common.properties");
	         prop = new Properties();
	         prop.load(fis);
	         
	         prop.getProperty("prod_url");
	         
	         
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         fis.close();
	      }
	     
		
	}
	
	
	public static void selectDropdown(WebDriver driver) {
		
		 driver.findElement(By.className("css-1icznci-indicatorContainer")).click();
		
	   WebElement filter =  driver.findElement(By.className("css-uav3tb-control"));
	    Select sel = new Select(filter);
	    sel.deselectByValue("Most Relevant");
	 
	}

	
	
	
}
