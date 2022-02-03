package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimetrackSUb {
	
	
	@FindBy(xpath = "//a[text()='View Time-Track']")private WebElement viewTT;
	@FindBy(xpath = "//a[text()='Enter Time-Track']")private WebElement EnterTT;
	

	public TimetrackSUb(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ClickViewTT() {
		viewTT.click();
	}
	
	public void ClickEnterTT() {
		EnterTT.click();
	}
	
	
}
