package testcases;

import java.util.Iterator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;

public class ProductSearch 
{

	@Test
	public void search() throws Exception
	{
		   if(AmazonLogin.login == true)
		   {
		Hook.searchbox.sendKeys("shirt");
		Hook.logger.log(Status.PASS, MarkupHelper.createLabel( " searching for shirtproducts  ", ExtentColor.GREEN));

		Actions a = new Actions(Hook.driver);
		a.sendKeys(Keys.ENTER).perform();
		
		utility.ScreenShot.takeScreenShot("productsearch");
		
	Iterator <WebElement> it =	Hook.productlist.iterator();
	   while(it.hasNext())
	   {
		  WebElement product = it.next();
		  
		  Hook.logger.log(Status.PASS, MarkupHelper.createLabel( "products  "+product.getText(), ExtentColor.GREEN));

	   }
	} 
		   

	}
	
}
