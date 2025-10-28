package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//h1[text()='My Account']")
	WebElement msgHeading;
	
//	@FindBy(xpath="//div[@class='list-group mb-3']/a[text()='Logout']")
	@FindBy(xpath="//aside[@id='column-right']/div/a[text()='Logout']")
	WebElement Logoutlk;
	
	
	
	@FindBy(xpath="//h1[text()='Account Logout']")
	WebElement Acclogout;
	
	public boolean isMyAccountPageExists() {
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(msgHeading));
			System.out.println(msgHeading.isDisplayed());
			return (msgHeading.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
	

	public void logoutlink() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(Logoutlk));
		Logoutlk.click();
		Thread.sleep(3000);
	}
	
	public String AccountLogout() throws InterruptedException {
		Thread.sleep(3000);
		String acctLg=Acclogout.getText();
		return acctLg;
	}
}
