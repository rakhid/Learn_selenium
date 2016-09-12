package learning_selenium_pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

 

public class LoginPage {

/**

* @param args

*/

       public static void main(String[] args) {

    	 //System.setProperty("webdriver.chrome.driver","/Users/divyar/Desktop/chromedriver");
   		//driver=new ChromeDriver();
           
       	// Defining a Firefox driver           

// location declaration ,objects and variables instantiation
    	      System.setProperty("webdriver.chrome.driver","/Users/divyar/Desktop/chromedriver");
    	  
              WebDriver driver = new ChromeDriver();

              String appUrl = "https://www.amazon.in/ap/signin?_encoding=UTF8&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin";

              

// launch the chrome browser and open the application url

              driver.get(appUrl);

              

// maximize the browser window

              driver.manage().window().maximize();

              

// declare and initialize the variable to store the expected title of the webpage.

              String expectedTitle = "Amazon Sign In";

              

// fetch the title of the web page and save it into a string variable

              String actualTitle = driver.getTitle();

              

// compare the expected title of the page with the actual title of the page and print the result
              System.out.println(actualTitle);
              if (expectedTitle.equals(actualTitle))

              {

                     System.out.println("Verification Successful - The correct title is displayed on the web page.");

              }

             else

              {

                     System.out.println("Verification Failed - An incorrect title is displayed on the web page.");

              }

 

// enter a valid username in the email textbox

              WebElement username = driver.findElement(By.id("ap_email"));

              username.clear();

              username.sendKeys("divyarakhiani7@gmail.com");

              

// enter a valid password in the password textbox

              WebElement password = driver.findElement(By.id("ap_password"));

              password.clear();

              password.sendKeys("rakhiani");

              

// click on the Sign in button

              WebElement SignInButton = driver.findElement(By.id("signInSubmit"));

              SignInButton.click();
              

// close the web browser

              driver.close();

              System.out.println("Test script executed successfully.");

              

// terminate the program

              System.exit(0);

       }
       


}