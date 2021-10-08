package core;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

import utility.screenshot;
import utility.monitoringMail;
import utility.TestConfig;

public class Page {
	public WebDriver driver = null;
	
	public Logger logs , logs2 =null;
	
	//public ExtentTest test=null;
	
	//public ExtentReports report=null;

  @Parameters({ "browser","url" })
  @BeforeTest
  public void beforeTest(String browser,String url) throws Exception {
	 
	  logs = Logger.getLogger("devpinoyLogger1");
	  logs2 = Logger.getLogger("devpinoyLogger2");
	  logs2.debug("working2");
	  logs.debug("working1");
	  
	 // report = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\ExtentReportResults.html");
	  
	 // test = report.startTest("ExtentDemo");


		if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "c:\\browser-drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			logs.debug("firefox init");
			//test.log(LogStatus.PASS, "Navigated to Firefox URL");
		}
		else if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","c:\\browser-drivers\\chromedriver.exe");
			  driver=new ChromeDriver();
			  logs2.debug("new msg..");
			  logs.debug("chrome inint");
			  
			//  test.log(LogStatus.PASS, "Navigated to the chrome URL");
		}
		driver.navigate().to(url);
		logs.debug("url open..");
		//test.log(LogStatus.PASS, "Navigated to the specified URL");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS); 
		
  }

  @AfterTest
  public void afterTest() throws Exception {
	  
	  screenshot s=new screenshot();
	  s.captureScreenShot(driver);
	  
	  monitoringMail mail=new monitoringMail();
	  logs.debug("gmail server init..");
	//  test.log(LogStatus.PASS, "Gmail Server inint");
	  try{
		  logs.debug(TestConfig.server);
		  logs.debug(TestConfig.from);
		  logs.debug(TestConfig.to);
		  logs.debug(TestConfig.subject);
		  logs.debug(TestConfig.messageBody);
		  logs.debug(TestConfig.attachmentPath);
		  logs.debug(TestConfig.attachmentName);
		  
		//mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
		Thread.sleep(7000);
		System.out.println("awake...mail ");
	  }catch(Exception e){e.printStackTrace();}   
		logs.debug("mail sent");
	//	test.log(LogStatus.PASS, "Mail sent");  
	  driver.quit();  // closing 
	  logs.debug("driver quit");
	//  test.log(LogStatus.PASS, "Browser close");
	  
	  
	//  report.endTest(test);
	  
	 // report.flush();

  }

}
