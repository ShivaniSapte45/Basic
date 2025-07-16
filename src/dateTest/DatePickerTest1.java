package dateTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DatePickerTest1 {
	static void dateTest(String expectedYear, String expectedMonth, String expectedDate, WebDriver driver)
	{
		while(true)
        {
        	String year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
	        String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
        	if(month.equalsIgnoreCase(expectedMonth) && year.equalsIgnoreCase(expectedYear))
        	{
        		break;
        	}
        	//click on next arrow
        	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        }
        
        //select date
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td//a"));
        
        for(WebElement date : allDates)
        {
        	String actualDate = date.getText();
        	if(actualDate.equalsIgnoreCase(expectedDate))
        {
        		date.click();
        		break;
        }
        }
	}

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
	        driver.get("https://testautomationpractice.blogspot.com/");
	        
	        //scroll down
	        JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("window.scrollBy(0,200)");
	        
	        //click on date picker
	        driver.findElement(By.xpath("//input[@id='datepicker']")).click();
	        
	        String expectedYear = "2026";
	        String expectedMonth = "May";
	        String expectedDate = "10";
	        		
	        dateTest(expectedYear, expectedMonth, expectedDate, driver);
	        
	        Thread.sleep(2000);
	        driver.quit();
	        
	        
	        
	        
	}

}
