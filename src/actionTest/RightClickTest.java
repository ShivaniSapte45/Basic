package actionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class RightClickTest {

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
	        
	        Thread.sleep(2000);
	        //scrolling
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,200)");
	        
	        Thread.sleep(2000);
	        //Initialize actions class
	        Actions act = new Actions(driver);
	        
	        //store webelement on which need to perform action
	        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
	        
	        //perform right click action on above element
	        act.contextClick(rightClick).build().perform();
	        
	        //for cross check need to perform below operation
	        String rightClickMsg = driver.findElement(By.id("rightClickMessage")).getText();
	        
	        if(rightClickMsg.equalsIgnoreCase("You have done a right click"))
	        {
	        	System.out.println("test case pass");
	        }
	        else {
	        	System.out.println("test case failed");
	        }
	        
driver.quit();
	}

}
