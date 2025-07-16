package sortVerification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AscendingOrderTest {

	@Test
	public void AscendingTest()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\New folder\\Eclipse WS\\LumaWeb\\driver\\chromedriver.exe");
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
		 WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.saucedemo.com/");
		
		//login
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//take a list of all cost before sorting
		List <WebElement> beforeFilter = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		
		List<Double> beforeFilterPrice = new ArrayList<>();
		for(WebElement price : beforeFilter)
		{
			 beforeFilterPrice.add(Double.valueOf(price.getText().replace("$", "")));
		}
		
		//Now select filter low to high
		Select selectFilter = new Select(driver.findElement(By.xpath("//select[@class = 'product_sort_container']")));
		selectFilter.selectByVisibleText("Price (low to high)");
		
		//Now again take list of all prices
		List <WebElement> afterFilter = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		
		List<Double> afterFilterPrice = new ArrayList<>();
		for(WebElement price : afterFilter)
		{
			 afterFilterPrice.add(Double.valueOf(price.getText().replace("$", "")));
		}
		
		Collections.sort(beforeFilterPrice);
		
		Assert.assertEquals(beforeFilterPrice, afterFilterPrice);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}
}
