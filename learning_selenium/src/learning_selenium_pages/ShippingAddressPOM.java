/**
 * 
 */
package learning_selenium_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 * @author divyar
 *
 */
public class ShippingAddressPOM {

	WebDriver driver;
	
	public ShippingAddressPOM(WebDriver driver){
  		this.driver=driver;
  	}
	By fullname=By.id("enterAddressFullName");
	By mobilenumber=By.id("enterAddressPhoneNumber");
	By pincode=By.id("enterAddressPostalCode");
	By building=By.id("enterAddressAddressLine1");
	By locality=By.id("enterAddressAddressLine2");
	By city=By.id("enterAddressCity");
	By state=By.id("enterAddressStateOrRegion");
	By shiptoadd=By.name("shipToThisAddress");
	
	
	 
	@Test
	public void filladdress(){
		
		//Filling the address details to ship
		
		driver.findElement(fullname).sendKeys("Ritika Ram");
		driver.findElement(mobilenumber).sendKeys("9953668560");
		driver.findElement(pincode).sendKeys("110029");
		driver.findElement(building).sendKeys("seven spaces ");
		driver.findElement(locality).sendKeys("b-4 ,SAFDARJUNG ENCLAVE, near RDX dhaba");
		driver.findElement(city).sendKeys("New Delhi");
		driver.findElement(state).sendKeys("Delhi");
		
		WebElement mySelectElement = driver.findElement(By.id("AddressType"));
		Select se= new Select(mySelectElement);
		se.selectByValue("COM");
		
		 
	 }
	
	@Test
	public void clickOnShipButton(){
		//Clicking the "Deliver to this Address" button
		
		driver.findElement(shiptoadd).click();
	}
	
	
}
