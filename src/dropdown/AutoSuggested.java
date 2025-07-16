package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoSuggested {

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
	        driver.get("https://www.google.com/");
	        
	        driver.findElement(By.name("q")).sendKeys("Java");
	        Thread.sleep(2000);
	        List <WebElement> options = driver.findElements(By.xpath("//ul[@class='G43f7e']//li//div[@role='option']"));
	        
	        for(WebElement option : options)
	        {
	        	String op = option.getText();
	        	System.out.println("options list " + op);

	        	if(op.equals("javascript"))
	        	{
	        		option.click();
	        	}
	        }
	        
	}

}
