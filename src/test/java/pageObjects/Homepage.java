package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage{

	public Homepage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//span[text()='My Account']")
	WebElement InkMyaccount;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement IbkRegister;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement InLogin;
	
	public void clickMyAccount() {
		InkMyaccount.click();
	}
	
	public void clickRegister() {
		IbkRegister.click();
		
	}
	
	public void clickLogin() {
		InLogin.click();
		
	}
	
	

}
