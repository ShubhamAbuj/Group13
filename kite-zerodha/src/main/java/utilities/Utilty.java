package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilty {
	
	public static void takeScreenshot(WebDriver driver, int testID) throws IOException {
		String Screenshot = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    File dest = new File("C:\\Shubham\\software testing\\Screenshots\\test"+testID+Screenshot+".png");
	    FileHandler.copy(scr, dest);
	}
}
