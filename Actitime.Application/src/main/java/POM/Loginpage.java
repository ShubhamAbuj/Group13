package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage 
{
	@FindBy(xpath = "//input[@name='username']")private WebElement Username;
	@FindBy(xpath = "//input[@placeholder='Password']")private WebElement Password;
	@FindBy(xpath = "//div[text()='Login ']")private WebElement LoginButton;
	@FindBy(xpath = "//a[text()='Logout']")private WebElement LogoutButton;
	
	public Loginpage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);	
	}
	
	public void SendUsername() {
		Username.sendKeys("admin");
	}
	
	public void SendPassword() {
		Password.sendKeys("manager");
	}
	
	public void ClickonLogin() {
		LoginButton.click();
	}
	
	public void clickonLogout() {
		LogoutButton.click();
	}
	
	
	
	
	
}
