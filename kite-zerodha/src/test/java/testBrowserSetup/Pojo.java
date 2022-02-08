package testBrowserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Pojo {
	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Shubham\\software testing\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
		
	}
	
	public static WebDriver openOperaBrowser() {
		System.setProperty("webdriver.opera.driver","C:\\Shubham\\software testing\\operadriver.exe");
		WebDriver driver = new OperaDriver();
		return driver;
		
	}
	
	public static WebDriver openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver","C:\\Shubham\\software testing\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
}