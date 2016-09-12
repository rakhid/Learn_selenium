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
public class LoginPagePOM {

	
	By username=By.id("ap_email");
	By password=By.id("ap_password");
	By loginButton=By.id("signInSubmit");
	WebDriver driver;
	
	
	public LoginPagePOM(WebDriver driver){
		this.driver=driver;
	}
	
	public void typeUserName(String loginname){
		driver.findElement(username).sendKeys(loginname);
	}
	
	public void typePassword(String loginpsswd){
		driver.findElement(password).sendKeys(loginpsswd);
	}
	
	public void clickOnLoginButton(){
		driver.findElement(loginButton).click();
	}
}
