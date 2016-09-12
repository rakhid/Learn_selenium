/**
 * 
 */
package learning_selenium_testcases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Scanner;
import java.io.IOException;

/**
 * @author divyar
 *Defining before and after test scenario
 *Defining a function for each page verification 
 *Defining a firefox driver and closing the driver after test is complete
 */
public class Firsttest {
	
	  
    public static WebDriver driver ;
    @BeforeTest
	public void verifyFirstTest(){
    	System.out.println("Test START");
		System.out.println("Page 1");
    	FirefoxProfile profile = new FirefoxProfile();
		System.setProperty("webdriver.firefox.marionette","/Users/divyar/Downloads/geckodriver.exe");
		 
		 driver = new FirefoxDriver(new FirefoxBinary(new File("/Applications/Firefox.app/Contents/MacOS/firefox")), profile);
		
	}
    
    public void verifyPagesTest(int pagenumber){
    	String currentTitle=driver.getTitle();
    	String expectedTitle=null;
    	switch (pagenumber) {
    	
    	case 2:  expectedTitle = "Amazon Sign In";
        		break;
    	case 3:  expectedTitle = "Online Shopping: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        		break;
    	case 4:  expectedTitle = "Amazon.in: rujuta diwekar indian super foods";
        		break;
    	case 5:  expectedTitle = "Buy Indian Superfoods Book Online at Low Prices in India | Indian Superfoods Reviews & Ratings - Amazon.in";
        		break;
    	case 6:  expectedTitle = "Amazon.in Shopping Cart";
        		break;
    	case 7:  expectedTitle = "Select a delivery address";
        		break;
    	default: assert !true : "Invalid Option" ;
				break;
    	}
    	
    	if(currentTitle.equals(expectedTitle)) {
    		//do nothing
    		
    	}else{
    		assert false:"The flow has landed on the wrong page, verification failed";
    	
    	}
    	
    }
    
    @AfterTest
    public void close_browser()
    {
    	//closing the driver after test is complete
        driver.close();
        System.out.println("Test END");
    }
    
}
