package sortVerification;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.DocumentName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AscendingOrderVerification {

	@Test
	public void ascendingOrder() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "E:\\New folder\\Eclipse WS\\LumaWeb\\driver\\chromedriver.exe");
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
		 WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//launch URL
		driver.get("http://shivanitest.itgurussoft.com:6120/Pages/User/Login.aspx");
		
		//login into app
		driver.findElement(By.id("txtEmailId")).sendKeys("shivanitest@yopmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("Password@1");
		
		//click on login button
		driver.findElement(By.id("btnLogin")).click();
		
		Thread.sleep(3000);
		
		//click on document tab
		driver.findElement(By.id("ucLeftSegment_aDocument")).click();
		Thread.sleep(3000);
		
		List<WebElement> docName = null;
		for(int i=1; i<3; i++)
		{
			docName = driver.findElements(By.xpath("//tr[@id='rptDocumentList_docRow_"+i+"']//td[1]"));
			
		}
		
		List <String> beforeSortDocName = new ArrayList<>();
		for(WebElement docNameBeforeSort : docName)
		{
			System.out.println(beforeSortDocName.add(String.valueOf(docNameBeforeSort.getText())));
		}		
				
		driver.findElement(By.xpath("//td[@data-column=\"DocumentName\"]")).click();
		
		for(int i=1; i<3; i++)
		{
			List<WebElement> docNameAfterSort = driver.findElements(By.xpath("//tr[@id='rptDocumentList_docRow_"+i+"']//td[1]"));
		}
		
		
	}
}
