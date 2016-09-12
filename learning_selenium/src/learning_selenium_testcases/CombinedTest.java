/**
 * 
 */
package learning_selenium_testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.BindException;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import learning_selenium_pages.AddtocartPOM;
import learning_selenium_pages.HomepageSearchPOM;
import learning_selenium_pages.LoginPagePOM;
import learning_selenium_pages.ProceedtoCheckoutPOM;
import learning_selenium_pages.SelectionPagePOM;
import learning_selenium_pages.ShippingAddressPOM;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.poi.*;


/**
 * @author divyar
 *combining all test 
 *This business case is to do the following :- 
 *1.)login to amazon as a valid user .
 *2.)select a product based on search string .
 *3.)select the product 
 *4.)put the product into the card
 *5.)move it to checkout 
 *6.)fill the shipping address 
 *The code uses excel sheet to pick up data for login.
 *
 */
public class CombinedTest extends Firsttest{
	
	
	public void switchWindow(){
    	String handle =Firsttest.driver.getWindowHandle();
		
		
		Set<String> handles =Firsttest.driver.getWindowHandles();
		
		for (String hnd:handles){
			if(!hnd.equals(handle)){
				Firsttest.driver.switchTo().window(hnd);
			}
		}
		
    }
	
	@Test(dataProvider="TestData")
	public void businessFlowOne(String loginname , String loginpasswd){
		
		//declaring objects of all classes 
		
		LoginPagePOM login =new LoginPagePOM(Firsttest.driver);
		HomepageSearchPOM search =new HomepageSearchPOM(Firsttest.driver);
		SelectionPagePOM sp = new SelectionPagePOM(Firsttest.driver);
		ProceedtoCheckoutPOM ptc =new ProceedtoCheckoutPOM(Firsttest.driver);
		ShippingAddressPOM sa =new ShippingAddressPOM(Firsttest.driver);
		AddtocartPOM atc =new AddtocartPOM(Firsttest.driver);
		Firsttest ft=new Firsttest();
		
		
		String appUrl = "https://www.amazon.in/ap/signin?_encoding=UTF8&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin";

        Firsttest.driver.get(appUrl);
        
        Firsttest.driver.manage().window().maximize();
		
		//verification of page2 
		ft.verifyPagesTest(2);
		
		//logging in the login page
		login.typeUserName(loginname);
        login.typePassword(loginpasswd);
        login.clickOnLoginButton();
        
        //verification of page3
        ft.verifyPagesTest(3);
        
        //searching for specified item
        search.searchname();
        search.clickOnsearchButton();
        
        //verification of page4
        ft.verifyPagesTest(4);
        
       //selecting the item
        sp.clickontitle();
        
       //new tab gets opened , transfer the control
        switchWindow();
        
      //verification of page5
        ft.verifyPagesTest(5);
        
       //adding the item to cart
        atc.addtocart();
        
      //verification of page6
        ft.verifyPagesTest(6);
        
       //proceed to checkout 
        ptc.checkout();
        
      //verification of page7
        ft.verifyPagesTest(7);
           
       //fill in the shipping address and click the button "ship to this address"
        sa.filladdress();
		sa.clickOnShipButton();
	}
	
	@DataProvider(name="TestData")
	public Object[][] passData()
	{   
	 	///Users/divyar/Documents/workspace/
		Object[][] data=getExcelData("../learning_selenium/src/Excel_sheet/test1.xls","Sheet1");
		
		
		return data;
		
	}
	
	public  String[][] getExcelData(String fileName,String sheetName){
		String[][] arrayExcelData=null;
			
			try {
				
				FileInputStream fs= new FileInputStream(fileName);
				
				Workbook wb=Workbook.getWorkbook(fs);
				
				Sheet sh= wb.getSheet(sheetName);
				// make sure value of column is always constant as columns remain same and rows change
				int rowcount=sh.getRows();
				int colcount=sh.getColumns();
				
				if(rowcount==colcount){
					arrayExcelData=new String[rowcount][colcount];
					for(int i=0;i<rowcount;i++){
						
						for(int j=0;j<colcount;j++){
							
					      /*The matrix gets transposed while being read from Excel*/
					      arrayExcelData[i][j]=sh.getCell(j,i).getContents();
									
						}
					}
				}else{
				
				arrayExcelData=new String[rowcount-1][colcount-1];
				
				for(int i=0;i<rowcount-1;i++){
					
					for(int j=0;j<colcount-1;j++){
						
				      /*The matrix gets transposed while being read from Excel*/
				      arrayExcelData[i][j]=sh.getCell(j,i).getContents();
								
					}
				}
				}
			}catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		return arrayExcelData;
		
	}
}
