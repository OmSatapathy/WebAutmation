package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomepageObject {
	
	 static WebDriver driver;
	
	@FindBy(xpath = "//input[@placeholder='Job role eg ‘waiter’']")
	static WebElement jobTitle;
	
	@FindBy(xpath = "//input[@placeholder='Location eg ‘london’']")
	static WebElement location;
	
	@FindBy(xpath ="//button[contains ( text(), 'Search jobs')]") ////button[normalize-space()='Search jobs']
	static WebElement searchButton;
	
	public HomepageObject(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	public static  void enterTitle() {
		jobTitle.sendKeys("cleaner");
	}
	
	public  static void enterLocation() {
		location.sendKeys("London");
		driver.findElement(By.xpath("//header[@class='navbar_navbar__Glo9S navbar_scrolled__5VGPz ']")).click();
		
	}
	
	public static void enterButton() {
		searchButton.click();
		
	}
	
	
	public  void serachAction(WebDriver driver) {
		enterTitle();
		enterLocation();
		enterButton();

		
	}
	

}


