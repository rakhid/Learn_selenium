/**
 * 
 */
package learning_selenium_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author divyar
 *
 */
public class HomepageSearchPOM {

	
	By searchname=By.id("twotabsearchtextbox");
	By searchButton=By.id("nav-search-submit-text");
	By searchClass=By.className("nav-input");
	WebDriver driver;
	
	public HomepageSearchPOM(WebDriver driver){
		this.driver=driver;
	}
	
	public void searchname(){
		driver.findElement(searchname).sendKeys("rujuta diwekar indian super foods");
	}
	
	public void clickOnsearchButton(){
		
		driver.findElement(searchClass).click();
	}
}
