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
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.base;
import POM.ActitimeHeader;
import POM.Loginpage;
import Utility.Utilty;

public class validateHeader extends base{

	private WebDriver driver;
	private Loginpage loginpage;
	private ActitimeHeader actitimeheader;
	private ExtentReports extend;
	int testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
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
		System.out.println("CreateObject");
		actitimeheader =new ActitimeHeader(driver);
		loginpage = new Loginpage(driver);
	}
	
	@BeforeMethod
	public void loginToUserAccount() {
		System.out.println("loginToUserAccount");
		driver.get("http://localhost/login.do");
		driver.manage().window().maximize();
		loginpage.SendUsername();
		loginpage.SendPassword();
		loginpage.ClickonLogin();
	}
	
	@Test
	public void VerifyTimetrack() {
		System.out.println("");
		testID = 100;
		actitimeheader.ClickonTimetrack();
		String Timetrack = driver.getCurrentUrl();
		System.out.println(Timetrack);
		Assert.assertEquals(Timetrack, "http://localhost/user/submit_tt.do");
	}
	
	@Test
	public void VerifyTasks() {
		testID = 101;
		actitimeheader.ClickonTask();
		String Tasks = driver.getCurrentUrl();
		System.out.println(Tasks);
		Assert.assertEquals(Tasks, "http://localhost/tasks/otasklist.do");
	}
	
	@Test
	public void VerifyReports() {
		testID = 102;
		actitimeheader.ClickonReports();
		String Reports = driver.getCurrentUrl();
		System.out.println(Reports);
		Assert.assertEquals(Reports, "http://localhost/reports/reports.do");
	}
	
	@Test
	public void VerifyUsers() {
		testID = 103;
		actitimeheader.Clickonusers();
		String Users = driver.getCurrentUrl();
		System.out.println(Users);
		Assert.assertEquals(Users, "http://localhost/administration/userlist.do");
	}
	
	@Test
	public void VerifyWorkSchedule() {
		testID = 104;
		actitimeheader.ClickonWorkschedule();
		String Schedule = driver.getCurrentUrl();
		System.out.println(Schedule);
		Assert.assertEquals(Schedule, "http://localhost/administration/workingdays.do");
	}
	
	@AfterMethod
	public void Logout() throws IOException {
		testID = 105;
		loginpage.clickonLogout();
		Utilty.ScreenShot(driver, testID);
	}
	
	@AfterClass
	public void CloseObject() {
		actitimeheader = null;
		loginpage = null;
	}
	
	@AfterTest
	public void CloseBrowser() {
		driver.close();
		driver = null;
		System.gc();
	}
}
