package table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Table_Test2 {
	
	static WebDriver driver;
	@BeforeClass
	public void login() throws InterruptedException
	{
		System.setProperty("driver.chromedriver.webdriver", "C:\\Users\\ADMIN\\eclipse-workspace\\Basic\\Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://titukuat.peoplehruat.com/");
		driver.findElement(By.id("txtEmailId")).sendKeys("tituk@yopmail.com");
		driver.findElement(By.id("btnNext")).click();
		driver.findElement(By.xpath("//*[contains(@name,'Password')]")).sendKeys("Vaibhavi@1234");
		driver.findElement(By.id("SignIn")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 1)
	public void test1() throws Exception 
	{
		driver.findElement(By.xpath("//nav/a[@id='navQuery']")).click();
		Thread.sleep(3000);
		int	row = driver.findElements(By.xpath("//table[@id='tblQueryList']/tbody/tr")).size();
		System.out.println(row);
	
		int col = driver.findElements(By.xpath("//table[@id='tblQueryList']/tbody/tr[1]/th")).size();
		System.out.println(col);
		
		for(int i=1; i<row; i++)
		{
			for(int j=1; j<col; j++)
			{
				
				String actual = driver.findElement(By.xpath("//table[@id='tblQueryList']/tbody/tr["+(i+1)+"]/td["+(j+1)+"]")).getText();
				Thread.sleep(3000);
				//System.out.println(actual);
				
				if(actual.equalsIgnoreCase("Background Check"))
				{
					System.out.println("Postion in table  "+i+" : "+j);
					//driver.findElement(By.xpath("//table[@id='tblQueryList']/tbody/tr["+(i+1)+"]/td["+(j)+"]")).click();
					break;
				}
			}
		}
		
	}

}
