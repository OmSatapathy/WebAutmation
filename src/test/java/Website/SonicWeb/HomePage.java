package Website.SonicWeb;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Utility.CommonUtlity;
import com.pageObject.HomepageObject;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage  {
	
	
 //  static String url = "https://www.sonicjobs.com/uk" ;
	static  WebDriver driver ;
	
	
	   // @DataProvider(name="")
	   // @Parameters({"browser"})
        @Test(priority=0)
	    public void launch(String browser) throws InterruptedException, IOException {
	    	
	    	if(browser.contains("Chrome")) {
	    		WebDriverManager.chromedriver().setup();
	  		  driver = new ChromeDriver();
	    	}
	    	else if(browser.contains("firefox")) {
	    		
				System.setProperty("webdriver.gecko.driver", "/Users/om.satapthy/Downloads/geckodriver 4");
				driver = new FirefoxDriver();
	    	}
	
		  
		
	     driver.manage().window().maximize();
		
		//driver.get("https://SonicJobs:TKNEZKEse2yuj8tq@master.dev.sonicjobs.net/");
	    
		
	     driver.get("https://www.sonicjobs.com/uk");
		
	
		
		driver.findElement(By.xpath("//div[normalize-space()='Accept'] ")).click();
		
		 
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,350)", "");
  
		
		HomepageObject pgs = new HomepageObject(driver);
	    pgs.serachAction(driver);
	    
	    
	 

	      Thread.sleep(4000);
	      
	  
	      System.out.println(driver.getTitle());
	      
	      AssertJUnit.assertEquals("Cleaner Jobs - SonicJobs", driver.getTitle());
	      
	      
	   driver.findElement(By.xpath("//button[@type='submit'] ")).click();
	      
		
	  
		
	}
        @Test(priority=1)
        public void totalNumberJobs() {
        	
        	
        	List<WebElement> jobTiles = driver.findElements(By.className("job-item_title__iVfzN"));
        	
        	for (WebElement webElement : jobTiles) {
        		
        		System.out.println(webElement.getText());
        		

				
			}
        	
        
        	CommonUtlity.selectDropdown(driver);
        	
        
        	
        }
     
}
