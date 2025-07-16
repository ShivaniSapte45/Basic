package Test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("driver.chromedriver.webdriver", "C:\\Users\\ADMIN\\eclipse-workspace\\Basic\\Driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
				
		driver.get("https://9menu.peoplehruat.com/");
		driver.findElement(By.id("txtEmailId")).sendKeys("9menu@yopmail.com");
		driver.findElement(By.id("btnNext")).click();
		driver.findElement(By.xpath("//*[contains(@name,'Password')]")).sendKeys("Staging@1234");
		driver.findElement(By.id("SignIn")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("workspace_product_menu")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul[@id='menu_sb_MyProducts']//following::li//a//following::span"
				+ "[text()='Employees']//ancestor::a")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tbody//tr[@class='dRow']//td[text()='0 ATS - Emp m']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='hlnPersonal']")).click();
		
		Thread.sleep(3000);
		
		WebElement title = driver.findElement(By.xpath("//*[@id='ucTitle_ddlManagedList']"));
		Select SelTitle=new Select(title);
		
		String SelectedOption= SelTitle.getFirstSelectedOption().getText();
		System.out.println("Default selected option is - "+SelectedOption);
		
//		if(SelectedOption.isBlank())
//		{		
		   SelTitle.selectByVisibleText("Miss");
//		}
//		else
//		{
//			System.out.println("Title is already selected.");
//			System.out.println("Selected title is - "+SelectedOption);
//		}
		   
		   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					  .withTimeout(Duration.ofSeconds(30))
					  .pollingEvery(Duration.ofSeconds(5))
					  .ignoring(NoSuchElementException.class);
		   
		   
		   WebElement ele=driver.findElement(By.xpath("//*[@id='ucAnalysisCode1_ddlCustomManagedList']"));
		   Select selEle=new Select(ele);
		   selEle.selectByIndex(2);
	
		   
	
	
	}
	
	
	
}
