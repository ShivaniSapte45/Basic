package dynamicElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DynamicTest1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\eclipse-workspace\\Basic\\Driver\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://practice.expandtesting.com/dynamic-table");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(2000);
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		System.out.println("no of rows = "+rows.size());
		
		for(int i=1; i<=rows.size(); i++)
		{
			String data = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td[1]")).getText();
			System.out.println(data);
			if(data.contains("Chrome"))
			{
				String cpuload = driver.findElement(By.xpath("//td[normalize-space()='Chrome']/following-sibling::*[contains(text(),'%')]")).getText();
				//xpath i have created - //table[@class='table table-striped']/tbody/tr/td[contains(text(),'Chrome')]/following-sibling::*[contains(text(),'%')]
				String value = driver.findElement(By.xpath("//p[@id='chrome-cpu']")).getText();
				if(value.contains(cpuload))
				{
					System.out.println("Test pass");
				}
				else {
					System.out.println("Test failed");
				}
				break;
			}
		}
		
		driver.quit();

	}

}
