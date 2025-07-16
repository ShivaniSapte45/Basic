package popupHandle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PopupTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ADMIN\\eclipse-workspace\\Basic\\Driver\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");

	        // Instantiate a ChromeDriver class.
	        WebDriver driver = new ChromeDriver(opt);

	        // Maximize the browser
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();

	        // Launch Website
	        driver.get("https://demoqa.com/browser-windows");
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        
	        js.executeScript("window.scrollBy(0,100)");

	        //click on alert option
	        driver.findElement(By.xpath("//li[@id='item-1']")).click();
	        
	        Thread.sleep(2000);
	        
	        js.executeScript("window.scrollBy(0,500)");
	        
	        driver.findElement(By.id("alertButton")).click();
	        
	        Thread.sleep(2000);
	        
	        driver.switchTo().alert().accept();
	        
	        

	}

}
