package Website.SonicWeb;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.pageObject.HomepageObject;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchIngWindow {

	
	static  WebDriver driver ;
	
	
	@Test
    public void launch(String browser) throws InterruptedException, IOException {
    	
    	
    		WebDriverManager.chromedriver().setup();
  		  driver = new ChromeDriver();
    	
	
     driver.manage().window().maximize();
     
     

     driver.get("https://www.sonicjobs.com/uk");
	

	

	
	 
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,350)", "");

	
	HomepageObject pgs = new HomepageObject(driver);
    pgs.serachAction(driver);
    
    
 

      Thread.sleep(4000);
      
      
	}
	
}
