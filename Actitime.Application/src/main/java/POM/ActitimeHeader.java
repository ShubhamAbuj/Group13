package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActitimeHeader {
	
	@FindBy(xpath = "//a[@class='content tt_selected selected']//img")private WebElement Timetrack;
	@FindBy(xpath = "//a[@class='content tasks']//img")private WebElement Tasks;
	@FindBy(xpath = "//a[@class='content reports']//img")private WebElement Reports;
	@FindBy(xpath = "//a[@class='content users']//img")private WebElement Users;
	@FindBy(xpath = "//a[@class='content calendar']/img")private WebElement WorkSchedule;
	
	public ActitimeHeader(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);	
	}
	
	public void ClickonTimetrack() {
		Timetrack.click();
	}
	
	public void ClickonTask() {
		Tasks.click();
	}
	
	public void ClickonReports() {
		Reports.click();
	}
	
	public void Clickonusers() {
		Users.click();
	}
	
	public void ClickonWorkschedule() {
		WorkSchedule.click();
	}
	
	
}
