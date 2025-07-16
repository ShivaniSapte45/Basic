package Test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HaldiramPriceSorting {
	
	static WebDriver driver;
	
	@BeforeClass
	public void launchbrowser() throws InterruptedException
	{
		//Launch chrome browser

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\eclipse-workspace\\Basic\\Driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		//Launch URL
		driver.get("https://www.haldirams.com/sweets-73.html");
		Thread.sleep(300);
	}
	@Test
	public void CheckPrice() throws InterruptedException 
	{
			
		//From drop down select price option
		Select dropDown = new Select (driver.findElement(By.xpath("//*[@id='sorter' and @class='sorter-options'][1]")));
		dropDown.selectByVisibleText("Price");
		Thread.sleep(3000);
		
		//Scroll down whole page
		boolean flag = true;
		long lastHeight = 0;
		long newHight = 0;
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		while (flag) {
		    //js executor to scroll the page
		    
		    lastHeight = (long) js.executeScript("return document.body.scrollHeight");
		    js.executeScript("window.scrollBy(0,2250)","");
		    // Do some waiting
		    Thread.sleep(4000);

		    newHight = (long) js.executeScript("return document.body.scrollHeight");
		    if (lastHeight == newHight) {
		        flag = false;
		    }
		    
		    lastHeight = newHight;
		}
		
		//Scroll up to top
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		Thread.sleep(3000);

		//save price web elements in list
		List<WebElement> beforeFilter = driver.findElements(By.className("price-wrapper"));
		
		List<Double> beforeFilterPriceList = new ArrayList<Double>();
		
		for(WebElement p : beforeFilter)
		{
			//remove symbols
			beforeFilterPriceList.add(Double.valueOf(p.getText().replace("₹","").replace(",", "")));
		}
		
		System.out.println(beforeFilterPriceList);

		Thread.sleep(3000);
				
		driver.findElement(By.xpath("//a[@title='Set Descending Direction']")).click();
		Thread.sleep(3000);
		
//		driver.findElement(By.xpath("//a[@title='Set Ascending Direction']")).click();
//		Thread.sleep(3000);
		
		boolean flag2 = true;
		long lastHeight2 = 0;
		long newHight2 = 0;
		JavascriptExecutor js2 = ((JavascriptExecutor) driver);

		while (flag2) {
		    //js executor to scroll the page
		    
		    lastHeight2 = (long) js2.executeScript("return document.body.scrollHeight");
		    js2.executeScript("window.scrollBy(0,2250)","");
		    // Do some waiting
		    Thread.sleep(4000);

		    newHight2 = (long) js2.executeScript("return document.body.scrollHeight");
		    if (lastHeight2 == newHight2) {
		        flag2 = false;
		    }
		    
		    lastHeight2 = newHight2;
		}
		
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		Thread.sleep(3000);
		
		List<WebElement> afterDesendingFilter = driver.findElements(By.className("price-wrapper"));
		Thread.sleep(3000);
		
		List<Double> afterFilterPriceList = new ArrayList<Double>();
		
		for(WebElement pr: afterDesendingFilter)
		{
			
			afterFilterPriceList.add(Double.valueOf(pr.getText().replace("₹","").replace(",", "")));
			
		}
		
		Thread.sleep(3000);
				
		System.out.println(afterFilterPriceList);
		
		Collections.reverse(beforeFilterPriceList);
		System.out.println(beforeFilterPriceList);
		
		Assert.assertEquals(beforeFilterPriceList, afterFilterPriceList);
		   
	}
	
	@Test(priority = 2)
	public void asendingOrederFilter() throws InterruptedException
	{
		        driver.findElement(By.xpath("//a[@title='Set Ascending Direction']")).click();
		        Thread.sleep(3000);
				
		        //Scroll down whole page
				boolean flag = true;
				long lastHeight = 0;
				long newHight = 0;
				JavascriptExecutor js = ((JavascriptExecutor) driver);

				while (flag) {
				    //js executor to scroll the page
				    
				    lastHeight = (long) js.executeScript("return document.body.scrollHeight");
				    js.executeScript("window.scrollBy(0,2250)","");
				    // Do some waiting
				    Thread.sleep(4000);

				    newHight = (long) js.executeScript("return document.body.scrollHeight");
				    if (lastHeight == newHight) {
				        flag = false;
				    }
				    
				    lastHeight = newHight;
				}
				
				//Scroll up to top
				js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
				Thread.sleep(3000);

				//save price web elements in list
				List<WebElement> beforeFilter = driver.findElements(By.className("price-wrapper"));
				
				List<Double> beforeFilterPriceList = new ArrayList<Double>();
				
				for(WebElement p : beforeFilter)
				{
					//remove symbols
					beforeFilterPriceList.add(Double.valueOf(p.getText().replace("₹","").replace(",", "")));
				}
				
				System.out.println(beforeFilterPriceList);

				Thread.sleep(3000);
									
				boolean flag2 = true;
				long lastHeight2 = 0;
				long newHight2 = 0;
				JavascriptExecutor js2 = ((JavascriptExecutor) driver);

				while (flag2) {
				    //js executor to scroll the page
				    
				    lastHeight2 = (long) js2.executeScript("return document.body.scrollHeight");
				    js2.executeScript("window.scrollBy(0,2250)","");
				    // Do some waiting
				    Thread.sleep(4000);

				    newHight2 = (long) js2.executeScript("return document.body.scrollHeight");
				    if (lastHeight2 == newHight2) {
				        flag2 = false;
				    }
				    
				    lastHeight2 = newHight2;
				}
				
				js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
				Thread.sleep(3000);
				
				List<WebElement> afterDesendingFilter = driver.findElements(By.className("price-wrapper"));
				Thread.sleep(3000);
				
				List<Double> afterFilterPriceList = new ArrayList<Double>();
				
				for(WebElement pr: afterDesendingFilter)
				{
					afterFilterPriceList.add(Double.valueOf(pr.getText().replace("₹","").replace(",", "")));
					
				}
				
				Thread.sleep(3000);
						
				System.out.println(afterFilterPriceList);
				
				Collections.sort(beforeFilterPriceList);
				System.out.println(beforeFilterPriceList);
				
				Assert.assertEquals(beforeFilterPriceList, afterFilterPriceList,"Not sorting correctly in asending order");
		
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	

	
	
}
