package Utilities;
import com.relevantcodes.extentreports.ExtentReports;

/**
 *Extent Report Path
 */

public class ExtentFactory {
	public static ExtentReports getInstance(){
		ExtentReports extent;
		//set extent report path
		String path =".....\\report-demo.html";
		extent = new ExtentReports(path,false);
		return extent;
	}
}
