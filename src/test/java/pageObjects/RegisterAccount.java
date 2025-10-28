package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegisterAccount extends BasePage{

	public RegisterAccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(id="input-firstname")
	WebElement txtFname;
	
	@FindBy(id="input-lastname")
	WebElement txtLname;
	
	@FindBy(id="input-email")
	WebElement txtemail;
	
	@FindBy(id="input-password")
	WebElement txtpassword;
	
	@FindBy(id="input-newsletter")
	WebElement chkNewsletter;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPrivacyPolicy;
	
	@FindBy(tagName="h1")
	WebElement AccountSuccessMessage;
	
	@FindBy(xpath="//button[text()='Continue']")
	WebElement btncontinuetoNxtpage;
	
	public void EnterFirstName(String fname) {
		txtFname.sendKeys(fname);
	}
	
	public void EnterLastName(String Lname) {
		txtLname.sendKeys(Lname);
	}
	
	public void Enteremail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void password(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	
	public void ClickNewsletter() throws InterruptedException  {
		
		System.out.println(chkNewsletter.isDisplayed()+"ClickNewsletter is displayed");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(chkNewsletter));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
//		clickletter.click();
//		Thread.sleep(5000);
//		chkNewsletter.click();
	}
	
	public void PrivacyPolicy() throws InterruptedException {
//		Thread.sleep(5000);
		System.out.println(chkPrivacyPolicy.isDisplayed()+"PrivacyPolicy is displayed");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(chkPrivacyPolicy));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
//		privacy.click();
		
//		chkPrivacyPolicy.click();
	}
	
	public void btncontinuetoNxtpage() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(btncontinuetoNxtpage));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
//		btncontinuetoNxtpage.click();
	}
	
	public String GetAccountSuccessMessage() throws InterruptedException {
		 
		Thread.sleep(5000);
		try {
			return (AccountSuccessMessage.getText());
		}
		catch(Exception e){
			return (e.getMessage());
		}
	}
}
