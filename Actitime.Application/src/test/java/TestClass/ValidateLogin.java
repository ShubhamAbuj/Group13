package TestClass;



import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.base;
import POM.Loginpage;


public class ValidateLogin extends base{
	private WebDriver driver;
	private Loginpage loginpage;
	ExtentReporter reporter;
	ExtentReports extend;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) throws Exception {
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		System.out.println("Before Test");
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = openChromeBrowser();
		}
		if(browser.equalsIgnoreCase("Opera"))
		{
			driver = openOperaBrowser();
		}
		if(browser.equalsIgnoreCase("Firefox"))
		{
			driver = openFirefoxBrowser();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void createObject() 
	{
		System.out.println("create Object");
		loginpage = new Loginpage(driver);
	}
	
	@BeforeMethod
	public void OpenUrl() {
		driver.get("http://localhost/login.do");
		driver.manage().window().maximize();
	}
	
	@Test
	public void Login() {
		loginpage.SendUsername();
		loginpage.SendPassword();
		loginpage.ClickonLogin();
	}
	
	@AfterMethod
	public void Logout() {
		loginpage.clickonLogout();
	}
	
	@AfterClass
	public void CloseBrowser() {
		loginpage = null;
	}
	
	@AfterTest
	public void CloseObject() {
		driver.quit();
		driver = null;
		System.gc();
	}
	

}
