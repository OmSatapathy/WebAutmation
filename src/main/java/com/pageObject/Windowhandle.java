package com.pageObject;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Windowhandle {
	
	
	WebDriver driver;
	
	// window hanlde
	@Test
	public void handle() {
		
		
		driver.switchTo().frame(1);
		
		Set<String> elem= driver.getWindowHandles();
		
		Iterator<String > itr = elem.iterator();
		
		while(itr.hasNext()) {
	
			String chld = itr.next();
			driver.switchTo().window(chld);
		}
		
		
	}
	
	
	// -iframe handle
	
	
	public void iframehandle() {
		
	
    int size = driver.findElements(By.tagName("iframe")).size();
            
            for( int i =0; i< size ; i++) {
            	
            	driver.switchTo().frame(i);
            	
            	driver.switchTo().defaultContent();
            }
		
	}
	
	// alert
	

	  public void alerts() {
		  
		  Alert  alt= driver.switchTo().alert();
		  alt.accept();
		  alt.dismiss();
		  alt.sendKeys("abcd");
		  
		  
	  }
	  
	  
	  //javascript executor
	  
	  public void jse() {
		  
	WebElement eles =  driver.findElement(By.xpath(""));
	WebElement eles1 =  driver.findElement(By.xpath(""));
	
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("argument[0].click", eles); 
		  
		  // scrolldown

		  JavascriptExecutor jss = (JavascriptExecutor) driver;
		  jss.executeScript("window.scrollBy(0,1000)");
		  
		  
		  Actions ct = new Actions(driver);
		  ct.contextClick();
		  
		  
		  ct.dragAndDrop(eles, eles1).build().perform();
		  
		  ct.release(eles1);
	  }

	  
	  
	  // Screenshot
	  
	  public void screenshot() throws IOException {
		  
		  TakesScreenshot shot = (TakesScreenshot) driver;
		  
	      File out  = shot.getScreenshotAs(OutputType.FILE);
	      
	      String path =  "";
		  
		  File des =new File(path);
		  
		  FileUtils.copyFile(out, des);
		  
		  
		  Select sele = (Select) driver.findElements(By.className(""));
		  sele.selectByIndex(0);
		  
		  
		  
		  
	  }
	  


}
