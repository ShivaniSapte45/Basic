/**
 * 
 */
package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BootstrapDropdown {

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
	        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
	        
	        //click on dropdown
	        driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
	        Thread.sleep(2000);
	        
	        List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
	        System.out.println("Size = "+options.size());
	        for(WebElement option : options)
	        {
	        	String text = option.getText();
	        	if(text.equals("Java") || text.equals("C#"))
	        	{
	        		option.click();
	        	}
	        }
	        Thread.sleep(2000);
	        
	        driver.quit();

	}

}
