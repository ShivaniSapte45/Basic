package Test1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
		boolean flag = true;
		long lastHeight = 0;
		long newHight = 0;
		
System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\eclipse-workspace\\Basic\\Driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://www.haldirams.com/sweets-73.html");
		Thread.sleep(300);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		while (flag) {
		    //js executor to scroll the page
		    
		    lastHeight = (long) js.executeScript("return document.body.scrollHeight");
		    js.executeScript("window.scrollBy(0,2500)","");
		    // Do some waiting
		    Thread.sleep(3000);

		    newHight = (long) js.executeScript("return document.body.scrollHeight");
		    if (lastHeight == newHight) {
		        flag = false;
		    }
		    
		    lastHeight = newHight;
		}
		
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}

}
