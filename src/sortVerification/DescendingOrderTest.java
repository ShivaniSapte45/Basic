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

public class DescendingOrderTest {

		@Test
		public void SortingTest() {
		System.setProperty("webdriver.chrome.driver", "E:\\New folder\\Eclipse WS\\LumaWeb\\driver\\chromedriver.exe");
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
		 WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//launch URL
		driver.get("https://www.saucedemo.com/");
		
		//login
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//before sorting data
		List<WebElement> beforeSorting = driver.findElements(By.className("inventory_item_price"));
		
		List<Double> beforeSortingPrice = new ArrayList<>();
		
		for(WebElement price : beforeSorting)
		{
			beforeSortingPrice.add(Double.valueOf(price.getText().replace("$", "")));
		}
		
		Select filter = new Select(driver.findElement(By.className("product_sort_container")));
		filter.selectByVisibleText("Price (high to low)");
		
		List<WebElement> afterSorting = driver.findElements(By.className("inventory_item_price"));
		
		List<Double> afterSortingPrice = new ArrayList<>();
		
		for(WebElement priceList : afterSorting)
		{
			afterSortingPrice.add(Double.valueOf(priceList.getText().replace("$", "")));
		}
		
		Collections.sort(beforeSortingPrice);
		Collections.reverse(beforeSortingPrice);
		
		Assert.assertEquals(beforeSortingPrice, afterSortingPrice);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
