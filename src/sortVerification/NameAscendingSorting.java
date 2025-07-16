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

public class NameAscendingSorting {

	@Test
	public void NameSortTest()
	{
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
		
		List<WebElement> nameList = driver.findElements(By.xpath("//div[@class = 'inventory_item_name ']"));
		
		List <String> names = new ArrayList<>();
		
		for (WebElement allNames : nameList)
		{
			names.add(allNames.getText());
			System.out.println(names);
		}
		
		Select filter = new Select(driver.findElement(By.className("product_sort_container")));
		filter.selectByVisibleText("Name (Z to A)");
		
		List<WebElement> afternameList = driver.findElements(By.xpath("//div[@class = 'inventory_item_name ']"));
		
		List <String> afternames = new ArrayList<>();
		
		for (WebElement afterallNames : afternameList)
		{
			afternames.add(afterallNames.getText());
		}
		
		Collections.sort(names);
		Collections.reverse(names);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(afternames, names);
		driver.quit(); 
	}
}
