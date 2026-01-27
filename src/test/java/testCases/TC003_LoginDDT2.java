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


@Listeners(utilities.ExtentReportManager.class)
public class TC003_LoginDDT2 extends Baseclass{

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven")  
	public void verify_loginDDT( String username, String password) throws InterruptedException {
		
		logger.info("******** Starting TC_003_LoginDDT********");
		
		try {
			Homepage hp=new Homepage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			logger.info("************** homepage******");
			
			LoginPage lp=new LoginPage(driver);
			logger.info("************** loginpage******");
			
			lp.setemail(username);
			lp.setpasswordl(password);
			lp.clickLoginbtn();
			
			logger.info("************** cliked login******");
			
			MyAccountPage macc=new MyAccountPage(driver);
			logger.info("************** Accountpage******");
			boolean targetPage=macc.isMyAccountPageExists();
			logger.info("************** AccountPageExists******");
			Assert.assertEquals(targetPage, true,"Login failed");
			
			}
			catch(Exception e) {
				Assert.fail();
			}
			logger.info("************** Finished TC_002_LoginTest******");
		}
	}

