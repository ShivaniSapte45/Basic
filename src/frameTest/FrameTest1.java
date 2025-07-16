package frameTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FrameTest1 {
	
	static void defaultcontent1(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ADMIN\\eclipse-workspace\\Basic\\Driver\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");

	        // Instantiate a ChromeDriver class.
	        WebDriver driver = new ChromeDriver(opt);

	        // Maximize the browser
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();

	        // Launch Website
	        driver.get("https://ui.vision/demo/webtest/frames/");
	        
	        //switch to frame 1 and enter some data
	        WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
	        driver.switchTo().frame(frame1);
	        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Welcome");
	        Thread.sleep(2000);
	        
	        //switch to default contents before switching to another frame
	        defaultcontent1(driver);
	        
	        //switch to frame 2 and enter data
	        WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
	        driver.switchTo().frame(frame2);
	        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Selenium");
	        defaultcontent1(driver);
	        Thread.sleep(2000);
	        
	        //switch to frame 3
	        WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
	        driver.switchTo().frame(frame3);
	        driver.switchTo().frame(0);   //switch by passing index
	        driver.findElement(By.xpath("//span[contains(text(),'I am a human')]")).click();
	        driver.findElement(By.xpath("//div[@role='option']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//div[@jsname='wQNmvb']")).click();
	        Thread.sleep(2000);
	        
	        defaultcontent1(driver);
	        
	        
	        
	        
	}

}
