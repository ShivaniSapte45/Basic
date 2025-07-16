package windowHandle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MultipleTab {

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
	        driver.get("https://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");
	        
	        //save parent window handle
	        String parent = driver.getWindowHandle();
	        
	        //click on 1st option
	        driver.findElement(By.xpath("//a[contains(@href,'www.google')]")).click();
	        driver.switchTo().window(parent);
	        
	        //click on second option
	        driver.findElement(By.xpath("//a[contains(@href,'www.yahoo')]")).click();
	        
	        Set <String> windows = driver.getWindowHandles();
	        
	        ArrayList<String> tabs = new ArrayList<>(windows);
	        driver.switchTo().window(tabs.get(1));
	        Thread.sleep(2000);
	        driver.close();
	        
	        driver.switchTo().window(tabs.get(2));
	        Thread.sleep(2000);
	        driver.close();
	        
//	        Iterator<String> handels = windows.iterator();
//	        
//	        while(handels.hasNext())
//	        {
//	        	String child = handels.next();
//	        	if(!parent.equalsIgnoreCase(child))
//	        	{
//	        		driver.switchTo().window(child);
//	        		Thread.sleep(2000);
//	        		driver.close();
//	        	}
//	        }
	        driver.switchTo().window(parent);
	        Thread.sleep(2000);
	        driver.close();
	
	}

}
