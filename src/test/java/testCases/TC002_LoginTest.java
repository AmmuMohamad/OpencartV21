package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.Baseclass;

@Listeners(utilities.ExtentReportManager.class)
public class TC002_LoginTest extends Baseclass {

	@Test(groups={"sanity", "Master"})
	public void verify_login() {

		logger.info("************** Starting TC_002_LoginTest******");
		
		try {
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		logger.info("************** homepage******");
		
		LoginPage lp=new LoginPage(driver);
		logger.info("************** loginpage******");
		
		lp.setemail(p.getProperty("email"));
		lp.setpasswordl(p.getProperty("password"));
		lp.clickLoginbtn();
		
		logger.info("************** cliked login******");
		
		MyAccountPage macc=new MyAccountPage(driver);
		logger.info("************** Accountpage******");
		boolean targetPage=macc.isMyAccountPageExists();
		logger.info("************** AccountPageExists******");
		Assert.assertEquals(targetPage, true,"Login passed");
		
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("************** Finished TC_002_LoginTest******");
	}
}