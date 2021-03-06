package TestClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Utilities.Contanst;
import Utilities.EmailPage;
import Utilities.ExtentFactory;
import Utilities.ScreenShot;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

/**
 * Enter incorrect username and password and take screenShot if login failed
 */

public class TestWrongUsernameAndPasswordLoginFailed {
	private WebDriver driver;
	ExtentReports report;
	ExtentTest test;

  @Test
  public void EnterUserNameAndPassword() throws InterruptedException {
		//Enter Username
		EmailPage.enterUsername(driver,"test");
		test.log(LogStatus.INFO, "Enter username...");
		//Enter password
		EmailPage.enterPassword(driver,"test");
		test.log(LogStatus.INFO, "Enter password");
		Thread.sleep(3000);
		//Check login status
		boolean loginStatus = EmailPage.isLoginSuccess(driver);
		if( loginStatus == true){
			Assert.assertTrue(true);
			test.log(LogStatus.INFO, "login successfully");
		}else{
			test.log(LogStatus.FAIL,"login failed");
		 }
  }
	
@Test(dependsOnMethods = {"EnterUserNameAndPassword"})
public void UploadAttachmentAndSend(){
		//New letter
		EmailPage.clickNewLetter(driver);
		test.log(LogStatus.INFO, "Click New Letter button");
		Thread.sleep(3000);
		//Enter email address
		EmailPage.enterEmailAddress(driver,"Ronnie-wai@hotmail.com");
		test.log(LogStatus.INFO, "Enter email address");
		//Click upload attachment button and upload attachment with AutiIt tool
		EmailPage.uploadAttachment(driver);
		Thread.sleep(2000);
		Runtime.getRuntime().exec("E:\\EW\\TestGmailLogin\\script\\fileUpload.exe");
		test.log(LogStatus.INFO, "Upload attachment");
		Thread.sleep(2000);
		//Click send email button
		EmailPage.sendEmail(driver);
		Thread.sleep(3000);	
		//Check is email send successfully
		boolean isEmailSent = EmailPage.isEamilSent(driver);
		if( isEmailSent == true){
			Assert.assertTrue(true);
			test.log(LogStatus.PASS, "Email sent successfully");
		}else{
			test.log(LogStatus.FAIL,"Email sent failed");
		 }
}
  
  @BeforeMethod
  public void beforeMethod() {
	  	System.setProperty("webdriver.gecko.driver", "E:\\EW\\TestGmailLogin\\geckodriver.exe");
		driver = new FirefoxDriver();
		report = ExtentFactory.getInstance();
		test = report.startTest("Test Eamil login");
		test.log(LogStatus.INFO, "Browser started");
		// maximize window
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "maximize window");
		// Waiting Page Loading
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// Web Application Opened
		driver.get(Contanst.baseUrl);
		test.log(LogStatus.INFO, "Web Application Opened");
  }

  @AfterMethod
  public void afterMethod(ITestResult testResult) throws InterruptedException, IOException {
		Thread.sleep(2000);
		String path = ScreenShot.takeScreenShot(driver, testResult.getName());
		String imagePath =test.addScreenCapture(path);
		test.log(LogStatus.FAIL, "log in Failed",imagePath);
		driver.quit();
		report.endTest(test);
		report.flush();
  }
}
