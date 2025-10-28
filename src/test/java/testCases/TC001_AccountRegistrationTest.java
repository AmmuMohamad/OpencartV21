package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.RegisterAccount;
import testBase.Baseclass;

@Listeners(utilities.ExtentReportManager.class)
public class TC001_AccountRegistrationTest extends Baseclass {
	@Test(groups= {"Regression","Master"})
	public void verify_account_registration() throws InterruptedException {

		logger.info("****** Starting TC001_AccountRegistrationTest *****");

		try {

			Homepage hp = new Homepage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on my account Link");
			hp.clickRegister();
			logger.info("Clicked on my Register Link");
			RegisterAccount repage = new RegisterAccount(driver);
			logger.info("Providing customer details ....");
			repage.EnterFirstName(RandomString().toUpperCase());
			repage.EnterLastName(RandomString().toUpperCase());
			repage.Enteremail(RandomString() + "@gmail.com");
			repage.password(RandomString());
			repage.ClickNewsletter();
			repage.PrivacyPolicy();
			repage.btncontinuetoNxtpage();
			logger.info("Validating expected message");
			String ActualMgs = repage.GetAccountSuccessMessage();
			if(ActualMgs.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			}else {
				logger.error("Test failed..");
				logger.debug("Debug logs..");
				Assert.assertTrue(false);
				
			}

		} catch (Exception e) {
			
			Assert.fail();
		}
		
		logger.info("****** Finished TC001_AccountRegistrationTest *****");

	}
}
