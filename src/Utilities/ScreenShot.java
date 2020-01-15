package Utilities;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Screenshot path
 */

public class ScreenShot {
	public static String takeScreenShot(WebDriver driver, String fileName) throws IOException{
		fileName = fileName+".png";
		//set screenshot path 
		String dir = "......\\ScreenShot\\";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(dir+fileName));
		String destination = dir + fileName;
		return destination;	
	}
}
