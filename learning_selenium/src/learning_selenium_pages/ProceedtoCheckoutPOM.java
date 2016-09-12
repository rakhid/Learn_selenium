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
public class ProceedtoCheckoutPOM {

	
	WebDriver driver;
    By checkoutbtn=By.partialLinkText("Proceed to checkout");
    
    
    public ProceedtoCheckoutPOM(WebDriver driver){
		this.driver=driver;
	}
	
    public void checkout(){
		driver.findElement(checkoutbtn).click();
	}
}
