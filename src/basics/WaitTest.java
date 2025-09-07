package basics;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;

public class WaitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ADMIN\\eclipse-workspace\\Basic\\Driver\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.getBrowserVersion();

	        // Instantiate a ChromeDriver class.
	        WebDriver driver = new ChromeDriver(opt);

	        // Maximize the browser
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();

	        // Launch Website
	        driver.get("https://www.saucedemo.com/");
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait until the element with ID "myId" is visible
		WebElement myElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));

		// Now you can interact with 'myElement'
		myElement.click();

	}

}
