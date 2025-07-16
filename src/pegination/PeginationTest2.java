package pegination;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PeginationTest2 {
	
	@Test
	public void peginationTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\eclipse-workspace\\Basic\\Driver\\chromedriver.exe");
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
		 WebDriver driver = new ChromeDriver(options);
		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 
		 //launch URL
		 driver.get("https://datatables.net/examples/advanced_init/dt_events.html");
		 
		 //take list of all webelements and store it in list.
		 List<WebElement> positionElements = driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		 
		 //now create another array list type 
		 List<String> positionText = new ArrayList<>();
		 
		 //create loop of webelement type and take 1 by 1 text of all names
		 for(WebElement positionElement : positionElements)
		 {
			 positionText.add(positionElement.getText());
		 }
		 
		 //store next button attribute value.
		 String nextBtn = driver.findElement(By.id("example_next")).getAttribute("class");
		 
		 while(!nextBtn.contains("disabled"))
		 {
			 driver.findElement(By.id("example_next")).click();
			 positionElements = driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
			 		 
			 //create loop of webelement type and take 1 by 1 text of all names
			 for(WebElement positionElement : positionElements)
			 {
				 positionText.add(positionElement.getText());
			 }
			 nextBtn = driver.findElement(By.id("example_next")).getAttribute("class");
		 }
		 
		 for(String positions : positionText)
		 {
			System.out.println(positions);
			 
		 }
		 
		 String count = driver.findElement(By.id("example_info")).getText().split(" ")[5];
		 
		 Assert.assertEquals(count, "57");
		 
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 driver.quit();
	}

}
