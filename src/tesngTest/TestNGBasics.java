package tesngTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestNGBasics {

	WebDriver driver;
	@BeforeMethod
	public void LaunchBrowser()
	{
		System.setProperty("driver.chromedriver.webdriver", "C:\\Users\\ADMIN\\eclipse-workspace\\Basic\\Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
				
	}
	
	@Test(priority = 1)
	public void login()
	{
		driver.get("https://titukuat.peoplehruat.com/");
		driver.findElement(By.id("txtEmailId")).sendKeys("tituk@yopmail.com");
		driver.findElement(By.id("btnNext")).click();
		driver.findElement(By.xpath("//*[contains(@name,'Password')]")).sendKeys("Vaibhavi@1234");
		driver.findElement(By.id("SignIn")).click();
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("People", title);
	}
	
	@Test(priority = 2)
	public void failTC()
	{
		Assert.assertTrue(true);
		
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.close();
	}
	
}
