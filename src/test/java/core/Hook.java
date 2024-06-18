package core;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Hook extends Page
{
        // login
	@FindBy(xpath = externalxpath.AmazonXPath.signin)
	public static WebElement signin;
	
	@FindBy(xpath = externalxpath.AmazonXPath.uid)
	public static WebElement uid;
	
	@FindBy(xpath = externalxpath.AmazonXPath.ctnbtn)
	public static WebElement ctnbtn;
	
	@FindBy(xpath = externalxpath.AmazonXPath.err1)
	public static WebElement err1;
	
	@FindBy(xpath = externalxpath.AmazonXPath.pwd)
	public static WebElement pwd;
	
	@FindBy(xpath = externalxpath.AmazonXPath.submit)
	public static WebElement submit;
	
	@FindBy(xpath = externalxpath.AmazonXPath.err2)
	public static WebElement err2;
	
	  // product search
	@FindBy(xpath = externalxpath.AmazonXPath.searchbox)
	public static WebElement searchbox;
	
	@FindBy(xpath = externalxpath.AmazonXPath.productlist)
	public static List <WebElement> productlist;
	
	// forget
	@FindBy(xpath = externalxpath.AmazonXPath.help)
	public static WebElement help;
	
	@FindBy(xpath = externalxpath.AmazonXPath.forgetpwdlink)
	public static WebElement forgetpwdlink;
	
	@FindBy(xpath = externalxpath.AmazonXPath.forgettxtbox)
	public static WebElement forgettxtbox;
}
