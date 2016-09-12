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
public class AddtocartPOM {

	
	WebDriver driver;
      By cartitem=By.name("submit.add-to-cart");
      
      public AddtocartPOM(WebDriver driver){
  		this.driver=driver;
  	}
	
      public void addtocart(){
  		driver.findElement(cartitem).click();
  	}
}
