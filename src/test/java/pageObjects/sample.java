package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost/opencart/upload/index.php?");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("input-email")).sendKeys("admin@admin.com");
		driver.findElement(By.id("input-password")).sendKeys("admin@123");
		driver.findElement(By.xpath("//button[text()='Login']")).submit();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//h1[text()='My Account']")).isDisplayed());
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		WebElement clicked=driver.findElement(By.xpath("//div[@class='list-group mb-3']//a[text()='Logout']"));
		clicked.click();
		System.out.println("clicked");
		System.out.println(driver.findElement(By.tagName("h1")).getText());
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		
	}

}
