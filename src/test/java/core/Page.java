package core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Page 
{
  
	public static WebDriver driver = null;
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	
  @Parameters({"browser","url","reportname","key","testname"})	
  @BeforeTest
  public void openBrowser(String browser,String url,String reportname,String key,String testname) 
  {
	  if(!Boolean.parseBoolean(key))
	  {
		  throw new SkipException("skip this test "+testname);
	  }
	  else
	  {
		  // report initialize
		  extent = new ExtentReports();
		spark = new ExtentSparkReporter( System.getProperty("user.dir")+"//src//test//java//reports//"+reportname+".html" );
		extent.attachReporter(spark);
		spark.config().setDocumentTitle(reportname);
	        // Name of the report
	spark.config().setReportName(reportname);
	        // Dark Theme
	spark.config().setTheme(Theme.STANDARD);
	logger = extent.createTest(testname);

		  
		  // browser open
		  if(browser.equals("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(browser.equals("edge"))
			{
				driver = new EdgeDriver();
			}
			else if(browser.equals("firefox"))
			{
				driver = new FirefoxDriver();
			}
		  
			driver.navigate().to(url); // prefer -> go back/forward/refresh
			
			logger.log(Status.INFO, MarkupHelper.createLabel( "Browser "+browser+" url "+url+" opens ", ExtentColor.BLUE));

			PageFactory.initElements(driver, this); // for reading external xpath
			
			// implicit wait 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			driver.manage().window().maximize();

		  
	  }
  }

  @AfterTest
  public void closeBrowser() 
  {
	  driver.quit();
	  extent.flush();
  }

}
