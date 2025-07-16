package dateTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DatePicker2 {
	static void dateTest(WebDriver driver, String requiredMonth, String requiredYear, String requiredDate)
	{
		//select month from dropdown
		WebElement month = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select monthSelect = new Select(month);
		monthSelect.selectByVisibleText(requiredMonth);
		
		//select year from dropdown
		WebElement year = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select yeartSelect = new Select(year);
		yeartSelect.selectByVisibleText(requiredYear);
		
		List <WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td//a"));
		for(WebElement date : allDates)
		{
			String actualDate = date.getText();
			if(actualDate.equalsIgnoreCase(requiredDate))
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
	        js.executeScript("window.scrollBy(0,250)");
	        
	        driver.findElement(By.xpath("//input[@id='txtDate']")).click();
	        
	        String requiredMonth = "Dec";
	        String requiredYea = "2025";
	        String requiredDate = "19";
	        
	        dateTest(driver, requiredMonth, requiredYea, requiredDate);
	        
	        Thread.sleep(2000);
	        driver.quit();
	        
	        
	}

}
