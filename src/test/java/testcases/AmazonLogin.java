package testcases;

import java.util.Iterator;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;

public class AmazonLogin extends Hook
{
	 public static boolean login = false; 
	@Test
	public void login() throws Exception
	{
		
		
		signin.click();
		uid.sendKeys("paragguide@yahoo.co.in");
		ctnbtn.click();
		   try
		   {
	String msg1 =	err1.getText();
	logger.log(Status.FAIL, MarkupHelper.createLabel( "valid uid but error showing ", ExtentColor.RED));
    Assert.fail("uid is valid but error showing");
		   }
		   catch(Exception e)
		   {
			   // valid uid
			   logger.log(Status.PASS, MarkupHelper.createLabel( "valid uid ", ExtentColor.GREEN));

			   pwd.sendKeys("RMinfotech12#&&"); 
			   submit.click();
			        try {
			   String msg2 =	err2.getText();
				logger.log(Status.FAIL, MarkupHelper.createLabel( "valid pwd but error showing ", ExtentColor.RED));
				
				Assert.fail("password is correct but not login");
			        }
			        catch(Exception ee)
			        {
			        	// valid pwd
			        	logger.log(Status.PASS, MarkupHelper.createLabel( "valid pwdd ", ExtentColor.GREEN));
                       utility.ScreenShot.takeScreenShot("SucsesLogin");
                     login = true;
			        }
			   
		   }
	
	}
	
	//@Test(dependsOnMethods = "login")  
	public void searchProducts() throws Exception
	{
		searchbox.sendKeys("shirt");
		logger.log(Status.PASS, MarkupHelper.createLabel( " searching for shirtproducts  ", ExtentColor.GREEN));

		Actions a = new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
		
		utility.ScreenShot.takeScreenShot("productsearch");
		
	Iterator <WebElement> it =	productlist.iterator();
	   while(it.hasNext())
	   {
		  WebElement product = it.next();
		  
		  logger.log(Status.PASS, MarkupHelper.createLabel( "products  "+product.getText(), ExtentColor.GREEN));

	   }
	}
}
