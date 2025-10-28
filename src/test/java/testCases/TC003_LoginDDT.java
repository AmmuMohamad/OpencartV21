package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.Baseclass;
import utilities.DataProviders;

/*Data is valid - login success - test pass - logout
Data is valid - login failed - test fail

Data is invalid - login success - test fail - logout
Data is invalid - login failed - test pass
*/

@Listeners(utilities.ExtentReportManager.class)
public class TC003_LoginDDT extends Baseclass{

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven")  
	public void verify_loginDDT( String email, String pwd, String exp) throws InterruptedException {
		
		logger.info("******** Starting TC_003_LoginDDT********");
		
		try {
		logger.info("******** Home page********");
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		logger.info("******** Loginpage********");
		LoginPage lp=new LoginPage(driver);
		lp.setemail(email);
		lp.setpasswordl(pwd);
		lp.clickLoginbtn();
		logger.info("******** AccountPage********");
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
//		WebElement target=driver.findElement(By.tagName("h1"));
//		boolean exists=target.isDisplayed();
//		System.out.println(exists);
		
//		WebElement clicked=driver.findElement(By.xpath("//aside[@id='column-right']/div/a[text()='Logout']"));
//		clicked.click();
//		System.out.println("clicked");
		logger.info("******** PageExists********");

		if(exp.trim().equalsIgnoreCase("valid")) {
			if(targetPage==true) {
				
				macc.logoutlink();
				String AccountValue=macc.AccountLogout();
				String ExpectedValue="Account Logout";
				Assert.assertEquals(AccountValue, ExpectedValue);
//				Assert.assertTrue(true);
//				
//			}
//			else {
//				Assert.assertTrue(false);
//			}
//		}
//		
//		else if(exp.equalsIgnoreCase("invalid")) {
//			if(targetPage==true) {
//				macc.logoutlink();
//				Assert.assertTrue(false);
//				
//			}
//			else {
//				Assert.assertTrue(true);
//			}
		}}
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("******** Finished TC_003_LoginDDT********");
	}
}
