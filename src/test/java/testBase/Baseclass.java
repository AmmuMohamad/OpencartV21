package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class Baseclass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	
	@BeforeClass(groups = { "sanity", "Regression", "Master" })
	@Parameters({ "os", "browser" })
	public void setup(String os, String browser) throws Exception {

//		loading config.properties file
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass()); // log4j2

//		os

		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {

			DesiredCapabilities capabilities = new DesiredCapabilities();

			if (os.equalsIgnoreCase("windows")) {

				capabilities.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("linux")) {

				capabilities.setPlatform(Platform.LINUX);
			} else if (os.equalsIgnoreCase("mac")) {

				capabilities.setPlatform(Platform.MAC);
			} else {
				System.out.println("no matching os");
				return;
			}

			// browser

			switch (browser.toLowerCase()) {

			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			case "firefox":
				capabilities.setBrowserName("firefox");
				break;
			default:
				System.out.println("No matchinh browser");
				return;
			}

//			driver= new RemoteWebDriver(new URL("http://192.168.29.77:4444/WD/hub"), capabilities);
			driver = new RemoteWebDriver(new URL("http://192.168.29.77:4444"), capabilities);

		}

		if (p.getProperty("execution_env").equalsIgnoreCase("local")) {

			switch (browser.toLowerCase()) {

			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("invalid browser name..");
				return;
			}
		}

		switch (browser.toLowerCase()) {

		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("invalid browser name..");
			return;
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL2")); // reading url from properties file

	}

	
	@AfterClass
	public void tearDown() {

		driver.quit();
		
	}
	

	public String RandomString() {

		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}

	public String RandomNumeric() {

		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

	public String RandomAlphaNumeric() {

		String generatedString = RandomStringUtils.randomAlphabetic(3);
		String generatedNumber = RandomStringUtils.randomNumeric(3);
		return generatedString + generatedNumber;
	}

//	public String captureScreen(String tname) throws IOException {
//
//		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//
//		TakesScreenshot tsc = (TakesScreenshot) driver;
//		File SourceFile = tsc.getScreenshotAs(OutputType.FILE);
//
//		String targetFilePath = System.getProperty("user.dir") + "\\screenshots" + tname + "_" + timeStamp + ".png";
//		File targetFile = new File(targetFilePath);
//
//		FileUtils.copyFile(SourceFile, targetFile);
////		SourceFile.renameTo(targetFile);
//		return targetFilePath;
		
		public String captureScreen(String tname) throws IOException {

			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

			TakesScreenshot tsc = (TakesScreenshot) driver;
			File SourceFile = tsc.getScreenshotAs(OutputType.FILE);

			String screenshotsDir=System.getProperty("user.dir")+"\\screenshots\\";
			
			File folder=new File(screenshotsDir);
			if(!folder.exists()) {
				folder.mkdirs();
			}
			
			String targetFilePath = screenshotsDir + tname + "_" + timeStamp + ".png";
			File targetFile = new File(targetFilePath);

			FileUtils.copyFile(SourceFile, targetFile);
//			SourceFile.renameTo(targetFile);
			return targetFilePath;
	}

}
