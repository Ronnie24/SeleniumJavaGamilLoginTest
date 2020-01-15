package Utilities;
import com.relevantcodes.extentreports.ExtentReports;
/**
 *Extent Report Path
 */
public class ExtentFactory {
	public static ExtentReports getInstance(){
		ExtentReports extent;
		String path ="E:\\EW\\TestGmailLogin\\report-demo.html";
		extent = new ExtentReports(path,false);
		return extent;
	}

}
