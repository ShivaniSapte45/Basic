package actionTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionTest1 {

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
	        driver.get("https://demoqa.com/buttons");
	        
	        //scrolling
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,100)");
	        
	        //wait for some time
	        Thread.sleep(2000);
	        
	        //initialize actions class
	        Actions act = new Actions(driver);
	        
	        WebElement doubleclick = driver.findElement(By.id("doubleClickBtn"));
	        act.doubleClick(doubleclick).build().perform();
	        
	        Thread.sleep(2000);
	        
	        //observe msg after double click on button
	        String double_msg = driver.findElement(By.id("doubleClickMessage")).getText();
	        
	        if(double_msg.equalsIgnoreCase("You have done a double click"))
	        {
	        	System.out.println("Test case pass");
	        }
	        else
	        {
	        	System.out.println("Test case failed.");
	        }
	        
	        Thread.sleep(2000);
	        driver.quit();
	}

}
