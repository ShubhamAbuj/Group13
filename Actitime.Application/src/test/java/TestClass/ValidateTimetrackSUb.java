package TestClass;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.base;
import POM.Loginpage;
import POM.TimetrackSUb;
import Utility.Utilty;


public class ValidateTimetrackSUb extends base{
	private WebDriver driver;
	private Loginpage loginpage;
	private TimetrackSUb timetracksub;
	static ExtentHtmlReporter reporter;
	static ExtentReports extend;
	int testID;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) throws Exception {
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		extend = new ExtentReports();
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
	public void CreateObject() {
		loginpage = new Loginpage(driver);
		timetracksub =new TimetrackSUb(driver);
	}
	
	@BeforeMethod
	public void Login() {
		driver.get("http://localhost/login.do");
		driver.manage().window().maximize();
		loginpage.SendUsername();
		loginpage.SendPassword();
		loginpage.ClickonLogin();
	}
	
	@Test
	public void ViewTT() {
		testID = 201;
		timetracksub.ClickViewTT();
		String TT = driver.getCurrentUrl();
		System.out.println(TT);
		Assert.assertEquals(TT,"http://localhost/user/view_tt.do");
	}
	
	@Test
	public void EnterTT() {
		testID = 201;
		timetracksub.ClickEnterTT();
		String EnterTT = driver.getCurrentUrl();
		System.out.println(EnterTT);
		Assert.assertEquals(EnterTT,"http://localhost/user/submit_tt.do");
	}
	
	@AfterMethod
	public void Logout() throws IOException {
		loginpage.clickonLogout();
		Utilty.ScreenShot(driver, testID);
	}
	
	@AfterClass
	public void CloseObjet() {
		loginpage = null;
		timetracksub = null;
	}
	@AfterTest
	public void CloseBrowser() {
		driver.close();
		driver = null;
		System.gc();
	}
}
