package tootipTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Tooltip1 {

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
	        
	        Thread.sleep(2000);
	        
	        String tooltip1 = driver.findElement(By.xpath("//a[@class='g-profile']")).getAttribute("title");
	        System.out.println("Hover mouse over author name - "+tooltip1);
	        JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("window.scrollBy(0,100)");
	        
	        
	        String toolTip = driver.findElement(By.xpath("//a[contains(@class,'blog-pager-newer-link')]")).getAttribute("title");

	        System.out.println(toolTip);
	        
	        driver.quit();
	}

}
