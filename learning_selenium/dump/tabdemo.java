/**
 * 
 */
package learning_selenium_testcases;
import java.io.File;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @author divyar
 *
 */
public class tabdemo {
	
	public static void main(String[] args){
		FirefoxProfile profile = new FirefoxProfile();
		System.setProperty("webdriver.firefox.marionette","/Users/divyar/Downloads/geckodriver.exe");
		 
		WebDriver driver = new FirefoxDriver(new FirefoxBinary(new File("/Applications/Firefox.app/Contents/MacOS/firefox")), profile);
		
		 
		driver.get("http://google.com");
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		
		driver.get("http://bling.com");
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
		
		System.out.println(driver.getTitle());
	}

}
