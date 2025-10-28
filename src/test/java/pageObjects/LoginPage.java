package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(id="input-email")
	WebElement inemail;
	
	@FindBy(id="input-password")
	WebElement inPassword;
	
	@FindBy(xpath="//form[@id='form-login']//div[2]//a")
	WebElement inforgottenPassword;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement inLogin;
//	
//	@FindBy(xpath="//a[text()='Account']")
//	WebElement inLanding;
//	
	public void setemail(String email) {
		inemail.sendKeys(email);
	}
	
	public void setpasswordl(String password) {
		inPassword.sendKeys(password);
	}
	
	public void clickLoginbtn() {
		inLogin.submit();
	}
}
