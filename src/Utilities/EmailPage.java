package Utilities;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EmailPage {
	public static WebElement element = null;
	//Enter username and click next button
	public static void enterUsername(WebDriver driver,String username) {
		element = driver.findElement(By.xpath("//input[@id='identifierId']"));
		element.sendKeys(username);
		driver.findElement(By.xpath("//span[@class='CwaK9']")).click();
	}
	//Enter password and click next button
	public static void enterPassword(WebDriver driver,String password) {
		element = driver.findElement(By.xpath("//input[@name='password']"));
		element.sendKeys(password);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[@id='passwordNext']//span[@class='CwaK9']"))).click().build().perform();		
	}
	//Check is login successfully
	public static boolean isLoginSuccess(WebDriver driver) {
		WebElement welcomeText = null;
		try {
			welcomeText = driver.findElement(By.xpath("//img[@class='gb_ua']"));
			if (welcomeText != null) {
				return true;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		 }
		return false;
	}
	//Click New Letter button
	public static void clickNewLetter(WebDriver driver) {
		element = driver.findElement(By.xpath("//img[@class='gb_ua']"));
		element.click();
	}
	//Enter email address
	public static void enterEmailAddress(WebDriver driver,String emailAddress) {
		element = driver.findElement(By.xpath("//textarea[@id=':qx']"));
		element.sendKeys(emailAddress);
		driver.findElement(By.xpath("//input[@id=':qf']")).sendKeys("Test");
	}
	//Upload attachment
	public static void uploadAttachment(WebDriver driver) throws IOException {
		// click add attachment button
		element = driver.findElement(By.xpath("//div[@id=':rx']"));
		element.click();
	}
	//Click send button
	public static void sendEmail(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id=':q5']"));
		element.click();
		//test.log(LogStatus.INFO, "Click send button");
	}
	//Check is email send successfully
	public static boolean isEamilSent(WebDriver driver) {
		WebElement emailSent = null;
		try {
			emailSent = driver.findElement(By.xpath("//div[@class='b8 UC bAp']//div[@class='vh']"));
			if (emailSent.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}
}
