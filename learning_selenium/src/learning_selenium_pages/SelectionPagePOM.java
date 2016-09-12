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
public class SelectionPagePOM {

WebDriver driver;
	
      By titlename=By.linkText("Indian Superfoods");
      
	
	public SelectionPagePOM(WebDriver driver){
		this.driver=driver;
	}
	
	public void clickontitle(){
		driver.findElement(titlename).click();
	}
	
	
}
