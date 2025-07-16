package windowHandle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class HandleWindow {

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
	        
	        //now save handler in string
	        String parentWindow = driver.getWindowHandle();
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,500)");
	        
	        Thread.sleep(2000);
	        
	        //click on new window option
	        driver.findElement(By.id("windowButton")).click();
	        
	        Set<String> s1 = driver.getWindowHandles();
	        
	       // now create iterator
	        Iterator <String> i = s1.iterator();
	        while(i.hasNext())
	        {
	        	String childWindow = i.next();
		        if(!parentWindow.equalsIgnoreCase(childWindow));
		        driver.switchTo().window(childWindow);
		        Thread.sleep(2000);
		        System.out.println(driver.getTitle());
		        driver.close();
		                	
	        }
	        
	        driver.switchTo().window(parentWindow);
	        Thread.sleep(2000);
	        driver.quit();
			
	        
	        

	}

}
